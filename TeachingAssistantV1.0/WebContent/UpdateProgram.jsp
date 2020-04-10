<%@page import="java.util.ArrayList"%>
<%@page import="com.abc.model.ProgramModel"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Program Details</title>
</head>
<body>

<%
ProgramModel program = (ProgramModel) request.getAttribute("program");
%>


<header class="head">
	<div class="main-bar">
    	<div class="row no-gutters">
        	<div class="col-6">
            	<h4 class="m-t-5">
                	<i class="fa fa-home"></i>
                    	Update Program Details
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
<input type="hidden" name="programID" value="<%=program.getProgramID()%>"/>
Program Name
<input type="text" class="widthc1 form-control" name="programName" placeholder="Enter Program Name" value="<%=program.getProgramName()%>"/>
No. of Terms
<input type="text" class="widthc1 form-control" name="totalTerms" placeholder="Enter Total Terms" value="<%=program.getTotalTerms()%>"/>
<br>
<br>
Offered In:
<div class="spacec1"></div>
Winter
<%if(program.getWinter() == 1)
{
%>
<label class="switch">
	<input type="checkbox" checked="checked" name="offeredterm" value="winter"/>
  	<span class="slider round"></span>
</label>

<%
}
else
{
%>
<label class="switch">
	<input type="checkbox" name="offeredterm" value="winter"/>
  	<span class="slider round"></span>
</label>
<%	
}
%>
<div class="spacec1"></div>
Summer
<%if(program.getSummer() == 1)
{
%>
<label class="switch">
	<input type="checkbox" checked="checked" name="offeredterm" value="summer"/>
  	<span class="slider round"></span>
</label>
<%
}
else
{
%>
<label class="switch">
	<input type="checkbox" name="offeredterm" value="summer"/>
  	<span class="slider round"></span>
</label>
<%	
}
%>
<div class="spacec1"></div>
Fall
<%if(program.getFall() == 1)
{
%>
<label class="switch">
	<input type="checkbox" checked="checked" name="offeredterm" value="fall"/>
  	<span class="slider round"></span>
</label>
<%
}
else
{
%>
<label class="switch">
	<input type="checkbox" name="offeredterm" value="fall"/>
  	<span class="slider round"></span>
</label>
<%	
}
%>
<br>
<br>
<input type="hidden" name="q" value="updateprogram"/>
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