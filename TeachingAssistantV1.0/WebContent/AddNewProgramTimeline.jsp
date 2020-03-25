<%@page import="java.util.ArrayList"%>
<%@page import="com.abc.model.ProgramModel"%>
<%@page import="java.util.List"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Program Timeline</title>
</head>
<body>

<form action="subject" method="post">

<select name="programID">
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
<select name="startingTerm">
<option value="">Select Term</option>
<option value="winter">Winter</option>
<option value="summer">Summer</option>
<option value="fall">Fall</option>
</select>
<input type="text" name="startingYear" placeholder="Enter Starting Year. e.g.2020"/>


<input type="hidden" name="q" value="addnewprogramtimeline"/>
<input type="submit" value="Add Program Timeline" />
<input type="reset" value="Reset" />
</form>

</body>
</html>