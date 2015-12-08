/**
 * Created by Jeremy on 12/7/2015.
 */
app.controller('projectSelectCtrl', ['$scope','getAllProjects',
  function($, projects){
    $.projects = projects.data;
    $.expenseReport.project={};
    console.log($.projects)
    $.addItem = function(){
      console.log($.dropdownvalue);
      $.expenseReport.project.id = $.dropdownvalue.id;
    }
    $.save = function(){
      console.log("HIIIIIII");
    }
  }
]);