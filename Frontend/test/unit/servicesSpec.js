'use strict';

describe('service', function() {
    beforeEach(module('Frontend'));

    it('check the existence of UserManagement factory', inject(function(UserManagement) {
        expect(UserManagement).toBeDefined();
    }));
    it('check the existence of popupService factory', inject(function(popupService) {
        expect(popupService).toBeDefined();
    }));
    it('check the existence of popupService factory', inject(function(Signalling) {
        expect(Signalling).toBeDefined();
    }));
});
