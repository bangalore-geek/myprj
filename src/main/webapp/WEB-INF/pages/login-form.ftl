<#import "/spring.ftl" as spring/>
<#include "header.ftl" />
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Sign in-CorpYOGI</title>
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
    	<#if error?exists>
   		 <div class="alert alert-error">
    		<button data-dismiss="alert" class="close" type="button"><i class="icon-close"></i></button>
    		<strong>Oops !</strong> user name or password is incorrect.
		 </div>
		</#if> 
        <div class="block">
            <p class="block-heading">Sign In</p>
            <div class="block-body">
                <form class="form-signin" method="post" action="j_spring_security_check">
                	<div class="form-group">
    					<label><@spring.message "login.label.username"/></label>
    					<div>
    						<input type="text" class="form-control" name="j_username" placeholder="User name">
      					</div>
  					</div>
  					<div class="form-group">
    					<label><@spring.message "login.label.password"/></label>
    					<div>
    						<input type="password" class="form-control" name="j_password" placeholder="Password">
      					</div>
  					</div>
                    <button class="btn btn-primary pull-right" type="submit"><@spring.message "login.label.signin"/></button>
                    <label class="remember-me"><input type="checkbox"> <@spring.message "login.label.rememberme"/></label>
                    <div class="clearfix"></div>
                </form>
            </div>
        </div>
        <!-- <p class="pull-right" style=""><a href="${rc.getContextPath()}/signup" >Create an account</a></p> -->
        <p><a href="${rc.getContextPath()}/reset-password">Forgot your password?</a></p>
    </div>
  </div>

<script type="text/javascript">
        var _contextPath = '${rc.getContextPath()}';
</script>

<script src="${rc.getContextPath()}/resources/js/core/jquery-1.9.1.js"></script>
<script src="${rc.getContextPath()}/resources/js/core/angular.min.js"></script>
<script src="${rc.getContextPath()}/resources/js/core/bootstrap.min.js"></script>
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/plugin/bootbox.min.js"></script>
<script type="text/javascript" src="${rc.getContextPath()}/resources/select2/select2.js"></script>
<script src="${rc.getContextPath()}/resources/js/core/main.js"></script>
<script src="${rc.getContextPath()}/resources/js/core/ui-bootstrap-tpls-0.12.1.min.js"></script>
<script src="${rc.getContextPath()}/resources/js/core/angular-animate.min.js"></script>
<script src="${rc.getContextPath()}/resources/js/plugin/toastr.js"></script>
<script src="${rc.getContextPath()}/resources/js/plugin/jqplot/jquery.jqplot.js"></script>
<script src="${rc.getContextPath()}/resources/js/plugin/jqplot/jqplot.pieRenderer.js"></script>
</body>
</html>


