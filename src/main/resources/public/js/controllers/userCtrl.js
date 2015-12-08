
app.controller('userCtrl', ['$scope', 'userFactory', 
   function($scope, userFactory){
		$scope.userName = "dsloaneee";
		$scope.setUsername = function(){
			$scope.userName = userFactory.getCurrentUser();
		};
	}                               
]);