(function() {
    'use strict';
    angular
        .module('Frontend')
        .factory('login.srvc', loginSrvc);

    loginSrvc.$inject = [
        '$location',
        '$http',
        'protocolResolver.srvc'
    ];

    function loginSrvc(
        $location,
        $http,
        protocolResolverSrvc
    ) {

        var service = {
            login: login
        };

        return service;

        //////////////////////////////

        function initialize() {

            websocketSrvc.onConnect(authenticateWebSocketSession);
            websocketSrvc.connect();
            keepSessionAliveSrvc.start(logoutSrvc.logoutOnSessionExpire);

        }

        //TODO fix this when you get to sockets
        /*function authenticateWebSocketSession() {
            var localUser = usersSrvc.getLocalUser();
            if (localUser) {

                var requestData = {};
                var websocketData = helperSrvc.getWebsocketData(applicationCnst.AUTHORIZATION.REQUEST_ACKNOWLEDGEMENT, requestData);
                websocketSrvc.send(websocketData);
            }

        }*/
        function onSuccess(response) {
            var user = response;
        }

        function onFailure(error) {
        	var user = error;
        }

        function login(credentials) {
            $http.get(
            		protocolResolverSrvc.getBackendRestApiUrl() + '/employee/b/b',
            		{
            			headers : {
                			'content-type' : 'application/json',
                			'Authorization' : 'Basic YTph'
                	}
            }).then(onSuccess(), onFailure());
        }

        

    }
})();
