/**
 * Created by ddelaney on 12/3/2015.
 */
app.controller('expenseReport', ['$scope', 'expenseReportFactory', 'getExpenseReport',
    function($scope, expenseReportFactory, getExpenseReport){
        $scope.expenseReports = getExpenseReport;

    }
]);