'use strict';

describe('Javascript unit tests', function () {

    beforeEach(module('assayManagementApp'));

    var scope,
        httpBackend;

    beforeEach(inject(function ($injector) {
        httpBackend = $injector.get('$httpBackend');
    }));

    describe("CreateAssayCtrl", function() {

        beforeEach(inject(function ($controller, $rootScope) {
            scope = $rootScope.$new();
            $controller('CreateAssayCtrl', {
                $scope: scope
            });
        }));

        describe('generateId', function () {
            it('should make a call to assays rest service', function () {
                httpBackend.expectPOST("rest/assays").respond("{\"id\":1}");
                scope.generateId();
                httpBackend.flush();
                expect(scope.assayId.id).toBe(1);
            });
        });
    });

    describe("ViewAssayCtrl", function() {

        it('should retrieve an Assay from rest service', inject(function ($controller, $rootScope ) {

            httpBackend.expectGET("rest/assays/1").respond("{\"id\":1}");
            scope = $rootScope.$new();
            $controller('ViewAssayCtrl', {
                $scope: scope,
                $routeParams: {assayId:1}
            });
            httpBackend.flush();

            expect(scope.assayId.id).toBe(1);
        }));

    });
});
