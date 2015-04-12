defysope.controller('UserListCtrl', ['$scope', '$http',
				function($scope, $http) {

					$scope.list = [{
								title : 'Deepak',
								desc : 'rathor'
							}, {
								title : 'akash',
								desc : 'prasad'
							}, {
								title : 'Bharat',
								desc : 'rathor'
							}]

					$scope.status = {
						isFirstOpen : true,
						isFirstDisabled : false
					};

				}]);