defysope.controller('StudentDetailsCtrl', ['$scope', '$http', function($scope, $http) {
			
			$scope.university = {data : {}};
			
			$scope.studentDetails = {
				profile : {
					data : {},
					editable : false
				},
				education : {
					data : {},
					editable : false,
					editableForm : false
				},
				address : {
					data : {},
					editable : false
				},
				workhistory : {
					data : {},
					editable : false,
					editableForm : false
				},
				references : {
					data : {},
					editable : false,
					editableForm : false
				}
			};
			
			$scope.enableEdit = function(key){
				$scope.studentDetails[key].editable = !$scope.studentDetails[key].editable; 
			};
			
			$scope.enableEditReferences = function(key){
				$scope.studentDetails.references[key].editable = !$scope.studentDetails.references[key].editable; 
			};			

			$scope.editWorkHistory = {};
			$scope.editEducation = {};
			
			
			
			$scope.enableAddForm = function(workhistory){
				$scope.studentDetails.workhistory.editableForm = !$scope.studentDetails.workhistory.editableForm;
				$scope.editWorkHistory = workhistory;
			};
			
			$scope.enableAddFormEducation = function(education){
				$scope.studentDetails.education.editableForm = !$scope.studentDetails.education.editableForm;
				$scope.editEducation = education;
			};
			
			$scope.cancel = function(key){
				$scope.studentDetails[key].editable = false;
			};
			
			$scope.viewStudentProfile = function() {
				$http.get(_context + '/load-student-detail').success(
						function(response) {
							$scope.studentDetails.profile.data = response.profile;
						});
				$scope.viewWorkhistory();
				$scope.viewEducation();
				$scope.viewReferences();
			};
			
			$scope.viewWorkhistory = function() {
				$http.get(_context + '/load-student-workhistory').success(
						function(response) {
							$scope.studentDetails.workhistory.data = response.viewWorkhistory;
						});
			};
			
			
			$scope.viewUniversity = function() {
				$http.get(_context + '/load-university').success(
						function(response) {
							$scope.university.data = response.viewUniversity;
						});
			};
			
			$scope.viewEducation = function() {
				$http.get(_context + '/load-student-education').success(
						function(response) {
							$scope.studentDetails.education.data = response.viewEducation;
						});
				$scope.viewUniversity();
			};
			
			$scope.viewReferences = function() {
				$http.get(_context + '/load-student-references').success(
					function(response) {
						$scope.studentDetails.references.data = response.viewReferences;
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
			$scope.saveStudentworkhistory = function($workhistory) {
				$http.post(_context + '/save-student-workhistory',
						$scope.editWorkHistory).then(function(response) {
							$scope.studentDetails.workhistory.editable = false;
							 $scope.studentDetails.workhistory.data.push($workhistory);
							 $workhistory = {};
							 $scope.enableAddForm();
				});
			};
			$scope.deleteStudentworkhistory = function(id, index) {
				if ( window.confirm("Are u sure") ) {
					$http['delete'](_context + '/delete-student-workhistory/' + id,
							$scope.workhistory).then(function(response) {
							$scope.studentDetails.workhistory.data = response.data.viewWorkhistory;	
					});
				}
			};
			
			$scope.saveStudentEducation = function($education) {
				$http.post(_context + '/save-student-education',
						$scope.editEducation).then(function(response) {
							$scope.studentDetails.education.editable = false;
							 $scope.studentDetails.education.data.push($education);
							 $education = {};
							 $scope.enableAddFormEducation();
				});
			};
			$scope.deleteStudenteducation = function(id, index) {
				if ( window.confirm("Are u sure delete education") ) {
					$http['delete'](_context + '/delete-student-education/' + id,
							$scope.education).then(function(response) {
							$scope.studentDetails.education.data = response.data.viewEducation;	
					});
				}
			};
			
			$scope.open = function($event) {
			    $event.preventDefault();
			    $event.stopPropagation();
			    $scope.opened = true;
			  };
		} ]);