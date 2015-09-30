<#import "/spring.ftl" as spring />
<#import "/macro.ftl" as macro/>

<@macro.showHeader />
<div class="header">
    <h1 class="page-title">Manage Users</h1>
</div><br>
<@macro.showFooter>
<div ng-controller="ManageCompanyUserCtrl">
    <div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
        <div class="col-lg-5 col-md-5 col-xs-5 col-sm-5">
            <form class="form-horizontal">
                <div class="row d">
                <div class="col-lg-6 col-md-6 col-xs-6 col-sm-6 ">
                    <label class="control-label">Name</label>
                </div>
                <div class="col-lg-6 col-md-6 col-xs-6 col-sm-6">
                    <input class="form-control" type="text">
                </div>
                </div>
                <div class="row d1">
                <div class="col-lg-6 col-md-6 col-xs-6 col-sm-6">
                    <label class="control-label">User Name</label>
                </div>
                <div class="col-lg-6 col-md-6 col-xs-6 col-sm-6">
                    <input class="form-control" type="text">
                </div>
                </div>
                 <div class="row d1">
                <div class="col-lg-6 col-md-6 col-xs-6 col-sm-6">
                    <label class="control-label">E-mail</label>
                </div>
                <div class="col-lg-6 col-md-6 col-xs-6 col-sm-6 ">
                    <input class="form-control" type="email">
                </div>
                </div>
                <div class="row d1">
                <div class="col-lg-6 col-md-6 col-xs-6 col-sm-6 ">
                    <label class="control-label">Password</label>
                </div>
                <div class="col-lg-6 col-md-6 col-xs-6 col-sm-6 ">
                    <input class="form-control" type="password">
                </div>
                </div>
                <div class="row d1">
                <div class="col-lg-6 col-md-6 col-xs-6 col-sm-6">
                    <label class="control-label">Active</label>
                </div>
                <div class="col-lg-6 col-md-6 col-xs-6 col-sm-6">
                    <input class="form-control" type="checkbox">
                </div>
                </div>
            </form>
        </div>
       
        <div class="col-lg-5 col-md-5 col-xs-5 col-sm-5 d2">
            <div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
                <label class="control-label">Roles</label>
            </div>
            <div class="col-lg-12 col-md-12 col-xs-12 col-sm-12 dropdown">
                <div class="form-group">
                    <select class="form-control" id="sel1">
                        <option>Corporate</option>
                        <option>Admin</option>
                        <option>Trainer</option>
                        <option>Candiadate</option>
                    </select>
            </div>
        </div>
           
        </div>
     </div>
</div>
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/kv/company_manage_user.js"></script>
</@macro.showFooter>