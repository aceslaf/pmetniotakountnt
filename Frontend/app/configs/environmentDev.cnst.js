(function() {
    'use strict';
    angular
        .module('Frontend')
        .constant('environment.cnst', getEnvironmentConstants());

    function getEnvironmentConstants() {
        var backendLocation = '10.1.3.97:8080/StartSmart';
        // TODO: Change this address to real host

        return {
            BACKEND: {
                REST: backendLocation,
                WS: backendLocation + '/channelSocket'
            },
            LOGGING: {
                DEBUG_ENABLED: true
            }
        };
    }
})();
