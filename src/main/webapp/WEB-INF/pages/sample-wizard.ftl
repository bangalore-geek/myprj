<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>

<@macro.showHeader />
<div class="header">
    <h1 class="page-title">Course Add</h1>
</div><br>
	<div ng-app="wizDemoApp" ng-controller="WizardCtrl">
		<wizard on-finish="finished()" current-step="curr">
			<wz-step  title="Add Course">
				<div class="row" style="margin-top:40px;">
					<form class="form-horizontal" name="courseFrm" novalidate>
						<div class="form-group" ng-class="{ 'has-error' : courseFrm.trainingNo.$invalid && !courseFrm.trainingNo.$pristine }">
							<label for="trainingNo" class="col-sm-3 control-label">Course No</label>
							<div class="col-sm-5">
								<input class="form-control" name="trainingNo" ng-model="thisCourse.trainingNo" required/>
								<p ng-show="courseFrm.trainingNo.$invalid && !courseFrm.trainingNo.$pristine" class="help-block">Course no is required.</p>
							</div>
						</div>
						<div class="form-group" ng-class="{ 'has-error' : courseFrm.name.$invalid && !courseFrm.name.$pristine }">
							<label for="name" class="col-sm-3 control-label">Name</label>
							<div class="col-sm-5">
								<input class="form-control" name="name" ng-model="thisCourse.name" required/>
								<p ng-show="courseFrm.name.$invalid && !courseFrm.name.$pristine" class="help-block">Course name is required.</p>
							</div>
						</div>

						<div class="form-group" ng-class="{ 'has-error' : courseFrm.description.$invalid && !courseFrm.description.$pristine }">
							<label for="description" class="col-sm-3 control-label">Description</label>
							<div class="col-sm-5">
								<textarea class="form-control" name="description" ng-model="thisCourse.description" required>{{thisCourse.description}} </textarea>
								<p ng-show="courseFrm.description.$invalid && !courseFrm.description.$pristine" class="help-block">Course description is required.</p>
							</div>
						</div>
						
						<div class="form-group" ng-class="{ 'has-error' : courseFrm.version.$invalid && !courseFrm.version.$pristine }">
							<label for="version" class="col-sm-3 control-label">Version</label>
							<div class="col-sm-2">
								<input class="form-control" name="version" ng-model="thisCourse.version" required/>
								<p ng-show="courseFrm.version.$invalid && !courseFrm.version.$pristine" class="help-block">Course version is required.</p>
							</div>
						</div>
						
						<div class="form-group" ng-class="{ 'has-error' : courseFrm.assesmentType.$invalid && !courseFrm.assesmentType.$pristine }">
							<label for="assesmentType" class="col-sm-3 control-label">Course Type</label>
							<div class="col-sm-2">
								<select ng-model="thisCourse.assesmentType" name="assesmentType" class="form-control" required>
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
								<select ng-model="thisCourse.active" class="form-control">
									<option selected value="true">YES</option>
									<option value="false">NO</option>
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="text-center">
					<input type="submit" value="Save" class="btn btn-primary" ng-disabled="courseFrm.$invalid" ng-click="saveCourse(thisCourse)" />
					<input type="submit" wz-next value="Continue" class="btn btn-primary"/>
				</div>
			</wz-step>
			
			
			<wz-step title="Add Training">
				<div class="row" style="margin-top:40px;">
					<form class="form-horizontal"  name="trainingFrm" novalidate>
						<div class="form-group">						
							<div class="text-center"><h2>Training for "{{thisSummary.thisCourse.name}}" Course</h2></div>
						</div>
							
						<div class="form-group" ng-class="{ 'has-error' : trainingFrm.courseNumber.$invalid && !trainingFrm.courseNumber.$pristine }" >
							<label for="courseNumber" class="col-sm-3 control-label">Training Number</label>
							<div class="col-sm-5">
								<input class="form-control" name="courseNumber" ng-model="thisTraining.courseNumber" required/>
								<p ng-show="trainingFrm.courseNumber.$invalid && !trainingFrm.courseNumber.$pristine" class="help-block">Training number is required.</p>
							</div>
						</div>
						<div class="form-group" ng-class="{ 'has-error' : trainingFrm.name.$invalid && !trainingFrm.name.$pristine }">
							<label for="courseNumber" class="col-sm-3 control-label">Training Name</label>
							<div class="col-sm-5">
								<input class="form-control" name="name" ng-model="thisTraining.trainingName" required/>
								<p ng-show="trainingFrm.name.$invalid && !trainingFrm.name.$pristine" class="help-block">Training name is required.</p>
							</div>
						</div>
						<div class="form-group" ng-class="{ 'has-error' : trainingFrm.trainername.$invalid && !trainingFrm.trainername.$pristine }">
							<label for="courseNumber" class="col-sm-3 control-label">Trainer Name</label>
							<div class="col-sm-5">
								<input class="form-control" name="trainername" ng-model="thisTraining.traininerName" required/>
								<p ng-show="trainingFrm.trainername.$invalid && !trainingFrm.trainername.$pristine" class="help-block">Traininer name is required.</p>
							</div>
						</div>
						<div class="form-group" ng-class="{ 'has-error' : trainingFrm.coustomer.$invalid && !trainingFrm.coustomer.$pristine }">
							<label for="courseNumber" class="col-sm-3 control-label">Customer Name</label>
							<div class="col-sm-5">
								<input class="form-control" name="coustomer" ng-model="thisTraining.coustomer" required/>
								<p ng-show="trainingFrm.coustomer.$invalid && !trainingFrm.coustomer.$pristine" class="help-block">Customer Name is required.</p>
							</div>
						</div>
						
						<div class="form-group">
							<label for="dob" class="col-sm-3 control-label">From Date</label>
							<div class="col-sm-5">
								<p class="input-group">
									<input type="text" class="form-control"
										datepicker-popup="dd-MMM-yyyy" name="fromDate"
										ng-model="editAssesmentCourses.startdate" is-open="startdateopened"
										datepicker-options="dateOptions"
										close-text="Close" show-button-bar="false"  /> <span class="input-group-btn">
										<button type="button" class="btn btn-default"
											ng-click="startdateopen($event)">
											<i class="fa fa-calendar"></i>
										</button>
									</span>
								</p>
							</div>
						</div>
					
						<div class="form-group">
							<label for="dob" class="col-sm-3 control-label">To Date</label>
							<div class="col-sm-5">
								<p class="input-group">
									<input type="text" class="form-control" name="toDate"
										datepicker-popup="dd-MMM-yyyy"
										ng-model="editAssesmentCourses.enddate" is-open="enddateopened"
										datepicker-options="dateOptions"
										close-text="Close" show-button-bar="false" /> <span class="input-group-btn">
										<button type="button" class="btn btn-default"
											ng-click="enddateopen($event)">
											<i class="fa fa-calendar"></i>
										</button>
									</span>
								</p>
							</div>
						</div>
					
						<div class="form-group">
							<label for="dob" class="col-sm-3 control-label">Assessment Date</label>
							<div class="col-sm-5">
								<p class="input-group">
									<input type="text" class="form-control" name="assesmentDate"
										datepicker-popup="dd-MMM-yyyy"
										ng-model="editAssesmentCourses.assesmentDate" is-open="assesmentopened"
										datepicker-options="dateOptions"
										close-text="Close" show-button-bar="false"/> <span class="input-group-btn">
										<button type="button" class="btn btn-default"
											ng-click="assesmentopen($event)">
											<i class="fa fa-calendar"></i>
										</button>
									</span>
								</p>
							</div>
						</div>
						
						<div class="form-group" ng-class="{ 'has-error' : trainingFrm.courseDescription.$invalid && !trainingFrm.courseDescription.$pristine }">
							<label for="courseDescription" class="col-sm-3 control-label">Training Description</label>
							<div class="col-sm-5">
								<textarea class="form-control" name="courseDescription" ng-model="thisTraining.courseDescription" required>{{thisTraining.courseDescription}} </textarea>
								<p ng-show="trainingFrm.courseDescription.$invalid && !trainingFrm.courseDescription.$pristine" class="help-block">Training description is required.</p>
							</div>
						</div>
					</form>
				</div>
				<div class = "text-center">
					<input type="submit" value="Save" class="btn btn-primary"   ng-disabled="trainingFrm.$invalid" ng-click="saveTraining(thisTraining)"/>
					<input type="submit" wz-next="logStep()" value="Continue" class="btn btn-primary"/>
				</div>
				
				<div class="row" >
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<div  style="padding:10px;">
							<accordion class="accordion" close-others="true">
								<accordion-group  ng-repeat="group in thisSummary.thisCourseTrainingList">
									<accordion-heading>
										<span>{{group.trainingName}}</span>
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
			</wz-step>
			
			<wz-step title="Upload TRAINEE">
				<div class="row" style="margin-top:100px;margin-left:115px;">
					<div class="row">
						<div class="col-md-6">
							<form class="form-horizontal">
							
								<div class="form-group">
									<label for="assesmentMasterTrainingId" class="col-sm-3 control-label">Select Training</label>
									<div class="col-sm-5">
										<select ng-model="thisTrainee.assesmentMasterTrainingId" name="assesmentMasterTrainingId" class="form-control">
											<option ng-repeat="operator in thisSummary.thisCourseTrainingList"
													value="{{operator.id}}">
											  {{operator.trainingName}}
											</option>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label for="name" class="col-sm-3 control-label">Name</label>
									<div class="col-sm-5">
										<input class="form-control" ng-model="thisTrainee.name" name="name" />
									</div>
								</div>
								<div class="form-group">
									<label for="email" class="col-sm-3 control-label">Email</label>
									<div class="col-sm-5">
										<input class="form-control" ng-model="thisTrainee.email" name="email"/>
									</div>
								</div>

								<div class="form-group">
									<label for="mobile" class="col-sm-3 control-label">Mobile</label>
									<div class="col-sm-5">
										<input class="form-control" ng-model="thisTrainee.phone" name="phone"/>
									</div>
								</div>
							</form>
						</div>
						<div class="col-md-1"><b>OR<b>
						</div>
						<div class="col-md-5">
							<div class="form-group">
								<label for="exampleInputFile">File input</label>
								<input type="file" id="exampleInputFile">
							</div>
						</div>
					</div>
				</div>
				<div class = "text-center">	
					<input type="submit" ng-click="saveTrainee(thisTrainee)" value="Save & Add New" class="btn btn-primary"/>
					<input type="submit" wz-next="logStep()" value="Continue" class="btn btn-primary"/>
				</div><br>
				
				
				<div class="row">
					<div class="col-sm-3"></div>
					<div class="col-sm-5">Show Trainee For
						<select ng-model="trainingIdForTrainee" name="assesmentMasterTrainingId" class="form-control" ng-change="loadTrainee(trainingIdForTrainee)">
							<option ng-repeat="operator in thisSummary.thisCourseTrainingList"
									value="{{operator.id}}">
							  {{operator.trainingName}}
							</option>
						</select>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<table class="table table-striped table-bordered">
							<tr>
								<th>Name</th>
								<th>Email</th>
								<th>Phone</th>
								<th>Action</th>
							</tr>
							<tr ng-repeat="trainee in traineeList">
								<td>{{trainee.name}}</td>
								<td>{{trainee.email}}</td>
								<td>{{trainee.phone}}</td>
								<td><button ng-click="deleteTrainee(trainee.id,$index)" title="delete" class="fa fa-trash"></button></td>
							</tr>
							
						</table>					
					</div>
					<div class="col-md-1"></div>
				</div>
			</wz-step>		
			<wz-step title="Summary">
				<div class="row" style="margin-top:100px;margin-left:115px;">
					<form class="form-horizontal">
						<div>
							<h2>Course</h2>
							<div>Name = {{thisSummary.thisCourse.name}}</div>
							<div>Training No = {{thisSummary.thisCourse.trainingNo}}</div>
							<div>Assessment Type = {{thisSummary.thisCourse.assesmentType}}</div>
							<div>Description = {{thisSummary.thisCourse.description}}</div>
							<div>version = {{thisSummary.thisCourse.version}}</div>
						</div>
						<div>
							<h2>Training</h2>
							<div ng-repeat="operator in thisSummary.thisCourseTrainingList">
								<div>Name = {{operator.trainingName}}</div>
								<div>Training No = {{operator.courseNumber}}</div>
								<div>coustomer = {{operator.coustomer}}</div>
								<div>Description = {{operator.courseDescription}}</div><br>
							</div>
						</div>
					</form>
					<input type="submit" value="Finish" class="btn btn-primary" ng-click="ShowFinish()"/>
				</div>
			</wz-step>			
		</wizard>
	</div>

<@macro.showFooter>
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/sample-wizard.js"></script>
</@macro.showFooter>


