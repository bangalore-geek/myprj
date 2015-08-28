<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Sign up-CorpYOGI</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/bootstrap.min.css">
    
    <link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/theme.css">
    <link rel="stylesheet" href="${rc.getContextPath()}/resources/css/font-awesome.css">
    <link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/toastr.css">

    <script src="${rc.getContextPath()}/resources/js/core/jquery-1.9.1.js" type="text/javascript"></script>
    <script src="${rc.getContextPath()}/resources/js/plugin/bootbox.js" type="text/javascript"></script>

    <!-- Demo page code -->

	<style type="text/css">
	    .first {
		    color: tomato;
		    font-size: 2em;
		    font-style: italic;
		}
	    .second {
		    color: skyblue;
		    font-size: 0.6em;
		    font-weight: bold;
		}
	</style>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  </head>

  <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
  <!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
  <!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
  <!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
  <!--[if (gt IE 9)|!(IE)]><!--> 
  <body ng-app="defysope"> 
  <!--<![endif]-->
    
 <nav class="navbar navbar-inverse">
      <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button data-target="#bs-example-navbar-collapse-9" data-toggle="collapse" class="navbar-toggle collapsed" type="button">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <img style="cursor: pointer;" alt="Corp Yogi" src="/careerpoint/resources/img/CorpYogiLogo.png">
        </div>
	</div><!-- /.container-fluid -->
 </nav>
    
	<div class="row-fluid" ng-controller="SignupCtrl">
	    <div class="dialog">
	        <div class="block">
	            <p class="block-heading">Sign up</p>
	            <div class="block-body">
		            <form class="form-signup">
	                	<div class="form-group">
	    					<label><@spring.message "signup.label.username"/></label>
	    					<div>
	    						<input type="text" class="form-control" name="userName" placeholder="User name" ng-model="user.userName">
	      					</div>
	  					</div>
	  					<div class="form-group">
	    					<label><@spring.message "signup.label.password"/></label>
	    					<div>
	    						<input type="password" class="form-control" name="password" placeholder="Password" ng-model="user.password">
	      					</div>
	  					</div>
	  					<div class="form-group">
	    					<label><@spring.message "signup.label.email"/></label>
	    					<div>
	    						<input type="email" class="form-control" name="email" placeholder="Email" ng-model="user.email">
	      					</div>
	  					</div>
	  					<div class="form-group">
	    					<label><@spring.message "signup.label.type"/></label>
	    					<div>
	    						<label class="radio-inline">
								  <input type="radio" name="inlineRadioOptions" value="3"  ng-model="user.userType"> Candidate
								</label>
								<label class="radio-inline">
								  <input type="radio" name="inlineRadioOptions" value="4"  ng-model="user.userType"> Freelancer
								</label>
								<label class="radio-inline">
								  <input type="radio" name="inlineRadioOptions" value="5"  ng-model="user.userType"> Corporate
								</label>
	      					</div>
	  					</div>
	                    <button class="btn btn-primary pull-right" ng-click="createUser()"><@spring.message "signup.label.submit"/></button>
	                    <div class="clearfix"></div>
	                </form>
	            </div>
	        </div>
	        <p class="pull-right" style=""><a href="${rc.getContextPath()}/user-login.html">Login</a></p>
	        <p><a href="${rc.getContextPath()}/reset-password">Forgot your password?</a></p>
	    </div>
   </div>

<script src="${rc.getContextPath()}/resources/js/core/jquery-1.9.1.js"></script>
<script src="${rc.getContextPath()}/resources/js/core/angular.min.js"></script>
<script src="${rc.getContextPath()}/resources/js/core/bootstrap.js"></script>
<script src="${rc.getContextPath()}/resources/js/pages/signup-form.js"></script>
<script src="${rc.getContextPath()}/resources/js/core/angular-animate.min.js"></script>
<script src="${rc.getContextPath()}/resources/js/plugin/toastr.js"></script>
</body>
</html>


