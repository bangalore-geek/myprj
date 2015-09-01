defysope.controller('TrainingListCtrl', [ '$scope', '$http',
		function($scope, $http) {
	
	
	$http.get(_context + '/corpyogi/kv/load-course-tranings').then(
			function(response) {
				$scope.courseId = response.data.courseId;
				$scope.training.content = response.data.viewCourseAssesmentList;
			});
	
	
	$scope.oneAtATime = true;

	  
	$scope.training = {
			content : {}
	};
	
	$scope.assesmentWizard = function(){
		window.location = _context + "/sample-wizard";
	};
	
	$scope.viewTrainings = function() {
		$http.get(_context + '/load-course-assesement').success(
				function(response) {
					$scope.courseId = 0;
					$scope.training.content = response.viewCourseAssesmentList;
				});
	};
	$scope.viewTrainings();	  
		  

  $scope.items = ['Item 1', 'Item 2', 'Item 3'];

  $scope.addItem = function() {
    var newItemNo = $scope.items.length + 1;
    $scope.items.push('Item ' + newItemNo);
  };

  $scope.status = {
    isFirstOpen: true,
    isFirstDisabled: false
  };

		} ]);