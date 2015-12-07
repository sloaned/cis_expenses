/**
 * Created by ddelaney on 12/3/2015.
 */
'use strict';

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider){

        $urlRouterProvider.otherwise('/');

        $stateProvider.state('project', {
            url:'/project',
            templateUrl: '../templates/project.tpl.html',
            controller: 'projectCtrl'
        }).state('expenseReport', {
            url: '/expense-report',
            templateUrl: '../templates/expense_report.tpl.html',
            controller: 'expenseReportCtrl',
            resolve: {
                LineItemTypes: function(expenseReportFactory) {
                    return expenseReportFactory.getAllListItems();
                },
                getAllProjects: function(projectFactory) {
                    return projectFactory.getAll();
                }
            }
        }).state('createProject', {
                      url: '/createProject',
                      templateUrl: '../templates/project.tpl.html',
                      controller: 'projectCreateCtrl'
        });

    }]);