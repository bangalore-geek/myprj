	<#import "/spring.ftl" as spring />
	<#import "macro.ftl" as macro/>

	<@macro.showHeader />

	<div class="header">
		<h1 class="page-title">Assessment</h1>
	</div><br>
		<div ng-app="wizDemoApp" ng-controller="TestCtrl">
			<wizard on-finish="finished()" current-step="st">
				<wz-step title="Trainer Feedback">
				
				


    
    <form action="" method="">
	<h3 class="text-center" style="margin-top:40px;">Trainer Feedback</h3>
	<div style="margin-top:50px;margin-left:115px;">
	

	
      <br>
      <div class="row">
        <div class="col-xs-6">
          <div class="pull-left">
          <label><strong>Course Name&nbsp;</strong></label>
          <input type="text" name="course" placeholder="__________________________________________">
          </div>
        </div>
        <div class="col-xs-6">
          <div class="">
          <label><strong>Instructor&nbsp;</strong></label>
          <input type="text" name="instructor" placeholder="_________________________________________">
          </div>
        </div>
      </div>
      <br>
      <div class="row">
        <div class="col-xs-4">
          <div class="pull-left">
          <label><strong>Class Date&nbsp;</strong></label>
          <input type="date" name="clsDt" placeholder="_________________________________________">
           </div>
        </div>
        <div class="col-xs-4">
          <div class="center-block">
          <label><strong>Class ID&nbsp;</strong></label>
          <input type="number" name="clsId" placeholder="_________________________________________">
          </div>
        </div>
        <div class="col-xs-4">
          <div class="">
          <label><strong>Location&nbsp;</strong></label>
          <input type="text" name="loc" placeholder="_________________________________________">
           </div>
        </div>
      </div>
      <br>
      <div class="row col-md-12">
        <h4>Instructor</h4>
      </div>
      
      <div class="row">
        <div class="col-xs-12">
          <p><strong>a.</strong>&nbsp;&nbsp;&nbsp;The instructor was knowledgeable about this subject.........................................</p>
        </div>
      </div>
      <div class="row">
        <div class="col-xs-12">
          <p><strong>b.</strong>&nbsp;&nbsp;&nbsp;The instructor managed student participation well.............................................................</p>
        </div>
      </div>
      <div class="row">
        <div class="col-xs-12">
          <p><strong>c.</strong>&nbsp;&nbsp;&nbsp;The instructor explained concepts well..............................................................................</p>
        </div>
      </div>
      <div class="row">
        <div class="col-xs-12">
          <p><strong>d.</strong>&nbsp;&nbsp;&nbsp;The instructor encouraged questions and was responsive to
them...................................</p>
        </div>
      </div>
      <div class="row">
        <div class="col-xs-12">
          <p><strong>e.</strong>&nbsp;&nbsp;&nbsp;The instructor provided feedback and clarification during
practice sessions......................</p>
        </div>
      </div>
      <div class="row">
        <div class="col-xs-12">
          <p><strong>f.</strong>&nbsp;&nbsp;&nbsp;The instructor made my overall experience a positive one..................................................</p>
        </div>
      </div>
      <div class="row">
        <div class="col-xs-12">
          <p><strong>g.</strong>&nbsp;&nbsp;&nbsp;The instructor advised me of the next class(es) that I should
take......................................</p>
        </div>
      </div>
       <div class="row">
        <div class="col-xs-12">
          <p><strong>h.</strong>&nbsp;&nbsp;&nbsp;The instructor recommended the self-paced offering that
compliments this class.........................................</p>
        </div>
      </div>
      
      <div class="row">
        <div class="col-xs-12">
          <p><strong>Instructor Comments</strong></p>
        </div>
      </div>
      <div class="row">
        <div class="col-xs-6">
          <textarea name="comments" rows="4" cols="80" placeholder="Enter Something"></textarea>
        </div>
      </div>
      
       <div class="row ">
        <div class="col-md-12">
          <h4>COURSE CONTENT</h4>
        </div>
      </div>
      
       <div class="row">
        <div class="col-xs-12">
          <p><strong>a.</strong>&nbsp;&nbsp;&nbsp;The course content was technically accurate… </p>
        </div>
      </div>
      
       <div class="row">
        <div class="col-xs-12">
          <p><strong>b.</strong>&nbsp;&nbsp;&nbsp;The course provided important job skills and
