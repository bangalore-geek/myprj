<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>

<@macro.showHeader />
<div class="header">
    <h1 class="page-title">Course Add</h1>
</div><br>
	<div ng-app="wizDemoApp" ng-controller="WizardCtrl">
		<wizard on-finish="finished()" current-step="st">
			<wz-step title="Add Course">
			
				<div class="row" style="margin-top:40px;">
					<form class="form-horizontal" name="courseFrm" novalidate>
						<div class="form-group" ng-class="{ 'has-error' : courseFrm.trainingNo.$invalid && !courseFrm.trainingNo.$pristine }">
							<label for="trainingNo" class="col-sm-3 control-label">Course No</label>
							<div class="col-sm-5">
								<input class="form-control" name="trainingNo" ng-model="editAssesement.trainingNo" required/>
								<p ng-show="courseFrm.trainingNo.$invalid && !courseFrm.trainingNo.$pristine" class="help-block">Course no is required.</p>
							</div>
						</div>
						<div class="form-group" ng-class="{ 'has-error' : courseFrm.name.$invalid && !courseFrm.name.$pristine }">
							<label for="name" class="col-sm-3 control-label">Name</label>
							<div class="col-sm-5">
								<input class="form-control" name="name" ng-model="editAssesement.name" required />
								<p ng-show="courseFrm.name.$invalid && !courseFrm.name.$pristine" class="help-block">Course name is required.</p>
							</div>
						</div>

						<div class="form-group" ng-class="{ 'has-error' : courseFrm.description.$invalid && !courseFrm.description.$pristine }">
							<label for="description" class="col-sm-3 control-label">Description</label>
							<div class="col-sm-5">
								<textarea class="form-control" name="description" ng-model="editAssesement.description" required>{{editAssesement.description}} </textarea>
								<p ng-show="courseFrm.description.$invalid && !courseFrm.description.$pristine" class="help-block">Course description is required.</p>
							</div>
						</div>
						
						<div class="form-group"  ng-class="{ 'has-error' : courseFrm.version.$invalid && !courseFrm.version.$pristine }">
							<label for="version" class="col-sm-3 control-label">Version</label>
							<div class="col-sm-2">
								<input class="form-control" name="version" ng-model="editAssesement.version" required/>
								<p ng-show="courseFrm.version.$invalid && !courseFrm.version.$pristine" class="help-block">Course version is required.</p>
							</div>
						</div>
						
						<div class="form-group" ng-class="{ 'has-error' : courseFrm.assesmentType.$invalid && !courseFrm.assesmentType.$pristine }">
							<label for="assesmentType" class="col-sm-3 control-label">Course Type</label>
							<div class="col-sm-2">
								<select ng-model="editAssesement.assesmentType" name="assesmentType" class="form-control" required>
									<option ng-repeat="operator in assesmentType.data"
											value="{{operator.description}}">
									  {{operator.description}}
									</option>
								</select>
								<p ng-show="courseFrm.assesmentType.$invalid && !courseFrm.assesmentType.$pristine" class="help-block">Course type is required.</p>
							</div>
						</div>
						
						<div class="form-group">
							<label for="assesmentType" class="col-sm-3 control-label">Active</label>
							<div class="col-sm-2">
								<select ng-model="editAssesement.active" class="form-control">
									<option selected value="true">YES</option>
									<option value="false">NO</option>
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="text-center">
					<input type="submit" wz-next value="Continue" class="btn btn-primary"  ng-disabled="courseFrm.$invalid" ng-click="saveAssesement(editAssesement)" />
				</div>
			</wz-step>
			<wz-step title="Add Training">
			<div class="row" style="margin-top:40px;">
				<form class="form-horizontal"  name="trainingFrm" novalidate>
				
					<div class="form-group" ng-class="{ 'has-error' : trainingFrm.assesmentMasterId.$invalid && !trainingFrm.assesmentMasterId.$pristine }">
						<label for="assesmentMasterId" class="col-sm-3 control-label">Course</label>
						<div class="col-sm-2">
							<select ng-model="editAssesement.assesmentMasterId" name="assesmentMasterId" class="form-control" required>
								<option ng-repeat="operator in assesementList.data"
										value="{{operator.id}}">
								  {{operator.name}}
								</option>
							</select>
							<p ng-show="courseFrm.assesmentType.$invalid && !courseFrm.assesmentType.$pristine" class="help-block">Course type is required.</p>
						</div>
					</div>
						
						
						
					<div class="form-group"  ng-class="{ 'has-error' : trainingFrm.courseNumber.$invalid && !trainingFrm.courseNumber.$pristine }">
						<label for="courseNumber" class="col-sm-3 control-label">Training Number</label>
						<div class="col-sm-5">
							<input class="form-control" name="courseNumber" ng-model="editAssesmentCourses.courseNumber" required/>
							<p ng-show="trainingFrm.courseNumber.$invalid && !trainingFrm.courseNumber.$pristine" class="help-block">Training number is required.</p>
						</div>
					</div>
					<div class="form-group"  ng-class="{ 'has-error' : trainingFrm.name.$invalid && !trainingFrm.name.$pristine }">
						<label for="courseNumber" class="col-sm-3 control-label">Training Name</label>
						<div class="col-sm-5">
							<input class="form-control" name="name" ng-model="editAssesmentCourses.trainingName" required/>
							<p ng-show="trainingFrm.name.$invalid && !trainingFrm.name.$pristine" class="help-block">Training name is required.</p>
						</div>
					</div>
					<div class="form-group"  ng-class="{ 'has-error' : trainingFrm.trainername.$invalid && !trainingFrm.trainername.$pristine }">
						<label for="courseNumber" class="col-sm-3 control-label">Traininer Name</label>
						<div class="col-sm-5">
							<input class="form-control" name="trainername" ng-model="editAssesmentCourses.traininerName" required/>
							<p ng-show="trainingFrm.trainername.$invalid && !trainingFrm.trainername.$pristine" class="help-block">Traininer name is required.</p>
						</div>
					</div>
					<div class="form-group"  ng-class="{ 'has-error' : trainingFrm.coustomer.$invalid && !trainingFrm.coustomer.$pristine }">
						<label for="courseNumber" class="col-sm-3 control-label">Coustomer Name</label>
						<div class="col-sm-5">
							<input class="form-control" name="coustomer" ng-model="editAssesmentCourses.coustomer" required/>
							<p ng-show="trainingFrm.coustomer.$invalid && !trainingFrm.coustomer.$pristine" class="help-block">Coustomer name is required.</p>
						</div>
					</div>
					<div class="form-group" ng-class="{ 'has-error' : trainingFrm.fromDate.$invalid && !trainingFrm.fromDate.$pristine }">
						<label for="dob" class="col-sm-3 control-label">From Date</label>
						<div class="col-sm-5">
							<p class="input-group">
								<input type="text" class="form-control"
									datepicker-popup="dd-MMM-yyyy" name="fromDate"
									ng-model="editAssesmentCourses.startdate" is-open="startdateopened"
									datepicker-options="dateOptions"
									close-text="Close" show-button-bar="false" required /> <span class="input-group-btn">
									<button type="button" class="btn btn-default"
										ng-click="startdateopen($event)">
										<i class="fa fa-calendar"></i>
									</button>
								</span>
							</p>
							<p ng-show="trainingFrm.fromDate.$invalid && !trainingFrm.fromDate.$pristine" class="help-block">Training start date is required.</p>
						</div>
					</div>
					
					<div class="form-group" ng-class="{ 'has-error' : trainingFrm.toDate.$invalid && !trainingFrm.toDate.$pristine }">
						<label for="dob" class="col-sm-3 control-label">To Date</label>
						<div class="col-sm-5">
							<p class="input-group">
								<input type="text" class="form-control" name="toDate"
									datepicker-popup="dd-MMM-yyyy"
									ng-model="editAssesmentCourses.enddate" is-open="enddateopened"
									datepicker-options="dateOptions"
									close-text="Close" show-button-bar="false" required/> <span class="input-group-btn">
									<button type="button" class="btn btn-default"
										ng-click="enddateopen($event)">
										<i class="fa fa-calendar"></i>
									</button>
								</span>
							</p>
							<p ng-show="trainingFrm.toDate.$invalid && !trainingFrm.toDate.$pristine" class="help-block">Training end date is required.</p>
						</div>
					</div>
					
					<div class="form-group" ng-class="{ 'has-error' : trainingFrm.assesmentDate.$invalid && !trainingFrm.assesmentDate.$pristine }">
						<label for="dob" class="col-sm-3 control-label">Assesment Date</label>
						<div class="col-sm-5">
							<p class="input-group">
								<input type="text" class="form-control" name="assesmentDate"
									datepicker-popup="dd-MMM-yyyy"
									ng-model="editAssesmentCourses.assesmentDate" is-open="assesmentopened"
									datepicker-options="dateOptions"
									close-text="Close" show-button-bar="false" required/> <span class="input-group-btn">
									<button type="button" class="btn btn-default"
										ng-click="assesmentopen($event)">
										<i class="fa fa-calendar"></i>
									</button>
								</span>
							</p>
							<p ng-show="trainingFrm.assesmentDate.$invalid && !trainingFrm.assesmentDate.$pristine" class="help-block">Training assesment date is required.</p>
						</div>
					</div>
					
					<div class="form-group" ng-class="{ 'has-error' : trainingFrm.courseDescription.$invalid && !trainingFrm.courseDescription.$pristine }">
						<label for="courseDescription" class="col-sm-3 control-label">Training Description</label>
						<div class="col-sm-5">
							<textarea class="form-control" name="courseDescription" ng-model="editAssesmentCourses.courseDescription" required>{{editAssesmentCourses.courseDescription}} </textarea>
							<p ng-show="trainingFrm.courseDescription.$invalid && !trainingFrm.courseDescription.$pristine" class="help-block">Training description is required.</p>
						</div>
					</div>
				
				</form>
				</div>
				<div class = "text-center">
					<input type="submit" wz-next="logStep()" value="Continue" class="btn btn-primary"  ng-disabled="trainingFrm.$invalid" ng-click="saveAssesementCourse(editAssesmentCourses)" ng-click="saveAssesementCourse(editAssesmentCourses)"/>
				</div>
			</wz-step>
			<wz-step title="Upload TRAINEE">
				<div class="row" style="margin-top:100px;margin-left:115px;">
					<div class="row">
						<form class="form-horizontal">
							<div class="form-group">
								<label for="exampleInputFile">File input</label>
								<input type="file" id="exampleInputFile">
							</div>
						</form>
					</div>
				</div>
				<div class = "text-center">
					<input type="submit" wz-next="logStep()" value="Continue" class="btn btn-primary" ng-click="saveAssesementCourse(editAssesmentCourses)"/>
				</div>
			</wz-step>
			<wz-step title="Summary">
				<div class="row" style="margin-top:100px;margin-left:115px;">
					<form class="form-horizontal">
						<div>
							<h2>Courses</h2>
							<div>Name = {{assesments.assesment.name}}</div>
							<div>Training No = {{assesments.assesment.trainingNo}}</div>
							<div>Assesment Type = {{assesments.assesment.assesmentType}}</div>
							<div>Description = {{assesments.assesment.description}}</div>
							<div>version = {{assesments.assesment.version}}</div>
						</div>
						
						<div>
							<h2>Training</h2>
							<div>Course Number = {{assesments.courses.courseNumber}}</div>
							<div>Assesment = {{assesments.courses.assesmentMasterId}}</div>
							<div>Course Description = {{assesments.courses.courseDescription}}</div>
							<div> coustomer = {{assesments.courses.coustomer}}</div>
						</div>
					</form>
				</div>
			</wz-step>
		</wizard>
	</div>

<@macro.showFooter>
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/sample-wizard.js"></script>
</@macro.showFooter>