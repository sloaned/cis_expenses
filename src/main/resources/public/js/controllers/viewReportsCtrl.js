app.controller('viewReportsCtrl', ['$scope', "expenseReportFactory", "ExpenseReports",
    function($scope, expenseReportFactory, ExpenseReports) {
        $scope.reports = ExpenseReports.data;
        console.log($scope.reports);
        console.log('viewReportsCtrl firing...')
    }
]);