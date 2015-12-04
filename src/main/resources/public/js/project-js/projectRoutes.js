'use strict';

angular.module('QuickrBooks').config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/#/');

    $stateProvider
        .state('createProject', {
            url: '/createProject',
            templateUrl: '/partials/create-project.tpl.html',
            controller: 'projectCtrl'
        });

});