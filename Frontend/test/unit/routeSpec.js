'use strict';

describe('Frontend routing', function() {
    /*Decaring local variable in which we'll store the futurely injected services
    and use them as references*/
    var $route, $location, $rootScope, $httpBackend;

    //Mocking module Frontend module before each test
    beforeEach(module('Frontend'));

    //Assigning each and every service to the corresponding local variables
    beforeEach(inject(function(_$route_, _$location_, _$rootScope_, _$httpBackend_) {
        $route = _$route_;
        $location = _$location_;
        $rootScope = _$rootScope_;
        $httpBackend = _$httpBackend_;
    }));

    //Unit tests for login view
    it('should be undefined at the beginning', function() {
        expect($route.current).toBeUndefined;
    });

    it('should load login.html when in login view', function() {

        $httpBackend.expectGET('app/components/login/templates/login.html').respond(200);
        $location.path('/login');
        /*The router works with the digest lifecycle, wherein after the location is set,
        it takes a single digest loop cycle to process the route,
        transform the page content, and finish the routing.
        In order to trigger the location request, I’ll run a digest cycle (on the $rootScope)
        and check that the controller is as expected.*/
        $rootScope.$digest();
        expect($route.current.templateUrl).toBe('app/components/login/templates/login.html');
    });
    it('should load LoginController when in login view', function() {

        $httpBackend.expectGET('app/components/login/templates/login.html').respond(200);
        $location.path('/login');
        $rootScope.$digest();
        expect($route.current.controller).toBe('LoginController');
    });
    it('should route to "/login" path when in login view', function() {
        $httpBackend.expectGET('app/components/login/templates/login.html').respond(200);
        $rootScope.$digest();
        expect($location.path()).toBe('/login');
    });

    //Unit tests for invalid routes pointing to login view
    it('should load the login.html when in invalid path', function() {
        $location.path('/otherwise');
        $httpBackend.expectGET('app/components/login/templates/login.html').respond(200);
        $rootScope.$digest();
        expect($route.current.templateUrl).toBe('app/components/login/templates/login.html');
    });
    it('should load LoginController when in invalid path', function() {
        $location.path('/otherwise');
        $httpBackend.expectGET('app/components/login/templates/login.html').respond(200);
        $rootScope.$digest();
        expect($route.current.controller).toBe('LoginController');
    });
    it('should route to "/login" path when in invalid path', function() {
        $location.path('/otherwise');
        $httpBackend.expectGET('app/components/login/templates/login.html').respond(200);
        $rootScope.$digest();
        expect($location.path()).toBe('/login');
    });

    //Unit tests for dashboard view
    it('should load dashboard.html when in dashboard view', function() {

        $httpBackend.expectGET('app/components/dashboard/templates/dashboard.html').respond(200);
        $location.path('/dashboard');
        $rootScope.$digest();
        expect($route.current.templateUrl).toBe('app/components/dashboard/templates/dashboard.html');
    });
    it('should load DashboardController when in dashboard view', function() {

        $httpBackend.expectGET('app/components/dashboard/templates/dashboard.html').respond(200);
        $location.path('/dashboard');
        $rootScope.$digest();
        expect($route.current.controller).toBe('DashboardController');
    });
    it('should route to "/dashboard" path when in dashboard view', function() {
        $httpBackend.expectGET('app/components/dashboard/templates/dashboard.html').respond(200);
        $location.path('/dashboard');
        $rootScope.$digest();
        expect($location.path()).toBe('/dashboard');
    });
});

/* NOTE: I used to setup a mock backend to handle the fetching of templates from the '../templates/..'.
...or I can use $templateCache service to store the template.$routeProvider will search for the 
template in the $templateCache first before fetching it using http $templateCache.put('templates/main.html', 'main HTML');*/