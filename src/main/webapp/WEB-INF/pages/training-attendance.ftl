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
		<div class="form-group">
			<form class="form-horizontal">
				<div class="form-group">
					<label>Course </label>
					<input type="text"name="text" placeholder="course name"required>
				</div>

				<div class="form-group">
					<label>Training</label>
					<input type="text"name="text" placeholder="training name"required>
				</div>

				<div class="form-group">
					<label>Trainer</label>
					<input type="text"name="text" placeholder="trainer name"required>
				</div>

				<div class="form-group">
					<label>From date</label>
					<input name="frmDate"type="text" id="datepicker"/>
				</div>

				<div class="form-group">
					<label>To date</label>
					<input name="toDate"type="text" id="datepicker1"/>
				</div>
			</form>
		</div>
		<div class="table-responsive">
			<table class="table-striped"width="80%">
				<tr>
					<th class="text-center">Name</th>
					<th class="text-center">Email</th>
					<th class="text-center">Day1</th>
					<th class="text-center">Day2</th>
					<th class="text-center">Day3</th>
					<th class="text-center">Day4</th>
					<th class="text-center">Day5</th>
				</tr>
				<tr>
					<td>Yogesh Rathore</td>
					<td>yogesh.rathore@gmail.com</td>
					<td><input type="checkbox" name="attendence"></td>
					<td><input type="checkbox" name="attendence"></td>
					<td><input type="checkbox" name="attendence"></td>
					<td><input type="checkbox" name="attendence"></td>
					<td><input type="checkbox"  name="attendence"></td>
				</tr>
				<tr>
					<td>Amit Tiwari</td>
					<td>amit.tiwari1985@gmail.com</td>
					<td><input type="checkbox" name="attendence"></td> 
					<td><input type="checkbox" name="attendence"></td>
					<td><input type="checkbox" name="attendence"></td>
					<td><input type="checkbox" name="attendence"></td>
					<td><input type="checkbox" name="attendence"></td>
				</tr>
				<tr>
					<td>Retesh Parmar</td>
					<td>parmarritesh@gmail.com</td>
					<td><input type="checkbox" name="attendence"></td>
					<td><input type="checkbox" name="attendence"></td>
					<td><input type="checkbox" name="attendence"></td>
					<td><input type="checkbox" name="attendence"></td>
					<td><input type="checkbox" name="attendence"></td>
				</tr>
				<tr>
					<td>Deepak Patel</td>
					<td>patel_deepak1988@gmail.com</td>
					<td><input type="checkbox" name="attendence"></td>
					<td><input type="checkbox" name="attendence"></td>
					<td><input type="checkbox" name="attendence"></td>
					<td><input type="checkbox" name="attendence"></td>
					<td><input type="checkbox" name="attendence"></td>
				</tr>
			</table>
		</div>
	</div>
	<div class="col-md-1"></div>
</div>
<@macro.showFooter>
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/training-attandance.js"></script>
</@macro.showFooter>