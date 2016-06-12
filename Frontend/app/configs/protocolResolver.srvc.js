'use strict'

(function() {
	angular
		.module('Frontend')
		.factory('protocolResolver.srvc', protocolResolverSrvc);
	
	protocolResolverSrvc.$inject = [
	    '$location',
	    'environment.cnst'
	];
	
	function protocolResolverSrvc(
		$location,
		environmentCnst
	) {
		var service = {
				getBackendRestApiUrl: getBackendRestApiUrl,
				getBackendWsApiUrl: getBackendWsApiUrl
		}
		
		return service;
		
		function getBackendRestApiUrl() {
			return $location.protocol + '://' + environmentCnst.BACKEND.REST;
		}
	}
})();