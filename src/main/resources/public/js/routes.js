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
            controller: 'expenseReportCtrl'
        });

    }]);