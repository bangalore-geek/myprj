<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>

<@macro.showHeader />
<div class="header">
    <h1 class="page-title">Change Password</h1>
</div>
<div id="mainDiv">
	
</div>

<@macro.showFooter>
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/changepassword.js"></script>
<script>
	$(function(){
		new defysope.changepassword.Main("#mainDiv", {});
	});
</script>
</@macro.showFooter>