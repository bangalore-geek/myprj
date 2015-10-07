<#import "/spring.ftl" as spring/>
<#include "header.ftl" />
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Company Registration</title>
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
  <body ng-app="defysope"> 
  <!--<![endif]-->
	<div class="row-fluid" ng-controller="CompanyRegestrationCtrl">
	    <div class="container">
			<div class="row">
				<div class="col-md-10">
					<div class="col-md-8">
						<div class="block">
							<p class="block-heading">Company Regestration</p>
							<div class="block-body">
								<form class="form-horizontal">
								  <div class="form-group">
									<label for="companyName" class="col-sm-5 control-label">Company Name</label>
									<div class="col-sm-7">
									  <input type="textbox" class="form-control" id="companyName" ng-model="thisSummary.thisCompany.companyName">
									</div>
								  </div>
								  
								  <div class="form-group">
									<label for="tinNumber" class="col-sm-5 control-label">Tin Number</label>
									<div class="col-sm-7">
									  <input type="textbox" class="form-control" id="tinNumber" ng-model="thisSummary.thisCompany.tinNumber">
									</div>
								  </div>
								  
								  
								  <div class="form-group">
									<label for="companyMobileNum" class="col-sm-5 control-label">Company Mobile number</label>
									<div class="col-sm-7">
									  <input type="textbox" class="form-control" id="companyMobileNum" ng-model="thisSummary.thisCompany.companyMobileNum">
									</div>
								  </div>
								  
								  
								  <div class="form-group">
									<label for="contactName" class="col-sm-5 control-label">Contact Name</label>
									<div class="col-sm-7">
									  <input type="textbox" class="form-control" id="contactName" ng-model="thisSummary.thisCompany.contactName">
									</div>
								  </div>
								  
								  <div class="form-group">
									<label for="contactMobileNum" class="col-sm-5 control-label">Contact Mobile number</label>
									<div class="col-sm-7">
									  <input type="textbox" class="form-control" id="contactMobileNum" ng-model="thisSummary.thisCompany.contactMobileNum">
									</div>
								  </div>
								  
								  <div class="form-group">
									<label for="contactEmailId" class="col-sm-5 control-label">Contact Email Id</label>
									<div class="col-sm-7">
									  <input type="textbox" class="form-control" id="contactEmailId" ng-model="thisSummary.thisCompany.contactEmailId">
									</div>
								  </div>

								  <div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
									  <button type="button" class="btn btn-default" ng-click="saveCompany(thisSummary.thisCompany)">Register</button>
									  <button type="button" class="btn btn-default">Cancel</button>
									</div>
								  </div>
								</form>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="block">
							<p class="block-heading">Product</p>
							<div class="block-body">
								<div ng-repeat="product in thisSummary.productList">
									<div class="action-checkbox">
									<input id="{{product.id}}" type="checkbox" 
										value="{{product.name}}" 
										ng-checked="selection.indexOf(product.id) > -1" 
										ng-click="toggleSelection(product.id)" />
										<label for="{{product.name}}"></label>
										{{product.name}}
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-1"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
   
   <script src="${rc.getContextPath()}/resources/js/core/jquery-1.9.1.js"></script>
	<script src="${rc.getContextPath()}/resources/js/core/angular.min.js"></script>
	<script src="${rc.getContextPath()}/resources/js/core/bootstrap.js"></script>
	<script src="${rc.getContextPath()}/resources/js/core/angular-animate.min.js"></script>
	<script src="${rc.getContextPath()}/resources/js/plugin/toastr.js"></script>
	<script src="${rc.getContextPath()}/resources/js/pages/company-registration.js"></script>
</body>
</html>