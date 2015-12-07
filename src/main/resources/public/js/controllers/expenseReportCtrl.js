/**
 * Created by ddelaney on 12/3/2015.
 */
app.controller('expenseReportCtrl', ['$scope', 'expenseReportFactory', 'LineItemTypes',
    function($scope, expenseReportFactory, LineItemTypes){
        var expenseReport = {};
        expenseReport.name = $scope.inputExpenseReportName;

        $scope.save = function(){
            expenseReportFactory.createExpenseReport(expenseReport);
        }

        $scope.addItem = function(){
        console.log("I called the addItem function");
        console.log($scope.drpdwnvalue);
            var lineItem = angular.element('Hi');
            var selectBox = angular.element(document.querySelector('#drpdwnvalue'));
            selectBox.append(lineItem);
        }

        $scope.LineItemTypes = LineItemTypes.data;
        console.log($scope.LineItemTypes);
    }
]);