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
<div class="container-fluid">

   

    <form class="">

    <div class="row col-xs-12 col-lg-12 col-md-12 col-sm-12">

    <div class="top-buffer col-xs-6 col-lg-6 col-md-6 col-sm-6 form-group">

    

      <label>Course </label>

      <input type="text" name="text" class="form-control" placeholder="course name" 

size="35" maxlength="40" required>

     

     </div>

    <div class="row top-buffer form-group col-xs-6 col-lg-6 col-md-6 col-sm-6">

    <label>From date</label>

    <input name="frmDate" type="date" class="form-control"  size="35"/>

    </div>

    

    </div>

  

  

    <div class="row col-xs-12 col-lg-12 col-md-12 col-sm-12">

    <div class="top-buffer col-xs-6 col-lg-6 col-md-6 col-sm-6 form-group">

    <label>Trainer</label>

    <input type="text" name="text" class="form-control" placeholder="trainer name" 

size="35" maxlength="2" required>

   </div>

    <div class="row top-buffer form-group col-xs-6 col-lg-6 col-md-6 col-sm-6">

    <label>To date</label>

    <input name="toDate" type="date" class="form-control"  size="35"/>

    </div>

    

    </div>

    

    

   

     <div class="row col-xs-12 col-lg-12 col-md-12 col-sm-12">

    <div class="top-buffer col-xs-6 col-lg-6 col-md-6 col-sm-6 form-group">

    <label>Training</label>

    <input type="text" class="form-control" placeholder="training name" required>
    
	

    

    </div>
    
    <div class="row col-xs-12 mb-10 text-center  mb-10" style="padding-bottom:20px">
    <input type="button" value="Add" class="btn btn-primary">
    </div>

   </div>

    </form>

 

    

    <br><br>

  <div class="table-responsive form-group top-buffer col-xs-12 col-lg-12 col-md-12 

col-sm-12">

    

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

      <tr>

        <td class="text-center">xyz</td>

        <td class="text-center">xyz@gmail.com</td>

        <td class="text-center"><input type="checkbox" name="attendence"></td>

        <td class="text-center"><input type="checkbox" name="attendence"></td>

        <td class="text-center"><input type="checkbox" name="attendence"></td>

        <td class="text-center"><input type="checkbox" name="attendence"></td>

        <td class="text-center"><input type="checkbox" name="attendence"></td>

      </tr>

      <tr>

        <td class="text-center">yyy</td>

        <td class="text-center">yyy@gmail.com</td>

        <td class="text-center"><input type="checkbox" name="attendence"></td>

        <td class="text-center"><input type="checkbox" name="attendence"></td>

        <td class="text-center"><input type="checkbox" name="attendence"></td>

        <td class="text-center"><input type="checkbox" name="attendence"></td>

        <td class="text-center"><input type="checkbox" name="attendence"></td>

      </tr>

      <tr>

        <td class="text-center">abc</td>

        <td class="text-center">abc@gmail.com</td>

        <td class="text-center"><input type="checkbox" name="attendence"></td>

        <td class="text-center"><input type="checkbox" name="attendence"></td>

        <td class="text-center"><input type="checkbox" name="attendence"></td>

        <td class="text-center"><input type="checkbox" name="attendence"></td>

        <td class="text-center"><input type="checkbox" name="attendence"></td>

      </tr>

      <tr>

        <td class="text-center">bbb</td>

        <td class="text-center">bbb@gmail.com</td>

        <td class="text-center"><input type="checkbox" name="attendence"></td>

        <td class="text-center"><input type="checkbox" name="attendence"></td>

        <td class="text-center"><input type="checkbox" name="attendence"></td>

        <td class="text-center"><input type="checkbox" name="attendence"></td>

        <td class="text-center"><input type="checkbox" name="attendence"></td>

      </tr>

    </table>

   </div>

  </div>
		</div>
		<div class="col-md-1"></div>
</div>
<@macro.showFooter>

</@macro.showFooter>