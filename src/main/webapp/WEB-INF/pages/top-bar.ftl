 	<style type="text/css">
	    .first {
		    color: tomato;
		    font-size: 2em;
		    font-style: italic;
		}
	    .second {
		    color: skyblue;
		    font-size: 0.6em;
		    font-weight: bold;
		}
	</style>
<nav class="navbar navbar-inverse">
      <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button data-target="#bs-example-navbar-collapse-9" data-toggle="collapse" class="navbar-toggle collapsed" type="button">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a href="#" class="navbar-brand"><span class="first">Career</span> <span class="second">Point</span></a>
        </div>
	</div><!-- /.container-fluid -->
 </nav>
<div class="sidebar-nav">
		<a data-toggle="collapse" class="nav-header collapsed" href="#dashboard-menu"><i class="icon-dashboard"></i>Menu</a>
		<ul class="nav nav-list collapse" id="dashboard-menu" style="height: 0px;">
		<#list menus as menu>
			<#if menu.visible?string != "false">
		    	<li><a href="${rc.getContextPath()}${menu.url}">${menu.title}</a></li>
		    </#if>
        </#list>
		</ul>
</div>