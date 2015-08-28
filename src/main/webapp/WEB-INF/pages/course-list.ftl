<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>

<@macro.showHeader />
<div class="header">
    <h1 class="page-title">Course List</h1>
</div><br>
<div ng-controller="AccordionDemoCtrl">
	<div class="row" >
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<div class="row" style="padding:10px;">
				<div class="col-md-8">
					<div class="form-group">
					 <div class="input-group">
					  <span class="input-group-addon">Search</span>
					  <input type="text" class="form-control">
					</div>
				   </div>	
			   </div>
			   <div class="col-md-4">
					<div class="pull-right" style="margin-right: 10px;">
						<div class="pull-right"> <a href="${rc.getContextPath()}/sample-wizard?editCourseId=0&editTrainingId=0" class="btn btn-primary">Add</a> </div>
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
					<accordion-group  ng-repeat="group in courses.content">
						<accordion-heading>
							<span>{{group.name}}</span>
							<div class="pull-right">
							</div>
						</accordion-heading>
						<div class="pull-right"> 
							<a href="${rc.getContextPath()}/sample-wizard?editCourseId={{group.id}}&editTrainingId=0">Edit</a> 
							<span ng-if="group.active" ng-click="toggleActive(group)">
								<i class="fa fa-play"></i>
							</span>
							<span ng-if="!group.active" ng-click="toggleActive(group)">
								<i class="fa fa-pause"></i>
							</span>
						</div>
						<div>  Part No : {{group.trainingNo}} </div>
						<div> Version : {{group.version}} </div>
						<div> Course Type : {{group.assesmentType}} </div>
						<div class="pull-right"> <a ng-click="callManageTrainingPage()" href="${rc.getContextPath()}/corpyogi/kv/trainings?id={{group.id}}">Manage Training</a> </div>
					</accordion-group>
				</accordion>
			</div>
		</div>
		<div class="col-md-1"></div>
	</div>	
</div>

<@macro.showFooter>
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/course-list.js"></script>
</@macro.showFooter> 