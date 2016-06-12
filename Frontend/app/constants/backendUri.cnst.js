'use strict';

(function() {
    angular
        .module('Frontend')
        .constant('backendUri.cnst', backendUriCnst());

    function backendUriCnst() {
        var service = {
            SETTINGS: {
                AUTO_ANSWER: '/userSettings/autoAnswer',
                SMART_GRID: '/userSettings/smartGrid',
                SUBSCRIBE: '/user/queue/userSettings'
            },
            USER_STATUSES: {
                SUBSCRIBE_STATUS_EVENTS: '/user/queue/statusEvents',
                SEND_UPDATE: '/app/updateStatus'
            },
            VIDEO: {
                SEND_IMG_ADDRESS: '/app/thumbnailRequest/',
                RECEIVE_IMG_ADDRESS: '/topic/thumbnailResponse/',
                DESTINATION_SUFFIX: {
                    MY_TOPIC: '',								//Used to send pics to users
                    MY_CONNECTING_TOPIC: 'connecting/'			//Used to send pics to a user in connecting state
                },
                SUBSCRIBE_INFIX: {
                    TO_USER: '',									//Subscribe to single room user
                    TO_CONNECTING_USER: 'connecting/'			//Subscribe to user in connecting state
                }
            },
            P2P_VIDEO: {
                SEND_DESCR_ADDRESS: '/app/sendsdp/',
                RECEIVE_DESCR_ADDRESS: '/user/queue/sdp',
                SEND_VIDEO_STATUS: "/app/sendVideoNotification/",
                RECEIVE_VIDEO_STATUS: "/user/queue/otherPartyVideo"
            },
            USER_INVING_STATUS: {
                SUBSCRIBE_STATUS_EVENTS: '/user/queue/inVingStatus'
            },
            LOGIN: {
                CLEAR_SESSION: '/clearSession',
                AUTHENTICATE_USER: '/user',
                // Send periodically requests to keep HTTP session alive
                // Reason: websocket session does not keep the HTTP session open on tomcat.
                KEEP_SESSION_ALIVE: '/keepSessionAlive'
            },
            GET_USER_INFO: '/user/',
            GET_GUEST_INFO: '/guest/',
            GET_USER_BY_EXTENSION: '/getUserIdByExtension/',
            SCREEN_SHARING: {
                START_SHARER: '/initiate-screensharing/',
                TERMINATE_SHARE_CONNECTION: '/terminate-screensharing/',
                SUBSCRIBE_NOTIFY: '/user/queue/screen-share'
            },
            DEFAULT_USER_IMAGE_LOCATION: 'assets/img/placeholder.png',
            USER_PICTURE: '/user/picture?userId=',
            ROOM_MEMBERS: '/roomMembers',
            UPDATE_FAVORITES: '/modifyFavoriteUsers',
            HELP_PAGE: '/help'
        };

        return service;
    }
})();
