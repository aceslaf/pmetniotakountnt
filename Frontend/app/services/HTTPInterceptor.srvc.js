/**
 * Service that intercepts http requests and responses.
 * It manipulates the requests to send the authorization token header.
 * It also intercepts the response errors and if it is status 401 the user is reauthorized using his refresh_token
 * @author kostadin.pop-kochev, created on 04.04.2016.
 */


'use strict';

(function() {
    angular
        .module('Frontend')
        .factory('HttpInterceptor.srvc', HttpInterceptorSrvc);

    HttpInterceptorSrvc.$inject = [
        '$location',
        '$window',
        '$injector',
        '$log'
    ];
    
    function HttpInterceptorSrvc(
        $location,
        $window,
        $injector,
        $log
    ) {
    	
    	return {};
    }
})();