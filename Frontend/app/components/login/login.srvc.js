(function() {
    'use strict';
    angular
        .module('Frontend')
        .factory('login.srvc', loginSrvc);

    loginSrvc.$inject = [
        '$location',
        '$http'
    ];

    function loginSrvc(
        $location,
        $http
    ) {

        var service = {
            authenticate: authenticate
        };

        return service;

        //////////////////////////////

        function initialize() {

            websocketSrvc.onConnect(authenticateWebSocketSession);
            websocketSrvc.connect();
            keepSessionAliveSrvc.start(logoutSrvc.logoutOnSessionExpire);

        }

        function authenticateWebSocketSession() {
            var localUser = usersSrvc.getLocalUser();
            if (localUser) {

                var requestData = {};
                var websocketData = helperSrvc.getWebsocketData(applicationCnst.AUTHORIZATION.REQUEST_ACKNOWLEDGEMENT, requestData);
                websocketSrvc.send(websocketData);
            }

        }

        function authenticate(credentials) {
            $http.get(protocolResolver)
        }

        function successAuth(response) {
            // Send request to backend to fetch the user, config params and initialize services on successful response
            $http.get(protocolResolverSrvc.getBackendRestApiLocation() + backendUriCnst.LOGIN.AUTHENTICATE_USER).then(onSuccessfulResponse, onErrorResponse);
        }

        function onSuccessfulResponse(response) {
            var user = response.data.user;
            var configParams = response.data.configParams;
            var localUser;
            if (angular.isDefined(user, configParams)) {
                configParamsSrvc.setConfigParams(configParams);
                localUser = user;
                usersSrvc.setLocalUser(localUser);
                roomsSrvc.getRoomMemebers(user.id, user.roomId);
                initialize();
                $location.path("/dashboard");
                if (typeof(Storage) !== undefined) {
                    localStorage.setItem("username", user.id);
                } else {
                    $log.debug("no local storage support");
                }
            }
        }

        function onErrorResponse(error) {
        }

    }
})();
