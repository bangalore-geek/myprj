defysope.controller('TrainingAssessmentCtrl', ['$scope','$http',
function($scope, $http) {
		
	$scope.trainings = {};
	$http.get(_context + '/kv/load-assesments').success(
			function(response) {
				$scope.trainings = response.trainingList;
	});
} ]);