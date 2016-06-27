(function() {
	'use strict';
	angular.module('Frontend').factory('login.srvc', loginSrvc);

	loginSrvc.$inject = [ '$location', '$http', 'protocolResolver.srvc', 'users.srvc' ];

	function loginSrvc($location, $http, protocolResolverSrvc, usersSrvc) {

		var service = {
			login : login
		};

		return service;

		// ////////////////////////////

		function initialize() {

			websocketSrvc.onConnect(authenticateWebSocketSession);
			websocketSrvc.connect();
			keepSessionAliveSrvc.start(logoutSrvc.logoutOnSessionExpire);

		}

		// TODO fix this when you get to sockets
		/*
		 * function authenticateWebSocketSession() { var localUser =
		 * usersSrvc.getLocalUser(); if (localUser) {
		 * 
		 * var requestData = {}; var websocketData =
		 * helperSrvc.getWebsocketData(applicationCnst.AUTHORIZATION.REQUEST_ACKNOWLEDGEMENT,
		 * requestData); websocketSrvc.send(websocketData); }
		 *  }
		 */

		function login(authorizationHeaders) {
			$http.get(
					protocolResolverSrvc.getBackendRestApiUrl()
							+ '/employee', {headers : authorizationHeaders}).then(onSuccess,
					onFailure);
		}
		
		function onSuccess(response) {
			var user = response.data;
			var localUser;
			if(angular.isDefined(user)) {
				localUser = user;
				usersSrvc.setLocalUser(user);
				
			}
			$location.path("/homepage");
			
		}

		function onFailure(error) {
			var errorMessage;
			if(error.status === 401) {
				//TODO replace all messages in constants file
				errorMessage = "InvalidCredentials";
			} else {
				errorMessage = navigator.onLine ? "Invalid credentials" :
					"No network connection.";
			}
			$location.path("/login");
			//TODO implement logic to show error
		}

	}
})();
