'use strict';

(function() {
    angular
        .module('Frontend')
        .constant('application.cnst', getApplicationConstants());

    function getApplicationConstants() {

        return {
            VOICEMAILS: {
                CHECK_FOR_NEW_VOICEMAIL_TIMEOUT: 1000 * 60 * 5,
                REQUEST_VOICEMAILS: '/app/voicemails/',
                REQUEST_UNREAD_VOICEMAILS_NUMBER: '/app/unreadVoicemailsNumber/',
                REQUEST_AUDIO: '/app/voicemails/recording/',
                REQUEST_DELETE_VOICEMAIL: '/app/deleteVoicemail/',
                REQUEST_MARK_VOICEMAIL_AS_READ: '/app/markVoicemailAsRead/',
                REQUEST_MARK_VOICEMAIL_AS_UNREAD: '/app/markVoicemailAsUnread/',
                VOICEMAILS_RESPONSE: '/topic/voicemails/',
                UNREAD_VOICEMAILS_NUMBER_RESPONSE: '/topic/unreadVoicemailsNumber/',
                AUDIO_RESPONSE: '/topic/voicemails/audio/',
                CURRENT_AUDIO_TIMING: 1000
            },
            VIDEO: {
                IMG_SEND_INTERVAL: 1000,
                MAX_WIDTH: 352,
                MAX_HEIGHT: 264
            },
            AUTHORIZATION: {
                REQUEST_ACKNOWLEDGEMENT: '/app/acknowledgement/',
                RECIEVE_UNSUBSCRIBE_NOTIFICATION: '/user/queue/disconnect'
            },
            MESSAGE: {
                TYPE: {
                    JSON: 'application/json',
                    TEXT: 'text/plain',
                    BINARY: 'application/octet-stream'
                }
            },
            CONNECTION_MONITOR_INTERVAL: {
                JAVA_BACKEND_TIMEOUT: 3000,
                ASTERISK_TIMEOUT: 1000,
                // Make http request every 14 minutes just to keep server http session alive.
                // Default server session timeout is 30 minutes.
                KEEP_HTTP_SESSION_ALIVE_TIMEOUT: 1000 * 60 * 14
            },
            CONNECTION: {
                RECEIVE_USER_STATUS: '/topic/connectionStatusRequest',
                SEND_USER_STATUS: '/app/connectionStatusResponse/'
            },
            CALL: {
                SEND_ORIGINATE_COMMAND: '/app/originateCall/',
                SEND_HANGUP_COMMAND: '/app/hangup/',
                SEND_LEAVE_VOICEMAIL_COMMAND: '/app/leaveVoicemail/',
                SUBSCRIBE_CALL_EVENTS: '/user/queue/callEvents'
            },
            CALL_STATES_TIMEOUT: {
                TERMINATING_STATE_MAX_TIMEOUT: 15000,
                REACHABLE_TIMEOUT_MS: 3000
            },
            VIDEO_SLIDER: {
                SLIDER_HEIGHT: 5,
                SLIDER_WIDTH_OFFSET: 3
            },
            AUTH_CLIENT:{
                CLIENT_ID: ''
            }
        };
    }
})();
