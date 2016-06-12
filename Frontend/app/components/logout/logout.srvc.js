(function() {
    'use strict';
    angular
        .module('Frontend')
        .factory('logout.srvc', logoutSrvc);

    logoutSrvc.$inject = [
        'application.cnst',
        'websocket.srvc',
        '$window',
        '$http',
    ];

    function logoutSrvc(
        applicationCnst,
        websocketSrvc,
        $window,
        $http
    ) {
    	
    	var service = {};
    	return service;
    	
        //write code here
    }
})();
