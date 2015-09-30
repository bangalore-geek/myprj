defysope.controller('ManageCompanyUserCtrl', ['$scope','$http', function($scope, $http) {
		
	$scope.manageUsers = {
		roleList :{}
	};
	
/*	$scope.loadRole = function() {
		$http.get(_context + '/load/role').success(function(response) {
			$scope.manageUsers.roleList = response.roleList;
		});
	};
	$scope.loadRole();*/
	
	
}]);