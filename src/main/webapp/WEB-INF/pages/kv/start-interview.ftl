<#import "/spring.ftl" as spring />
<#import "/macro.ftl" as macro/>

<@macro.showHeader />
<div class="header">
    <h1 class="page-title">Start Interview</h1>
</div><br>
<div ng-controller="StartInterviewCtrl">   
	<span ng-if="!thisSummary.elegibleForInterview">
		<div>Interview date is not started yet</div>
	</span>
</div>

<@macro.showFooter>
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/kv/start-interview.js"></script>
</@macro.showFooter>