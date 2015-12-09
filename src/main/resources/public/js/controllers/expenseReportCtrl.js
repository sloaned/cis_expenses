/**
 * Created by ddelaney on 12/3/2015.
 */
app.controller('expenseReportCtrl', ['$scope', '$state', 'expenseReportFactory', 'LineItemTypes', 'userFactory',
    function($scope, $state, expenseReportFactory, LineItemTypes, userFactory){
        $scope.expenseReport = {};
        $scope.showButton = false;
        userFactory.getCurrentUser().then(
            function(success) {
                if (Object.keys($scope.expenseReport.project).length === 0 ||
                    $scope.expenseReport.project.id === "" ||
                    $scope.expenseReport.project.id === undefined)
                {
                    $scope.expenseReport.project = null;
                }
                $scope.expenseReport.user = success.data;
            }
        );

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
            $scope.showButton = true;
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