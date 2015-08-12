<#import "/spring.ftl" as spring /> <#import "macro.ftl" as macro/>
<@macro.showHeader />
<div class="container">
	<div id="mainDiv" ng-controller="AssesementCtrl">
		<div class="header">
			<h1 class="page-title">Assesement List <samp class="pull-right"><button class="btn btn-primary" ng-click="enableAddForm()">Add</button></samp></h1>
		</div>
		<div class="panel-container">
			<div class="row">
				<div class="panel panel-4">
					<div>
						<div class="panel panel-default">
							<div ng-show="assesementList.editableForm">
								<form class="form-horizontal">
									<div class="form-group">
										<label for="trainingNo" class="col-sm-3 control-label">trainingNo</label>
										<div class="col-sm-5">
											<input class="form-control" name="trainingNo" ng-model="editAssesement.trainingNo" />
										</div>
									</div>
									
								<div class="form-group">
									<label for="assesmentType" class="col-sm-3 control-label">Assesement Type</label>
									<div class="col-sm-5">
							 			<select ng-model="editAssesement.assesmentType">
											<option ng-repeat="operator in assesmentType.data"
													value="{{operator.description}}">
											  {{operator.description}}
											</option>
										</select>
									</div>
								</div>
								
								
									<div class="form-group">
										<label for="description" class="col-sm-3 control-label">description</label>
										<div class="col-sm-5">
											<textarea class="form-control" name="description" ng-model="editAssesement.description">{{editAssesement.description}} </textarea>
										</div>
									</div>
									<div class="form-group">
										<label for="version" class="col-sm-3 control-label">version</label>
										<div class="col-sm-5">
											<input class="form-control" name="version" ng-model="editAssesement.version" />
										</div>
									</div>								
									<button ng-click="enableAddForm()" class="btn">Cancel</button>
									<button ng-click="saveAssesement(editAssesement)" class="btn btn-primary">Save</button>
								</form>
							</div>
						
							<div ng-show="!assesementList.editableForm">
								<table class="table">
									<thead>
										<tr>
											<th>#</th>
											<th>Training No</th>
											<th>description</th>
											<th>version</th>
										</tr>
									</thead>
									<div>
										<tbody>
											<tr ng-repeat="assesement in assesementList.data">
												<th scope="row">{{$index + 1}}</th>
												<td>{{assesement.trainingNo}}</td>
												<td>{{assesement.description}}</td>
												<td>{{assesement.version}}</td>
												<td>
													<button ng-click="enableEditAssesement(assesement)" title="edit" class="fa fa-pencil"></button>
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
	src="${rc.getContextPath()}/resources/js/pages/assesment-list.js"></script>
</@macro.showFooter>
