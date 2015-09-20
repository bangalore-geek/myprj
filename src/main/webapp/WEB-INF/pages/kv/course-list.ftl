<#import "/spring.ftl" as spring />
<#import "/macro.ftl" as macro/>

<@macro.showHeader />
<div class="header">
    <h1 class="page-title">Course Listing</h1>
</div><br>
<div ng-controller="AccordionDemoCtrl">
	<div class="row" >
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<div class="row" style="padding:10px;">
				<div class="col-md-8">
					<div class="form-group"  ng-show="courses.length > 0">
					 <div class="input-group">
					  <span class="input-group-addon">Search</span>
					  <input type="text" class="form-control search-query" ng-model="courses.search">
					</div>
				   </div>	
			   </div>
			   <div class="col-md-4">
					<div class="pull-right" style="margin-right: 10px;">
						<div class="pull-right"> <a href="${rc.getContextPath()}/kv/configure-assessment?editCourseId=0&editTrainingId=0" class="btn btn-primary"><i class="glyphicon glyphicon-plus"></i> Add Course</a> </div>
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
				<accordion class="accordion" close-others="true" ng-show="courses.length > 0">
					<accordion-group ng-init="isOpen = $first" is-open="isOpen" ng-repeat="group in courses | filter:courses.search | orderBy:'name'">
						<accordion-heading>
							<h5>{{group.name}} 
								<small>
									<span ng-if="group.active">(Active)</span>
									<span ng-if="!group.active">(In-active)</span>
								</small> 
							</h5>
						</accordion-heading>
						<div>  Part No : {{group.trainingNo}}
							<div class="pull-right">
							 	<a href="${rc.getContextPath()}/kv/configure-assessment?editCourseId={{group.id}}&editTrainingId=0">Edit&nbsp&nbsp</a>
								<span ng-if="group.active" ng-click="toggleActive(group)" style="cursor: pointer;">
									<i class="fa fa-play"></i>
								</span>
								<span ng-if="!group.active" ng-click="toggleActive(group)" style="cursor: pointer;">
									<i class="fa fa-pause"></i>
								</span>
							</div>
						</div>
						<div> Version : {{group.version}} </div>
						<div> Course Type : {{group.assesmentType}} </div>
						<div class="pull-right"> <a ng-click="callManageTrainingPage()" href="${rc.getContextPath()}/kv/trainings?courseIdFilter={{group.id}}">Manage Training</a> </div>
					</accordion-group>
				</accordion>
				
				<div class="alert alert-info" role="alert"  ng-show="courses.length == 0">
					No course found !!
				</div>
			</div>
		</div>
		<div class="col-md-1"></div>
	</div>	
</div>

<@macro.showFooter>
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/kv/course-list.js"></script>
</@macro.showFooter> 