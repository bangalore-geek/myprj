defysope.controller('CandidateProfileCtrl', [ '$scope', '$http', function($scope, $http) {
	
	$scope.thisCandidate = {
			data: '',
			enableEdit: false
	};
	// load company details when page is loaded
	$http.get(_context + '/kv/load-candidate').success(
	function(response) {
		$scope.thisCandidate.data = response.thisCandidate;
	});
	
	$scope.enableEdit = function(){
		$scope.thisCandidate.enableEdit = !$scope.thisCandidate.enableEdit; 
	};
	
	$scope.saveCompanyProfile = function() {
		$http.post(_context + '/kv/save-candidate-profile',
				$scope.thisCandidate.data).then(function(response) {
					toastr.success('Profile saved successfully.');
		});
	};

} ]);