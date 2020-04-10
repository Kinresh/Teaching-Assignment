<%@page import="java.util.ArrayList"%>
<%@page import="com.abc.model.ProgramTimelineModel"%>
<%@page import="com.abc.model.ProgramModel"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Program Timeline Details</title>
</head>
<body>

<%
ProgramTimelineModel pt = (ProgramTimelineModel) request.getAttribute("pt");
%>

<header class="head">
	<div class="main-bar">
    	<div class="row no-gutters">
        	<div class="col-6">
            	<h4 class="m-t-5">
                	<i class="fa fa-home"></i>
                    	Update Program Timeline Details
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
<input type="hidden" name="ptID" value="<%=pt.getPtID()%>"/>

Select Program:
<select name="programID" class="form-control selectc1">
<option value="">Select program</option>
<%
List<ProgramModel> programs = null;
programs = (ArrayList) request.getAttribute("programs");
if(programs != null)
{
for(int k = 0;k<programs.size();k++)
{
	if(programs.get(k).getProgramID() == pt.getProgramID())
	{
%>
<option selected="selected" value="<%=programs.get(k).getProgramID()%>"><%=programs.get(k).getProgramName()%></option>
<%
	}
	else
	{
%>
<option value="<%=programs.get(k).getProgramID()%>"><%=programs.get(k).getProgramName()%></option>
<%
	}
}
}
%>
</select>
<div class="spacec1"></div>

Select Term:

<select name="startingTerm" class="form-control selectc1">
<option value="">Select Term</option>
<%
	if(pt.getStartingTerm().equals("winter"))
	{
%>
<option selected="selected" value="winter">Winter</option>
<%
	}
	else
	{
%>
<option value="winter">Winter</option>
<%
	}
%>
<%
	if(pt.getStartingTerm().equals("summer"))
	{
%>
<option selected="selected" value="summer">Summer</option>
<%
	}
	else
	{
%>
<option value="summer">Summer</option>
<%
	}
%>
<%
	if(pt.getStartingTerm().equals("fall"))
	{
%>
<option selected="selected" value="fall">Fall</option>
<%
	}
	else
	{
%>
<option value="fall">Fall</option>
<%
	}
%>
</select>
<br>
<br>
Year:
<input type="text" name="startingYear" class="widthc1 form-control" style="margin-left: 65px;" value=<%= pt.getStartingYear() %> placeholder="Enter Starting Year. e.g.2020"/>
<br>
<br>
<input type="hidden" name="q" value="updateprogramtimeline"/>
<input type="submit" class="btn btn-success" value="Update" />
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