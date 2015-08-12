defysope.controller('AssesementCoursesCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {

			$scope.editAssesmentCourses = {};
			
			$scope.assesmentCourses = {
					data : {},
					editableForm : false
			};
			
			$scope.viewAssesmentType = function() {
				$http.get(_context + '/load-course-assesement').success(
					function(response) {
						console.log(response);
						$scope.assesmentCourses.data = response.viewCourseAssesmentList;
					});
			};
			
			$scope.enableAddForm = function(){
				$scope.assesmentCourses.editableForm = !$scope.assesmentCourses.editableForm;
			};
			
			$scope.viewAssesmentType();
			
			$scope.saveAssesementCourse = function($assesementCourse) {
				$http.post(_context + '/save-assesement-course',
						$scope.editAssesmentCourses).then(function(response) {
							$scope.assesmentCourses.editableForm = false;
							 $scope.assesmentCourses.data.push($assesementCourse);
							 $assesementCourse = {};
							
				});
			};
		} ]);