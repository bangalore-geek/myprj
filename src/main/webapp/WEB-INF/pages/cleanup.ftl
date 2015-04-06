<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>

<@macro.showHeader />
<div class="header">
    <h1 class="page-title">Perform Cleanup</h1>
</div>
<div id="mainDiv">
	
</div>

<@macro.showFooter>
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/cleanup.js"></script>
<script>
	$(function(){
		new defysope.cleanup.Main("#mainDiv", {});
	});
</script>
</@macro.showFooter>