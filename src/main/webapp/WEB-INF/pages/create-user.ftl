<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>

<@macro.showHeader />
<div class="header">
    <h1 class="page-title">User</h1>
</div>

<div id="mainDiv" ng-controller="UserListCtrl">
	<form class="form-create-user">
    	<div class="form-group">
			<label><@spring.message "signup.label.username"/></label>
			<div>
				<input type="text" class="form-control" name="userName" placeholder="User name" ng-model="user.userName">
			</div>
		</div>
		<div class="form-group">
			<label><@spring.message "signup.label.password"/></label>
			<div>
				<input type="password" class="form-control" name="password" placeholder="Password" ng-model="user.password">
			</div>
		</div>
		<div class="form-group">
			<label><@spring.message "signup.label.email"/></label>
			<div>
				<input type="email" class="form-control" name="email" placeholder="Email" ng-model="user.email">
			</div>
		</div>
		<div class="form-group">
			<label><@spring.message "signup.label.type"/></label>
			<div>
				<select ng-model="user.role">
					<#list roleList as role>
						<option value="${role.id}">${role.description}</option>
					</#list>
				</select>				
			</div>
		</div>
        <button class="btn btn-primary pull-right" ng-click="createUser()"><@spring.message "signup.label.submit"/></button>
        <div class="clearfix"></div>
        <pre>{{user | json}}</pre>
    </form>	
</div>

<@macro.showFooter>
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/create-user.js"></script>
</@macro.showFooter>