/**
 * Created by ddelaney on 12/3/2015.
 */
app.controller('expenseReportCtrl', ['$scope', 'expenseReportFactory', 'LineItemTypes',
    function($scope, expenseReportFactory, LineItemTypes){
        var expenseReport = {};
        $scope.lineItems = [];
        expenseReport.name = $scope.inputExpenseReportName;

        $scope.save = function(){
            expenseReportFactory.createExpenseReport(expenseReport);
        }

        $scope.addItem = function(){
            var item = $scope.dropdownvalue;
            var arr = $scope.lineItems;
            if(arr.indexOf(item) == -1){
            arr.push(item);
            }
        }

        $scope.LineItemTypes = LineItemTypes.data;
    }
]);