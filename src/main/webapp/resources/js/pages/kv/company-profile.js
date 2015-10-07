defysope.controller('CompanyProfileCtrl', [ '$scope', '$http', function($scope, $http) {
	
	$scope.thisCompany = {
			data: '',
			enableEdit: false,
			enableResetPassword: false
	};
	// load company details when page is loaded
	$http.get(_context + '/kv/load-company').success(
	function(response) {
		$scope.thisCompany.data = response.thisCompany;
	});
	
	$scope.enableEdit = function(){
		$scope.thisCompany.enableEdit = !$scope.thisCompany.enableEdit; 
	};
	
	$scope.enableResetPassword = function(){
		$scope.thisCompany.enableResetPassword = !$scope.thisCompany.enableResetPassword; 
	};
	
	$scope.saveCompanyProfile = function() {
		$http.post(_context + '/kv/save-company-profile',
				$scope.thisCompany.data).then(function(response) {
					toastr.success('Profile saved successfully.');
		});
	};

} ]);