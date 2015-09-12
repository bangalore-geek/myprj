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
  
  /*=======================================================================*/
  
  /*Summary for wizard*/
  $scope.thisSummary = {
	thisCourse :{},
	thisCourseTrainingList : {},
	thisTraineeList :{},
	pageTitle: 'Add Course'
  };
  
  /*==============================Save related code =========================================*/
  /*Save Course*/
  $scope.thisCourse = {};
	$scope.saveCourse = function($course) {
		$http.post(_context + '/save-course', $course).success(function(response) {
			console.log($scope.thisCourse);
			$scope.thisSummary.thisCourse = response.thisCourse;
			$scope.thisSummary.pageTitle = "Course: " + response.thisCourse.name;
			toastr.success('Course saved successfully.');
		});
	};
  
	/*Save Training*/
	$scope.thisTraining = {};
	$scope.saveTraining = function($thisTraining) {
		$thisTraining.assesmentMasterId = $scope.thisSummary.thisCourse.id;
		$http.post(_context + '/save-training', $thisTraining).then(function(response) {
			$scope.thisSummary.thisCourseTrainingList = response.data.trainingList;
			toastr.success('Training saved successfully.');
			$scope.thisTraining = {};
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
			toastr.success('Trainee saved successfully.');
			$scope.thisTrainee = {};
		});
	};

    /*=============================Edit related code ==========================================*/
    /*load edit course*/
    $scope.loadEditCourse = function() {
    	$http.get(_context + '/load-edit-course').then(
    		function(response) {
    			if (response.data.editCourseId == 0) {
    				$scope.thisSummary.pageTitle = "Add Course";
    			} else {
    				$scope.thisSummary.pageTitle = "Course: " + response.data.thisCourse.name;
    			}
    			$scope.thisCourse = response.data.thisCourse;
    			$scope.thisSummary.thisCourse = response.data.thisCourse;
    			$scope.thisSummary.thisCourseTrainingList = response.data.trainingList;
    		});
     };
     $scope.loadEditCourse();
     
     /*load edit training*/
     $scope.editTrainingId = 0;
     $scope.loadEditTraining = function() {
		$http.get(_context + '/load-edit-training').then(
		function(response) {
			$scope.editTrainingId = response.data.editTrainingId;
			if ($scope.editTrainingId > 0) {
		    	  $scope.curr = 'Training';
		      }
			$scope.thisTraining = response.data.thisTraining;
		});
	  };
	  $scope.loadEditTraining();
	  
	  /*=============================Others ==========================================*/
	  /*load trainee list for wizard last step*/
	  $scope.loadTrainee = function($thisTrainingId){
		$http.get(_context + '/load-trainee-list?trainingId='+$thisTrainingId).then( function(response) {
		  $scope.traineeList = response.data.traineeList;
		});
	  };
	    
	  /*delete trainee*/
	  $scope.deleteTrainee = function(id, index) {
		if ( window.confirm("Are u sure delete trainee") ) {
			$http['delete'](_context + '/delete-trainee/' + id, $scope.education).then(function(response) {
					$scope.traineeList.splice( index, 1 );	
			});
		}
	  };
	  
	  /*load assesment type*/
  	  $scope.assesmentType = {data : {}};
	  $scope.viewAssesmentType = function() {
		$http.get(_context + '/load-assesmentType').success( function(response) {
			$scope.assesmentType.data = response.viewAssesmentTypeList;
		});
	  };
	  $scope.viewAssesmentType();
	  
	  /*after completed wizard*/
	  $scope.ShowFinish = function() {
		window.location = _context + "/success-login";
	  };
	  
	  $timeout(function(){
	    $scope.curr = 'Add Course'; 
	  },100);
	  
	  /*Wizard properties*/
      $scope.st="";
      $scope.finished = function() {};
      $scope.logStep = function() {
    	window.scrollTo(0, 0);
      };
      $scope.goBack = function() {
    	  window.scrollTo(0, 0);
        WizardHandler.wizard().goTo(0);
      };
 });