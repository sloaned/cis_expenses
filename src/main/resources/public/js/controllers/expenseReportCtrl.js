/**
 * Created by ddelaney on 12/3/2015.
 */
app.controller('expenseReportCtrl', ['$scope', 'expenseReportFactory', 'getExpenseReport',
    function($scope, expenseReportFactory, getExpenseReport){
        $scope.LineItemTypes = expenseReportFactory.getAllListItems;
    }
]);