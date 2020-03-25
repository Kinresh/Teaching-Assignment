<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script>
function displayPriority(p)
{
	var s = "priority"+p;
	var selectTag = document.getElementById(s);
	if (selectTag.style.display == "none") {
		selectTag.style.display = "block";
	}
	else
	{
		selectTag.style.display = "none";
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
<%@page import="com.abc.model.SubjectTermModel"%>
<%@page import="com.abc.model.PriorityModel"%>

<%@page import="java.util.List"%>
<form action="schedule" method="post">

<input type="hidden" name="q" value="facultyselection" />


<% 
List<SubjectTermModel> stms = null;
stms = (ArrayList) request.getAttribute("stms");
List<SubjectModel> subjects = null;
subjects = (ArrayList) request.getAttribute("subjects");
List<TermModel> terms = null;
terms = (ArrayList) request.getAttribute("terms");
List<PriorityModel> priorities = null;
priorities = (ArrayList) request.getAttribute("priorities");
int syID = (int) request.getAttribute("syID");
int totalTerms = terms.size();
int subjectID=0,web_termID=0,t=0;
%>

<input type="hidden" name="syID" value="<%=syID %>" />
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
subjectID = subjects.get(k).getSubjectID();

for(int j=0; j<totalTerms; j++)
{

	web_termID = terms.get(j).getWeb_termID();	
%>
	<td>
	<%
	for(int c=0; c< stms.size() ; c++)
	{
		if(stms.get(c).getSubjectID() == subjectID && stms.get(c).getWeb_termsID() == web_termID)
		{
			%>
			<input type="checkbox" name="selection" style="width:165px;" value="<%= stms.get(c).getStID() %>" id="<%=subjectID%>,<%=web_termID%>" onClick="displayPriority(this.id);"/>
			<%=stms.get(c).getNotes() %>
			<select name="priority<%= stms.get(c).getStID() %>" id="priority<%=subjectID%>,<%=web_termID%>" style="display:none;">
			<option value="999">Select Priority</option>
			<%
			if(priorities != null)
			{
				for(int p = 0;p<priorities.size();p++)
				{
				%>
				<option value="<%=priorities.get(p).getPriorityID()%>"><%=priorities.get(p).getDescription()%></option>
				<%
				}
			}
			%>
			</select>
			<%
		}
	}
	%>
	<%-- <input type="checkbox" name="selection" style="width:165px;" value="<%=subjects.get(k).getSubjectID()%>,<%=terms.get(j).getWeb_termID() %>" onClick="displayNotes(this.value);"/>
	<input type="text" name="notes<%=subjects.get(k).getSubjectID()%>,<%=terms.get(j).getWeb_termID() %>" id="<%=subjects.get(k).getSubjectID()%>,<%=terms.get(j).getWeb_termID() %>" style="display: none;" placeholder="enter note"/> --%>
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