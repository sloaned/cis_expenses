/**
 * Created by ddelaney on 12/3/2015.
 */
app.controller('expenseReportCtrl', ['$scope', 'expenseReportFactory', 'LineItemTypes',
    function($scope, expenseReportFactory, LineItemTypes){
        $scope.expenseReport = {};

        $scope.expenseReport.lineItems = [];

        $scope.save = function() {
            expenseReportFactory.createExpenseReport($scope.expenseReport);
        }

        $scope.addItem = function() {
            var item = $scope.dropdownvalue;

            var arr = $scope.expenseReport.lineItems;
            if(arr.indexOf(item) == -1){
                arr.push(item);
            }
        }

        $scope.LineItemTypes = LineItemTypes.data;

        $scope.validateDatMoney = function(datMoney) {
            console.log(datMoney);
        }
    }
]);