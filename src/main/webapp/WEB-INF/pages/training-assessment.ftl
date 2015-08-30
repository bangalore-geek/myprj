<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>

<@macro.showHeader />
<div class="header">
    <h1 class="page-title">Manage Assessment </h1>
</div><br>
<div ng-controller="TrainingAssessmentCtrl">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<div>
				<div class="row" style="padding:10px;">
					<div class="col-md-8">
						<div class="form-group">
						 <div class="input-group">
						  <span class="input-group-addon">Search</span>
						  <input type="text" class="form-control">
						</div>
					   </div>	
				   </div>
				</div>
			</div>
		</div>
		<div class="col-md-1"></div>
	</div>
	
	<div class="row" >
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<div  style="padding:10px;">
				<accordion class="accordion" close-others="true">
					<accordion-group  ng-repeat="group in trainings">
						<accordion-heading>
							<span>{{group.trainingName}}</span>
							<div class="pull-right">Launch</div>
						</accordion-heading>
						<div>  Number : {{group.courseNumber}} </div>
						<div>  Start Date : {{group.startdate | date:'dd-MMM-yyyy'}} </div>
						<div>  End Date : {{group.enddate | date:'dd-MMM-yyyy'}} </div>
						<div>  Assessment Date : {{group.assesmentDate | date:'dd-MMM-yyyy'}} </div>
						<div>  Customer : {{group.coustomer}} </div>
						<div>  Training Description : {{group.courseDescription}} </div>
					</accordion-group>
				</accordion>
				
				<div class="alert alert-info" role="alert"  ng-show="training.content.length == 0">
					No Training found !!
				</div>
			</div>
		</div>
		<div class="col-md-1"></div>
	</div>
	
	
	
	
	
</div>
<@macro.showFooter>
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/training-assessment.js"></script>
</@macro.showFooter>