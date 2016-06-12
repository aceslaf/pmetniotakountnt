/**
 * Application configuration
 */
(function() {
    'use strict';
    angular
        .module('Frontend')
        .config(applicationConfig);

    applicationConfig.$inject = ['$httpProvider', '$logProvider', 'environment.cnst'];

    function applicationConfig($httpProvider, $logProvider, environmentCnst) {
        // HttpProvider configuration
        $httpProvider.interceptors.push('HttpInterceptor.srvc');

        // Logging configuration
        $logProvider.debugEnabled(environmentCnst.LOGGING.DEBUG_ENABLED);
    }
})();
