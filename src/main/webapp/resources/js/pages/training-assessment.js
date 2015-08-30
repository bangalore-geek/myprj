defysope.controller('TrainingAssessmentCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {
			
			$scope.trainings = {};

			$scope.loadTrainings = function() {
				$http.get(_context + '/load-trainings').success(
					function(response) {
						$scope.trainings = response.trainingList;
					});
			};
			
			$scope.loadTrainings();
		} ]);