knowledge.........................................</p>
        </div>
      </div>
      
       <div class="row">
        <div class="col-xs-12">
          <p><strong>c.</strong>&nbsp;&nbsp;&nbsp;The practice exercises were relevant and supported my
learning.........................................</p>
        </div>
      </div>
      
       <div class="row">
        <div class="col-xs-12">
          <p><strong>d.</strong>&nbsp;&nbsp;&nbsp;The course structure, flow and logic effectively supported the
course objectives.........................................</p>
        </div>
      </div>
      <div class="row">
        <div class="col-xs-12">
          <p><strong>Course Content Comments</strong></p>
        </div>
      </div>
       <div class="row">
        <div class="col-xs-6">
          <textarea name="comments" rows="4" cols="80" placeholder="Enter Something"></textarea>
        </div>
      </div>
      
      <div class="row ">
        <div class="col-md-12">
          <h4>PRACTICE ENVIRONMENT</h4>
        </div>
      </div>
      <div class="row">
        <div class="col-xs-12">
          <p><strong>a.</strong>&nbsp;&nbsp;&nbsp;The practice environment was set up in a satisfactory way….</p>
        </div>
      </div>
      <div class="row">
        <div class="col-xs-12">
          <p><strong>b.</strong>&nbsp;&nbsp;&nbsp;The performance of the software, hardware and network was
satisfactory.........................................</p>
        </div>
      </div>
      <div class="row">
        <div class="col-xs-12">
          <p><strong>c.</strong>&nbsp;&nbsp;&nbsp;Technical problems were resolved satisfactorily. …..…..…..</p>
        </div>
      </div>
      
       <div class="row ">
        <div class="col-md-12">
          <h4>EDUCATION CENTER</h4>
        </div>
      </div>
      <div class="row">
        <div class="col-xs-12">
          <p><strong>a.</strong>&nbsp;&nbsp;&nbsp;The physical environment of the classroom was comfortable
and conducive to learning......................................... </p>
        </div>
      </div>
      <div class="row">
        <div class="col-xs-12">
          <p><strong>b.</strong>&nbsp;&nbsp;&nbsp;The projection system and whiteboards were clearly visible...</p>
        </div>
      </div>
      <div class="row">
        <div class="col-xs-12">
          <p><strong>c.</strong>&nbsp;&nbsp;&nbsp;The education center and classroom were clean and well
