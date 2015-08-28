<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>

<#include "header.ftl" />

<style>
	/* Carousel base class */
.carousel {
	margin-bottom: 60px;
}

.carousel .container {
	position: relative;
	z-index: 9;
}

.carousel-control {
	height: 80px;
	margin-top: 0;
	font-size: 120px;
	text-shadow: 0 1px 1px rgba(0, 0, 0, .4);
	background-color: transparent;
	border: 0;
}

.carousel .item {
	height: 500px;
}

.carousel img {
	position: absolute;
	top: 0;
	left: 0;
	min-width: 100%;
	height: 500px;
}

.carousel-caption {
	background-color: transparent;
	position: static;
	padding: 0 20px;
	margin-top: 200px;
}

.carousel-caption h1,.carousel-caption .lead {
	margin: 0;
	line-height: 1.25;
	color: #fff;
	text-shadow: 0 1px 1px rgba(0, 0, 0, .4);
}

.carousel-caption .btn {
	margin-top: 10px;
}
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
<div ng-app="defysope">
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
	        <a class="btn btn-default navbar-btn pull-right" type="button" href="${rc.getContextPath()}/user-login" style="margin-left:10px;">Freelancer/Candidate Login</a>
	        <a class="btn btn-default navbar-btn pull-right" type="button" href="${rc.getContextPath()}/user-login">Corporate Login</a>
		</div><!-- /.container-fluid -->
	 </nav>
	
	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
	  <!-- Indicators -->
	  <ol class="carousel-indicators">
	    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
	    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
	    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
	    <li data-target="#carousel-example-generic" data-slide-to="3"></li>
	    <li data-target="#carousel-example-generic" data-slide-to="4"></li>
	  </ol>
	
	  <!-- Wrapper for slides -->
	  <div class="carousel-inner" role="listbox">
	    <div class="item">
	      <img alt="" src="${rc.getContextPath()}/resources/img/slide-01.jpg">
			<div class="container">
				<div class="carousel-caption">
					<h1>Skill Store</h1>
					<p class="lead">A Global market place to get verified resume.It will save your valuable time for searching the right candidate for right job</p>
					<a href="${rc.getContextPath()}/signup" class="btn btn-large btn-slide1 btn-primary">Sign
						up today</a>
				</div>
			</div>
	    </div>
		<div class="item">
			<img alt="" src="${rc.getContextPath()}/resources/img/slide-02.jpg">
			<div class="container">
				<div class="carousel-caption">
					<h1>Kwick Evaluate</h1>
					<p class="lead">No more guessing! Easily assess candidates using our SME verified selection of pre-built psychometric, aptitude, & skills tests or administer your own custom tests.</p>
					<a href="${rc.getContextPath()}/signup" class="btn btn-large btn-slide1 btn-primary">Sign
						up today</a>
				</div>
			</div>
		</div>
		<div class="item active">
			<img alt="" src="${rc.getContextPath()}/resources/img/slide-03.jpg">
			<div class="container">
				<div class="carousel-caption">
					<h1>QB Knox</h1>
					<p class="lead">Whether you are a human resources professional conducting exit interviews, or an auto body shop owner trying to close the customer feedback loop, you have got to ask the right survey questions to get the answers you need.</p>
					<a href="${rc.getContextPath()}/signup" class="btn btn-large btn-slide1 btn-primary">Sign
						up today</a>
				</div>
			</div>
		</div>
		<div class="item">
	      <img alt="" src="${rc.getContextPath()}/resources/img/slide-01.jpg">
			<div class="container">
				<div class="carousel-caption">
					<h1>Freelancer</h1>
					<p class="lead">For freelancer this is the perfect place to get some good work as well as they can schedule their training program.</p>
					<a href="${rc.getContextPath()}/signup" class="btn btn-large btn-slide1 btn-primary">Sign
						up today</a>
				</div>
			</div>
	    </div>
	    <div class="item">
			<img alt="" src="${rc.getContextPath()}/resources/img/slide-02.jpg">
			<div class="container">
				<div class="carousel-caption">
					<h1>Candidate</h1>
					<p class="lead">For jobseeker.</p>
					<a href="${rc.getContextPath()}/signup" class="btn btn-large btn-slide1 btn-primary">Sign
						up today</a>
				</div>
			</div>
		</div>
	  </div>
	
	  <!-- Controls -->
	  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
	    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	    <span class="sr-only">Previous</span>
	  </a>
	  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
	    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	    <span class="sr-only">Next</span>
	  </a>
	</div>
	
	
	
	<div class="row posRelative" ng-controller="HomeCtrl" style="margin-left:50px;margin-right:50px;">
	  <div ng-init="sWindow=sWindow" ng-repeat="sWindow in windowList">
		<skwindow  title="{{sWindow.title}}" margin="{{sWindow.topMargin}}" height="{{sWindow.height}}" windowid="{{sWindow.id}}" enableremovesession="{{sWindow.enableRemoveSession}}" enableremovepermanent="{{sWindow.enableRemovePermanent}}"  windowclass="col-sm-12 col-md-4">
		<div collapse="sWindow.flag">
		  		<div  ng-show="sWindow.filterTemplate" ng-include="sWindow.filterTemplate"></div>
		  	</div>
			<div ng-include="sWindow.storeTemplate" onload="hideLoading(sWindow.id)"></div>
		</skwindow>
	  </div>
	 </div>
	</div>
</div>
<@macro.showFooter>
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/home.js"></script>
</@macro.showFooter>