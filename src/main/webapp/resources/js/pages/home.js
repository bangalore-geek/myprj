defysope.controller('HomeCtrl', [ '$scope', '$http', function($scope, $http) {

	$scope.windowList = [
	         			{ "id": 1, "title": "Skill Set" ,
	            			"filterTemplate" : "resources/template/dashboard/skillset/filter-template.html" ,
	            			"storeTemplate" : "resources/template/dashboard/skillset/store-template.html" ,
	            			"dataJson" : "res/sampledata/currentorder/data.json",
	        				"enableRemoveSession" : false,
	        				"enableRemovePermanent" : false,
	        				"showOptions":true,
	        				"flag":false
	            		},
	            		{ "id": 1, "title": "Experience" ,
	            			"filterTemplate" : "resources/template/dashboard/experience/filter-template.html" ,
	            			"storeTemplate" : "resources/template/dashboard/experience/store-template.html" ,
	            			"dataJson" : "res/sampledata/currentorder/data.json",
	        				"enableRemoveSession" : false,
	        				"enableRemovePermanent" : false,
	        				"showOptions":true,
	        				"flag":false
	            		}

	          ]
} ]);