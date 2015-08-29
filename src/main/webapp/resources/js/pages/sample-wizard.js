defysope.controller('WizardCtrl', function($scope, WizardHandler, $http, $timeout) {
  $scope.stop=function(){
    return false;
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
  
  $scope.loadEditCourse = function() {
	$http.get(_context + '/load-edit-course').then(
		function(response) {
			$scope.editCourseId = response.data.editCourseId;
			$scope.trainee.assesmentMasterId = $scope.editCourseId;
			$scope.editAssesement = response.data.editCourse;
			console.log($scope.editAssesement);
			$scope.trainingListForEditCourse = response.data.viewCourseAssesmentList;
		});
  };
  
  $scope.loadEditTraining = function() {
	$http.get(_context + '/load-edit-training').then(
	function(response) {
		$scope.editTrainingId = response.data.editTrainingId;
		if ($scope.editTrainingId > 0) {
	    	  $scope.curr = 'Add Training';
	      }
		$scope.trainee.assesmentMasterTrainingId = $scope.editTrainingId;
		console.log(response.data.editTrainings);
		$scope.editAssesmentCourses = response.data.editTraining;
	});
  };
  $scope.loadEditTraining();
  $scope.loadEditCourse();
  
  
  /*save trainee*/
	$scope.traineeList = [];
	$scope.saveTrainee = function($thisTrainee) {
		if ($thisTrainee.assesmentMasterTrainingId == 0) {
			$thisTrainee.assesmentMasterTrainingId = $scope.newAssesmentAddedId;
		}
		$http.post(_context + '/save-trainee',
				$thisTrainee).then(function(response) {
					toastr.success('Trainee saved successfully.');
					$scope.traineeList = response.data.traineeList;
					
		});
	};

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
		console.log("$scope.editAssesement--> "+$scope.editAssesement.id);
		console.log("$scope.newAddedCourse.id-->"+$scope.newAddedCourse.id);
		
		
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
        console.log($scope.st);
    };
    $scope.goBack = function() {
        WizardHandler.wizard().goTo(0);
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
    
    $scope.obj = {showTrainee:false};
    $scope.loadTrainee = function(){
    	if($scope.obj.showTrainee){
    		console.log('loading trainee');
    		
    			$http.get(_context + '/load-training?trainingId='+$scope.newAssesmentAddedId).then( function(response) {
    				$scope.traineeList = response.data.traineeList;
    			});
    		
    	}
    };
 });