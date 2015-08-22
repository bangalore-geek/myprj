<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>

<@macro.showHeader />
<div class="header">
    <h1 class="page-title">Company Profile</h1>
</div><br>
<div ng-controller="CompanyProfileCtrl">
</div>

<@macro.showFooter>
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/company-profile.js"></script>
</@macro.showFooter>