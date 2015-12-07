/**
 * Created by ddelaney on 12/3/2015.
 */
app.controller('expenseReportCtrl', ['$scope', 'expenseReportFactory',
    function($scope, expenseReportFactory){
        var expenseReport = {};
        expenseReport.name = $scope.inputExpenseReportName;

        $scope.save = function(){
            expenseReportFactory.createExpenseReport(expenseReport);
        }
    }
]);