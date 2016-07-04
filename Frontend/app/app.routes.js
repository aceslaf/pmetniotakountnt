'use strict';

(function() {
	angular
		.module('Frontend')
		.config(Router);

	Router.$inject = ['$routeProvider'];

	function Router($routeProvider) {
		$routeProvider
			.when('/login', {
				templateUrl: 'app/components/login/login.tmpl.html',
				controller: 'login.ctrl',
				controllerAs: 'vm'
			})
			.when('/logout', {
				templateUrl: 'app/components/logout/logout.tmpl.html',
				controller: 'logout.ctrl',
				controllerAs: 'vm',
				access: {
					requiresLogin: true
				}
			})
			.when('/homepage', {
				templateUrl: 'app/components/homepage/homepage.tmpl.html',
				controller: 'homepage.ctrl',
				controllerAs: 'vm',
				access: {
					requiresLogin: true
				}
			})
			.when('/orders', {
				templateUrl: 'app/components/orders/orders.tmpl.html',
				controller: 'orders.ctrl',
				controllerAs: 'vm',
				access: {
					requiresLogin: true
				}
				
			})
			.when('/makeOrder', {
				templateUrl: 'app/components/makeOrder/makeOrder.tmpl.html',
				controller: 'makeOrder.ctrl',
				controllerAs: 'vm',
				access: {
					requiresLogin: true
				}
			})
			.when('/registerEmployee', {
				templateUrl: 'app/components/registerEmployee/registerEmployee.tmpl.html',
				controller: 'regEmployee.ctrl',
				controllerAs: 'vm',
				access: {
					requiresLogin: false
				}
			})
			.when('/registerProduct', {
				templateUrl: 'app/components/registerProduct/registerProduct.tmpl.html',
				controller: 'regProduct.ctrl',
				controllerAs: 'vm',
				access: {
					requiresLogin: false
				}
			})
			.otherwise({
				redirectTo: '/login'
			});
	}
})();
