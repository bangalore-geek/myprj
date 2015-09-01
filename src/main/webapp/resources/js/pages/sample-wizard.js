defysope.controller('WizardCtrl', function($scope, WizardHandler, $http, $timeout) {
  $scope.stop=function(){
    return false;
  };
  
  /*handling date control for training*/
  $scope.startdateopen = function($event) {
  	$event.preventDefault();
  	$event.stopPropagation();
  	$scope.startdateopened = !$scope.startdateopened;
  };
  $scope.enddateopen = function($event) {
  	$event.preventDefault();
  	$event.stopPropagation();
  	$scope.enddateopened = !$scope.enddateopened;
  };
  $scope.assesmentopen = function($event) {
	  	$event.preventDefault();
	  	$event.stopPropagation();
	  	$scope.assesmentopened = !$scope.assesmentopened;
  };
  
  $scope.thisSummary = {
	thisCourse :{},
	thisCourseTrainingList : {},
	thisTraineeList :{}
  };
  
  $scope.thisCourse = {};
	$scope.saveCourse = function($course) {
		$http.post(_context + '/save-course', $course).then(function(response) {
			$scope.thisCourse = response.data.thisCourse;
			$scope.thisSummary.thisCourse = response.data.thisCourse;
			toastr.success('Course saved successfully.');
		});
	};
  
	$scope.thisTraining = {};
	
	$scope.saveTraining = function($thisTraining) {
		$thisTraining.assesmentMasterId = $scope.thisSummary.thisCourse.id;
		$http.post(_context + '/save-training', $thisTraining).then(function(response) {
			$scope.thisTraining = {};
			$scope.thisSummary.thisCourseTrainingList = response.data.trainingList;
			toastr.success('Training saved successfully.');
		});
	};
	

	/*save trainee*/
	$scope.thisTrainee = {};
	$scope.saveTrainee = function($thisTrainee) {
		$thisTrainee.assesmentMasterId = $scope.thisSummary.thisCourse.id;
		$http.post(_context + '/save-trainee',
				$thisTrainee).then(function(response) {
					toastr.success('Trainee saved successfully.');
					$scope.thisSummary.thisTraineeList = response.data.traineeList;
					$scope.thisTrainee = {};
					
		});
	};
  
    $scope.obj = {showTrainee:false};
    $scope.loadTrainee = function($thisTrainingId){
    			$http.get(_context + '/load-training?trainingId='+$thisTrainingId).then( function(response) {
    				$scope.traineeList = response.data.traineeList;
    			});
    };
  
    $scope.loadEditCourse = function() {
    	$http.get(_context + '/load-edit-course').then(
    		function(response) {
    			$scope.thisCourse = response.data.thisCourse;
    			$scope.thisSummary.thisCourse = response.data.thisCourse;
    			$scope.thisSummary.thisCourseTrainingList = response.data.trainingList;
    		});
     };
     $scope.loadEditCourse();
     
     $scope.loadEditTraining = function() {
		$http.get(_context + '/load-edit-training').then(
		function(response) {
			$scope.thisTraining = response.data.thisTraining;
		});
	  };
	  $scope.loadEditTraining();
  
	  $scope.deleteTrainee = function(id, index) {
			if ( window.confirm("Are u sure delete trainee") ) {
				$http['delete'](_context + '/delete-trainee/' + id, $scope.education).then(function(response) {
						$scope.traineeList.splice( index, 1 );	
				});
			}
	  };
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
 

      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
  
  
  $timeout(function(){
	  $scope.curr = 'Add Course'; 
	 },100);
  
  $scope.trainingListForEditCourse = [];
  
  /*Load course for edit*/
  $scope.trainee = {
	  assesmentMasterId: 0,
	  assesmentMasterTrainingId: 0
  };
  
  $scope.editAssesement = {};
  $scope.editAssesmentCourses = {};
  
  /*edit things load*/
  $scope.editCourseId = 0;
  $scope.editTrainingId = 0;
  

  
  $scope.loadEditTraining = function() {
	$http.get(_context + '/load-edit-training').then(
	function(response) {
		$scope.editTrainingId = response.data.editTrainingId;
		if ($scope.editTrainingId > 0) {
	    	  $scope.curr = 'Add Training';
	      }
		$scope.trainee.assesmentMasterTrainingId = $scope.editTrainingId;
		$scope.editAssesmentCourses = response.data.editTraining;
	});
  };
  $scope.loadEditTraining();
  
  
  


	/*load assesment type*/
  	$scope.assesmentType = {data : {}};
	$scope.viewAssesmentType = function() {
		$http.get(_context + '/load-assesmentType').success( function(response) {
					$scope.assesmentType.data = response.viewAssesmentTypeList;
				});
	};
	$scope.viewAssesmentType();

	/*save course/assesement*/
	$scope.courseSaveSuccess = false;
	$scope.newAddedCourse = {};
	$scope.saveAssesement = function($assesement) {
		$http.post(_context + '/save-assesement',
				$assesement).then(function(response) {
			$scope.editAssesement = $assesement;
			$assesement.id = response.data.newCourseId;
			$scope.newAddedCourse = $assesement;
			$scope.courseSaveSuccess = true;
			$scope.summary.courses = $assesement;
			toastr.success('Course saved successfully.');
		});
	};
	
	/*save training/assesment course*/
	$scope.trainingSaveSuccess = false;
	$scope.newAssesmentAddedId =0;
	$scope.saveAssesementCourse = function($assesementCourse) {
		
		if ($scope.newAddedCourse.id != 0) {
			$assesementCourse.assesmentMasterId = $scope.newAddedCourse.id; 
		}
		if ($scope.editAssesement.id != 0) {
			$assesementCourse.assesmentMasterId = $scope.editAssesement.id;
		}
		$http.post(_context + '/save-assesement-course',
			$assesementCourse).then(function(response) {
			$scope.newAssesmentAddedId = response.data.newAssesmentId;
			if ($scope.trainingListForEditCourse) {
				$scope.trainingListForEditCourse.push($assesementCourse);
			}
			$scope.editAssesmentCourses = $assesementCourse;
			$scope.trainingSaveSuccess = true;
			toastr.success('Training saved successfully.');
		});
	};
	
	/*after completed wizard*/
	$scope.ShowFinish = function() {
		window.location = _context + "/success-login";
	};
	
	/*Wizard properties*/
    $scope.st="";
    $scope.finished = function() {
        alert("Saved successfully");
    };
    $scope.logStep = function() {
    };
    $scope.goBack = function() {
        WizardHandler.wizard().goTo(0);
    };



 });