maintained.........................................</p>
        </div>
      </div>
      
      <div class="row ">
        <div class="col-md-12">
          <h4>OVERALL</h4>
        </div>
      </div>
      <div class="row">
        <div class="col-xs-12">
          <p><strong>a.</strong>&nbsp;&nbsp;&nbsp;Overall this course met my expectations and requirements...</p>
        </div>
      </div>
      <div class="row">
        <div class="col-xs-12">
          <p><strong>b.</strong>&nbsp;&nbsp;&nbsp;Based on your experience in this class would you…</p>
        </div>
      </div>
      <div class="row">
        <ul>
          <li>…take another class at Oracle University?</li>
          <li>…take another class from this instructor?</li>
          <li>…recommend training at Oracle University to others? </li>
        </ul>
      </div>
      <div class="row">
        <div class="col-xs-12">
         <p><strong>c.</strong>&nbsp;&nbsp;&nbsp;Why or why not?</p>
        </div>
      </div>
      <div class="row">
        <div class="col-xs-12">
          <textarea name="comments" rows="4" cols="80" placeholder="Enter Something"></textarea>
        </div>
      </div>
      
      <div class="row">
        <div class="col-xs-12">
         <p><strong>d.</strong>&nbsp;&nbsp;&nbsp;Suggest how we could improve your satisfaction with the course</p>
        </div>
      </div>
      <div class="row">
        <div class="col-xs-12">
          <textarea name="comments" rows="4" cols="80" placeholder="Enter Something"></textarea>
        </div>
      </div>
      <div class="row ">
        <div class="col-md-12">
          <h4>ABOUT YOU</h4>
        </div>
      </div>
      <div class="row">
        <div class="col-xs-6">
          <strong>Name*</strong>
        </div>
        <div class="col-xs-6">
          <input type="text" name="instructor" placeholder="_________________________________________">
        </div>
      </div>
      <div class="row">
        <div class="col-xs-6">
          <strong>Company*</strong>
        </div>
        <div class="col-xs-6">
          <input type="text" name="instructor" placeholder="_________________________________________">
        </div>
      </div>
      <div class="row">
        <div class="col-xs-6">
          <strong>E-Mail ID*</strong>
        </div>
        <div class="col-xs-6">
          <input type="text" name="instructor" placeholder="_________________________________________">
        </div>
      </div>
      <div class="row">
        <div class="col-xs-6">
          <strong>Address*</strong>
        </div>
        <div class="col-xs-6">
          <input type="text" name="instructor" placeholder="_________________________________________">
        </div>
      </div>
      <div class="row">
        <div class="col-xs-6">
          <strong>Phone Number*</strong>
        </div>
        <div class="col-xs-6">
          <input type="text" name="instructor" placeholder="_________________________________________">
        </div>
      </div>
      <br>
      <div class="row">
        <div class="col-xs-12">
          <button type="button" wz-next class="btn btn-primary">Submit</button>&emsp;&emsp;&emsp;
          <button type="button" value="reset" class="btn btn-default">Reset</button>
        </div>
      </div>
      <br><br><br>
      <div class="row">
        <div class="col-xs-12">
          <p style="font-size:80%">
            **The information marked with an “*“ in this form is voluntary. If you provide us with this information, it may be used within Oracle
Corporation and Oracle Authorized Education Centers to inform you of Oracle University training opportunities that are appropriate
for the products you use, the role you play in your organization, and your specific preferences. The information will not be shared
with any entities outside of Oracle Corporation and its Oracle Authorized Education Centers. For a complete description of Oracle's
privacy policy.
          </p>
        </div>
      </div>
</div>

      </form>	
					
				</wz-step>
				<wz-step title="Trainee Assessment">
					<div class="row" style="margin-top:50px;margin-left:115px;">
						<h3>Question</h3>
						
						---------{{questionAttempetCount}}--------
						<div>{{question.que}}</div>
					</div>
					<div class="row" style="margin-top:10px;margin-left:115px;">
						<h3>Options</h3>
						<div><input type="radio" name="option" ng-model="correctkAnswer.ans" value="op1"> {{question.op1}}</div>
						<div><input type="radio" name="option" ng-model="correctkAnswer.ans" value="op2"> {{question.op2}}</div>
						<div><input type="radio" name="option" ng-model="correctkAnswer.ans" value="op3"> {{question.op3}}</div>
						<div><input type="radio" name="option" ng-model="correctkAnswer.ans" value="op4"> {{question.op4}}</div>
						<div class="row" style="margin-top:10px;margin-left:115px;">
							<input type="button"  class="btn btn-primary" ng-click="getQuestion(question)" value="Next Question" />
							<input type="submit" wz-next value="Submit" class="btn btn-primary" />
						</div>
					</div>				
				</wz-step>
				<wz-step title="Submit">
					<div class="row" style="margin-top:100px;margin-left:115px;">
						Correctk Answer: {{correctkAnswerCount}}
						Question Attend: {{questionAttempetCount}}
					</div>
				</wz-step>
			</wizard>
		</div>

	<@macro.showFooter>
	<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/test-wizard.js"></script>
	</@macro.showFooter>