/**
 * Created by ddelaney on 12/3/2015.
 */
app.factory('expenseReportFactory', ['$http',
    function($http) {
        return {
            createExpenseReport: function(data){
                return $http.post('/expense-report', {ExpenseReport: data});
            },
            getDatExpenseReport: function(){
                return $http.get('/expense-report');
            },
            getAllListItems: function(){
                return $http.get('/line-item-types');
            }
        };
    }
]);