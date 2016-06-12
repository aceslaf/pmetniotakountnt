(function() {
    'use strict';
    angular
        .module('Frontend')
        .constant('environment.cnst', getEnvironmentConstants());

    function getEnvironmentConstants() {
        var backendLocation = '192.168.0.103:8080';
        return {
            BACKEND: {
                REST: backendLocation,
                WS: backendLocation + '/channelSocket'
            },
            LOGGING: {
                DEBUG_ENABLED: false
            }
        };
    }
})();
