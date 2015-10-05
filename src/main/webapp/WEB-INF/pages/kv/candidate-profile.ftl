<#import "/spring.ftl" as spring />
<#import "/macro.ftl" as macro/>

<@macro.showHeader />
<div class="header">
    <h1 class="page-title">Profile</h1>
</div><br>

<div ng-controller="CandidateProfileCtrl">
    <div class="row" >
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="pull-right ng-scope">
                <i ng-show="!thisCandidate.enableEdit"
                    ng-click="enableEdit()" title="edit"
                    class="fa fa-pencil" style="cursor: pointer;"></i> <i
                    ng-show="thisCandidate.enableEdit"
                    ng-click="enableEdit()" class="fa fa-times"
                    style="cursor: pointer;"></i>
            </div>
                       
            <div ng-show="!thisCandidate.enableEdit">
                <div class="data-row">
                    <label>Name: </label>
                    <div>{{thisCandidate.data.name}}</div>
                </div>               
            </div>
            <div class="col-lg-12"><br></div>
            <div ng-show="!thisCandidate.enableEdit">
                <div class="data-row">
                    <label>Experience level: </label>
                    <div>{{thisCandidate.data.companyName}}</div>
                </div>               
            </div>
           
            <div class="col-lg-12"><br></div>
           
            <div ng-show="!thisCandidate.enableEdit">
                <div class="data-row">
                    <label>Mobile: </label>
                    <div>{{thisCandidate.data.name}}</div>
                </div>               
            </div>
           
            <div class="col-lg-12"><br></div>
           
            <div class="col-lg-5 col-md-offset-3" ng-show="!thisCandidate.enableEdit">
                <div class="data-row">
                    <button type="button" class="btn btn-link">Change Password</button>
                </div>               
            </div>
           
            <div ng-show="thisCandidate.enableEdit">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-4 control-label">Name </label>
                        <div class="col-sm-6">
                            <input ng-model="thisCandidate.data.name" type="text" class="form-control">
                        </div>
                    </div>
                   
                    <div class="form-group">
                        <label class="col-sm-4 control-label">Experience level </label>
                        <div class="col-sm-6">
                            <input ng-model="thisCandidate.data.companyName" type="text" class="form-control">
                        </div>
                    </div>
                   
                    <div class="form-group">
                        <label class="col-sm-4 control-label">Mobile </label>
                        <div class="col-sm-6">
                            <input ng-model="thisCandidate.data.companyName" type="text" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-4 col-sm-10">
                            <button ng-click="saveCandidateProfile()" class="btn btn-primary">Save</button>
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
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/kv/candidate-profile.js"></script>
</@macro.showFooter>