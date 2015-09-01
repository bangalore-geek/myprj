defysope.controller('AssesementCoursesCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {

			$scope.editAssesmentCourses = {};
			
			$scope.assesementList = {
					data : {},
					editableForm : false
			};
			$scope.viewAssesement = function() {
				$http.get(_context + '/load-assesement').success(
						function(response) {
							$scope.assesementList.data = response.viewAssesmentList;
						});
			};
			$scope.viewAssesement();
			
			$scope.assesmentCourses = {
					data : {},
					editableForm : false
			};
			$scope.viewAssesmentType = function() {
				$http.get(_context + '/load-course-assesement').success(
					function(response) {
						$scope.assesmentCourses.data = response.viewCourseAssesmentList;
					});
			};
			
			$scope.enableAddForm = function(){
				$scope.assesmentCourses.editableForm = !$scope.assesmentCourses.editableForm;
			};
			
			$scope.enableEditForm = function($assesmentCourse){
				$scope.assesmentCourses.editableForm = !$scope.assesmentCourses.editableForm;
				$scope.editAssesmentCourses = $assesmentCourse;
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
			
			$scope.deleteAssesementCourse = function(id, index) {
				if ( window.confirm("Are u sure") ) {
					$http['delete'](_context + '/delete-assesement-course/' + id,
							$scope.AssesementCourse).then(function(response) {
								$scope.assesmentCourses.data = response.data.viewCourseAssesmentList;
					});
				}
			};
		} ]);