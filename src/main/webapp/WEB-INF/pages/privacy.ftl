<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>

<@macro.showHeader />
<div class="header">
    <h1 class="page-title">Privacy</h1>
</div>
<div id="mainDiv">
	
</div>

<@macro.showFooter>
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/bookmarklist.js"></script>
<script>
	$(function(){
		new defysope.privacy.Main("#mainDiv", {});
	});
</script>
</@macro.showFooter>