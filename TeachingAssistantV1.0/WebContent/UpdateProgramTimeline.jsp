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


<form action="subject" method="post">
<input type="hidden" name="ptID" value="<%=pt.getPtID()%>"/>

<select name="programID">
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
<select name="startingTerm">
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
<input type="text" name="startingYear" value=<%= pt.getStartingYear() %> placeholder="Enter Starting Year. e.g.2020"/>

<input type="hidden" name="q" value="updateprogramtimeline"/>
<input type="submit" value="Update" />
<input type="reset" value="Reset" />
</form>

</body>
</html>