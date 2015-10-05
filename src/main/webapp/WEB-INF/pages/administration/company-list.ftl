<#import "/spring.ftl" as spring />
<#import "/macro.ftl" as macro/>

<@macro.showHeader />
<div class="header">
    <h1 class="page-title">Company Listing</h1>
</div><br>
<div ng-controller="CompanyListCtrl">
	<div class="row" >
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<div class="row" style="padding:10px;">
				<div class="col-md-8">
					<div class="form-group"  ng-show="companies.length > 0">
					 <div class="input-group">
					  <span class="input-group-addon">Search</span>
					  <input type="text" class="form-control search-query" ng-model="companies.search">
					</div>
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
				<accordion class="accordion" close-others="true" ng-show="companies.length > 0">
					<accordion-group ng-init="isOpen = $first" is-open="isOpen" ng-repeat="group in companies | filter:companies.search | orderBy:'name'">
						<accordion-heading>
							<h5>{{group.companyName}} 
								<small>
									<span ng-if="group.approved">(Approved)</span>
									<span ng-if="!group.approved">(Un-approved)</span>
								</small> 
							</h5>
						</accordion-heading>
						<div>  Tin Number : {{group.tinNumber}}
							<span ng-if="!group.approved">
								<div class="pull-right" ng-click="approveCompany(group)">
								 	<a href="#">Approved It</a>
								</div>
							</span>
						</div>
						<div> Contact Name : {{group.contactName}} </div>
						<div> Contact Email Id : {{group.contactEmailId}} </div>
						
						<span ng-if="group.approved">
							<div> Contact Mobile Number : {{group.contactMobileNum}} </div>
							<div> Company Mobile Number : {{group.companyMobileNum}} </div>
							<div> Approved On : {{group.approvedOn | date:'dd-MMM-yyyy'}} </div>
							<div> Approved By : {{group.approvedBy}} </div>
						</span>
					</accordion-group>
				</accordion>
				
				<div class="alert alert-info" role="alert"  ng-show="companies.length == 0">
					No course found !!
				</div>
			</div>
		</div>
		<div class="col-md-1"></div>
	</div>	
</div>

<@macro.showFooter>
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/administration/company-list.js"></script>
</@macro.showFooter> 