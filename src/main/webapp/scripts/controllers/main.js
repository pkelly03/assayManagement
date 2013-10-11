'use strict';

angular.module('assayManagementApp')
    .controller('CreateAssayCtrl', function ($scope, $resource) {

        var assayService = $resource('rest/assays', {}, {});

        $scope.generateId = function () {
            $scope.assayId = assayService.save();
        }

    });

angular.module('assayManagementApp')
    .controller('ViewAssayCtrl', function ($scope, $routeParams, $resource) {

        var assayService = $resource('rest/assays/:assayId', {});
        $scope.assayId = assayService.get({assayId:$routeParams.assayId});

    });


