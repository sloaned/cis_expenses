'use strict';

angular.module('QuickrBooks').factory('projectFactory', ['$http', function($http) {
    return {
        create: function(project, response) {
            $http({
                method: 'POST',
                url: "/project",
                data: project,
            }).success(response);
        }
    };
}]);