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


<form action="subject" method="post">
<input type="hidden" name="programID" value="<%=program.getProgramID()%>"/>
<input type="text" name="programName" placeholder="Enter Program Name" value="<%=program.getProgramName()%>"/>
<input type="text" name="totalTerms" placeholder="Enter Total Terms" value="<%=program.getTotalTerms()%>"/>
<%if(program.getWinter() == 1)
{
%>
<input type="checkbox" checked="checked" name="offeredterm" value="winter"/>Winter
<%
}
else
{
%>
<input type="checkbox" name="offeredterm" value="winter"/>Winter
<%	
}
%>
<%if(program.getSummer() == 1)
{
%>
<input type="checkbox" checked="checked" name="offeredterm" value="summer"/>Summer
<%
}
else
{
%>
<input type="checkbox" name="offeredterm" value="summer"/>Summer
<%	
}
%>
<%if(program.getFall() == 1)
{
%>
<input type="checkbox" checked="checked" name="offeredterm" value="fall"/>Fall
<%
}
else
{
%>
<input type="checkbox" name="offeredterm" value="fall"/>Fall
<%	
}
%>

<input type="hidden" name="q" value="updateprogram"/>
<input type="submit" value="Update" />
<input type="reset" value="Reset" />
</form>

</body>
</html>