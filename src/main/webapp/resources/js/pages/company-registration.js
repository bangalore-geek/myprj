angular.module('defysope', []).controller('CompanyRegestrationCtrl', ['$scope', '$http', function($scope, $http) {
			$scope.thisSummary = {
					thisCompany : {
						productList : [],
						}
			};
			
			// getting selected products
		  $scope.toggleSelection = function toggleSelection(employeeName) {
		     var idx = $scope.thisSummary.thisCompany.productList.indexOf(employeeName);
		     if (idx > -1) {
		    	 $scope.thisSummary.thisCompany.productList.splice(idx, 1);
		     }
		     else {
		    	 $scope.thisSummary.thisCompany.productList.push(employeeName);
		     }
		   };
				   
				   
				  
		   
		   
		   
				   
				   

			$http.get('/corpyogi/load-product-list',
					$scope.thisCompany).then(function(response) {
						$scope.thisSummary.productList = response.data.productList;
			});
			
			$scope.saveCompany = function(thisCompany) {
				$http.post('/corpyogi/save-company-registration',
						$scope.thisSummary.thisCompany).then(function(response) {
							$scope.thisSummary.thisCompany = {};
							toastr.success('Thanks! for your intrest');
				});
			};
}]);