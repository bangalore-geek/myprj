<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>

<@macro.showHeader />
<div class="header">
    <h1 class="page-title">Dashboard</h1>
</div>
	<div class="row posRelative" ng-controller="HomeCtrl">
	 <div ng-init="sWindow=sWindow" ng-repeat="sWindow in windowList">
	  <skwindow  title="{{sWindow.title}}" windowid="{{sWindow.id}}" enableremovesession="{{sWindow.enableRemoveSession}}" enableremovepermanent="{{sWindow.enableRemovePermanent}}"  windowclass="col-sm-12 col-md-6">
		<div class="panel panel-default nopadding zindex9" ng-show="sWindow.filterTemplate">
		  <div class="panel-body nopadding">
		    <div class="btn-filter" ng-click="cWindow.filterToggle();">
		    	 Filter
		    	 <div class="pull-right">
			    	<i class="glyphicon glyphicon-plus" ng-show="!sWindow.showFilter"></i>
					<i class="glyphicon glyphicon-minus" ng-show="sWindow.showFilter"></i>
		    	 </div>
		    </div>
			<div  ng-show="sWindow.filterTemplate" ng-include="sWindow.filterTemplate"></div>
		  </div>
		</div>
		<div ng-include="sWindow.storeTemplate" ng-show="sWindow.autoPopulate == 'true'" onload="hideLoading(sWindow.id)"></div>
		{{sWindow | json}}
	  </skwindow>
  </div>
</div>

<@macro.showFooter>
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/home.js"></script>
</@macro.showFooter>