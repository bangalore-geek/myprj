defysope.controller('ManageCompanyUserCtrl', ['$scope','$http',
function($scope, $http) {
		
	$scope.trainings = {};
	$http.get(_context + '/kv/corporate/coordinator').success(
			function(response) {
				$scope.trainings = response.trainingList;
	});
} ]);