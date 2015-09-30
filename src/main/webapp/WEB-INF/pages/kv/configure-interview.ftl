<#import "/spring.ftl" as spring />
<#import "/macro.ftl" as macro/>

<@macro.showHeader />
<div ng-controller="ConfigureRequirementCtrl">
	<div class="header">
	    <h1 class="page-title">{{thisSummary.pageTitle}}</h1>
	</div><br>
	<div>
		<div class="row" >
			<div class="col-md-12">
				<wizard on-finish="finished()" current-step="st">
					<wz-step title="Requirement">
						<div class="col-md-1"></div>
						<div class="col-md-5">
							<div style="margin-top:15px;">
								<form class="form-horizontal" action="register.html" method="post" id="registerFrm"  role="form">
									<div class="form-group">
										<div class="col-sm-4">
											<label class="control-label">Job Code</label>
										</div>
										<div class="col-sm-8">
											<input class="form-control" type="text" name="CompJobCode" ng-model="thisRequirement.companyJobCode" />
										</div>
									</div>
										
									<div class="form-group">
										<div class="col-sm-4">
										  <label class="control-label">Description</label>
										</div>
										<div class="col-sm-8">
											<textarea class="form-control" name="jobDisc" ng-model="thisRequirement.jobDescription"></textarea>
										</div>
									</div>
										
									<div class="form-group">
										<div class="col-sm-4">
										  <label class="control-label">Designation</label>
										</div>
										<div class="col-sm-8">
										  <input class="form-control" type="text" name="jobDes" ng-model="thisRequirement.jobDesignation" />
										</div>
									</div>
									
									<div class="form-group">
										<div class="col-sm-4">
											<label class="control-label">Status</label>
										</div>
										<div class="col-sm-8">
											<input class="form-control" type="text" name="jobDes" ng-model="thisRequirement.status" />
										</div>
									</div>
									
									<div class="form-group">
										<label for="dob" class="col-sm-2 control-label">Start</label>
										<div class="col-sm-4">
											<p class="input-group">
												<input type="text" class="form-control"
													datepicker-popup="dd-MMM-yyyy" name="fromDate"
													ng-model="thisRequirement.startdate" is-open="startdateopened"
													datepicker-options="dateOptions"
													close-text="Close" show-button-bar="false" /> <span class="input-group-btn">
													<button type="button" class="btn btn-default"
														ng-click="startdateopen($event)">
														<i class="fa fa-calendar"></i>
													</button>
												</span>
											</p>
										</div>
										<label for="dob" class="col-sm-1 control-label">End</label>
										<div class="col-sm-4">
											<p class="input-group">
												<input type="text" class="form-control" name="toDate"
													datepicker-popup="dd-MMM-yyyy"
													ng-model="thisRequirement.enddate" is-open="enddateopened"
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
										<label for="dob" class="col-sm-2 control-label">Experience</label>
									</div>
								
									<div class="form-group">
										<label for="dob" class="col-sm-2 control-label">Min</label>
										<div class="col-sm-4">
											<input class="form-control" type="text" name="jobDes" ng-model="thisRequirement.minExperience" />
										</div>
										<label for="dob" class="col-sm-1 control-label">Max</label>
										<div class="col-sm-4">
											<input class="form-control" type="text" name="jobDes" ng-model="thisRequirement.maxExperience" />
										</div>
									</div>
								</form>
								
								<div class="text-center">
									<input type="submit" value="Save" class="btn btn-primary" ng-click="saveRequirement(thisRequirement)" />
									<input type="submit" wz-next="logStep()" value="Continue" class="btn btn-primary"/>
								</div>
							</div>
						</div>
						<div class="col-md-6">	
							<div  style="padding:10px;">
								<div class="text-center">
									<div class="label label-success">Requirement Added</div>
								</div><br>
								<accordion class="accordion" close-others="true">
									<accordion-group ng-init="isOpen = $first" is-open="isOpen" ng-repeat="group in thisSummary.thisRequirementList">
										<accordion-heading>
											<span>{{group.companyJobCode}}</span>
										</accordion-heading>
										<div>  Designation : {{group.jobDesignation}} </div>
										<div>  Status : {{group.status}} </div>
										<div>  Min Experience : {{group.minExperience}} </div>
										<div>  Max Experience : {{group.maxExperience}} </div>
										<div>  Start Date : {{group.startDate | date:'dd-MMM-yyyy'}} </div>
										<div>  End Date : {{group.endDate | date:'dd-MMM-yyyy'}} </div>
										<div>  Job Description : {{group.jobDescription}} </div>
									</accordion-group>
								</accordion>
								<div class="alert alert-info" role="alert"  ng-show="!thisSummary.thisRequirementList.length">
									No Requirement found !!
								</div>
							</div>
						</div>
					</wz-step>
					<wz-step title="Candidate">
					<div class="col-md-1"></div>
					<div class="col-md-5">			
						<div style="margin-top:40px;">
							<form class="form-horizontal">
								<div class="form-group">
									<label for="trainingId" class="col-sm-4 control-label">Requirement</label>
									<div class="col-sm-8">
										<select ng-model="thisCandidate.requirementId" name="requirementId" class="form-control" ng-change="loadCandidate(thisCandidate.requirementId)">
											<option ng-repeat="operator in thisSummary.thisRequirementList"
													value="{{operator.id}}">
											  {{operator.companyJobCode}}
											</option>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label for="name" class="col-sm-4 control-label">Name</label>
									<div class="col-sm-8">
										<input class="form-control" ng-model="thisCandidate.name" name="name" />
									</div>
								</div>
								<div class="form-group">
									<label for="email" class="col-sm-4 control-label">Email</label>
									<div class="col-sm-8">
										<input class="form-control" ng-model="thisCandidate.email" name="email" ng-change="validateEmail()"/>
										<span ng-show="thisSummary.showSpinner"><i class="fa fa-spinner fa-pulse"></i> </span>
										<div class="label label-danger" role="alert" ng-show="thisSummary.candidateEmailIdError">
											Email Id Already Exist.
										</div>
									</div>
								</div>

								<div class="form-group">
									<label for="mobile" class="col-sm-4 control-label">Mobile</label>
									<div class="col-sm-8">
										<input class="form-control" ng-model="thisCandidate.phone" name="phone"/>
									</div>
								</div>
							</form>
							
							<div class = "text-center">	
								<input type="submit" ng-click="saveCandidate(thisCandidate)" value="Save & Add New" class="btn btn-primary"/>
								<input type="submit" wz-next="logStep()" value="Continue" class="btn btn-primary"/>
							</div><br>
							
							<div class="col-md-1"><b>OR</div><br><br>
							<div class="col-md-5">
								<div class="row">
									<input type="file" id="exampleInputFile">
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div style="margin-top:40px;">
							<div class="text-center">
								<div class="label label-success">Candidate Added</div>
							</div><br>
							<table class="table table-striped table-bordered" ng-show="thisSummary.thisRequirementCandidateList.length">
								<tr>
									<th>Name</th>
									<th>Email</th>
									<th>Phone</th>
									<th>Action</th>
								</tr>
								<tr ng-repeat="trainee in thisSummary.thisRequirementCandidateList">
									<td>{{trainee.name}}</td>
									<td>{{trainee.email}}</td>
									<td>{{trainee.phone}}</td>
									<td><button ng-click="deleteTrainee(trainee.id,$index)" title="delete" class="fa fa-trash"></button></td>
								</tr>
							</table>
							<div class="alert alert-info" role="alert" ng-show="!thisSummary.thisRequirementCandidateList.length">
								No Candidate found !!
							</div>
						</div>
					</div>
					</wz-step>
					<wz-step title="Summary">
					
					</wz-step>
				</wizard>
			</div>
		</div>
	</div>
</div>

<@macro.showFooter>
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/kv/configure-interview.js"></script>
</@macro.showFooter>