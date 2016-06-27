'use strict';

(function() {
	angular.module('Frontend').controller('register.ctrl', registerCtrl);

	registerCtrl.$inject = [ '$location', 'users.srvc', '$scope' ];

	function registerCtrl($location, usersSrvc, $scope) {
		angular.extend(this, {
			register : register
		});

		function register() {
			var data = $scope;
		}
	}
})();