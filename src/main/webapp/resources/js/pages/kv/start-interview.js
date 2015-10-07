defysope.controller('StartInterviewCtrl', [ '$scope', '$http', function($scope, $http) {
	
	$scope.thisSummary = {
			question : {},
			elegibleForInterview : false
	};	
	
	$http.get(_context + '/kv/candidate/load-interview-data').then(function(response) {
		$scope.thisSummary.elegibleForInterview = response.data.elegibleForInterview;
		$scope.thisSummary.question = response.data.elegibleForInterview;
	});

} ]);