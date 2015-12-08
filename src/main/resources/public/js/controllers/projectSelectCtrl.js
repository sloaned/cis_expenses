/**
 * Created by Jeremy on 12/7/2015.
 */
app.controller('projectSelectCtrl', ['$scope','getAllProjects',
  function($, projects){
    $.projects = projects.data;
    $.expenseReport.project={};

    $.addItem = function(){
      $.expenseReport.project.id = $.dropdownvalue.id;
    }

  }
]);