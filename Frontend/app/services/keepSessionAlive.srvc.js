/**
 * Service about making periodical requests to keep the HTTP session alive.
 */
(function() {
    'use strict';

    angular
        .module('Frontend')
        .factory('keepSessionAlive.srvc', keepSessionAlive);

    keepSessionAlive.$inject = [
        '$interval',
        '$http',
        'application.cnst',
        'backendUri.cnst',
        'protocolResolver.srvc'
    ];

    function keepSessionAlive(
        $interval,
        $http,
        applicationsCnst,
        backendUriCnst,
        protocolResolverSrvc
    ) {
        var keepAlivePromise,
            sessionExpireCallback;

        var service = {
            start: start,
            stop: stop
        };

        return service;

        //////////////////////////////

        /**
         * Initiates time interval for sending periodical HTTP requests
         * @return {void}
         */
        function start(logoutOnSessionExpire) {
            if (angular.isDefined(keepAlivePromise)) {
                return;
            }

            sessionExpireCallback = logoutOnSessionExpire;

            keepAlivePromise = $interval(makeAliveRequest,
                applicationsCnst.CONNECTION_MONITOR_INTERVAL.KEEP_HTTP_SESSION_ALIVE_TIMEOUT,
                false);
        }

        /**
         * Stops sending interval for sending periodical HTTP requests
         * @return {void}
         */
        function stop() {
            if (angular.isDefined(keepAlivePromise)) {
                $interval.cancel(keepAlivePromise);
                keepAlivePromise = undefined;
            }
        }

        /**
         * Callback invoked at regular timeout just to keep the server side HTTP session alive
         * @return {void}
         */
        function makeAliveRequest() {
            $http.get(protocolResolverSrvc.getBackendRestApiLocation() + backendUriCnst.LOGIN.KEEP_SESSION_ALIVE)
                .then(function successCallback(response) {
                    // this callback will be called asynchronously
                    // when the response is available
                }, function errorCallback(response) {
                    console.log('Share response: ' + response);
                    if (response.status === 401) {
                        sessionExpireCallback();
                    }
                });
        }
    }
})();
