<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>

<@macro.showHeader />
<div class="header">
    <h1 class="page-title">User</h1>
</div>
<div id="mainDiv" ng-controller="UserListCtrl">
	<ul>
		<li ng-repeat="l in list">{{l.title}}-{{l.desc}}</li>
	</ul>
</div>

<@macro.showFooter>
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/create-user.js"></script>
</@macro.showFooter>