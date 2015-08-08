defysope.controller('HomeCtrl', [ '$scope', '$http', function($scope, $http) {

	$scope.windowList = [
	         			{ "id": 1, "title": "Skill Set" ,
	            			"filterTemplate" : "resources/template/dashboard/skillset/filter-template.html" ,
	            			"storeTemplate" : "resources/template/dashboard/skillset/store-template.html" ,
	            			"dataJson" : "res/sampledata/currentorder/data.json",
	        				"enableRemoveSession" : false,
	        				"enableRemovePermanent" : false,
	        				"showOptions":true,
	        				"flag":false,
	        				"topMargin":"0px"
	            		},
	            		{ "id": 2, "title": "Experience" ,
	            			"filterTemplate" : "resources/template/dashboard/experience/filter-template.html" ,
	            			"storeTemplate" : "resources/template/dashboard/experience/store-template.html" ,
	            			"dataJson" : "res/sampledata/currentorder/data.json",
	        				"enableRemoveSession" : false,
	        				"enableRemovePermanent" : false,
	        				"showOptions":true,
	        				"flag":false,
	        				"topMargin":"0px",
	        				"height":"550px"
	            		},
	            		{ "id": 3, "title": "Registered Training" ,
	            			"filterTemplate" : "resources/template/dashboard/training/filter-template.html" ,
	            			"storeTemplate" : "resources/template/dashboard/training/store-template.html" ,
	            			"dataJson" : "res/sampledata/currentorder/data.json",
	        				"enableRemoveSession" : false,
	        				"enableRemovePermanent" : false,
	        				"showOptions":true,
	        				"flag":false,
	        				"topMargin":"0px"
	            		},
	            		{ "id": 1, "title": "Training on demand" ,
	            			"filterTemplate" : "resources/template/dashboard/trainingondemand/filter-template.html" ,
	            			"storeTemplate" : "resources/template/dashboard/trainingondemand/store-template.html" ,
	            			"dataJson" : "res/sampledata/currentorder/data.json",
	        				"enableRemoveSession" : false,
	        				"enableRemovePermanent" : false,
	        				"showOptions":true,
	        				"flag":false,
	        				"topMargin":"0px"
	            		},
	            		{ "id": 1, "title": "Skill on demand" ,
	            			"filterTemplate" : "resources/template/dashboard/skillondemand/filter-template.html" ,
	            			"storeTemplate" : "resources/template/dashboard/skillondemand/store-template.html" ,
	            			"dataJson" : "res/sampledata/currentorder/data.json",
	        				"enableRemoveSession" : false,
	        				"enableRemovePermanent" : false,
	        				"showOptions":true,
	        				"flag":false,
	        				"topMargin":"-390px"
	            		}


	          ]
} ]);