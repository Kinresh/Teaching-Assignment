
<header class="head">
	<div class="main-bar">
    	<div class="row no-gutters">
        	<div class="col-6">
            	<h4 class="m-t-5">
                	<i class="fa fa-home"></i>
                    	New Program Details
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
Program Name:
<input type="text" name="programName" class="widthc1 form-control" placeholder="Enter Program Name"/>
<div class="spacec1"></div>
No. of Terms:
<input type="text" name="totalTerms" class="widthc1 form-control" placeholder="Enter Total Terms"/>
<br>
<br>
Offered In:
<div class="spacec1"></div>
Winter
<label class="switch">
	<input type="checkbox" name="offeredterm" value="winter"/>
  	<span class="slider round"></span>
</label>
<div class="spacec1"></div>
Summer
<label class="switch">
	<input type="checkbox" name="offeredterm" value="summer"/>
  	<span class="slider round"></span>
</label>
<div class="spacec1"></div>
Fall
<label class="switch">
	<input type="checkbox" name="offeredterm" value="fall"/>
  	<span class="slider round"></span>
</label>

<br>
<br>
<input type="hidden" name="q" value="addnewprogram"/>
<input type="submit" class="btn btn-success" value="Add Program" />
<input type="reset" class="btn btn-light" value="Reset" />
</form>



						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>