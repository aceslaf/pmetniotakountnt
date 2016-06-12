'use strict';

describe('Frontend', function() {
    var listOfUsers = element.all(by.repeater('person in people'));

    beforeEach(function() {
        browser.get('http://localhost:8080');
    })
    it("should have a title", function() {
        expect(browser.getTitle()).toEqual('Ving');
    });
    it("should load 4 users", function() {
        expect(listOfUsers.count()).toEqual(4);
    });
    it("should contain 'Account 1' text in button 'Account 1'", function() {
        expect(listOfUsers.first().getText()).toContain('Account 1');
    });
    it("should redirect to login screen in case of invalid path", function() {
        browser.get('http://localhost:8080/#/invalidPath');
        browser.getCurrentUrl().then(function() {
            expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/#/login');
        })
    });
});
