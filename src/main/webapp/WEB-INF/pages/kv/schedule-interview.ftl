<#import "/spring.ftl" as spring />
<#import "/macro.ftl" as macro/>

<@macro.showHeader />
<div class="header">
    <h1 class="page-title">Schedule Interview</h1>
</div><br>
<div ng-controller="AttendInterviewCtrl">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">
			Company Name : {{thisSummary.thisCompany.companyName}}
		</div>
		<div class="col-md-1"></div>
	</div>
</div>


<@macro.showFooter>
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/kv/schedule-interview.js"></script>
</@macro.showFooter> 