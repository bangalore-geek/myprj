<#import "/spring.ftl" as spring /> <#import "macro.ftl" as macro/>
<@macro.showHeader />
<div class="header">
	<h1 class="page-title">Student Profile</h1>
</div>
<div id="mainDiv" ng-controller="StudentDetailsCtrl">
	<div class="panel-container">
		<div class="row">
			<div class="col-md-6">
			
				<div class="panel panel-1">
					<div class="pull-right ng-scope">
						<i ng-show="!studentDetails.profile.editable" ng-click="enableEdit('profile')" title="edit" class="fa fa-pencil" style="cursor:pointer;"></i>
						<i ng-show="studentDetails.profile.editable" ng-click="cancel('profile')" class="fa fa-times" style="cursor:pointer;"></i>
					</div>
					<h3 class="ng-scope">Personal Information</h3>
					<div ng-show="!studentDetails.profile.editable">
						<div class="data-row">
							<label>Gender</label>
							<div>{{studentDetails.profile.data.gender}}</div>
						</div>
						<div class="data-row">
							<label>DOB</label>
							<div>{{studentDetails.profile.data.dob | date:'dd-MMM-yyyy'}}</div>
						</div>
						<div class="data-row">
							<label>Disability</label>
							<div>{{studentDetails.profile.data.disability}}</div>
						</div>
						<div class="data-row">
							<label>Current Location</label>
							<div>{{studentDetails.profile.data.currentLocation}}</div>
						</div>
						<div class="data-row">
							<label>Preffered Location</label>
							<div>{{studentDetails.profile.data.prefferedLocation}}</div>
						</div>
						<div class="data-row">
							<label>Notice Period</label>
							<div>{{studentDetails.profile.data.noticePeriod}}</div>
						</div>
						<div class="data-row">
							<label>Experience</label>
							<div>{{studentDetails.profile.data.experience}}</div>
						</div>
						<div class="data-row">
							<label>Industry</label>
							<div>{{studentDetails.profile.data.industry}}</div>
						</div>
						<div class="data-row">
							<label>Current Ctc</label>
							<div>{{studentDetails.profile.data.currentCtc}}</div>
						</div>
						<div class="data-row">
							<label>Expected Ctc</label>
							<div>{{studentDetails.profile.data.expectedCtc}}</div>
						</div> 	
					</div>
					<div ng-show="studentDetails.profile.editable">
					 <form class="form-horizontal">
						  <div class="form-group">
						    <label for="gender" class="col-sm-3 control-label">Gender</label>
						    <div class="col-sm-5">
							      <select  class="form-control" name="gender" ng-model="studentDetails.profile.data.gender"> 
									  <option value="M">Male</option>
									  <option value="F">Female</option>
								 </select>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="dob" class="col-sm-3 control-label">DOB</label>
						    <div class="col-sm-5">
						    	 <p class="input-group">
								      <input type="text" class="form-control" datepicker-popup="dd-MMM-yyyy" ng-model="studentDetails.profile.data.dob" is-open="opened"  datepicker-options="dateOptions" ng-required="true" close-text="Close" />
								      <span class="input-group-btn">
	                					<button type="button" class="btn btn-default" ng-click="open($event)"><i class="fa fa-calendar"></i></button>
	              					 </span>
              					 </p>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="disability" class="col-sm-3 control-label">Disability</label>
						    <div class="col-sm-5">
							      <select  class="form-control" name="disability" ng-model="studentDetails.profile.data.disability"> 
									  <option value="true">True</option>
									  <option value="false">False</option>
								 </select>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="currentLocation" class="col-sm-3 control-label">Current Location</label>
						    <div class="col-sm-5">
							      <input  class="form-control" name="currentLocation" ng-model="studentDetails.profile.data.currentLocation"/>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="prefferedLocation" class="col-sm-3 control-label">Preffered Location</label>
						    <div class="col-sm-5">
							      <input  class="form-control" name="prefferedLocation" ng-model="studentDetails.profile.data.prefferedLocation"/>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="noticePeriod" class="col-sm-3 control-label">Notice Period</label>
						    <div class="col-sm-5">
							      <input  class="form-control" name="noticePeriod" ng-model="studentDetails.profile.data.noticePeriod"/>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="experience" class="col-sm-3 control-label">Experience</label>
						    <div class="col-sm-5">
							      <input  class="form-control" name="Experience" ng-model="studentDetails.profile.data.experience"/> (in months)
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="industry" class="col-sm-3 control-label">Industry</label>
						    <div class="col-sm-5">
							      <input  class="form-control" name="industry" ng-model="studentDetails.profile.data.industry"/>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="currentCtc" class="col-sm-3 control-label">Current Ctc</label>
						    <div class="col-sm-5">
							      <input  class="form-control" name="currentCtc" ng-model="studentDetails.profile.data.currentCtc"/>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="expectedCtc" class="col-sm-3 control-label">Expected Ctc</label>
						    <div class="col-sm-5">
							      <input  class="form-control" name="expectedCtc " ng-model="studentDetails.profile.data.expectedCtc"/>
						    </div>
						 </div>
						 <div class="form-group">
    						<div class="col-sm-offset-4 col-sm-10">
      							<button ng-click="saveStudentProfile()" class="btn btn-primary">Save</button>
								<button ng-click="ccancel('profile')" class="btn">Cancel</button>
    						</div>
  						</div>
						
					  </form>
					</div>
				</div>
				<div class="panel panel-4"></div>
				
			</div>
			<div class="col-md-6">
				<div class="panel panel-3"></div>
				<div class="panel panel-5"></div>
			</div>
		</div>
	</div>
</div>
<@macro.showFooter>
<script type="text/javascript"
	src="${rc.getContextPath()}/resources/js/pages/student-profile.js"></script>
</@macro.showFooter>
