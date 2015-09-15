<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>

<@macro.showHeader />
<div class="header">
    <h1 class="page-title">User</h1>
</div>
<div class="container">
	<div id="mainDiv" ng-controller="UserListCtrl">
		<div class="col-md-8"><br>
			<div class="pull-right" ng-click="addFormEnable()">
				<a class="btn btn-primary pull-right"><i class="glyphicon glyphicon-plus"></i> Add User</a>
			</div><br><br><br>
				<div class="col-md-8">
					<form class="form-create-user">
				    	<div class="form-group">
							<label>Name</label>
							<div>
								<input type="text" class="form-control" name="name" placeholder="name" ng-model="userAdministration.user.name">
							</div>
						</div>
						
				    	<div class="form-group">
							<label>User Name</label>
							<div>
								<input type="text" class="form-control" name="userName" placeholder="User name" ng-model="userAdministration.user.userName">
							</div>
						</div>
						
						<div class="form-group">
							<label>Password</label>
							<div>
								<input type="password" class="form-control" name="password" placeholder="Password" ng-model="userAdministration.user.password">
							</div>
						</div>
						<div class="form-group">
							<label>Email</label>
							<div>
								<input type="email" class="form-control" name="email" placeholder="Email" ng-model="userAdministration.user.email">
							</div>
						</div>
						
						<div class="form-group">
							<label>Active</label>
							<div>
								<input type="checkbox" class="form-control" ng-model="userAdministration.user.isSystemDisabled">
							</div>
						</div>
				    </form>
				    <button class="btn btn-primary pull-right" ng-click="createUser()">Save</button>
			    </div>
				<div class="col-md-4">{{userAdministration.user}}</div>
	    </div>
	</div>
</div>
<@macro.showFooter>
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/create-user.js"></script>
</@macro.showFooter>