'use strict';

(function() {
	angular.module('Frontend').controller('login.ctrl', loginCtrl);

	loginCtrl.$inject = [ 'login.srvc', 'logout.srvc', '$location', '$http',
			'$scope' ];

	function loginCtrl(loginSrvc, logoutSrvc, $location, $http, $scope) {

		angular.extend(this, {
			login : login,
			register : register
		});

		function login() {
			var headers = $scope.credentials ? 
					{
						authorization : "Basic " + window.btoa($scope.credentials.username + ":" + $scope.credentials.password)
					} : {};
			
			loginSrvc.login(headers);
		}
		
		function register() {
			$location.path("/registerEmployee");
		}
	}
})();
