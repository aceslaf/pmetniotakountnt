'use strict';

(function() {
	angular
		.module('Frontend')
		.controller('orders.ctrl', ordersCtrl);
	
	ordersCtrl.$inject = [
        '$location',
        '$http'
	];
	
	function ordersCtrl($location, $http) {
		angular.extend(this, {
			
		});
	}
})();