/**
 * Created by ddelaney on 12/3/2015.
 */
app.controller('expenseReportCtrl', ['$scope', 'expenseReportFactory',
    function($scope, expenseReportFactory){
        var expenseReport = {};

        $scope.save = function(){
            expenseReport.name = $scope.inputExpenseReportName;
            expenseReportFactory.createExpenseReport(expenseReport);
        }
    }
]);