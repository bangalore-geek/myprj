<#import "/spring.ftl" as spring /> <#import "macro.ftl" as macro/>
<@macro.showHeader />
<div class="container">
	<div class="header">
		<h1 class="page-title">Student Profile</h1>
	</div>
	<div id="mainDiv" ng-controller="StudentDetailsCtrl">
		<div class="panel-container">
			<div class="row">
				<div class="col-md-4">
					<div class="panel panel-1">
						<div class="pull-right ng-scope">
							<i ng-show="!studentDetails.profile.editable"
								ng-click="enableEdit('profile')" title="edit"
								class="fa fa-pencil" style="cursor: pointer;"></i> <i
								ng-show="studentDetails.profile.editable"
								ng-click="cancel('profile')" class="fa fa-times"
								style="cursor: pointer;"></i>
						</div>
						<h3 class="ng-scope">Personal Information</h3>
						<div ng-show="!studentDetails.profile.editable">
							<div class="data-row">
								<label>First Name</label>
								<div>{{studentDetails.profile.data.firstname}}</div>
							</div>
							<div class="data-row">
								<label>Middle Name</label>
								<div>{{studentDetails.profile.data.middlename}}</div>
							</div>
							<div class="data-row">
								<label>Last Name</label>
								<div>{{studentDetails.profile.data.lastname}}</div>
							</div>
							<div class="data-row">
								<label>DOB</label>
								<div>{{studentDetails.profile.data.dob |
									date:'dd-MMM-yyyy'}}</div>
							</div>
							<div class="data-row">
								<label>Gender</label>
								<div>{{studentDetails.profile.data.gender}}</div>
							</div>
							<div class="data-row">
								<label>Marital Status</label>
								<div>{{studentDetails.profile.data.maritalStatus}}</div>
							</div>
							<div class="data-row">
								<label>Passport</label>
								<div>{{studentDetails.profile.data.passport}}</div>
							</div>
							<div class="data-row">
								<label>Pancard</label>
								<div>{{studentDetails.profile.data.pancard}}</div>
							</div>
							<div class="data-row">
								<label>Aadhar Card</label>
								<div>{{studentDetails.profile.data.aadharcard}}</div>
							</div>
							
							<div class="data-row">
								<label>Residence Address</label>
							</div>
							
							<div class="data-row">
								<label>Address 1</label>
								<div>{{studentDetails.profile.data.aadharcard}}</div>
							</div>
						</div>
						<div ng-show="studentDetails.profile.editable">
							<form class="form-horizontal">
								<div class="form-group">
									<label for="currentLocation" class="col-sm-3 control-label">First Name</label>
									<div class="col-sm-5">
										<input class="form-control" name="firstname"
											ng-model="studentDetails.profile.data.firstname" />
									</div>
								</div>
								<div class="form-group">
									<label for="currentLocation" class="col-sm-3 control-label">Middle Name</label>
									<div class="col-sm-5">
										<input class="form-control" name="middlename"
											ng-model="studentDetails.profile.data.middlename" />
									</div>
								</div>
								<div class="form-group">
									<label for="currentLocation" class="col-sm-3 control-label">Last Name</label>
									<div class="col-sm-5">
										<input class="form-control" name="lastname"
											ng-model="studentDetails.profile.data.lastname" />
									</div>
								</div>
								<div class="form-group">
									<label for="dob" class="col-sm-3 control-label">DOB</label>
									<div class="col-sm-5">
										<p class="input-group">
											<input type="text" class="form-control"
												datepicker-popup="dd-MMM-yyyy"
												ng-model="studentDetails.profile.data.dob" is-open="opened"
												datepicker-options="dateOptions" ng-required="true"
												close-text="Close" /> <span class="input-group-btn">
												<button type="button" class="btn btn-default"
													ng-click="open($event)">
													<i class="fa fa-calendar"></i>
												</button>
											</span>
										</p>
									</div>
								</div>
								<div class="form-group">
									<label for="gender" class="col-sm-3 control-label">Gender</label>
									<div class="col-sm-5">
										<select class="form-control" name="gender"
											ng-model="studentDetails.profile.data.gender">
											<option value="M">Male</option>
											<option value="F">Female</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="gender" class="col-sm-3 control-label">Marital Status</label>
									<div class="col-sm-5">
										<select class="form-control" name="maritalStatus"
											ng-model="studentDetails.profile.data.maritalStatus">
											<option value="Single">Single </option>
											<option value="Married">Married</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="currentLocation" class="col-sm-3 control-label">Passport</label>
									<div class="col-sm-5">
										<input class="form-control" name="passport"
											ng-model="studentDetails.profile.data.passport" />
									</div>
								</div>
								<div class="form-group">
									<label for="currentLocation" class="col-sm-3 control-label">Pancard</label>
									<div class="col-sm-5">
										<input class="form-control" name="pancard"
											ng-model="studentDetails.profile.data.pancard" />
									</div>
								</div>
								<div class="form-group">
									<label for="currentLocation" class="col-sm-3 control-label">Aadhar Card</label>
									<div class="col-sm-5">
										<input class="form-control" name="aadharcard"
											ng-model="studentDetails.profile.data.aadharcard" />
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-4 col-sm-10">
										<button ng-click="saveStudentProfile()" class="btn btn-primary">Save</button>
										<button ng-click="cancel('profile')" class="btn">Cancel</button>
									</div>
								</div>
							</form>
						</div>
					</div>
					</div>
				<div class="col-md-8">
					<div class="panel panel-3">
						<div class="pull-right ng-scope"><samp class="pull-right"><button ng-click="enableAddFormEducation(editEducation)" class="btn btn-primary">Add</button></samp></div>
						<h3 class="ng-scope">Education Information</h3>
						<div ng-show="studentDetails.education.editableForm">
							<form class="form-horizontal">
								<div class="form-group">
									<label for="institutions" class="col-sm-3 control-label">institutions</label>
									<div class="col-sm-5">
										<input class="form-control" name="institutions" ng-model="editEducation.institutions" />
									</div>
								</div>
								<div class="form-group">
									<label for="certification" class="col-sm-3 control-label">certification</label>
									<div class="col-sm-5">
										<input class="form-control" name="certification" ng-model="editEducation.certification" />
									</div>
								</div>
								<div class="form-group">
									<label for="certification" class="col-sm-3 control-label">Major In</label>
									<div class="col-sm-5">
										<textarea class="form-control" name="certification" ng-model="editEducation.majorIn">{{editEducation.majorIn}} </textarea>
									</div>
								</div>
								<div class="form-group">
									<label for="grade" class="col-sm-3 control-label">Grade </label>
									<div class="col-sm-5">
										<input class="form-control" name="Grade " ng-model="editEducation.grade" />
									</div>
								</div>	
								<div class="form-group">
									<label for="description" class="col-sm-3 control-label">Description</label>
									<div class="col-sm-5">
										<textarea class="form-control" name="description" ng-model="editEducation.description">{{editEducation.description}} </textarea>
									</div>
								</div>
								<div class="form-group">
									<label for="description" class="col-sm-3 control-label">University</label>
									<div class="col-sm-5">
										<select ng-model="editEducation.university">
											<option ng-selected="{{operator.description == editEducation.university}}"
													ng-repeat="operator in university.data"
													value="{{operator.description}}">
											  {{operator.description}}
											</option>
										</select>
									</div>
								</div>								
								<button ng-click="enableAddFormEducation()" class="btn">Cancel</button>
								<button ng-click="saveStudentEducation(editEducation)" class="btn btn-primary">Save</button>
							</form>
						</div>
						<div ng-show="!studentDetails.education.editableForm">
							<table class="table">
								<thead>
									<tr>
										<th>#</th>
										<th>Institute</th>
										<th>University</th>
										<th>Certification</th>
										<th>Major In</th>
										<th>Grade</th>
										<th>Description</th>
									</tr>
								</thead>
								<div>
									<tbody>
										<tr ng-repeat="edu in studentDetails.education.data">
											<th scope="row">{{$index + 1}}</th>
											<td>{{edu.institutions}}</td>
											<td>{{edu.university}}</td>
											<td>{{edu.certification}}</td>
											<td>{{edu.majorIn}}</td>
											<td>{{edu.grade}}</td>
											<td>{{edu.description}}</td>
											<td>
												<div class="pull-right ng-scope">
													<button ng-click="enableAddFormEducation(edu)" title="edit" class="fa fa-pencil"></button>
													<button ng-click="deleteStudenteducation(edu.id,$index)" title="delete" class="fa fa-trash"></button>  
												</div>
											</td>
										</tr>
									</tbody>
								</div>
							</table>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="panel panel-4">
					<div>
						<div class="panel panel-default">
							<!-- Default panel contents -->
							<div class="panel-heading">
								Experience<samp class="pull-right"><button class="btn btn-primary" ng-click="enableAddForm()">Add</button></samp>
							</div>
							<div ng-show="studentDetails.workhistory.editableForm">
								<form class="form-horizontal"  name="workHistory" novalidate>
									<div class="form-group" ng-class="{ 'has-error' : workHistory.companyName.$invalid && !workHistory.companyName.$pristine }"> 
										<label for="companyName" class="col-sm-3 control-label">Company
											Name</label>
										<div class="col-sm-5">
											<input class="form-control" name="companyName"
												ng-model="editWorkHistory.companyName" required />
												<p ng-show="workHistory.companyName.$invalid && !workHistory.companyName.$pristine" class="help-block">Company name is required.</p>
												
										</div>
									</div>
									<div class="form-group"  ng-class="{ 'has-error' : workHistory.title.$invalid && !workHistory.title.$pristine }">
										<label for="title" class="col-sm-3 control-label">Title</label>
										<div class="col-sm-5">
											<input class="form-control" name="title"
												ng-model="editWorkHistory.title" required/>
												<p ng-show="workHistory.title.$invalid && !workHistory.title.$pristine" class="help-block">Title is required.</p>
										</div>
									</div>
									<div class="form-group"  ng-class="{ 'has-error' : workHistory.location.$invalid && !workHistory.location.$pristine }">
										<label for="location" class="col-sm-3 control-label">Location</label>
										<div class="col-sm-5">
											<input class="form-control" name="location"
												ng-model="editWorkHistory.location" required/>
												<p ng-show="workHistory.location.$invalid && !workHistory.location.$pristine" class="help-block">Location is required.</p>
										</div>
									</div>
									
									<div class="form-group">
										<label for="description" class="col-sm-3 control-label">Description</label>
										<div class="col-sm-5">
											<textarea class="form-control" name="description" ng-model="editWorkHistory.description">{{editWorkHistory.description}} </textarea>
										</div>
									</div>
									
									
									
									<button ng-click="enableAddForm()" class="btn">Cancel</button>
									<button ng-click="saveStudentworkhistory(editWorkHistory)" class="btn btn-primary" ng-disabled="workHistory.$invalid">Save</button>
								</form>
							</div>
							<div ng-show="!studentDetails.workhistory.editableForm">
								<!-- </div> -->
								<!-- Table -->
								<table class="table">
									<thead>
										<tr>
											<th>#</th>
											<th>Company Name</th>
											<th>Title</th>
											<th>Location</th>
											<th>Description</th>
										</tr>
									</thead>
									<div>
										<tbody>
											<tr ng-repeat="workhistory in studentDetails.workhistory.data">
												<th scope="row">{{$index + 1}}</th>
												<td>{{workhistory.companyName}}</td>
												<td>{{workhistory.title}}</td>
												<td>{{workhistory.location}}</td>
												<td>{{workhistory.description}}</td>
												<td>
													<div class="pull-right ng-scope">
														<button ng-click="enableAddForm(workhistory)" title="edit" class="fa fa-pencil"></button>
														<button ng-click="deleteStudentworkhistory(workhistory.id,$index)" title="delete" class="fa fa-trash"></button>  
													</div>
												</td>
											</tr>
										</tbody>
									</div>
								</table>
							</div>
						</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="panel panel-2">
						<div class="pull-right ng-scope">
							<i ng-show="!studentDetails.references[0].editable"
								ng-click="enableEditReferences('0')" title="edit"
								class="fa fa-pencil" style="cursor: pointer;"></i> <i
								ng-show="studentDetails.references[0].editable"
								ng-click="cancel('references')" class="fa fa-times"
								style="cursor: pointer;"></i>
						</div>
						<h3 class="ng-scope">References 1</h3>
						<div ng-show="!studentDetails.references[0].editable">
							<div class="data-row">
								<label>Name</label>
								<div>{{studentDetails.references.data[0].name}}</div>
							</div>
						</div>
						<div ng-show="studentDetails.references[0].editable">
							<form class="form-horizontal">
								<div class="form-group">
									<label for="references" class="col-sm-3 control-label">Name</label>
									<div class="col-sm-5">
										<input class="form-control" name="name"
											ng-model="studentDetails.references.data[0].name" />
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
				
				<div class="col-md-6">
					<div class="panel panel-2">
						<div class="pull-right ng-scope">
							<i ng-show="!studentDetails.references[1].editable"
								ng-click="enableEdit('references')" title="edit"
								class="fa fa-pencil" style="cursor: pointer;"></i> <i
								ng-show="studentDetails.references[1].editable"
								ng-click="cancel('references')" class="fa fa-times"
								style="cursor: pointer;"></i>
						</div>
						<h3 class="ng-scope">References 2</h3>
						<div ng-show="!studentDetails.references[1].editable">
							<div class="data-row">
								<label>Name</label>
								<div>{{studentDetails.references.data[1].name}}</div>
							</div>
						</div>
						<div ng-show="studentDetails.references[1].editable">
							<form class="form-horizontal">
								<div class="form-group">
									<label for="references" class="col-sm-3 control-label">Name</label>
									<div class="col-sm-5">
										<input class="form-control" name="name"
											ng-model="studentDetails.references.data[1].name" />
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>
</div>
<@macro.showFooter>
<script type="text/javascript"
	src="${rc.getContextPath()}/resources/js/pages/student-profile.js"></script>
</@macro.showFooter>
