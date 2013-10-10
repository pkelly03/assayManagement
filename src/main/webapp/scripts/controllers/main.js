'use strict';

angular.module('assayManagementApp')
    .controller('MainCtrl', function ($scope, $resource) {

        var AssayService = $resource('rest/assays', {}, {
            post: {method: 'POST', responseType: 'text'}
        });

        $scope.generateId = function () {
            $scope.assayId = AssayService.post();
        }

    });
