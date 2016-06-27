(function() {
	'use strict';
	angular
		.module('Frontend')
		.factory('homepage.srvc', homepageSrvc);
	
	homepageSrvc.$inject = [
	    '$location',
	    '$http',
	    'users.srvc'
	];
	
	function homepageSrvc(
			$location,
			$http,
			usersSrvc
	) {
		var service = {
			
		};
		return service;
	}
})();