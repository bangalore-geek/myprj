<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>

<@macro.showHeader />
<style>
table,
th {
border: 1px solid green;
    }

th {
background-color: grey;
color: white;
    }

td {
padding: 4px;
    }

label {
display: inline-block;
width: 200px;
margin-right: 20px;
text-align: left;
    }

input {}


    }
h1 {
font-family: Helvetica;
font-weight: 100;
    }
body {
color:#333;
	text-align:left;
}
</style>
<div class="header">
    <h1 class="page-title">Training Attendance</h1>
</div><br>

<div class="row">
<div class="col-md-1"></div>
<div class="col-md-10">
<div class="container-fluid"  ng-controller="TrainingAttendanceCtrl">
    <form class="">
		<div class="form-group">
			<label for="assesmentType" class="col-sm-3 control-label">Select Course</label>
			<div class="col-sm-5">
				<select ng-model="thisCourseId" name="assesmentType" class="form-control" ng-change="loadTraining(thisCourseId)" >
					<option ng-repeat="operator in courseList"
							value="{{operator.id}}">
					  {{operator.name}}
					</option>
				</select>
			</div>
		</div><br><br>
		
		<div class="form-group">
			<label for="assesmentType" class="col-sm-3 control-label">Select Training</label>
			<div class="col-sm-5">
				<select ng-model="thisTrainingId" name="assesmentType" class="form-control" ng-change="loadTrainee(thisTrainingId)" >
					<option ng-repeat="operator in trainingList"
							value="{{operator.id}}">
					  {{operator.trainingName}}
					</option>
				</select>
			</div>
		</div>
    </form>
    <br><br>

  <div class="table-responsive form-group top-buffer col-xs-12 col-lg-12 col-md-12 col-sm-12">
    <table class="table-striped" width="100%">
      <tr>
        <th class="text-center">Name</th>
        <th class="text-center">Email</th>
        <th class="text-center">Day1</th> 
		<th class="text-center">Day2</th> 
		<th class="text-center">Day3</th> 
		<th class="text-center">Day4</th> 
		<th class="text-center">Day5</th>
      </tr>

      <tr ng-repeat="operator in traineeList"> 
        <td class="text-center">{{operator.name}}</td>
        <td class="text-center">{{operator.email}}</td>
        <td class="text-center"><input type="checkbox" name="attendence"></td>
        <td class="text-center"><input type="checkbox" name="attendence"></td>
        <td class="text-center"><input type="checkbox" name="attendence"></td>
        <td class="text-center"><input type="checkbox" name="attendence"></td>
        <td class="text-center"><input type="checkbox" name="attendence"></td>
      </tr>

    </table><br><br><br>
	<div class="text-center">
		<input type="submit" wz-next value="Submit" class="btn btn-primary"/>
	</div>
   </div>
  </div>
</div>
<div class="col-md-1"></div>
</div>
<@macro.showFooter>
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/training-attendance.js"></script>
</@macro.showFooter>