(function() {
	'use strict';
	angular
		.module('Frontend')
		.factory('makeOrder.srvc', makeOrderSrvc);
	
	makeOrderSrvc.$inject = [
        '$location',
        '$http'
	];
	
	function makeOrderSrvc(
		$location,
		$http
	) {
		var service = {};
		return service;
	}
})();