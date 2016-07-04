'use strict';

(function() {
	angular.module( 'Frontend' ).controller( 'homepage.ctrl', homepageCtrl );

	homepageCtrl.$inject = [ '$location', 'users.srvc' ];

	function homepageCtrl( $location, usersSrvc ) {
		angular.extend(this, {
			changePassword : changePassword,
			makeOrder : makeOrder,
			orders : orders,
			registerProduct : registerProduct,
			logout : logout
		});

		function changePassword() {
			$location.path( '/changePassword' );
		}

		function makeOrder() {
			$location.path( '/makeOrder' );
		}

		function orders() {
			$location.path( '/orders' );
		}

		function registerProduct() {
			$location.path( '/registerProduct' );
		}

		function logout() {
			$location.path( '/logout' );
		}
	}
})();