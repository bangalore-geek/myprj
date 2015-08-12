defysope.controller('AssesementCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {
			
			$scope.editAssesement = {};
			$scope.assesmentType = {data : {}};
			
			$scope.assesementList = {
					data : {},
					editableForm : false
			};
			
			$scope.assesementCourseList = {
					data : {},
					editableForm : false
			};
			
			$scope.viewAssesement = function() {
				$http.get(_context + '/load-assesement').success(
						function(response) {
							console.log(response);
							$scope.assesementList.data = response.viewAssesmentList;
						});
			};
			
			$scope.enableAddForm = function(){
				$scope.assesementList.editableForm = !$scope.assesementList.editableForm;
			};
			
			$scope.enableEditAssesement = function(assesement){
				$scope.assesementList.editableForm = !$scope.assesementList.editableForm;
				$scope.editAssesement = assesement;
			};
			
			$scope.viewAssesement();
			
			$scope.saveAssesement = function($assesement) {
				$http.post(_context + '/save-assesement',
						$scope.editAssesement).then(function(response) {
							$scope.assesementList.editableForm = false;
							 $scope.assesementList.data.push($assesement);
							 $assesement = {};
							
				});
			};
			
			$scope.viewAssesmentType = function() {
				$http.get(_context + '/load-assesmentType').success(
						function(response) {
							console.log(response);
							$scope.assesmentType.data = response.viewAssesmentTypeList;
						});
			};
			
			$scope.viewAssesement = function() {
				$http.get(_context + '/load-course-assesement').success(
						function(response) {
							console.log(response);
							$scope.assesementCourseList.data = response.viewCourseAssesmentList;
						});
			};
			
			$scope.viewAssesmentType();
		} ]);