(function() {
	'use strict';
	angular
		.module('Frontend')
		.factory('users.srvc', usersSrvc);
	
	usersSrvc.$inject = [
        'User'
	];
	
	function usersSrvc(User) {
		var localUser;
		var service = {
				setLocalUser : setLocalUser,
				getLocalUser : getLocalUser
		};
		
		return service;
		
		function setLocalUser(user) {
			localUser = new User(user);
		}
		
		function getLocalUser() {
			return localUser;
		}
	};
})();