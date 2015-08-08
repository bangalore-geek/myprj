var defysope = angular.module('defysope', [ 'ui.bootstrap', 'ngAnimate' ]);

defysope.directive('skwindow', function() {
	return {
		restrict : 'EA',
		templateUrl : "resources/template/skwindow.template.html",
		scope : {
			title : '@'
		},
		transclude : true,
		link : function(scope, element, attrs, dropdownCtrl, $http) {
			scope.title = attrs.title;
			scope.margin = attrs.margin;
			scope.height = attrs.height;
			scope.windowid = attrs.windowid;
			scope.windowclass = attrs.windowclass;
			scope.windowVisible = true;
			scope.fullscreen = false;
			scope.minimize = false;
			scope.enableRemoveSession = attrs.enableremovesession;
			scope.enableRemovePermanent = attrs.enableremovepermanent;
			scope.minimiseMaximiseWindow = function() {
				if (scope.minimize)
					scope.minimize = false;
				else
					scope.minimize = true;
			};
			scope.resizeWindow = function() {
				if (scope.fullscreen)
					scope.fullscreen = false;
				else
					scope.fullscreen = true;
			};
			scope.hideWindow = function(windowid) {
				scope.windowVisible = false;
			};
			scope.removeWindow = function(windowid) {
				scope.windowVisible = false;
			};

		}
	};
})