<#import "/spring.ftl" as spring/>
<#include "header.ftl" />
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Reset Password-CorpYOGI</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <script src="${rc.getContextPath()}/resources/js/core/jquery-1.9.1.js" type="text/javascript"></script>

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
  <body class=""> 
  <!--<![endif]-->
  
	<div class="row-fluid">
	    <div class="dialog">
	        <div class="block">
	            <p class="block-heading">Reset Password</p>
	            <div class="block-body">
	                <form class="form-signin" method="post">
	                    <div class="form-group">
	    					<label>Email</label>
	    					<div>
	    						<input type="text" class="form-control" name="userName" placeholder="Email">
	      					</div>
	  					</div>
	                </form>
	            </div>
	        </div>
	        <p class="pull-right" style=""><a href="${rc.getContextPath()}/user-login.html">Login</a></p>
	        <!-- <p><a href="${rc.getContextPath()}/signup" >Create an account</a></p> -->
	    </div>
   </div>

<script src="${rc.getContextPath()}/resources/js/core/bootstrap.js"></script>
</body>
</html>


