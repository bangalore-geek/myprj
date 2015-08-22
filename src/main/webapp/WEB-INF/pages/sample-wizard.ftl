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
					<form class="form-horizontal">
						<div class="form-group">
							<label for="trainingNo" class="col-sm-3 control-label">Course No</label>
							<div class="col-sm-5">
								<input class="form-control" name="trainingNo" ng-model="editAssesement.trainingNo" />
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="col-sm-3 control-label">Name</label>
							<div class="col-sm-5">
								<input class="form-control" name="name" ng-model="editAssesement.name" />
							</div>
						</div>

						<div class="form-group">
							<label for="description" class="col-sm-3 control-label">Description</label>
							<div class="col-sm-5">
								<textarea class="form-control" name="description" ng-model="editAssesement.description">{{editAssesement.description}} </textarea>
							</div>
						</div>
						
						<div class="form-group">
							<label for="version" class="col-sm-3 control-label">Version</label>
							<div class="col-sm-2">
								<input class="form-control" name="version" ng-model="editAssesement.version" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="assesmentType" class="col-sm-3 control-label">Course Type</label>
							<div class="col-sm-2">
								<select ng-model="editAssesement.assesmentType" class="form-control">
									<option ng-repeat="operator in assesmentType.data"
											value="{{operator.description}}">
									  {{operator.description}}
									</option>
								</select>
							</div>
						</div>
						
						<div class="form-group">
							<label for="assesmentType" class="col-sm-3 control-label">Active</label>
							<div class="col-sm-2">
								<select ng-model="editAssesement.active" class="form-control">
									<option selected value="true">True</option>
									<option value="false">False</option>
								</select>
							</div>
						</div>

					


					</form>
				</div>
				<div class="text-center">
					<input type="submit" wz-next value="Continue" class="btn btn-primary"  />
				</div>
			</wz-step>
			<wz-step title="Add Training">
			<div class="row" style="margin-top:40px;">
				<form class="form-horizontal">
					<div class="form-group">
						<label for="assesmentMasterId" class="col-sm-3 control-label">Courses</label>
						<div class="col-sm-3">
							<select class="form-control" ng-model="editAssesmentCourses.assesmentMasterId">
								<option ng-selected="{{operator.description == editAssesmentCourses.assesmentMasterId}}"
										ng-repeat="operator in assesementList.data"
										value="{{operator.id}}">
								  {{operator.name}}
								</option>
							</select>
						</div>
					</div>
					
					<div class="form-group">
						<label for="courseNumber" class="col-sm-3 control-label">Training Number</label>
						<div class="col-sm-5">
							<input class="form-control" name="courseNumber" ng-model="editAssesmentCourses.courseNumber" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="name" class="col-sm-3 control-label">Training Name</label>
						<div class="col-sm-5">
							<input class="form-control" name="name" ng-model="editAssesmentCourses.name" />
						</div>
					</div>						
					
					<div class="form-group">
						<label for="coustomer" class="col-sm-3 control-label">Coustomer</label>
						<div class="col-sm-5">
							<input class="form-control" name="coustomer" ng-model="editAssesmentCourses.coustomer" />
						</div>
					</div>

					<div class="form-group">
						<label for="courseDescription" class="col-sm-3 control-label">Training Description</label>
						<div class="col-sm-5">
							<textarea class="form-control" name="courseDescription" ng-model="editAssesmentCourses.courseDescription">{{editAssesmentCourses.courseDescription}} </textarea>
						</div>
					</div>	
				</form>
				</div>
				<div class = "text-center">
					<input type="submit" wz-next="logStep()" value="Continue"class="btn btn-primary"/>
				</div>
			</wz-step>
			<wz-step title="Upload">
				<div class="row" style="margin-top:40px;">
					<div class="row">
						<form class="form-horizontal">
							<div class="form-group">
								<label for="exampleInputFile">File input</label>
								<input type="file" id="exampleInputFile">
								<p class="help-block">Example block-level help text here.</p>
							</div>
						</form>
					</div>
				</div>
			</wz-step>
			<wz-step title="Summary">
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
				
				<input type="submit"  class="btn btn-primary" wz-next value="Save" />
			</wz-step>
		</wizard>
	</div>

<@macro.showFooter>
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/sample-wizard.js"></script>
</@macro.showFooter>