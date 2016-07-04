'use strict';

(function() {
	angular.module('Frontend').controller('regEmployee.ctrl', registerEmployeeCtrl);

	registerEmployeeCtrl.$inject = [ '$location', 'users.srvc', '$scope', 'registerEmployee.srvc' ];

	function registerEmployeeCtrl($location, usersSrvc, $scope, registerEmployeeSrvc) {
		angular.extend(this, {
			registerEmployee : registerEmployee
		});

		function registerEmployee() {
			var data = $scope.employee;
			registerEmployeeSrvc.registerEmployee(data);
			$location.path('/login');
		}
	}
})();