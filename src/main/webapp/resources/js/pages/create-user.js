defysope.controller('UserListCtrl', ['$scope', '$http',
				function($scope, $http) {
					$scope.user = {};
					$scope.createUser = function(){
						$http.post('/careerpoint/create-user',$scope.user).then(function(res){
							$scope.user = res.data.user;
						})
					};

				}]);