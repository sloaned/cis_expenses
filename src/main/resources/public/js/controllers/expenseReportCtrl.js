/**
 * Created by ddelaney on 12/3/2015.
 */
app.controller('expenseReportCtrl', ['$scope', 'expenseReportFactory','projectFactory',
    function($scope, expenseReportFactory,projectFactory){
        var expenseReport = {};

        $scope.save = function(){
            expenseReport.name = $scope.inputExpenseReportName;
            expenseReportFactory.createExpenseReport(expenseReport);
        }
    }
]);