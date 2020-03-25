<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script>
function displayNotes(p)
{	
	if (document.getElementById(p).style.display == "none") {
		document.getElementById(p).style.display = "block";
	}
	else
	{
		document.getElementById(p).style.display = "none";
	}
}
function validateForm() {
	  var x = document.forms["myForm"]["schedule"].value;
	  if (x == "") {
	    alert("Schedule must be selected");
	    return false;
	  }
	}
</script>
<%@page import="java.util.ArrayList"%>
<%@page import="com.abc.model.TermModel"%>
<%@page import="com.abc.model.SubjectModel"%>
<%@page import="com.abc.model.ScheduleModel"%>

<%@page import="java.util.List"%>
<form action="schedule" method="post" onsubmit="return validateForm()" name="myForm">

<input type="hidden" name="q" value="addnewinputform" />


<% 
List<ScheduleModel> schedules = null;
schedules = (ArrayList) request.getAttribute("schedules");
List<SubjectModel> subjects = null;
subjects = (ArrayList) request.getAttribute("subjects");
List<TermModel> terms = null;
terms = (ArrayList) request.getAttribute("terms");
int totalTerms = terms.size();
%>

<select name="schedule">
<option value="">select schedule</option>
<%
if(schedules != null)
{
for(int k = 0;k<schedules.size();k++)
{
%>
<option value="<%=schedules.get(k).getSyID()%>"><%=schedules.get(k).getName()%></option>
<%
}
}
%>
</select>

<table border="1">
<tr>
<th>COURSE</th>
<%
if(terms!=null)
{
for(int k=0 ; k<terms.size(); k++)
{
%>
<th><%=terms.get(k).getName() %></th>
<%
}
}
%>
</tr>
<%
if(subjects!=null)
{
for(int k=0; k<subjects.size();k++)
{
%>
<tr>
<td><%=subjects.get(k).getSubjectCode()%></td>
<%
for(int j=0; j<totalTerms; j++)
{
%>
	<td>
	<input type="checkbox" name="selection" style="width:165px;" value="<%=subjects.get(k).getSubjectID()%>,<%=terms.get(j).getWeb_termID() %>" onClick="displayNotes(this.value);"/>
	<input type="text" name="notes<%=subjects.get(k).getSubjectID()%>,<%=terms.get(j).getWeb_termID() %>" id="<%=subjects.get(k).getSubjectID()%>,<%=terms.get(j).getWeb_termID() %>" style="display: none;" placeholder="enter note"/>
	</td>
<%
}
%>
</tr>
<%	
}
}
else
{
%>
<tr>no subjects found</tr>
<%	
}
%>
</table>



<input type="submit" value="Create Form"/>
<input type="reset" value="Cancel"/>

</form>