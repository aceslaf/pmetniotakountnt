'use strict';

(function() {
	angular
		.module('Frontend')
		.controller('logout.ctrl', logoutCtrl);

	logoutCtrl.$inject = ['$location', 'logout.srvc'];

	function logoutCtrl($location,  logoutSrvc) {
		angular.extend(this, {
			logout: logoutSrvc.logout,
			cancel: cancel
		});

		//////////////////////////////

		function cancel() {
			$location.path('/dashboard');
		}
	}
})();
