defysope.controller('TestCtrl', function($scope, WizardHandler, $http) {
  $scope.stop=function(){
    return false;
  };
  
  
  
	$scope.qb = [];
	
	$http.get(_context+'/load-question').then(function(res){
		$scope.qb = res.data.questionList
	})
	
	  $scope.loadQuestion = function() {
		$http.get(_context + '/load-question').then(
			function(response) {
				console.log(response.questionList);
			});
	  };
	
	
	$scope.correctkAnswerCount = 0;
	$scope.questionAttempetCount = 0;
	$scope.correctkAnswer={ans: ''};
	
	$scope.checkAnswer = function($thisQuestion) {
		$check = $scope.correctkAnswer.ans;
		if ($check == $thisQuestion.ans) {
			console.log("correct");
			$scope.correctkAnswerCount = $scope.correctkAnswerCount + 1; 
		} else {
			console.log("wrong");
		}
	};

	$scope.question = $scope.qb[0];
	$scope.yogesh = {};
	$scope.disablegetQuestion = false;
	
	$scope.getQuestion = function($thisQuestion) {
		console.log("Question called >>>> ");
		$scope.question = $scope.qb[Math.floor(Math.random() *  $scope.qb.length)];
		
	};

	$scope.getQuestion();
	
    $scope.st="";
    $scope.finished = function() {
    };

    $scope.logStep = function() {
        console.log($scope.st);
    };
    
    $scope.questionStep = function() {
        console.log($scope.st);
    };
    
    $scope.loadQuestin=function(){
    	$http.get(_context+'/load-question').then(function(res){
    		$scope.qb = res.data.questionList
    	})
    }

    $scope.goBack = function() {
        WizardHandler.wizard().goTo(0);
    };
 });