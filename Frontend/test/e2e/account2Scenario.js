'use strict';

describe('Frontend', function() {
    var listOfUsers = element.all(by.repeater('person in people'));
    var endCallButtons = element.all(by.css('.notInCallTxt'));

    it("should redirect to dashboard view on 'Account 2' button click", function(done) {
        browser.get('http://localhost:8080').then(function() {
            setTimeout(done, 1000);
            listOfUsers.get(1).click();
        });
        browser.getCurrentUrl().then(function(url) {
            expect(url).toEqual('http://localhost:8080/#/dashboard');
        });
    });

    var listOfCallableUsers = element.all(by.repeater('currentPerson in people'));

    it("should load 3 callable users", function() {
        expect(listOfCallableUsers.count()).toEqual(3);
    });
    it("should load 'Account 2' as the text for my account in dashboard view", function() {
        var myAccount = element(by.css('.my-acc'));
        expect(myAccount.getText()).toBe('Account 2');
    });
    it("should contain 3 hidden 'End Ving' buttons", function(done) {
        var endMsgLabels = element.all(by.css('.end-msg'));
        expect(endMsgLabels.count()).toBe(3);
        //button click for the next case
        listOfCallableUsers.get(0).click();
        setTimeout(done, 6000);
    });
    it("should have Account 1 'currentPerson.called' class active, eg. call Account 1", function() {
        var activePersonsCalled = element.all(by.css('.inCallTxt'));
        expect(activePersonsCalled.count()).toBe(1);
    });

    it("should hangup to Account 1 on button click", function(done) {
        element.all(by.css('.inCallTxt')).click();
        var activePersonsCalled = element.all(by.css('.inCallTxt'));
        expect(activePersonsCalled.count()).toBe(0);
        //button click for the next case
        listOfCallableUsers.get(1).click();
        setTimeout(done, 6000);
    });
    it("should have Account 3 'currentPerson.called' class active, eg. call Account 3", function() {
        var activePersonsCalled = element.all(by.css('.inCallTxt'));
        expect(activePersonsCalled.count()).toBe(1);
    });
    it("should hangup to Account 3 on button click", function(done) {
        element.all(by.css('.inCallTxt')).click();
        var activePersonsCalled = element.all(by.css('.inCallTxt'));
        expect(activePersonsCalled.count()).toBe(0);
        //button click for the next case
        listOfCallableUsers.get(2).click();
        setTimeout(done, 6000);
    });
    it("should have Account 4 'currentPerson.called' class active, eg. call Account 4", function() {
        var activePersonsCalled = element.all(by.css('.inCallTxt'));
        expect(activePersonsCalled.count()).toBe(1);
    });
    it("should hangup to Account 4 on button click", function(done) {
        element.all(by.css('.inCallTxt')).click();
        var activePersonsCalled = element.all(by.css('.inCallTxt'));
        expect(activePersonsCalled.count()).toBe(0);
        setTimeout(done, 1000);
    });
    /* TO-DO
        Make a test simulation calling all the other three accounts simultaiously
        Currently there is a bug and this is not possible
    */
});
