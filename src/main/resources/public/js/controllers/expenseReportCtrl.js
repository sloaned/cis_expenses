/**
 * Created by ddelaney on 12/3/2015.
 */
app.controller('expenseReportCtrl', ['$scope', '$state', 'expenseReportFactory', 'LineItemTypes',
    function($scope, $state, expenseReportFactory, LineItemTypes){
        $scope.expenseReport = {};

        $scope.expenseReport.lineItems = [];

        $scope.save = function() {
            expenseReportFactory.createExpenseReport($scope.expenseReport).then(
                function(success) {
                    $state.go("viewReports", {}, {reload: true})
                },
                function(error) {
                    console.log("working as intended");
                }
            );

        }

        $scope.addItem = function() {
            var item = {};
            console.log($scope.dropdownvalue)
            item.type = $scope.dropdownvalue;

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