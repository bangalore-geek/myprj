defysope.controller('TrainingListCtrl', [ '$scope', '$http',
		function($scope, $http) {

	$scope.training = {};
	
	// load training list
	$http.get(_context + '/kv/load-tranings').then(
	  function(response) {
		$scope.courseId = response.data.courseIdFilter;
		$scope.training = response.data.trainingList;
	});
} ]);