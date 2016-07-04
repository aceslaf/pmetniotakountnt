(function() {
	'use strict';
	angular.module('Frontend').factory('registerProduct.srvc',
			registerProductSrvc);

	registerProductSrvc.$inject = [ '$location', '$http',
			'protocolResolver.srvc', 'users.srvc' ];

	function registerProductSrvc($location, $http, protocolResolverSrvc,
			usersSrvc) {

		var service = {
			registerProduct : registerProduct
		};

		return service;

		// ////////////////////////////

		function registerProduct(product) {
			var request = {
					method : 'POST', 
					url : protocolResolverSrvc.getBackendRestApiUrl()
					+ '/product/create',
					headers : {
						'Authorization' : 'Basic ' + window.btoa(usersSrvc.getLocalUser().username + ":"
								+ usersSrvc.getLocalUser().password)
					},
					data : product
					
			};
			$http(request).then(onSuccess, onFailure);
			
			/*
			var auth = {
				authorization : "Basic "
						+ window.btoa(usersSrvc.getLocalUser().username + ":"
								+ usersSrvc.getLocalUser().password)
			};
			$http.post(
					protocolResolverSrvc.getBackendRestApiUrl()
							+ '/product/create', product, auth).then(onSuccess,
					onFailure);*/
		}

		function onSuccess(response) {
			var user = response.data;
			var localUser;
			if (angular.isDefined(user)) {
				localUser = user;
				usersSrvc.setLocalUser(user);

			}
			$location.path("/homepage");
		}

		function onFailure(error) {
			var errorMessage;
			if (error.status === 401) {
				// TODO replace all messages in constants file
				errorMessage = "InvalidCredentials";
			} else {
				errorMessage = navigator.onLine ? "Invalid credentials"
						: "No network connection.";
			}
		}
	}
})();
