(function() {
    'use strict';
    angular
        .module('Frontend')
        .factory('websocket.srvc', websocketSrvc);

   websocketSrvc.$inject = [
        '$timeout',
        'application.cnst',
        '$log',
        '$window'
    ];

    function websocketSrvc(
        $timeout,
        applicationCnst,
        $log,
        $window
    ) {
    	var service = {};
    	
    	return service;
    }
        /*var stompClient,
            subscriptions = {},
            onConnectCallbacks = [],
            onConnectionLostCallbacks = [],
            firstTimeLogin = true,
            attempts = 1,
            errorsId = [];

        var service = {
            connect: connect,
            onConnect: onConnect,
            onConnectionLost: onConnectionLost,
            send: send,
            subscribe: subscribe,
            unsubscribe: unsubscribe,
            disconnect: disconnect
        };

        return service;


        function connect() {
            $log.debug("STOMP: CONNECTING");
            stompClient = Stomp.over(new WebSocket(protocolResolverSrvc.getBackendWsApiLocation()));
            startWsConnectionMonitor();
            stompClient.debug = null;
            
            stompClient.connect({}, successCallback, errorCallback);
        }

        function successCallback(frame) {
            $log.debug("STOMP: CONNECTED");
            attempts = 1;
            if (!firstTimeLogin) {
                notificationSrvc.removeMessage(errorsId[0]);
                notificationSrvc.success(messagesCnst.BACKEND_RECONNECTED_SUCCESSFULLY);
                errorsId.splice(0, 1);
            } else {
                firstTimeLogin = false;
            }

            for (var topic in subscriptions) {
                if (subscriptions.hasOwnProperty(topic)) {
                    sendSubscribeFrame(topic, subscriptions[topic].callback);
                }
            }

            onConnectCallbacks.forEach(function(callback) {
                callback();
            });
        }

        function errorCallback(frame) {
            $log.error(frame);
        }

        function isStompClientConnected() {
            if (stompClient && stompClient.connected) {
                return true;
            }

            return false;
        }

        function onConnect(callback) {
            onConnectCallbacks.push(callback);
        }

        function onConnectionLost(callback) {
            onConnectionLostCallbacks.push(callback);
        }

        function send(data) {
            if (isStompClientConnected()) {
                stompClient.send(data.destination, data.headers, data.body);
            } else {
                if (!errorsId[0]) {
                    firstTimeLogin = false;
                    errorsId[0] = notificationSrvc.warning(messagesCnst.BACKEND_CONNECTION_LOST);
                }
                $log.error("STOMP is not connected. Can not send data to URL: " + data.destination + ".");
            }
        }

        function subscribe(topic, callback) {
            if (hasTopic(topic)) {
                return;
            }

            subscriptions[topic] = {
                callback: callback,
                unsubscribe: undefined
            };

            if (isStompClientConnected()) {
                sendSubscribeFrame(topic, callback);
            }
        }

        function hasTopic(newTopic) {
            for (var topic in subscriptions) {
                if (subscriptions.hasOwnProperty(topic)) {
                    if (topic === newTopic) {
                        return true;
                    }
                }
            }
            return false;
        }

        function sendSubscribeFrame(topic, callback) {
            var subscribeObj = stompClient.subscribe(topic, function(message) {
                var contentType = message.headers['content-type'];
                if (contentType.indexOf(applicationCnst.MESSAGE.TYPE.TEXT) >= 0) {
                    callback(message.body);
                } else if (contentType.indexOf(applicationCnst.MESSAGE.TYPE.JSON) >= 0) {
                    callback(angular.fromJson(message.body));
                } else if (contentType.indexOf(applicationCnst.MESSAGE.TYPE.BINARY) >= 0) {
                    callback(message.body, message.headers);
                } else {
                    $log.error("Recieved unknown message content-type: " + contentType);
                }
            });

            subscriptions[topic].unsubscribe = subscribeObj.unsubscribe;
        }

        function startWsConnectionMonitor() {
            stompClient.ws.addEventListener('close', function(e) {
                onConnectionLostCallbacks.forEach(function(callback) {
                    callback(e);
                });

                $log.debug("STOMP: LOST_CONNECTION");
                var delayTime = generateDelayTime(attempts);
                attempts++;
                $timeout(connect, delayTime, false);
            });

        }

        *//**
         * Generates a number of ms the user has to wait before another attempt to reconnect
         * based on the number of attempts so far
         *//*
        function generateDelayTime(attempts) {
            var maxInterval = (Math.pow(2, attempts) - 1) * 1000;
            if (maxInterval > 30000) {
                maxInterval = 30000; // the max time to wait for a reconnect should be 30 sec
            }
            // generate a random number in ms from 0 to the maxInterval
            return Math.random() * maxInterval;
        }

        function unsubscribe(topic) {
            if (subscriptions[topic] && subscriptions[topic].unsubscribe) {
                subscriptions[topic].unsubscribe();
                delete subscriptions[topic];
            }
        }

        function disconnect() {
            for (var topic in subscriptions) {
                if (subscriptions.hasOwnProperty(topic)) {
                    subscriptions[topic].unsubscribe();
                }
            }

            subscriptions = {};
            onConnectCallbacks = [];
            onConnectionLostCallbacks = [];
            stompClient.disconnect();
        }
    }*/
})();
