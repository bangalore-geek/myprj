<#import "/spring.ftl" as spring />
<#import "/macro.ftl" as macro/>

<@macro.showHeader />
<div ng-controller="RequirementListCtrl">
	<div class="header">
	    <h1 class="page-title">Requirement Listing</h1>
	</div><br>
	
	<div class="row" >
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<div class="row" style="padding:10px;">
				<div class="col-md-8">
					<div class="form-group"  ng-show="requirementList.length > 0">
					 <div class="input-group">
					  <span class="input-group-addon">Search</span>
					  <input type="text" class="form-control search-query" ng-model="requirementList.search">
					</div>
				   </div>	
			   </div>
			   
			   <div class="col-md-4">
					<div class="pull-right" style="margin-right: 10px;">
						<div class="pull-right"> <a href="${rc.getContextPath()}/kv/configure-interview" class="btn btn-primary"><i class="glyphicon glyphicon-plus"></i> Add Requirement</a> </div>
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
				<accordion class="accordion" close-others="true" ng-show="requirementList.length > 0">
					<accordion-group ng-init="isOpen = $first" is-open="isOpen" ng-repeat="group in requirementList | filter:requirementList.search">
						<accordion-heading>
							<h5>{{group.companyJobCode}}</h5>
						</accordion-heading>
						<div>  Job Description : {{group.jobDescription}}</div>
						<div> Job Designation : {{group.jobDesignation}} </div>
						<div> Min Experience : {{group.minExperience}} </div>
						
					</accordion-group>
				</accordion>
				
				<div class="alert alert-info" role="alert"  ng-show="requirementList.length == 0">
					No course found !!
				</div>
			</div>
		</div>
		<div class="col-md-1"></div>
	</div>	
	
</div>



<@macro.showFooter>
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/kv/requirement-list.js"></script>
</@macro.showFooter> 