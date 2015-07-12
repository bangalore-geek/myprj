defysope.controller('HomeCtrl', [ '$scope', '$http', function($scope, $http) {

	$scope.windowList = [
	         			{ "id": 1, "title": "Current Order Revenue" ,
	            			"filterTemplate" : "" ,
	            			"storeTemplate" : "res/template/dashboard/currentorder/store.template.html" ,
	            			"dataJson" : "res/sampledata/currentorder/data.json",
	        				"enableRemoveSession" : "false",
	        				"enableRemovePermanent" : "false",
	        				"autoRefresh":"true",
	        				"autoPopulate":"true"
	            		},
	        			{ "id": 2, "title": "Unclaimed Orders" ,
	            			"filterTemplate" : "" ,
	            			"storeTemplate" : "res/template/dashboard/unclaimedorder/store.template.html" ,
	            			"dataJson" : "res/sampledata/unclaimedorder/data.json",
	        				"enableRemoveSession" : "false",
	        				"enableRemovePermanent" : "false",
	        				"autoRefresh":"true",
	        				"autoPopulate":"true"
	            		},
	            		{ "id": 3, "title": "Machine Downtime" ,
	            			"filterTemplate" : "res/template/dashboard/machine/filter.template.html" ,
	            			"storeTemplate" : "res/template/dashboard/machine/store.template.html" ,
	            			"dataJson" : "res/sampledata/downtime/data.fuji.json" ,
	            			"machinelistJson" : "res/sampledata/downtime/machine.list.json" ,
	            			"locationlistJson" : "res/sampledata/downtime/location.list.json",
	            			"storeJson" : "res/sampledata/downtime/downtime.store.json",
	        				"enableRemoveSession" : "true",
	        				"enableRemovePermanent" : "true",
	        				"autoRefresh":"true",
	        				"autoPopulate":"true",
	        				"defaultFilter" : {"startDate": "05-01-2008", "endDate" : "05-01-2008", "location": "Chain", "machine": "Fuji 330"}
	            		},
	            		{ "id": 4, "title": "Machine Kiosk" ,
	            			"filterTemplate" : "res/template/dashboard/kiosk/filter.template.html" ,
	            			"storeTemplate" : "res/template/dashboard/kiosk/store.template.html" ,
	            			"dataJson" : "res/sampledata/kiosk/data.json",
	        				"enableRemoveSession" : "true",
	        				"enableRemovePermanent" : "true",
	        				"autoRefresh":"true",
	        				"autoPopulate":"true",
	        				"defaultFilter" : [{"criteria": "Store Number", "value" : "1238"}],
	            			"filterCriteria" : ["Store Number" , "Kiosk IP" , "Software version" , "Template version" , "iMemories version" ,
	        									"TOMO Version" , "Last Reboot" , "C Drive Space (MB)" , "D Drive Space (MB)" ]
	            		}

	          ]
} ]);