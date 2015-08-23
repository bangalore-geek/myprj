defysope.controller('TestCtrl', function($scope, WizardHandler, $http) {
  $scope.stop=function(){
    return false;
  };
  
	$scope.qb = [
	             {
					que : 'What is a group of contacts with whom you have a selling relationship?',
					op1 : 'Contact',
					op2 : 'Household',
					op3 : 'Account',
					op4 : 'Contact Group',
					ans : 'op2',
					flag : true
	             },
	             {
					que : 'What are the different Ways to navigate to Desktop UI From Simplified UI? A)More Details B)Navigator C)More Info D)Full View',
					op1 : 'A and C',
					op2 : 'B and C',
					op3 : 'A and B',
					op4 : 'A and D',
					ans : 'op3',
					flag : true
	             },
	             {
					que : 'Which Page provides comprehensive information in one spot relevant to your job?',
					op1 : 'Work Area Page',
					op2 : 'Contextual Area',
					op3 : 'Dashboards',
					op4 : 'List Page',
					ans : 'op3',
					flag : true
		          },
	             {
					que : 'Which Search allows users to search for records across the application?',
					op1 : 'Search Pane',
					op2 : 'Query By Example',
					op3 : 'Local Search',
					op4 : 'Regional Search',
					ans : 'op4',
					flag : true
			     },
	             {
					que : 'In Oracle Sales Cloud an account of type customer must have what?',
					op1 : 'Team Members',
					op2 : 'Sell-To Address',
					op3 : 'Territories',
					op4 : 'Account Name',
					ans : 'op2',
					flag : true
			     },
	             {
					que : 'The most important function of Oracle Hyperion Financial Reporting Studio is?',
					op1 : 'Monitor Key account balances in real-time at every level of the users dimensions and hierarchies in Oracle Fusion GL.',
					op2 : 'Integration of Oracle Fusion GL with Microsoft Excel using the Excel add-in, to interactively analyze the users actual and budget account balances in real-time.',
					op3 : 'Offering Financial Report writer to create a boardroom ready financial statements without a need for technical involvement.',
					op4 : 'Perform adhoc balance queries and multi-dimensional analysis as users pivot within a web page.',
					ans : 'op3',
					flag : true
			     },
	             {
					que : 'The two reporting tools viz. Oracle Hyperion Financial Reporting Studio and Account Monitor & Account Inspector?',
					op1 : 'Makes use of the Oracle Financials setup for generating header level information.',
					op2 : 'Access the data in the balances cubes and transaction tables.',
					op3 : 'Has a limitation in generating the data report in PDF & word formats.',
					op4 : 'Provides a first level drill-down only for financial data.',
					ans : 'op2',
					flag : true
			     },
	             {
					que : 'Which are the reporting tools that are used across the Oracle Fusion Applications platform?',
					op1 : 'Oracle Fusion Transactional Business Intelligence (OTBI), Oracle Hyperion Financial Reporting Studio',
					op2 : 'Oracle Fusion Transactional Business Intelligence (OTBI) and Oracle Business Intelligence Publisher (Oracle BI Publisher)',
					op3 : 'Oracle Business Intelligence Publisher (Oracle BI Publisher), Account Monitor and Account Inspector.',
					op4 : 'Oracle Business Intelligence Publisher (Oracle BI Publisher), Oracle Hyperion Smart View, Oracle Fusion Transactional Business Intelligence (OTBI) and Account Monitor.',
					ans : 'op2',
					flag : true
			     },
	             {
					que : 'What are the different types of reports / objects that can be generated using Oracle Fusion Transactional Business Intelligence (OTBI)?',
					op1 : 'OTBI generates different types of Intelligence reports viz. Business Intelligence, Business Reports and SQL Reports',
					op2 : 'OTBI generates four types of Business Intelligence reports viz. SQL Reports, Form Reports, Overview Reports and BI Reports.',
					op3 : 'OTBI generates two types of Business Intelligence reports / objects viz. Analysis and Dashboard reports.',
					op4 : 'OTBI generates three types of Business Intelligence reports viz. SQL Reports, BI Reports and Overview Reports.',
					ans : 'op3',
					flag : true
			     },		
	             {
					que : 'What is Oracle BI Presentation Catalog?',
					op1 : 'Oracle BI Presentation Catalog 1. Stores BI Objects 2. Provides an Interface to create and manage BI Objects 3. Organized in hierarchy with two top level folders.',
					op2 : 'Oracle BI Presentation Catalog 1. Stores BI Information & data 2. Stores data in a sequential manner',
					op3 : 'Oracle BI Presentation Catalog 1. Manages Catalog data for presentation 2. Stores Catalog data after presentation',
					op4 : 'Oracle BI Presentation Catalog 1. Holds data for presentation in BI 2. Manages BI content for Presentation.',
					ans : 'op1',
					flag : true
			     },
	             {
					que : 'Accounting Period has one of the following statuses?',
					op1 : 'Future Enabled, Open, Closed , Temporarily Closed',
					op2 : 'Future Enabled, Open, Closed , Permanently Closed',
					op3 : 'Open, Closed, Future Enabled',
					op4 : 'Opened, Closed, Future',
					ans : 'op2',
					flag : true
			     },
	             {
					que : 'To what value must all Intercompany trading be set to when accounting is consolidated',
					op1 : '1',
					op2 : '2',
					op3 : '3',
					op4 : '0',
					ans : 'op4',
					flag : true
			     },
	             {
					que : 'At what level are Intercompany transaction processing ruled defined to maintain consistency?',
					op1 : 'At company level',
					op2 : 'At Enterprise level',
					op3 : 'At brand level',
					op4 : 'At data level',
					ans : 'op2',
					flag : true
			     },
	             {
					que : 'How many intercompany organizations can there be per Business unit',
					op1 : '1',
					op2 : '2',
					op3 : '5',
					op4 : 'Any Number',
					ans : 'op4',
					flag : true
			     },
	             {
					que : 'What is Reference Data sharing',
					op1 : 'Referring the data that has been shared',
					op2 : 'Defines reference data and divides the data into partitions called reference data sets',
					op3 : 'Referring the partitioned data',
					op4 : 'Partitioned data reconciliation',
					ans : 'op2',
					flag : true
			     },   
	             {
					que : 'For ease of Reconciliation and Analysis, Oracle Assets provides the following types of reports: a) Registry Reports b) Standard Accounting Report c) FAH Reports d) Transaction Reports',
					op1 : 'A, B, D',
					op2 : 'A, B, C',
					op3 : 'B, C, D',
					op4 : 'A, C, D',
					ans : 'op1',
					flag : true
			     }
	 ];
	
	
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

	$scope.question = {};
	$scope.yogesh = {};
	$scope.disablegetQuestion = false;
	
	$scope.getQuestion = function($thisQuestion) {
		
		for (var i = 0; i < 5; i++) {
			$scope.question = $scope.qb[i];
		    if ($scope.question.flag) {
		    	$scope.qb[i].flag = false;
		    	question = $scope.question.que;
		    	$scope.questionAttempetCount = $scope.questionAttempetCount + 1;
		    	break;
		    }
		    if (i == 4) {
		    	$scope.disablegetQuestion = true;	
		    }
		}
		if ($thisQuestion) {
			$check = $scope.correctkAnswer.ans;
			if ($check == $thisQuestion.ans) {
				$scope.correctkAnswerCount = $scope.correctkAnswerCount + 1;
			} else {
			}
		}
	 };

	 $scope.getQuestion();
	
    $scope.st="";
    $scope.finished = function() {
    };

    $scope.logStep = function() {
        console.log($scope.st);
    };

    $scope.goBack = function() {
        WizardHandler.wizard().goTo(0);
    };
 });