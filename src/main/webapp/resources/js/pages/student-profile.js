defysope.controller('StudentDetailsCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {
			$scope.studentDetails = {
				profile : {
					data : {},
					editable : false
				},
				education : {
					data : {},
					editable : false
				},
				address : {
					data : {},
					editable : false
				},
				workhistory : {
					data : {},
					editable : false
				}
			};
			
			$scope.enableEdit = function(key){
				console.log(key);
				$scope.studentDetails[key].editable = !$scope.studentDetails[key].editable; 
			};
			
			$scope.cancel = function(key){
				$scope.studentDetails[key].editable = false;
			};
			
			$scope.viewStudentProfile = function() {
				$http.get(_context + '/load-student-detail').success(
						function(response) {
							console.log(response);
							$scope.studentDetails.profile.data = response.profile;
							
							$scope.studentDetails.education.data = response.education;
							$scope.studentDetails.workhistory.data = response.workhistory;
						});
			};
			$scope.viewStudentProfile();
			
			$scope.showGreeting = false;
			
			$scope.saveStudentProfile = function() {
				$http.post(_context + '/save-student-profile',
						$scope.studentDetails.profile.data).then(function(response) {
							$scope.studentDetails.profile.editable = false;
				});
			};
			$scope.saveStudentEducation = function() {
				$http.post(_context + '/save-student-education',
						$scope.studentDetails.education.data).then(function(response) {
							$scope.studentDetails.education.editable = false;
				});
			};
			$scope.saveStudentworkhistory = function() {
				$http.post(_context + '/save-student-workhistory',
						$scope.studentDetails.workhistory.data).then(function(response) {
							$scope.studentDetails.workhistory.editable = false;
				});
			};
			$scope.open = function($event) {
			    $event.preventDefault();
			    $event.stopPropagation();

			    $scope.opened = true;
			  };
		} ]);