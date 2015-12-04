'use strict';

angular.module('QuickrBooks').controller('projectCtrl', ['$scope', 'projectFactory', function($scope, projectFactory) {

    $scope.clearResult = function() {
        if ($scope.result !== undefined || $scope.result !== "") {
            $scope.result = "";
        }
    }

    // Shows the save button if there is text box input.
    $scope.textInput = function() {
        var namePattern = new RegExp("^[a-zA-Z0-9\- ]{1,25}$");

        if($scope.projectName !== undefined) {
            if (namePattern.test($scope.projectName)) {
                $scope.showButton = true;
            } else {
                $scope.showButton = false;
            }
        }
    }

    // Sends a post for a new project with the name.
    $scope.saveProject = function() {
        var newProject = {name: $scope.projectName};
        projectFactory.create(newProject, function(project) {
            if (project !== undefined || project !== null) {
                $scope.result = "Project " + $scope.projectName + " saved.";
                $scope.projectName = "";
                $scope.showButton = false;
            }
        });
    }
}]);