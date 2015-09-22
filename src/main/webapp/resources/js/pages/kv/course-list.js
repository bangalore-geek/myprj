defysope.controller('CourseListCtrl', [ '$scope', '$http', function ($scope, $http) {
	$scope.courses = {};	
	
	$scope.toggleActive = function(thisCourse) {
		$http.post(_context + '/kv/edit/course-active',
				thisCourse).then(function(response) {
				if(response.data.success){
					thisCourse.active=!thisCourse.active;
				}
		});
	};

	// load courses when page is loaded
	$http.get(_context + '/kv/load-courses').success(
	function(response) {
		$scope.courses = response.viewAssesmentList;
	});
}]);