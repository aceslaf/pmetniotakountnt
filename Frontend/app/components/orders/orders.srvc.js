(function() {
	'use strict';
	
	angular
		.module('Frontend')
		.factory('orders.srvc', ordersSrvc);
	
	ordersSrvc.$inject = [
        '$location',
        '$http'
	];
	
	function ordersSrvc(
		$location,
		$http
	){
		var service = {};
		return service
	}
})();