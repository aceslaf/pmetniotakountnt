(function() {
	'use strict';
	angular
		.module('Frontend')
		.factory('User', user);
	
	user.$inject = [];
	
	function user() {
		
		var User = function User(options) {
			angular.extend(this, {
				id : options.id,
				firstName : options.firstName,
				lastName : options.lastName,
				username : options.username,
				password : options.password,
				employeeRights : options.employeeRights,
				roleId : options.roleId
			});
		};
		
		angular.extend (User.prototype, {
			getId : getId,
			setId : setId,
			getFirstName : getFirstName,
			setFirstName : setFirstName,
			getLastName : getLastName,
			setLastName : setLastName,
			getUsername : getUsername,
			setUsername : setUsername,
			getPassword : getPassword, 
			setPassword : setPassword,
			getRights : getRights,
			setRights : setRights,
			getRole : getRole,
			setRole : setRole
		});
		
		return User;
		
		function getId() {
			return id;
		}
		
		function setId(id) {
			this.id = id;
		}
		
		function getFirstName() {
			return firstName;
		}
		
		function setFirstName(firstName) {
			this.firstName = firstName;
		}
		
		function getLastName() {
			return lastName;
		}
		
		function setLastName(lastName) {
			this.lastName = lastName;
		}
		
		function getUsername() {
			return username;
		}
		
		function setUsername(username) {
			this.username = username;
		}
		
		function getPassword() {
			return password;
		}
		
		function setPassword(password) {
			this.password = password;
		}
		
		function getRights() {
			return employeeRights;
		}
		
		function setRights(employeeRights) {
			this.employeeRights = employeeRights;
		}
		
		function getRole() {
			return roleId;
		}
		
		function setRole(roleId) {
			this.roleId = roleId;
		}
	}
})();