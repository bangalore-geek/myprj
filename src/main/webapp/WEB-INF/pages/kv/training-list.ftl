<#import "/spring.ftl" as spring />
<#import "/macro.ftl" as macro/>

<@macro.showHeader />
<div class="header">
    <h1 class="page-title">Training Listing</h1>
</div><br>
<div ng-controller="TrainingListCtrl">
	<div class="row" >
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<div class="row" style="padding:10px;">
				<div class="col-md-8">
					<div class="form-group" ng-show="training.length > 0">
					 <div class="input-group">
					  <span class="input-group-addon">Search</span>
					  <input type="text" class="form-control search-query" ng-model="training.search">
					</div>
				   </div>	
			   </div>
			   <div class="col-md-4">
			     <a class="btn btn-primary pull-right"  href="${rc.getContextPath()}/kv/configure-assessment?editCourseId=${courseId}&editTrainingId=0"><i class="glyphicon glyphicon-plus"></i> Add Training</a>
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
					<accordion-group  ng-init="isOpen = $first" is-open="isOpen" ng-repeat="group in training | filter:training.search | orderBy:'trainingName'" ng-show="training.length > 0">
						<accordion-heading>
							<span>{{group.trainingName}}</span>
						</accordion-heading>
						<div class="pull-right"> <a href="${rc.getContextPath()}/kv/configure-assessment?editCourseId={{group.assesmentMasterId}}&editTrainingId={{group.id}}">Edit</a> </div>
						<div>  Number : {{group.courseNumber}} </div>
						<div>  Start Date : {{group.startdate | date:'dd-MMM-yyyy'}} </div>
						<div>  End Date : {{group.enddate | date:'dd-MMM-yyyy'}} </div>
						<div>  Assessment Date : {{group.assesmentDate | date:'dd-MMM-yyyy'}} </div>
						<div>  Customer : {{group.coustomer}} </div>
						<div>  Training Description : {{group.courseDescription}} </div>
						<div class="pull-right"> <a ng-click="callManageTrainingPage()" href="${rc.getContextPath()}/kv/assesments?id={{group.id}}">Manage Assessment</a> </div>
					</accordion-group>
				</accordion>
				
				<div class="alert alert-info" role="alert"  ng-show="training.length == 0">
					No Training found !!
				</div>
			</div>
		</div>
		<div class="col-md-1"></div>
	</div>
</div>

<@macro.showFooter>
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/kv/training-list.js"></script>
</@macro.showFooter>