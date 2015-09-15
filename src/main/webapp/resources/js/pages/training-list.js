defysope.controller('TrainingListCtrl', [ '$scope', '$http',
		function($scope, $http) {

	$scope.training = {
	  title : 'headerfdvdggbgbbggg',
	  content : {}
	};
	
	$http.get(_context + '/corpyogi/kv/load-course-tranings').then(
	  function(response) {
		$scope.courseId = response.data.courseIdFilter;
		$scope.training.content = response.data.viewCourseAssesmentList;
	});
	
	$scope.assesmentWizard = function(){
	  window.location = _context + "/course/add/wizard";
	};
	
    $scope.status = {
      isFirstOpen: true,
      isFirstDisabled: false
    };
} ]);