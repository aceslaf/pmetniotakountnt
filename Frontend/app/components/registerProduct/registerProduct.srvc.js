(function() {
	'use strict';
	angular.module('Frontend').factory('registerProduct.srvc',
			registerProductSrvc);

	registerProductSrvc.$inject = [ '$location', '$http',
			'protocolResolver.srvc', 'users.srvc', 'products.srvc' ];

	function registerProductSrvc($location, $http, protocolResolverSrvc,
			usersSrvc, productsSrvc) {

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
		}

		function onSuccess(response) {
			var product = response.data;
			if (angular.isDefined(product)) {
				//productsSrvc.addProduct(product);
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
