angular.module('defysope', []).controller('CompanyRegestrationCtrl', ['$scope', '$http', function($scope, $http) {
			$scope.thisCompany = {};	
			
			$scope.saveCompany = function(thisCompany) {
				console.log($scope.thisCompany);
				$http.post('/corpyogi/save-company-registration',
						$scope.thisCompany).then(function(response) {
							$scope.thisCompany = {};
							toastr.success('Congratulations! you registered up successfully');
				});
			};
}]);