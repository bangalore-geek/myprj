defysope.controller('AttendInterviewCtrl', [ '$scope', '$http', function ($scope, $http) {
	$scope.thisSummary = {
			thisCompany : {}
	};	
	
	$http.get(_context + '/kv/laod-schedule-interview-data').then(function(response) {
		$scope.thisSummary.thisCompany = response.data.thisCompany;
	});

}]);