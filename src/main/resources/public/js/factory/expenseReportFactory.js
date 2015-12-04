/**
 * Created by ddelaney on 12/3/2015.
 */
angular.module('QuickrBooks').factory('expenseReportFactory', ['$http',
    function($http) {
        return {
            createExpenseReport: function(){
                $http.post('/expense-report');
            },
            getDatExpenseReport: function(){
                return $http.get('/expense-report');
            }
        };
    }
]);