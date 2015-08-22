<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>

<@macro.showHeader />
<div class="header">
    <h1 class="page-title">Dashboard</h1>
</div><br>
<div class="row posRelative" ng-controller="HomeCtrl" style="padding:10px;">
   <div ng-init="sWindow=sWindow" ng-repeat="sWindow in windowList">
	  <skwindow  title="{{sWindow.title}}" windowid="{{sWindow.id}}" enableremovesession="{{sWindow.enableRemoveSession}}" enableremovepermanent="{{sWindow.enableRemovePermanent}}"  windowclass="col-sm-12 col-md-6">
	  	<div collapse="sWindow.flag">
	  		<div  ng-show="sWindow.filterTemplate" ng-include="sWindow.filterTemplate"></div>
	  	</div>
		<div ng-include="sWindow.storeTemplate" onload="hideLoading(sWindow.id)"></div>
		</skwindow>
  </div>
</div>

<@macro.showFooter>
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/home.js"></script>
</@macro.showFooter>