defysope.controller('AccordionDemoCtrl', function ($scope, $http) {
  $scope.oneAtATime = true;

  
	$scope.courses = {
			title : 'headerfdvdggbgbbggg',
			content : {}
	};	
	
	
	
	
	
	
	$scope.toggleActive = function($course) {
		console.log($course);
		$http.post(_context + '/edit-course-active',
				$course).then(function(response) {
					if(response.data.success){
						$course.active=!$course.active;
					}
		});
	};
	
	
	
	
	$scope.assesmentWizard = function(){
		console.log("comed >>>>>>>>>>>>>");
		window.location = _context + "/sample-wizard?editCourseId=0";
	};
	
	$scope.viewAssesement = function() {
		$http.get(_context + '/load-assesement').success(
				function(response) {
					console.log(response);
					$scope.courses.content = response.viewAssesmentList;
				});
	};
	$scope.viewAssesement();	  
		  

  $scope.items = ['Item 1', 'Item 2', 'Item 3'];

  $scope.addItem = function() {
    var newItemNo = $scope.items.length + 1;
    $scope.items.push('Item ' + newItemNo);
  };

  $scope.status = {
    isFirstOpen: true,
    isFirstDisabled: false
  };
});