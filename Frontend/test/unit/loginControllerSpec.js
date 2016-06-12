'use strict';

describe('Frontend', function() {
    //Mocking our modules prior tests execution
    beforeEach(module('Frontend'));
    beforeEach(module('loginModule'));

    describe('LoginController', function() {
        /*Decaring local variable in which we'll store the futurely injected services
        and use them as references*/
        var scope, $httpBackend;

        beforeEach(inject(function(_$httpBackend_, $rootScope, $controller) {
            /*Assigning $httpBackend to the local variable $httpBackend
            We added _ in our dependencies to avoid conflicting with our variables.
            Angularjs will strip out the _ and inject the dependencies.*/
            $httpBackend = _$httpBackend_;

            //Setup a mock backend to handle the fetching data from people.json
            $httpBackend.expectGET('app/shared/people.json').
            respond([{
                "userName": "Account 1",
                "id": 1,
                "imageUrl": "",
                "txtRealm": "10.0.3.126",
                "txtPrivateIdentity": "6017",
                "txtPublicIdentity": "6017@10.0.3.126",
                "txtPassword": "0000"
            }, {
                "userName": "Account 2",
                "id": 2,
                "imageUrl": "",
                "txtRealm": "10.0.3.126",
                "txtPrivateIdentity": "6018",
                "txtPublicIdentity": "6018@10.0.3.126",
                "txtPassword": "0000"
            }, {
                "userName": "Account 3",
                "id": 3,
                "imageUrl": "",
                "txtRealm": "10.0.3.126",
                "txtPrivateIdentity": "6019",
                "txtPublicIdentity": "6019@10.0.3.126",
                "txtPassword": "0000"
            }, {
                "userName": "Account 4",
                "id": 4,
                "imageUrl": "",
                "txtRealm": "10.0.3.126",
                "txtPrivateIdentity": "6020",
                "txtPublicIdentity": "6020@10.0.3.126",
                "txtPassword": "0000"
            }]);

            scope = $rootScope.$new();
            $controller('LoginController', {
                $scope: scope
            });
        }));


        it('should compare the 4 users fetched from xhr as a string', function() {
            expect(scope.people).toEqual([]);
            $httpBackend.flush();
            console.log('Loaded users: ' + scope.people.length);
            expect(scope.people.toString()).toEqual([{
                "userName": "Account 1",
                "id": 1,
                "imageUrl": "",
                "txtRealm": "10.0.3.126",
                "txtPrivateIdentity": "6017",
                "txtPublicIdentity": "6017@10.0.3.126",
                "txtPassword": "0000"
            }, {
                "userName": "Account 2",
                "id": 2,
                "imageUrl": "",
                "txtRealm": "10.0.3.126",
                "txtPrivateIdentity": "6018",
                "txtPublicIdentity": "6018@10.0.3.126",
                "txtPassword": "0000"
            }, {
                "userName": "Account 3",
                "id": 3,
                "imageUrl": "",
                "txtRealm": "10.0.3.126",
                "txtPrivateIdentity": "6019",
                "txtPublicIdentity": "6019@10.0.3.126",
                "txtPassword": "0000"
            }, {
                "userName": "Account 4",
                "id": 4,
                "imageUrl": "",
                "txtRealm": "10.0.3.126",
                "txtPrivateIdentity": "6020",
                "txtPublicIdentity": "6020@10.0.3.126",
                "txtPassword": "0000"
            }].toString());
        });
        it('should load 4 users fetched from xhr', function() {
            expect(scope.people).toEqual([]);
            $httpBackend.flush();
            expect(scope.people.length).toEqual([{
                "userName": "Account 1",
                "id": 1,
                "imageUrl": "",
                "txtRealm": "10.0.3.126",
                "txtPrivateIdentity": "6017",
                "txtPublicIdentity": "6017@10.0.3.126",
                "txtPassword": "0000"
            }, {
                "userName": "Account 2",
                "id": 2,
                "imageUrl": "",
                "txtRealm": "10.0.3.126",
                "txtPrivateIdentity": "6018",
                "txtPublicIdentity": "6018@10.0.3.126",
                "txtPassword": "0000"
            }, {
                "userName": "Account 3",
                "id": 3,
                "imageUrl": "",
                "txtRealm": "10.0.3.126",
                "txtPrivateIdentity": "6019",
                "txtPublicIdentity": "6019@10.0.3.126",
                "txtPassword": "0000"
            }, {
                "userName": "Account 4",
                "id": 4,
                "imageUrl": "",
                "txtRealm": "10.0.3.126",
                "txtPrivateIdentity": "6020",
                "txtPublicIdentity": "6020@10.0.3.126",
                "txtPassword": "0000"
            }].length);
        });
    });
});
