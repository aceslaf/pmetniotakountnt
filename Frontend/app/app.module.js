'use strict';

(function() {
    angular
		.module('Frontend', ['ngRoute', 'ngResource', 'ui.bootstrap', 'ngAnimate', 'cgNotify','ngSanitize', 'cgBusy'])
        .run(onAppStart);

    onAppStart.$inject = [
        '$rootScope',
        '$location',
        '$log'
    ];

    function onAppStart(
        $rootScope,
        $location,
        $log
    ) {
       $log.debug('app started');


        $location.path('/login');

        $rootScope.$back = function() {
            window.history.back();
        };
    }
})();
