(function() {
	'use strict';
	angular
		.module('Frontend')
		.factory('homepage.srvc', homepageSrvc);
	
	homepageSrvc.$inject = [
	    '$location',
	    '$http'
	];
	
	function homepageSrvc(
			$location,
			$http
	) {
		var service = {
		};
		return service;
	}
})();