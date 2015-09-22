defysope.controller('TrainingAttendanceCtrl', ['$scope','$http', function ($scope, $http) {

	$scope.courseList = {};
	$scope.trainingList = {};
	$scope.traineeList = {};
	
	  $http.get(_context + '/load-course').success(
		function(response) {
			$scope.courseList = response.courseList;
		});
	
	$scope.loadTraining = function($courseId) {
		  $http.get(_context + '/load-training-for-course?courseId=' + $courseId).success(
			function(response) {
				$scope.trainingList = response.trainingList;
			});
	};
		
	$scope.loadTrainee = function($thisTrainingId){
		$http.get(_context + '/load-training?trainingId='+$thisTrainingId).then( function(response) {
			$scope.traineeList = response.data.traineeList;
		});
    };
}]);