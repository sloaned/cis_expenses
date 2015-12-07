'use strict';

angular.module('QuickrBooks').controller('projectCreateCtrl', ['$scope', 'projectFactory', function($scope, projectFactory) {

    /* Clears the project save message */
    $scope.clearResult = function() {
        if ($scope.result !== undefined || $scope.result !== "") {
            $scope.result = "";
        }
    }

    /* Shows the save button only if project name is valid. */
    $scope.textInput = function() {
        var namePattern = new RegExp("^[a-zA-Z0-9\-_ ]{1,25}$");

        if($scope.projectName !== undefined) {
            if (namePattern.test($scope.projectName)) {
                $scope.showButton = true;
            } else {
                $scope.showButton = false;
            }
        }
    }

    /* Saves the new project to the database, displays a save message,
       and resets the create new project text box. */
    $scope.saveProject = function() {
        var newProject = {name: $scope.projectName};
        projectFactory.create(newProject);
        $scope.showButton = false;
        $scope.result = "Project " + $scope.projectName + " saved.";
        $scope.projectName = "";
    }

}]);