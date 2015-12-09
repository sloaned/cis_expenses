describe('ProjectSelectController', function(){
    beforeEach(module('QuickrBooks'));

    //this loads the controlller
    beforeEach(inject(function(_$controller_){
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