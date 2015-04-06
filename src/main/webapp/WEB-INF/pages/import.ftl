<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>

<@macro.showHeader />
<div class="header">
    <h1 class="page-title">Import</h1>
</div>
<div id="mainDiv">
	
</div>

<@macro.showFooter>
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/import.js"></script>
<script>
	$(function(){
		new defysope.import.Main("#mainDiv", {});
	});
</script>
</@macro.showFooter>