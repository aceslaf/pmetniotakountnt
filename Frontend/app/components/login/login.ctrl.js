'use strict';

(function() {
    angular
        .module('Frontend')
        .controller('login.ctrl', loginCtrl);

    loginCtrl.$inject = [
	    'login.srvc', 
	    'logout.srvc', 
	    '$location',
	    '$http',
	    '$scope'];

    function loginCtrl(loginSrvc, 
    	logoutSrvc, 
    	$location, 
    	$http,
    	$scope) {
    	
    	angular.extend(this, {
            login: login
        });

    	function login() {
    		loginSrvc.login($scope.credentials);
    		
    		$location.path('/homepage');
        }
    }
})();
