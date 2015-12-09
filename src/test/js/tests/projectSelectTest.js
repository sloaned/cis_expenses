describe('ProjectSelectController', function(){
    beforeEach(module('QuickrBooks'));
    beforeEach(inject(function(_$controller_){
        // The injector unwraps the underscores (_) from around the parameter names when matching
        $controller = _$controller_;
      }));

    describe('$scope.ExpenseReport.project', function(){
        it('sets the project id of an expense report', function(){
            var scope = {};
            var p = {};
            var controller = $controller('projectSelectCtrl', { $scope: scope, getAllProjects:p});
            scope.dropdownvalue = {id:1};

            scope.addItem();
            expect(scope.expenseReport.project.id).toEqual(1);
        })

    });
});