defysope.controller('UserListCtrl', ['$scope', '$http',
function($scope, $http) {
	$scope.userAdministration = {
			roleList : {},
			addForm : {},
			user : {}
	};

	$scope.addFormEnable = function(){
		$scope.userAdministration.addForm = !$scope.userAdministration.addForm; 
	};
	
	$scope.loadRoleList = function() {
		$http.get(_context + '/load/user/role').success(
		function(response) {
			console.log(response);
		});
	};
	$scope.loadRoleList();

/*	$scope.createUser = function(){
	  $http.post(_context + '/corpyogi/administration/userinfo', $scope.userAdministration.user).then(function(res){
		  console.log("SAve success >>>");
		$scope.userAdministration.user = res.data.user;
	  });
	};*/
}]);