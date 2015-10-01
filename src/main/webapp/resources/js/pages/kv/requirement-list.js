defysope.controller('RequirementListCtrl', [ '$scope', '$http', function ($scope, $http) {
	
	$scope.requirementList = {};	
	
/*	$scope.toggleActive = function(thisCourse) {
		$http.post(_context + '/kv/edit/course-active',
				thisCourse).then(function(response) {
				if(response.data.success){
					thisCourse.active=!thisCourse.active;
				}
		});
	};*/

	// load requirement when page is loaded
	$http.get(_context + '/kv/load-requirement').success(
	function(response) {
		$scope.requirementList = response.requirementList;
	});
	
}]);