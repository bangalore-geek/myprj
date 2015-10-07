<#import "/spring.ftl" as spring />
<#import "/macro.ftl" as macro/>

<@macro.showHeader />
<div class="header">
    <h1 class="page-title">Company Profile</h1>
</div><br>
<div ng-controller="CompanyProfileCtrl">
	<div class="row" >
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<div class="pull-right ng-scope">
				<i ng-show="!thisCompany.enableEdit"
					ng-click="enableEdit()" title="edit"
					class="fa fa-pencil" style="cursor: pointer;"></i> <i
					ng-show="thisCompany.enableEdit"
					ng-click="enableEdit()" class="fa fa-times"
					style="cursor: pointer;"></i>
			</div>
						
			<div ng-show="!thisCompany.enableEdit">
				<div class="data-row">
					<label>Company Name: </label>
					<div>{{thisCompany.data.companyName}}</div>
				</div>
				<div class="data-row">
					<label>Contact Name: </label>
					<div>{{thisCompany.data.contactName}}</div>
				</div>
				<div class="data-row">
					<label>Contact E-mail ID: </label>
					<div>{{thisCompany.data.contactEmailId}}</div>
				</div>
				<div class="data-row">
					<label>Contact number: </label>
					<div>{{thisCompany.data.contactMobileNum}}</div>
				</div>
				<div class="data-row">
					<label>Licence Type: </label>
					<div>{{thisCompany.data.licenceType}}</div>
				</div>
				<div class="data-row">
					<label>Licence ID: </label>
					<div>{{thisCompany.data.licenceId}}</div>
				</div>
				<div class="data-row">
					<label></label>
					<div><a class="btn btn-primary" ng-click="enableResetPassword()">Reset Password</a></div>
				</div>
			</div>
			
			<div ng-show="thisCompany.enableResetPassword">
				<form class="form-horizontal">
			        <div class="form-group">
			            <label class="col-sm-4 control-label">Old Password </label>
			            <div class="col-sm-6">
			                <input type="text" class="form-control">
			            </div>
			        </div>
			        <div class="form-group">
			            <label class="col-sm-4 control-label">New Password </label>
			            <div class="col-sm-6">
			                <input type="text" class="form-control">
			            </div>
			        </div>
			        <div class="form-group">
			            <label class="col-sm-4 control-label">Conferm New Password </label>
			            <div class="col-sm-6">
			                <input type="text" class="form-control">
			            </div>
			        </div>
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-10">
							<button class="btn btn-primary">Save</button>
							<button ng-click="enableResetPassword()" class="btn">Cancel</button>
						</div>
					</div>
		    	</form>
			</div>
			
			<div ng-show="thisCompany.enableEdit">
			    <form class="form-horizontal">
			        <div class="form-group">
			            <label class="col-sm-4 control-label">Company Name </label>
			            <div class="col-sm-6">
			                <input ng-model="thisCompany.data.companyName" type="text" class="form-control">
			            </div>
			        </div>
			        <div class="form-group">
			            <label class="col-sm-4 control-label">Contact Name </label>
			            <div class="col-sm-6">
			                <input ng-model="thisCompany.data.contactName" type="text" class="form-control">
			            </div>
			        </div>
			        <div class="form-group">
			            <label class="col-sm-4 control-label">Contact E-mail ID </label>
			            <div class="col-sm-6">
			                <input ng-model="thisCompany.data.contactEmailId" type="email" class="form-control">
			            </div>
			        </div>
			        <div class="form-group">
			            <label class="col-sm-4 control-label">Contact mobile number </label>
			            <div class="col-sm-6">
			                <input ng-model="thisCompany.data.contactMobileNum" class="form-control">
			            </div>
			        </div>
			        <div class="form-group">
			            <label class="col-sm-4 control-label">Licence Type </label>
			            <div class="col-sm-6">
		                <input ng-model="thisCompany.data.licenceType" type="text" class="form-control">
					</div>        
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Licence ID </label>
						<div class="col-sm-6">
							<input ng-model="thisCompany.data.licenceId" type="text" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-10">
							<button ng-click="saveCompanyProfile()" class="btn btn-primary">Save</button>
							<button ng-click="enableEdit()" class="btn">Cancel</button>
						</div>
					</div>
		    	</form>
	    	</div>
    	</div>
		<div class="col-md-1"></div>
	</div>    
</div>

<@macro.showFooter>
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/kv/company-profile.js"></script>
</@macro.showFooter>