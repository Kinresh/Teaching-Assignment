<header class="head">
	<div class="main-bar">
    	<div class="row no-gutters">
        	<div class="col-6">
            	<h4 class="m-t-5">
                	<i class="fa fa-home"></i>
                    	New Subject Details
				</h4>
			</div>
		</div>
	</div>                    
</header>
<div class="outer">
	<div class="inner bg-container">
    	<div class="row">
			<div class="col-12 data_tables">
				<div class="card">
					<div class="card-body p-t-10">
						<div class=" m-t-25">

<form action="subject" method="post">
Subject Code:
<input type="text" name="subjectCode" class="widthc1 form-control" placeholder="Enter Subject Code"/>
<div class="spacec1"></div>
Subject Name:
<input type="text" name="subjectName" class="widthc1 form-control" placeholder="Enter Subject Name"/>
<br>
Description:
<input type="text" name="subjectDescription" class="form-control widthc1" style="margin-left:17px;" placeholder="Enter Subject Description"/>
<div class="spacec1"></div>
Instructors:
<input type="text" name="maxInstructor" class="form-control widthc1" style="margin-left:25px;" placeholder="Max. No. of Instructors"/>

<input type="hidden" name="q" value="addnewsubject"/>
<br>
<br>
<input type="submit" class="btn btn-success" value="Add Subject" />
<input type="reset" class="btn btn-light" value="Reset" />
</form>


						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>