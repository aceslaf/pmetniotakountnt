'use strict';

(function() {
	angular.module('Frontend').controller('regProduct.ctrl', registerCtrl);

	registerCtrl.$inject = [ '$location', 'users.srvc', '$scope', 'registerProduct.srvc' ];

	function registerCtrl($location, usersSrvc, $scope, registerProductSrvc) {
		angular.extend(this, {
			registerProduct : registerProduct
		});

		function registerProduct() {
			var data = $scope.product;
			registerProductSrvc.registerProduct(data);
		}
	}
})();