defysope.controller('WizardCtrl', function($scope, WizardHandler, $http) {
  $scope.stop=function(){
    return false;
  };
  
  $scope.trainingListForEditCourse = {};
  $scope.loadEditCourse = function() {
	$http.get(_context + '/load-edit-course').then(
			function(response) {
				console.log(response);
				$scope.editCourseId = response.data.editCourseId;
				console.log('$scope.editCourseId',$scope.editCourseId);
				$scope.editAssesement = response.data.editCourse;
				$scope.trainingListForEditCourse = response.data.viewCourseAssesmentList;
			});
  };
  $scope.loadEditCourse();
 
  
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
  
  $scope.editAssesement = {};
  $scope.editAssesmentCourses = {};
  
  $scope.assesmentCourses = {};
  $scope.assesments = {
		  assesment : $scope.editAssesement,
		  courses : $scope.editAssesmentCourses
  };
  
  $scope.assesmentType = {data : {}};
  $scope.assesementList = {data : {}};

	$scope.ShowFinish = function() {
		window.location = _context + "/success-login";
	};
	
	$scope.viewAssesmentType = function() {
		$http.get(_context + '/load-assesmentType').success(
				function(response) {
					console.log(response);
					$scope.assesmentType.data = response.viewAssesmentTypeList;
				});
	};
	$scope.viewAssesmentType();
	$scope.viewAssesement = function() {
		$http.get(_context + '/load-assesement').success(
				function(response) {
					console.log(response);
					$scope.assesementList.data = response.viewAssesmentList;
				});
	};
	$scope.viewAssesement();
	
	$scope.viewAssesement();
	
	$scope.saveAssesement = function($assesement) {
		$http.post(_context + '/save-assesement',
				$scope.editAssesement).then(function(response) {
					$scope.editAssesement = response.data.viewAssesment;
					$assesement.id = response.data.newCourseId;
					$scope.assesementList.data.push($assesement);
		});
	};
	$scope.saveAssesementCourse = function($assesementCourse) {
		$http.post(_context + '/save-assesement-course',
				$assesementCourse).then(function(response) {
					$scope.editAssesmentCourses = response.data.viewAssesmentCourse;
		});
	};
  
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
 });