<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>

<@macro.showHeader />
<div class="header">
    <h1 class="page-title">Excel Importer</h1>
</div><br>
<div ng-controller="ExcelImporterCtrl">
</div>

<@macro.showFooter>
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/importer-list.js"></script>
</@macro.showFooter>