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
          <img src="${rc.getContextPath()}/resources/img/CorpYogiLogo.png" alt="Corp Yogi" style="cursor: pointer;"></img>
         </div>
         <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1"> 
          <#if user.userType?string != '2'>
	          <ul class="nav navbar-nav" style="margin-left:103px;">
	            <li><a href="#"><i class="fa fa-home"></i><span> Home</span></a></li>
	            <li><a href="#">KwicValuate</a></li>
	          </ul>
          </#if>
          

		    <ul class="nav navbar-nav navbar-right">
		        <li class="dropdown">
		            <a href="#" data-toggle="dropdown" class="dropdown-toggle">Welcome <#if user?exists>${user.userName}</#if> <b class="caret"></b></a>
		            <ul class="dropdown-menu">
		                <li><a href="#"><i class="fa fa-shopping-cart"></i> <span>My Account</span></a></li>
		                <li><a href="#"><i class="fa fa-cog"></i><span> Application Settings</span></a></li>
		                <li><a href="${rc.getContextPath()}/corpyogi/administration/userinfo"><i class="fa fa-users"></i> <span>User Administration</span></a></li>
		                <li class="divider"></li>
		                <li><a href="${rc.getContextPath()}/logout"><i class="fa fa-sign-out"></i> <span>Log Out</span></a></li>
		            </ul>
		        </li>
		    </ul>
		</div>
	</div><!-- /.container-fluid -->
 </nav>


<!--
 <#if user.userType?string != '2'>
	<div class="sidebar-nav">
			<a data-toggle="collapse" class="nav-header collapsed" href="#dashboard-menu"><i class="icon-dashboard"></i>Menu</a>
			<ul class="nav nav-list collapse in" id="dashboard-menu" style="height: 246px;" aria-expanded="true">
			    	<li><a href="${rc.getContextPath()}/success-login">Dashboard</a></li>
			    	<li><a href="${rc.getContextPath()}/kv/courses">Manage Courses</a></li>
			    	<li><a href="${rc.getContextPath()}/kv/trainings?courseIdFilter=0">Manage Trainings</a></li>
			    	<li><a href="${rc.getContextPath()}/kv/assesments">Manage Assessments</a></li>
			    	<li><a href="${rc.getContextPath()}/kv/importer">Import from excel</a></li>
			    	<li><a href="${rc.getContextPath()}/kv/training-attendance">Training Attendance</a></li>
			    	<li><a href="${rc.getContextPath()}/corpyogi/kv/corpprofile">Profile</a></li>
			    	<li><a href="${rc.getContextPath()}/corpyogi/administration/userinfo">Manage User</a></li>
			</ul>
	</div>
</#if>
<#if user.userType?string =='2'>
	<div class="sidebar-nav">
			<a data-toggle="collapse" class="nav-header collapsed" href="#dashboard-menu"><i class="icon-dashboard"></i>Menu</a>
			<ul class="nav nav-list collapse" id="dashboard-menu" style="height: 0px;">
			    	<li><a href="${rc.getContextPath()}/corpyogi/kv/test">Start Test</a></li>
			</ul>
	</div>
</#if>
-->


<div class="sidebar-nav">
		<a data-toggle="collapse" class="nav-header" href="#dashboard-menu"><i class="icon-dashboard"></i>Menu</a>
		<ul class="nav nav-list" id="dashboard-menu" style="height: auto;">
		<#list menus as menu>
			<#if menu.visible?string != "false">
		    	<li><a href="${rc.getContextPath()}${menu.url}">${menu.title}</a></li>
		    </#if>
        </#list>
		</ul>
</div>