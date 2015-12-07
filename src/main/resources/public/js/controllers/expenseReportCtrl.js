/**
 * Created by ddelaney on 12/3/2015.
 */
app.controller('expenseReportCtrl', ['$scope', 'expenseReportFactory', 'LineItemTypes','projectFactory','getAllProjects',
    function($scope, expenseReportFactory, LineItemTypes, projectFactory,getAllProjects){
        var expenseReport = {};
        console.log(getAllProjects.data);
        $scope.projects = getAllProjects.data;
        $scope.lineItems = [];
        expenseReport.name = $scope.inputExpenseReportName;

        $scope.save = function(){
            expenseReport.name = $scope.inputExpenseReportName;
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