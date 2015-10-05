defysope.controller('CompanyListCtrl', [ '$scope', '$http', function ($scope, $http) {
	$scope.companies = {};	
	
	$scope.approveCompany = function(thisCompany) {
		$http.post(_context + '/administration/approve/company',
				thisCompany).then(function(response) {
				if(response.data.success){
					thisCompany.approve= true;
				}
		});
	};

	// load courses when page is loaded
	$http.get(_context + '/administration/laod/company-list').success(
	function(response) {
		$scope.companies = response.viewCompanies;
	});
}]);