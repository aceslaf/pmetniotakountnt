(function() {
	'use strict';
	angular.module('Frontend').factory('registerEmployee.srvc', registerEmployeeSrvc);

	registerEmployeeSrvc.$inject = [ '$location', '$http', 'protocolResolver.srvc', 'users.srvc' ];

	function registerEmployeeSrvc($location, $http, protocolResolverSrvc, usersSrvc) {

		var service = {
				registerEmployee : registerEmployee
		};

		return service;

		// ////////////////////////////

		

		function registerEmployee(employee) {
			$http.post(
					protocolResolverSrvc.getBackendRestApiUrl()
							+ '/employee/create',employee, {}).then(onSuccess,
					onFailure);
		}
		
		function onSuccess(response) {
			var user = response.data;
			var localUser;
			if(angular.isDefined(user)) {
				localUser = user;
				usersSrvc.setLocalUser(user);
				
			}
			$location.path("/homepage");
		}

		function onFailure(error) {
			var errorMessage;
			if(error.status === 401) {
				//TODO replace all messages in constants file
				errorMessage = "InvalidCredentials";
			} else {
				errorMessage = navigator.onLine ? "Invalid credentials" :
					"No network connection.";
			}
		}
	}
})();
