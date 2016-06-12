'use strict';

(function() {
	angular
		.module('Frontend')
		.controller('homepage.ctrl', homepageCtrl);
	
	homepageCtrl.$inject = ['$location'];
	
	function homepageCtrl($location) {
		angular.extend(this, {
			changePassword : changePassword,
			makeOrder : makeOrder,
			orders : orders
		});
		
		function changePassword() {
			$location.path('/changePassword');
		}
		
		function makeOrder() {
			$location.path('/makeOrder')
		}
		
		function orders() {
			$location.path('/orders')
		}
	}
})();