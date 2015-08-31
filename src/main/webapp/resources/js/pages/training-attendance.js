defysope.controller('TrainingAttendanceCtrl', function ($scope, $http) {


	$scope.courseList = {};
	$scope.trainingList = {};
	$scope.traineeList = {};
	
	$scope.loadCourse = function() {
	  $http.get(_context + '/load-course').success(
		function(response) {
			console.log(response);
			$scope.courseList = response.courseList;
		});
	};
	$scope.loadCourse();
	
	
	$scope.loadTraining = function($courseId) {
		console.log("loD training comwd < ");
		  $http.get(_context + '/load-training-for-course?courseId=' + $courseId).success(
			function(response) {
				$scope.trainingList = response.trainingList;
			});
	};
		
	$scope.loadTrainee = function($thisTrainingId){
	console.log('loading trainee');
		$http.get(_context + '/load-training?trainingId='+$thisTrainingId).then( function(response) {
			$scope.traineeList = response.data.traineeList;
		});
    };

});