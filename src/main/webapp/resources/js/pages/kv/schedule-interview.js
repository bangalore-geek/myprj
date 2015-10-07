defysope.controller('AttendInterviewCtrl', [ '$scope', '$http', function ($scope, $http) {
	$scope.thisSummary = {
			thisCompany : {},
			thisCandidate :{},
			showScheduleInterview : false
	};	
	
	$http.get(_context + '/kv/laod-schedule-interview-data').then(function(response) {
		$scope.thisSummary.thisCompany = response.data.thisCompany;
		$scope.thisSummary.thisCandidate = response.data.thisCandidate;
	});
	
	$scope.enableScheduleInterview = function(){
		$scope.thisSummary.showScheduleInterview = !$scope.thisSummary.showScheduleInterview; 
	};
	
	/*handling date control for training*/
	$scope.startdateopen = function($event) {
	  $event.preventDefault();
	  $event.stopPropagation();
	  $scope.startdateopened = !$scope.startdateopened;
	};
	
	/*save Schedule interview*/
	$scope.saveScheduleInterview = function() {
		$http.post(_context + '/kv/edit/candidate',
				$scope.thisSummary.thisCandidate).then(function(response) {
			$scope.thisSummary.thisRequirementCandidateList = response.data.thisRequirementCandidateList;
			toastr.success('Candidate saved successfully.');
			$scope.thisCandidate = {};
		});
	};
}]);