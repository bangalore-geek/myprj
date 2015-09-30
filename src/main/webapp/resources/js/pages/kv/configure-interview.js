defysope.controller('ConfigureRequirementCtrl', ['$scope', 'WizardHandler', '$http', '$timeout', function($scope, WizardHandler, $http, $timeout) {

	  /*Summary for wizard*/
	  $scope.thisSummary = {
		thisRequirement :{},
		thisRequirementList :{},
		thisRequirementCandidateList : {},
		candidateEmailIdError: false,
		pageTitle: 'Add Requirement'
	  };
	  
	  /*==============================Load requirement =========================================*/
	    $scope.loadRequirementList = function() {
	    	$http.get(_context + '/kv/load-requirement-list').then(
	    		function(response) {
	    			$scope.thisSummary.thisRequirementList = response.data.requirementList;
	    		});
	     };
	     $scope.loadRequirementList();

	  /*==============================Save related code =========================================*/
	  /*Save Requirement*/
	  $scope.thisRequirement = {};
		$scope.saveRequirement = function(requirement) {
			$http.post(_context + '/kv/save-requirement', requirement).success(function(response) {
				$scope.thisSummary.thisRequirement = response.thisRequirement;
				$scope.thisSummary.pageTitle = "Requirement: " + response.thisRequirement.jobCode;
				toastr.success('Requirement saved successfully.');
				$scope.thisRequirement = {};
				$scope.loadRequirementList();
			});
		};
	  
		
		/*============================ save candidate =========================*/
		$scope.thisCandidate = {};
		$scope.saveCandidate = function(thisCandidate) {
			$http.post(_context + '/kv/save-candidate',
					thisCandidate).then(function(response) {
				$scope.thisSummary.thisRequirementCandidateList = response.data.thisRequirementCandidateList;
				toastr.success('Candidate saved successfully.');
				$scope.thisCandidate = {};
			});
		};
		  
		  /*load trainee list for wizard last step*/
		  $scope.loadCandidate = function(requirementId){
			$http.get(_context + '/kv/load-candidate-list?requirementId='+requirementId).then( function(response) {
			  $scope.thisSummary.thisRequirementCandidateList = response.data.candidateList;
			});
		  };
		  
		  /*delete candidate*/
		  $scope.deleteTrainee = function(id, index) {
			if ( window.confirm("Are u sure delete candidate") ) {
				$http['delete'](_context + '/kv/delete-trainee/' + id).then(function(response) {
					toastr.success('Candidate deleted successfully.');
						$scope.thisSummary.thisRequirementCandidateList.splice( index, 1 );	
				});
			}
		  };
		  
	  $scope.stop=function(){
		return false;
	  };
	  
	  /*after completed wizard*/
	  $scope.ShowFinish = function() {
		window.location = _context + "/success-login";
	  };
	  
	  $timeout(function(){
	    $scope.curr = 'Add Course'; 
	  },100);
	  
	  /*Wizard properties*/
      $scope.st="";
      $scope.finished = function() {};
      $scope.logStep = function() {
    	window.scrollTo(0, 0);
      };
      $scope.goBack = function() {
    	  window.scrollTo(0, 0);
        WizardHandler.wizard().goTo(0);
      };
 }]);