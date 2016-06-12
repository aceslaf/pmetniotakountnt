'use strict';

(function() {
	angular
		.module('Frontend')
		.controller('makeOrder.ctrl', makeOrderCtrl);
	
	makeOrderCtrl.$inject = ['$location', '$http'];
	
	function makeOrderCtrl($location, $http) {
		angular.extend(this, {
			makeOrder : makeOrder
		});
		
		function makeOrder() {
			
		}
	}
})();