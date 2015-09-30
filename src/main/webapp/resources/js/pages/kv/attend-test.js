defysope.controller('TestCtrl', ['$scope', 'WizardHandler', '$http', function($scope, WizardHandler, $http) {
  $scope.stop=function(){
    return false;
  };
  
  $scope.course = {};
  $scope.training = {};
  
  $scope.loadTestDetails = function(){
  	$http.get(_context+'/kv/load-test-details').then(function(res){
  		$scope.course = res.data.course;
  		$scope.training = res.data.training;
  	});
  };
 
  
  
	$scope.qb = [];	
	$scope.question = {};
    $scope.loadQuestin = function(){
    	$http.get(_context+'/kv/load-question').then(function(res){
    		$scope.qb = res.data.questionList;
    		$scope.question = $scope.qb[0];
    	});
    	 $scope.loadTestDetails();
    };
    $scope.loadQuestin();
    
    $scope.i = 1;
    $scope.disablegetQuestion = false;
    $scope.questionAttempetCount = 0;
    $scope.correctkAnswerCount = 0;
    $scope.correctkAnswer={ans: ''};
    
	$scope.nextQuestion = function($thisQuestion) {
		$scope.question = $scope.qb[$scope.i];
		$scope.i = $scope.i + 1;
		if ($scope.i == 5) {
			$scope.disablegetQuestion = true;
		}
		if ($scope.correctkAnswer.ans != "") {
			 $scope.questionAttempetCount = $scope.questionAttempetCount + 1;
			 if ($scope.correctkAnswer.ans == $thisQuestion.ans) { /*this is not able to check*/
				 $scope.correctkAnswerCount = $scope.correctkAnswerCount + 1;
			 }
		}
		$scope.correctkAnswer = {ans: ''};
	};
	
    $scope.st="";
    $scope.finished = function() {
    };

    $scope.logStep = function() {
        console.log($scope.st);
    };
    
    $scope.questionStep = function() {
        console.log($scope.st);
    };

    $scope.goBack = function() {
        WizardHandler.wizard().goTo(0);
    };
 }]);