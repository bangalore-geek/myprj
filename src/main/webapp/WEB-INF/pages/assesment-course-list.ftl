<#import "/spring.ftl" as spring /> <#import "macro.ftl" as macro/>
<@macro.showHeader />
<div class="container">
	<div id="mainDiv" ng-controller="AssesementCoursesCtrl">
		<div class="header">
			<h1 class="page-title">Assesement Course List <samp class="pull-right"><button class="btn btn-primary" ng-click="enableAddForm()">Add</button></samp></h1>
		</div>
		<div class="panel-container">
			<div class="row">
				<div class="panel panel-4">
					<div>
						<div class="panel panel-default">
							<div ng-show="assesmentCourses.editableForm">
								<form class="form-horizontal">
									<div class="form-group">
										<label for="courseNumber" class="col-sm-3 control-label">Course Number</label>
										<div class="col-sm-5">
											<input class="form-control" name="courseNumber" ng-model="editAssesmentCourses.courseNumber" />
										</div>
									</div>
									
									<div class="form-group">
										<label for="assesmentMasterId" class="col-sm-3 control-label">Assesement</label>
										<div class="col-sm-5">
											<select ng-model="editAssesmentCourses.assesmentMasterId">
												<option ng-selected="{{operator.description == editAssesmentCourses.assesmentMasterId}}"
														ng-repeat="operator in assesementList.data"
														value="{{operator.id}}">
												  {{operator.description}}
												</option>
											</select>
										</div>
									</div>	
									
									<div class="form-group">
										<label for="courseDescription" class="col-sm-3 control-label">Course Description</label>
										<div class="col-sm-5">
											<textarea class="form-control" name="courseDescription" ng-model="editAssesmentCourses.courseDescription">{{editAssesmentCourses.courseDescription}} </textarea>
										</div>
									</div>
									<div class="form-group">
										<label for="coustomer" class="col-sm-3 control-label">Coustomer</label>
										<div class="col-sm-5">
											<input class="form-control" name="coustomer" ng-model="editAssesmentCourses.coustomer" />
										</div>
									</div>								
									<button ng-click="enableAddForm()" class="btn">Cancel</button>
									<button ng-click="saveAssesementCourse(editAssesmentCourses)" class="btn btn-primary">Save</button>
								</form>
							</div>
							<div ng-show="!assesmentCourses.editableForm">
								<table class="table">
									<thead>
										<tr>
											<th>#</th>
											<th>Course Number</th>
											<th>Course Description</th>
											<th>Coustomer</th>
										</tr>
									</thead>
									<div>
										<tbody>
											<tr ng-repeat="assesement in assesmentCourses.data">
												<th scope="row">{{$index + 1}}</th>
												<td>{{assesement.courseNumber}}</td>
												<td>{{assesement.courseDescription}}</td>
												<td>{{assesement.coustomer}}</td>
												<td>
													<button ng-click="enableEditForm(assesement)" title="edit" class="fa fa-pencil"></button>
													<button ng-click="deleteAssesementCourse(assesement.id,$index)" title="delete" class="fa fa-trash"></button>
												</td>
											</tr>
										</tbody>
									</div>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>		
		</div>
	</div>
</div>
<@macro.showFooter>
<script type="text/javascript"
	src="${rc.getContextPath()}/resources/js/pages/assesment-course-list.js"></script>
</@macro.showFooter>
