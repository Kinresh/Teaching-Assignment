<%@page import="java.util.ArrayList"%>
<%@page import="com.abc.model.ProgramModel"%>
<%@page import="java.util.List"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Program Timeline</title>
</head>
<body>
<header class="head">
	<div class="main-bar">
    	<div class="row no-gutters">
        	<div class="col-6">
            	<h4 class="m-t-5">
                	<i class="fa fa-home"></i>
                    	New Program Timeline Details
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
Select Program:
<select name="programID" class="form-control selectc1" tabindex="2">
<option value="">Select program</option>
<%
List<ProgramModel> programs = null;
programs = (ArrayList) request.getAttribute("programs");
if(programs != null)
{
for(int k = 0;k<programs.size();k++)
{
%>
<option value="<%=programs.get(k).getProgramID()%>"><%=programs.get(k).getProgramName()%></option>
<%
}
}
%>
</select>
<div class="spacec1"></div>

Select Term:
<select name="startingTerm" class="form-control selectc1" tabindex="2">
<option value="">Select Term</option>
<option value="winter">Winter</option>
<option value="summer">Summer</option>
<option value="fall">Fall</option>
</select>
<br>
<br>
Year:
<input type="text" name="startingYear" class="widthc1 form-control" style="margin-left: 65px;" placeholder="Enter Starting Year. e.g.2020"/>

<br>
<input type="hidden" name="q" value="addnewprogramtimeline"/>
<br>
<input type="submit" class="btn btn-success" value="Add Program Timeline" />
<input type="reset" class="btn btn-light" value="Reset" />
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