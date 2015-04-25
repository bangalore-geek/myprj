angular.module('defysope', []).controller('SignupCtrl', ['$scope', '$http',
				function($scope, $http) {
				$scope.user = {};
				//http://plnkr.co/edit/6W9URNyyp2ItO4aUWzBB?p=preview
				//http://codeseven.github.io/toastr/demo.html
				$scope.createUser = function(){
					$http.post('/careerpoint/signup',$scope.user).then(function(response){
						if(response.data.success){
							toastr.success('Congratulations! you signed up successfully');
						}else{
							toastr.error('Sorry! something goes wrong please try again after some time.');
						}
					});
				};
				}]);