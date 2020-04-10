<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Schedule</title>
</head>
<body>

<header class="head">
	<div class="main-bar">
    	<div class="row no-gutters">
        	<div class="col-6">
            	<h4 class="m-t-5">
                	<i class="fa fa-home"></i>
                    	New Schedule Details
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
<form action="schedule" method="post">
Schedule Name:
<input type="text" name="scheduleName" class="widthc1 form-control"  placeholder="Enter Schedule Name"/>
<div class="spacec1"></div>
Year: 
<select name="year" class="form-control selectc1">
<option value="0">Select Year</option>
<option value="2020">2019</option>
<option value="2020">2020</option>
<option value="2021">2021</option>
<option value="2022">2022</option>
<option value="2023">2023</option>
<option value="2024">2024</option>
<option value="2025">2025</option>
<option value="2026">2026</option>
<option value="2027">2027</option>
<option value="2028">2028</option>
<option value="2029">2029</option>
<option value="2030">2030</option>
</select>

<br>
<BR>
<input type="hidden" name="q" value="addnewschedule"/>
<input type="submit" class="btn btn-success" value="Create Schedule" />
<input type="reset" class="btn btn-success" value="Reset" />
</form>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


</body>
</html>