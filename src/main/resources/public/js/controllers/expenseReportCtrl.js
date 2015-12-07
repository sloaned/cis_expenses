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
            $(this).before('<div class="form-group"><label for="inputExpenseReportName">{{type.Name}}</label><input type="text" class="form-control" ng-model="inputExpenseReportName" id="inputExpenseReportName" placeholder="Name"></div>');
        }

        $scope.LineItemTypes = LineItemTypes.data;
        console.log($scope.LineItemTypes);
    }
]);