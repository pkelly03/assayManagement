'use strict';

angular.module('assayManagementApp', ['ngResource'])
    .config(function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'views/create.html',
                controller: 'CreateAssayCtrl'
            })
            .when('/:assayId', {
                templateUrl: 'views/view.html',
                controller: 'ViewAssayCtrl'
            })
            .otherwise({
                redirectTo: '/'
            });
    });
