<#import "/spring.ftl" as spring /> <#import "macro.ftl" as macro/>
<@macro.showHeader />
<div class="header">
	<h1 class="page-title">Student Profile</h1>
</div>
<div id="mainDiv" ng-controller="StudentDetailsCtrl">
	<!-- row 1 -->
	
<div class="ng-hide" ng-show="showMessage">{{msg}} {{ greeting }}</div>
	
	
	<div class="row col-md-12">
		<!-- student details table-->
		<div class="col-md-6">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">
						Personal Information <a href="#" ng-click="enableEdit('profile')"
							class="pull-right"> <span class="fa fa-pencil"></span>
						</a>
					</h3>
				</div>
				<div class="panel-body">
					<div ng-show="!studentDetails.profile.editable">
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-sm-2 control-label">Gender</label>
								<div class="col-sm-10">
									<p class="form-control-static">{{studentDetails.profile.data.gender}}</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">DOB</label>
								<div class="col-sm-10">
									<p class="form-control-static">{{studentDetails.profile.data.dob | date:'dd-MMM-yyyy'}}</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Disability</label>
								<div class="col-sm-10">
									<p class="form-control-static">{{studentDetails.profile.data.disability}}</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Current Location</label>
								<div class="col-sm-10">
									<p class="form-control-static">{{studentDetails.profile.data.currentLocation}}</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Preffered Location</label>
								<div class="col-sm-10">
									<p class="form-control-static">{{studentDetails.profile.data.prefferedLocation}}</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Notice Period</label>
								<div class="col-sm-10">
									<p class="form-control-static">{{studentDetails.profile.data.noticePeriod}}</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Experience</label>
								<div class="col-sm-10">
									<p class="form-control-static">{{studentDetails.profile.data.experience}}</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Industry</label>
								<div class="col-sm-10">
									<p class="form-control-static">{{studentDetails.profile.data.industry}}</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Current Ctc</label>
								<div class="col-sm-10">
									<p class="form-control-static">{{studentDetails.profile.data.currentCtc}}</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Expected Ctc</label>
								<div class="col-sm-10">
									<p class="form-control-static">{{studentDetails.profile.data.expectedCtc}}</p>
								</div>
							</div>
						</form>
					</div>
					<form ng-show="studentDetails.profile.editable"
						class="form-horizontal">
						<div class="control-group">
							<label class="control-label">Gender</label>
							<div class="controls">
								<select name="gender" ng-model="studentDetails.profile.data.gender"> 
								  <option value="M">Male</option>
								  <option value="F">Female</option>
								</select>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">DOB</label>
							<div class="controls">
								<input class="input-small" name="dob"
									ng-model="studentDetails.profile.data.dob" type="text" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Disability</label>
							
							<div class="controls">
								<select name="gender" name="disability" ng-model="studentDetails.profile.data.disability"> 
								  <option value="true">Yes</option>
								  <option value="false">No</option>
								</select>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Current Location</label>
							<div class="controls">
								<input class="input-small" name="currentLocation"
									ng-model="studentDetails.profile.data.currentLocation"
									type="text" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Preffered Location</label>
							<div class="controls">
								<input class="input-small" name="prefferedLocation"
									ng-model="studentDetails.profile.data.prefferedLocation"
									type="text" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Notice Period</label>
							<div class="controls">
								<input class="input-small" name="noticePeriod"
									ng-model="studentDetails.profile.data.noticePeriod" type="text" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Experience</label>
							<div class="controls">
								<input class="input-small" name="experience"
									ng-model="studentDetails.profile.data.experience" type="text" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Industry</label>
							<div class="controls">
								<input class="input-small" name="industry"
									ng-model="studentDetails.profile.data.industry" type="text" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Current Ctc</label>
							<div class="controls">
								<input class="input-small" name="currentCtc"
									ng-model="studentDetails.profile.data.currentCtc" type="text" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">expectedCtc</label>
							<div class="controls">
								<input class="input-small" name="expectedCtc"
									ng-model="studentDetails.profile.data.expectedCtc" type="text" />
							</div>
						</div>

						<div class="panel-footer"
							ng-show="studentDetails.profile.editable">
							<div class="controls">
								<button class="btn btn-primary" ng-click="saveStudentProfile()">Save</button>
								<button class="btn" ng-click="cancel('profile')">Cancel</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">
						Education Information <a href="#"
							ng-click="enableEdit('education')" class="pull-right"> <span
							class="fa fa-pencil"></span>
						</a>
					</h3>
				</div>
				<div class="panel-body">
					<form class="form-horizontal">
						<div ng-show="!studentDetails.education.editable">
							<div class="form-group">
								<label class="col-sm-2 control-label">Course</label>
								<div class="col-sm-10">
									<p class="form-control-static">{{studentDetails.education.data.course}}</p>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label">Year Completed</label>
								<div class="col-sm-10">
									<p class="form-control-static">{{studentDetails.education.data.yearCompleted}}</p>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label">Grade</label>
								<div class="col-sm-10">
									<p class="form-control-static">{{studentDetails.education.data.grade}}</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Percentage</label>
								<div class="col-sm-10">
									<p class="form-control-static">{{studentDetails.education.data.percentage}}</p>
								</div>
							</div>
						</div>
					</form>
					<form ng-show="studentDetails.education.editable"
						class="form-horizontal">
						<div class="control-group">
							<label class="control-label">Course</label>
							<div class="controls">
								<input class="input-small" name="course"
									ng-model="studentDetails.education.data.course" type="text" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Year Completed</label>
							<div class="controls">
								<input class="input-small" name="yearCompleted"
									ng-model="studentDetails.education.data.yearCompleted"
									type="text" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Grade</label>
							<div class="controls">
								<input class="input-small" name="grade"
									ng-model="studentDetails.education.data.grade" type="text" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Percentage</label>
							<div class="controls">
								<input class="input-small" name="percentage"
									ng-model="studentDetails.education.data.percentage" type="text" />
							</div>
						</div>
						<div class="panel-footer"
							ng-show="studentDetails.education.editable">
							<div class="controls">
								<button class="btn btn-primary"
									ng-click="saveStudentEducation()">Save</button>
								<button class="btn" ng-click="cancel('education')">Cancel</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">
						Work History<a href="#" ng-click="enableEdit('workhistory')"
							class="pull-right" onclick="return false"> <span
							class="fa fa-pencil"></span>
						</a>
					</h3>
				</div>
				<div class="panel-body">
					<div ng-show="!studentDetails.workhistory.editable">
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-sm-2 control-label">Company Name</label>
								<div class="col-sm-10">
									<p class="form-control-static">{{studentDetails.workhistory.data.companyName}}</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Designation</label>
								<div class="col-sm-10">
									<p class="form-control-static">{{studentDetails.workhistory.data.designation}}</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Start Date</label>
								<div class="col-sm-10">
									<p class="form-control-static">{{studentDetails.workhistory.data.startdate}}</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">End Date</label>
								<div class="col-sm-10">
									<p class="form-control-static">{{studentDetails.workhistory.data.enddate}}</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Job Type</label>
								<div class="col-sm-10">
									<p class="form-control-static">{{studentDetails.workhistory.data.jobType}}</p>
								</div>
							</div>
						</form>
					</div>
					<form ng-show="studentDetails.workhistory.editable"
						class="form-horizontal">
						<div class="control-group">
							<label class="control-label">Company Name</label>
							<div class="controls">
								<input class="input-small" name="companyName"
									ng-model="studentDetails.workhistory.data.companyName"
									type="text" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Designation</label>
							<div class="controls">
								<input class="input-small" name="designation"
									ng-model="studentDetails.workhistory.data.designation"
									type="text" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Start Date</label>
							<div class="controls">
								<input class="input-small" name="startdate"
									ng-model="studentDetails.workhistory.data.startdate"
									type="text" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">End Date</label>
							<div class="controls">
								<input class="input-small" name="enddate"
									ng-model="studentDetails.workhistory.data.enddate" type="text" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Job Type</label>
							<div class="controls">
								<input class="input-small" name="jobType"
									ng-model="studentDetails.workhistory.data.jobType" type="text" />
							</div>
						</div>

						<div class="panel-footer"
							ng-show="studentDetails.workhistory.editable">
							<div class="controls">
								<button class="btn btn-primary"
									ng-click="saveStudentworkhistory()">Save</button>
								<button class="btn" ng-click="cancel('workhistory')">Cancel</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<@macro.showFooter>
<script type="text/javascript"
	src="${rc.getContextPath()}/resources/js/pages/student-profile.js"></script>
</@macro.showFooter>
