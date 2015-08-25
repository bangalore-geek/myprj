<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>

<@macro.showHeader />
<div class="header">
    <h1 class="page-title">Manage Assessment </h1>
</div><br>

<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">
	<div ng-app="wizDemoApp" ng-controller="WizardCtrl">
		<form>
<div class="form-group">
					 <div class="input-group col-md-8">
					  <span class="input-group-addon">Search</span>
					  <input type="text" class="form-control">
					</div>
				   </div>
			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="headingOne">
					  <h4 class="panel-title">
					  <a>TR1</a>
					  <a role="button" class="pull-right" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne" >
					  Launch
					</a>
				  </h4>
				</div>
				<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
				  <div class="panel-body">
				  </div>
				</div>
			</div>
	  
		   <div class="panel panel-default">
			<div class="panel-heading" role="tab" id="headingTwo">
			  <h4 class="panel-title">
				<a>TR2</a>
			   <a class="collapsed pull-right" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
				  Launch
				</a>
			  </h4>
			</div>
			<div id="collapseTwo" class="panel-collapse collapse" role="button" aria-labelledby="headingTwo">
			  <div class="panel-body">
			  </div>
			</div>
		  </div>
	  
		   <div class="panel panel-default">
			<div class="panel-heading" role="tab" id="headingThree">
			  <h4 class="panel-title">
				<a>TR3</a>
				<a class="collapsed pull-right"   role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
				  Launch
				</a>
			  </h4>
			</div>
			<div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
			  <div class="panel-body">
			  </div>
			</div>
		  </div>
	  </form>
	</div>
			</div>
		</div>
		<div class="col-md-1"></div>

<@macro.showFooter>
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/sample-wizard.js"></script>
</@macro.showFooter>