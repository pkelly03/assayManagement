'use strict';

describe('Controller: MainCtrl', function () {

    // load the controller's module
    beforeEach(module('assayManagementApp'));

    var MainCtrl,
        scope,
        httpBackend;

    // Initialize the controller and a mock scope
    beforeEach(inject(function ($controller, $rootScope) {
        scope = $rootScope.$new();
        MainCtrl = $controller('MainCtrl', {
            $scope: scope
        });
        var x=1;

    }));

    beforeEach(inject(function ($injector) {
        httpBackend = $injector.get('$httpBackend');
    }));


    describe('generateId', function () {


        it('should make a call to assays rest service', function () {

            httpBackend.expectPOST("rest/assays").respond("{\"id\":1}");

            var result = scope.generateId();
            httpBackend.flush();
            expect(result).not.toBe(null);

        });

    });

});
