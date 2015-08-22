defysope.controller('WizardCtrl', function($scope, WizardHandler, $http) {
  $scope.stop=function(){
    return false;
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
	
	
	
	
	
	$scope.saveAssesement = function($assesement) {
		$http.post(_context + '/save-assesement',
				$scope.editAssesement).then(function(response) {
					$scope.editAssesement = response.data.viewAssesment;
		});
	};
	$scope.saveAssesementCourse = function($assesementCourse) {
		$http.post(_context + '/save-assesement-course',
				$scope.editAssesmentCourses).then(function(response) {
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