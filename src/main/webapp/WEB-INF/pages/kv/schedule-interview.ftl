<#import "/spring.ftl" as spring />
<#import "/macro.ftl" as macro/>

<@macro.showHeader />
<div class="header">
    <h1 class="page-title">Schedule Interview</h1>
</div><br>
<div ng-controller="AttendInterviewCtrl">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<div>Company Name : {{thisSummary.thisCompany.companyName}}</div>
			<span ng-if="thisSummary.thisCandidate.startDate != null">
				<div>Interview Start Date : {{thisSummary.thisCandidate.startDate | date:'dd-MMM-yyyy'}}</div>
			</span>
			<span ng-if="thisSummary.thisCandidate.startDate != null">
				<div>Interview End Date : {{thisSummary.thisCandidate.endDate | date:'dd-MMM-yyyy'}}</div>
			</span>
			<br><br><br>
			<div class="btn btn-primary" ng-click="enableScheduleInterview()">Schedule Interview</div>
			<a class="btn btn-primary" href="${rc.getContextPath()}/kv/candidate/start-interview" >Take Now</a>
			
			<div ng-show="thisSummary.showScheduleInterview"><br>
				<label for="dob" class="col-sm-1 control-label">Date</label>
				<div class="col-sm-4">
					<p class="input-group">
						<input type="text" class="form-control"
							datepicker-popup="dd-MMM-yyyy" name="fromDate"
							ng-model="thisSummary.thisCandidate.startDate" is-open="startdateopened"
							datepicker-options="dateOptions"
							close-text="Close" show-button-bar="false" /> <span class="input-group-btn">
							<button type="button" class="btn btn-default"
								ng-click="startdateopen($event)">
								<i class="fa fa-calendar"></i>
							</button>
						</span>
					</p>
				</div><br>
				<div class = "text-center">
					<input type="submit" value="Save" class="btn btn-primary" ng-click="saveScheduleInterview()"/>
					<input type="submit" value="Cancel" class="btn btn-primary" ng-click="enableScheduleInterview()"/>
				</div>
			<div>
		</div>
		<div class="col-md-1"></div>
	</div>
</div>


<@macro.showFooter>
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/kv/schedule-interview.js"></script>
</@macro.showFooter> 