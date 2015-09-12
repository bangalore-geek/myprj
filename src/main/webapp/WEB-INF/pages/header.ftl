<#import "macro.ftl" as macro/>
	<title>Corp Yogi</title>
	 <link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/bootstrap.min.css">
	 <link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/bootstrap-theme.min.css">
     <link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/font-awesome.css">
     <link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/theme.css">
     <link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/toastr.css">
     <link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/jquery.jqplot.css">
     <link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/angular-wizard.min.css">
     <link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/corpyogi.css">
	 <#if user?exists>
	<#else>
	<div class="page-header hdr-margin hdr-padding">
		<div class="row row-list">
			<div class="col-xs-2 container-img"><img alt="Corp Yogi" onClick="${rc.getContextPath()}" src="/careerpoint/resources/img/CorpYogiLogo.png" class="img-responsive img-padding" width="90" height="40"></div>
			<div class="col-xs-5 container-paragraph"><marquee> Enhancing the Corporates' Value System Enabling the capability matrix mechanism</marquee> </div>
			<div class="col-xs-2 container-img">
				<div class="form-group">
					<div class="col-sm-10">
						<input type="email" placeholder="Search" class="form-control">
					</div>
					<div>
						<img alt="Corp Yogi" onClick="${rc.getContextPath()}" src="/careerpoint/resources/img/facebook_logo.png" class="img-responsive img-padding" width="40" height="40">
					</div>
				</div>
			</div>
			<div class="col-xs-2 container-img">
				<img alt="Corp Yogi" onClick="${rc.getContextPath()}" src="/careerpoint/resources/img/linkedIn_logo.png" class="img-responsive img-padding" width="100" height="90">
			</div>
		</div>
	</div>	
	<nav class="navbar navbar-default nav-grad navbar-static-top navbar-fixed-top" role="navigation">
		 <div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="${rc.getContextPath()}">#CheckStats</a>
			</div>
			<div>
				<ul class="nav navbar-nav">
					<li><a href="index.htm"><span class="glyphicon glyphicon-home"></span> Home</a></li>
					<li><a href="products.htm"><span class="glyphicon glyphicon-list-alt"></span> Products</a></li>
					<li><a href="services.htm"><span class="glyphicon glyphicon-folder-open"></span> Services</a></li>
					<li><a href="about.htm"><span class="glyphicon glyphicon-user"></span> About US</a></li>
					<li><a href="contact.htm"><span class="glyphicon glyphicon-phone-alt"></span> Contact</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${rc.getContextPath()}/user-login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</ul>
			</div>
		 </div>
	</nav>
	</#if>