	<#import "/spring.ftl" as spring />
	<#import "/macro.ftl" as macro/>

	<@macro.showHeader />
<style>
input {
    background-color: transparent;
    border: 0px solid;
    color: #CCC;
}

.placeholder {
    text-align: center;
}

#th {
    margin-left: 17cm;
}

#tb {
    margin-left: 1.5cm;
}

input[type="checkbox"]{
  width: 10px; /*Desired width*/
  height: 10px; /*Desired height*/
}

.topmargin {
    margin-top: 1cm;
}
.topMarginData {
    margin-top: 0.5cm;
}

.mytopmargin
{
  margin-top: 1cm;
}
</style>


	<div class="header">
		<h1 class="page-title">Assessment</h1>
	</div><br>
		<div ng-app="wizDemoApp" ng-controller="TestCtrl">
			<wizard on-finish="finished()" current-step="st">
				<wz-step title="Trainer Feedback">
				<div class="row">
				<div class="col-md-1"></div>
					<div class="col-md-10">
					<h3 class="text-center"><b>Trainer Feedback<b></h3>
						<form action="" method="">
							  <br>
							  <div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							   
								  <label><strong>Course Name&nbsp;:</strong>&nbsp;<input type="text" name="course" value="{{course.name}}" placeholder="____________________________________________________________"></label>
								  
								  
								  <label><strong>Instructor&nbsp;:</strong>&nbsp;<input type="text" name="instructor" placeholder="_____________________________________________"></label>
								  
								  
								</div>
							  </div>
							  <br>
							  <div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								  
								  <label><strong>Class Date&nbsp;</strong>:<input type="date" name="clsDt" placeholder="_________________________________________"></label>
								  
								  
								  <label><strong>Class ID&nbsp;</strong>:<input type="number" name="clsId" placeholder="_________________________________________"></label>
										   
								  <label><strong>Location&nbsp;</strong><input type="text" name="loc" placeholder="_________________________________________"></label>
								  
								  
								</div>
							  </div>
							  <br>
							  <div>
								<h4>Instructor</h4>
							  </div>
							  <div class="row topmargin">
								  <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								  
									 <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
								  <p><strong>a.</strong>&nbsp;&nbsp;&nbsp;The instructor was knowledgeable about this subject :</p>
								  </div>
								 <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
									  <select class="form-control">
										  <option>Select</option>
										  <option>Strongly Agree</option>
										  <option>Agree</option>
										  <option>Undecided</option>
										  <option>Disagree</option>
										  <option>Strongly Disagree</option>
										  <option>N/A</option>
									  </select>
									</div>
								  </div>
							  </div>
							  
							  <div class="row topMarginData">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								  
								  <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
								  <p><strong>b.</strong>&nbsp;&nbsp;&nbsp;The instructor managed student participation well :</p>
								  </div>
								  <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
										<select class="form-control">
										  <option>Select</option>
										  <option>Strongly Agree</option>
										  <option>Agree</option>
										  <option>Undecided</option>
										  <option>Disagree</option>
										  <option>Strongly Disagree</option>
										  <option>N/A</option>
										</select>
									</div>
								</div>
							  </div>
									
							  
							  <div class="row topMarginData">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								  
									<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
								  <p><strong>c.</strong>&nbsp;&nbsp;&nbsp;The instructor explained concepts well :</p>
								  </div>
								  <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
										<select class="form-control">
										  <option>Select</option>
										  <option>Strongly Agree</option>
										  <option>Agree</option>
										  <option>Undecided</option>
										  <option>Disagree</option>
										  <option>Strongly Disagree</option>
										  <option>N/A</option>
										</select>
							   </div>
							  
								</div>
							  </div>
								  
							  <div class="row topMarginData">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								  
									<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
								  <p><strong>d.</strong>&nbsp;&nbsp;&nbsp;The instructor encouraged questions and was responsive to
						them :</p>
							   </div>
							   <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
										<select class="form-control">
										  <option>Select</option>
										  <option>Strongly Agree</option>
										  <option>Agree</option>
										  <option>Undecided</option>
										  <option>Disagree</option>
										  <option>Strongly Disagree</option>
										  <option>N/A</option>
										</select>
								   </div> 
								</div>
							  </div>
								   
							  
							  <div class="row topMarginData">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								 <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
								  <p><strong>e.</strong>&nbsp;&nbsp;&nbsp;The instructor provided feedback and clarification during
								 practice sessions :</p>
								 </div>
								 
									<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
								 <select class="form-control">
										  <option>Select</option>
										  <option>Strongly Agree</option>
										  <option>Agree</option>
										  <option>Undecided</option>
										  <option>Disagree</option>
										  <option>Strongly Disagree</option>
										  <option>N/A</option>
										</select>
										</div>
								</div>
							  </div>
								  
							  <div class="row topMarginData">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								  <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
								  
								  <p><strong>f.</strong>&nbsp;&nbsp;&nbsp;The instructor made my overall experience a positive one :</p>
								  </div>
								 `<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
								  <select class="form-control mytopMargin">
										  <option>Select</option>
										  <option>Strongly Agree</option>
										  <option>Agree</option>
										  <option>Undecided</option>
										  <option>Disagree</option>
										  <option>Strongly Disagree</option>
										  <option>N/A</option>
										</select>
										</div>
								</div>
							  </div>
									
							  <div class="row topMarginData">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								  
									`<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
								  <p><strong>g.</strong>&nbsp;&nbsp;&nbsp;The instructor advised me of the next class(es) that I should
						take :</p>
						</div>
								 <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
							   <select class="form-control">
										  <option>Select</option>
										  <option>Strongly Agree</option>
										  <option>Agree</option>
										  <option>Undecided</option>
										  <option>Disagree</option>
										  <option>Strongly Disagree</option>
										  <option>N/A</option>
										</select>
										</div>
								</div>
							  </div>
								  
							   <div class="row topMarginData">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								  
									<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
								  <p><strong>h.</strong>&nbsp;&nbsp;&nbsp;The instructor recommended the self-paced offering that
						compliments this class :</p>
						</div>
								 `<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
								<select class="form-control">
										  <option>Select</option>
										  <option>Strongly Agree</option>
										  <option>Agree</option>
										  <option>Undecided</option>
										  <option>Disagree</option>
										  <option>Strongly Disagree</option>
										  <option>N/A</option>
										</select>
										</div>
								</div>
							  </div>
							  <div class="row mytopmargin">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								  <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<p><strong>Instructor Comments</strong></p>
									<label for="comment">Comment:</label>
								  </div>
								  <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<div class="topMarginData">
									  <div class="form-group">
										<textarea class="form-control topMarginData" rows="5" placeholder="Enter Something" id=""></textarea>
									  </div>
									</div>
								  </div>
							  </div></div>
							   <div class="row topmargin">
								<div class="col-md-12">
								  <h4>COURSE CONTENT</h4>
								</div>
							  </div>
							  
							   <div class="row topMarginData">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
									  <p><strong>a.</strong>&nbsp;&nbsp;&nbsp;The course content was technically accurate :</p>
									</div>
								  <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
								  <select class="form-control">
										  <option>Select</option>
										  <option>Strongly Agree</option>
										  <option>Agree</option>
										  <option>Undecided</option>
										  <option>Disagree</option>
										  <option>Strongly Disagree</option>
										  <option>N/A</option>
										</select>
								 </div>
								</div>
							   </div>
							  
							   <div class="row topMarginData">
								 <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								  <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
								  <p><strong>b.</strong>&nbsp;&nbsp;&nbsp;The course provided important job skills and
						knowledge :</p>
								  </div>
								  <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
									<select class="form-control">
										  <option>Select</option>
										  <option>Strongly Agree</option>
										  <option>Agree</option>
										  <option>Undecided</option>
										  <option>Disagree</option>
										  <option>Strongly Disagree</option>
										  <option>N/A</option>
										</select>
								</div>
								</div>
							  </div>
							  
							   <div class="row topMarginData">
								 <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								  <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
									<p><strong>c.</strong>&nbsp;&nbsp;&nbsp;The practice exercises were relevant and supported my
											  learning :</p>
								  </div>
								  <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
									<select class="form-control">
									  <option>Select</option>
									  <option>Strongly Agree</option>
									  <option>Agree</option>
									  <option>Undecided</option>
									  <option>Disagree</option>
									  <option>Strongly Disagree</option>
									  <option>N/A</option>
									</select>
								  </div>
								</div>
							  </div>
							  
							   <div class="row topMarginData">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								  
									<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
								  <p><strong>d.</strong>&nbsp;&nbsp;&nbsp;The course structure, flow and logic effectively supported the
						course objectives :</p>
						</div>
								  <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
						<select class="form-control">
										  <option>Select</option>
										  <option>Strongly Agree</option>
										  <option>Agree</option>
										  <option>Undecided</option>
										  <option>Disagree</option>
										  <option>Strongly Disagree</option>
										  <option>N/A</option>
										</select>
								</div>
								</div>
							  </div>
							  <div class="row topMarginData">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								  <p><strong>Course Content Comments</strong></p>
								</div>
							  </div>
							<div class="row mytopmargin">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								  <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<p><strong>Course Content Comments</strong></p>
									<label for="comment">&nbsp;&nbsp;&nbsp;\Comment:</label>
								  </div>
								  <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<div class="topMarginData">
									  <div class="form-group">
										<textarea class="form-control topMarginData" rows="5" placeholder="Enter Something" id=""></textarea>
									  </div>
									</div>
								  </div>
							  </div></div>
							  
							  <div class="row topmargin">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								  <h4>PRACTICE ENVIRONMENT</h4>
								</div>
							  </div>
							  <div class="row topMarginData">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								  <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
								  <p><strong>a.</strong>&nbsp;&nbsp;&nbsp;The practice environment was set up in a satisfactory way….</p>
							   </div>
							   <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
								<select class="form-control">
										  <option>Select</option>
										  <option>Strongly Agree</option>
										  <option>Agree</option>
										  <option>Undecided</option>
										  <option>Disagree</option>
										  <option>Strongly Disagree</option>
										  <option>N/A</option>
										</select>
									  </div>
								</div>
							  </div>
							  <div class="row topMarginData">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								  <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
								  <p><strong>b.</strong>&nbsp;&nbsp;&nbsp;The performance of the software, hardware and network was
						satisfactory :</p>
						</div>
							   <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
						<select class="form-control">
										  <option>Select</option>
										  <option>Strongly Agree</option>
										  <option>Agree</option>
										  <option>Undecided</option>
										  <option>Disagree</option>
										  <option>Strongly Disagree</option>
										  <option>N/A</option>
										</select>
										</div>
								</div>
							  </div>
							  <div class="row topMarginData">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								  <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
								  <p><strong>c.</strong>&nbsp;&nbsp;&nbsp;Technical problems were resolved satisfactorily :</p>
								</div>
							   <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
								 <select class="form-control">
										  <option>Select</option>
										  <option>Strongly Agree</option>
										  <option>Agree</option>
										  <option>Undecided</option>
										  <option>Disagree</option>
										  <option>Strongly Disagree</option>
										  <option>N/A</option>
										</select>
								</div></div>
							  </div>
							  
							   <div class="row topmargin">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								  <h4>EDUCATION CENTER</h4>
								</div>
							  </div>
							  <div class="row topMarginData">
							   <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								  <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
								  <p><strong>a.</strong>&nbsp;&nbsp;&nbsp;The physical environment of the classroom was comfortable
						and conducive to learning :</p>
						 </div>
							   <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
						<select class="form-control">
										  <option>Select</option>
										  <option>Strongly Agree</option>
										  <option>Agree</option>
										  <option>Undecided</option>
										  <option>Disagree</option>
										  <option>Strongly Disagree</option>
										  <option>N/A</option>
										</select>
										</div>
								</div>
							  </div>
							  <div class="row topMarginData">
								 <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								  <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
								  <p><strong>b.</strong>&nbsp;&nbsp;&nbsp;The projection system and whiteboards were clearly visible :</p>
							   </div>
							   <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
							   <select class="form-control">
										  <option>Select</option>
										  <option>Strongly Agree</option>
										  <option>Agree</option>
										  <option>Undecided</option>
										  <option>Disagree</option>
										  <option>Strongly Disagree</option>
										  <option>N/A</option>
										</select>
										</div>
								</div>
							  </div>
							  <div class="row topMarginData">
								 <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								  <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
								  <p><strong>c.</strong>&nbsp;&nbsp;&nbsp;The education center and classroom were clean and well
						maintained :</p>
						 </div>
							   <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
							   <select class="form-control">
										  <option>Select</option>
										  <option>Strongly Agree</option>
										  <option>Agree</option>
										  <option>Undecided</option>
										  <option>Disagree</option>
										  <option>Strongly Disagree</option>
										  <option>N/A</option>
										</select>
										</div>
								</div>
							  </div>
							  
							  <div class="row topMargin">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								  <h4>OVERALL</h4>
								</div>
							  </div>
							  <div class="row topMarginData">
							   <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								  <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
								  <p><strong>a.</strong>&nbsp;&nbsp;&nbsp;Overall this course met my expectations and requirements :</p>
						  </div>
							   <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
							   <select class="form-control">
										  <option>Select</option>
										  <option>Strongly Agree</option>
										  <option>Agree</option>
										  <option>Undecided</option>
										  <option>Disagree</option>
										  <option>Strongly Disagree</option>
										  <option>N/A</option>
										</select>       
								</div></div>
							  </div>
							  <div class="row topMarginData">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								  <p><strong>b.</strong>&nbsp;&nbsp;&nbsp;Based on your experience in this class would you :</p>
								</div>
							  </div>
							  <div class="row col-xs-12 col-sm-12 col-md-12 col-lg-12 topMarginData">
								<ul>
								  <li class="col-xs-8 col-sm-8 col-md-8 col-lg-8">take another class at Oracle University?</li>
								  <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
								  <select class="form-control pull-right">
										  <option>Select</option>
										  <option>Yes</option>
										  <option>No</option>
										</select>
									</div>
								  <li class="col-xs-8 col-sm-8 col-md-8 col-lg-8">take another class from this instructor?</li>
								  <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
								  <select class="form-control pull-right">
										  <option>Select</option>
										  <option>Yes</option>
										  <option>No</option>
										</select>
									</div>
								  <li class="col-xs-8 col-sm-8 col-md-8 col-lg-8">recommend training at Oracle University to others?</li>
								  <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4"> 
								  <select class="form-control pull-right">
										  <option>Select</option>
										  <option>Yes</option>
										  <option>No</option>
										</select>
										</div>
								</ul>
						 
							  <div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
								 <p><strong>c.</strong>&nbsp;&nbsp;&nbsp;Why or why not?</p>
								 <label for="comment">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Comment:</label>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
							  <div class="topMarginData">
							  <div class="form-group">
								  <textarea class="form-control topMarginData" rows="5" placeholder="Enter Something" id="">
								  </textarea>
							  </div>
							  </div>
							  </div></div></div>
							  
							  <div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
								 <p><strong>d.</strong>&nbsp;&nbsp;&nbsp;Suggest how we could improve your satisfaction with the course</p>
								 <label for="comment">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Comment:</label>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
							  <div class="topMarginData">
							  <div class="form-group">
								  <textarea class="form-control topMarginData" rows="5" placeholder="Enter Something" id="">
								  </textarea>
							  </div>
							  </div>
							  </div></div></div>
							  <div class="row topMarginData">
								<div class="col-md-12">
								  <h4>ABOUT YOU</h4>
								</div>
							  </div>
							  <div class="row topMarginData">
								<div class="col-xs-6 topMarginData">
								  <strong>Name*</strong>
								</div>
								<div class="col-xs-6 topMarginData">
								  <input type="text" name="instructor" placeholder="_________________________________________">
								</div>
							  </div>
							  <div class="row">
								<div class="col-xs-6 topMarginData">
								  <strong>Company*</strong>
								</div>
								<div class="col-xs-6 topMarginData">
								  <input type="text" name="instructor" placeholder="_________________________________________">
								</div>
							  </div>
							  <div class="row">
								<div class="col-xs-6 topMarginData">
								  <strong>E-Mail ID*</strong>
								</div>
								<div class="col-xs-6 topMarginData">
								  <input type="text" name="instructor" placeholder="_________________________________________">
								</div>
							  </div>
							  <div class="row">
								<div class="col-xs-6 topMarginData">
								  <strong>Address*</strong>
								</div>
								<div class="col-xs-6 topMarginData">
								  <input type="text" name="instructor" placeholder="_________________________________________">
								</div>
							  </div>
							  <div class="row">
								<div class="col-xs-6 topMarginData">
								  <strong>Phone Number*</strong>
								</div>
								<div class="col-xs-6 topMarginData">
								  <input type="text" name="instructor" placeholder="_________________________________________">
								</div>
							  </div>
							  
							  <div class="row">
								<div class="col-xs-12 topMarginData">
								  <button type="button" wz-next value="submit" class="btn btn-primary">Submit</button>&emsp;&emsp;&emsp;
								  <button type="button" value="reset" class="btn btn-default">Reset</button>
								</div>
							  </div>
							  <br><br><br>
							  <div class="row">
								<div class="col-xs-12">
								  <p style="font-size:80%">
									**The information marked with * in this form is voluntary. If you provide us with this information, it may be used within Oracle
						Corporation and Oracle Authorized Education Centers to inform you of Oracle University training opportunities that are appropriate
						for the products you use, the role you play in your organization, and your specific preferences. The information will not be shared
						with any entities outside of Oracle Corporation and its Oracle Authorized Education Centers. For a complete description of Oracle's
						privacy policy.
								  </p>
								</div>
							  </div>
							 
						  </div>
						</form>
					</div>
					<div class="col-md-1"></div>
				</div>
				</wz-step>
				<wz-step title="Trainee Assessment">
					<div class="row" style="margin-top:50px;margin-left:115px;">
						Course: {{course.name}}<br>
						Training: {{training.trainingName}}
						<h3>Question</h3>
						<div>{{question.que}}</div>
					</div>
					<div class="row" style="margin-top:10px;margin-left:115px;">
						<h3>Options</h3>
						<div><input type="radio" name="option" ng-model="correctkAnswer.ans" value="opt1"> {{question.op1}}</div>
						<div><input type="radio" name="option" ng-model="correctkAnswer.ans" value="opt2"> {{question.op2}}</div>
						<div><input type="radio" name="option" ng-model="correctkAnswer.ans" value="opt3"> {{question.op3}}</div>
						<div><input type="radio" name="option" ng-model="correctkAnswer.ans" value="opt4"> {{question.op4}}</div>
						<div class="row" style="margin-top:10px;margin-left:115px;">
							<input type="button"  class="btn btn-primary" ng-disabled="disablegetQuestion" ng-click="nextQuestion(question)" value="Next Question" />
							<input type="submit" wz-next="nextQuestion(question)" value="Submit" class="btn btn-primary" />
						</div>
					</div>				
				</wz-step>
				<wz-step title="Submit">
					<div class="row" style="margin-top:50px;margin-left:115px;">
						<h3>Summary</h3>
					</div>
					<div class="row" style="margin-left:115px;">
						Correct Answer: {{correctkAnswerCount}} of {{questionAttempetCount}}
					</div>
				</wz-step>
			</wizard>
		</div>

	<@macro.showFooter>
	<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/kv/attend-test.js"></script>
	</@macro.showFooter>