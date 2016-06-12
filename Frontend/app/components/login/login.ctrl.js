'use strict';

(function() {
    angular
        .module('Frontend')
        .controller('login.ctrl', loginCtrl);

    loginCtrl.$inject = [
	    'login.srvc', 
	    'logout.srvc', 
	    '$location',
	    '$http'];

    function loginCtrl(loginSrvc, 
    	logoutSrvc, 
    	$location, 
    	$http) {
    	
    	angular.extend(this, {
            login: login
        });

    	function login() {
    		loginSrvc.authenticate
    		
    		$location.path('/homepage');
        }
    }
})();
