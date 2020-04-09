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

<header class="head">
	<div class="main-bar">
    	<div class="row no-gutters">
        	<div class="col-6">
            	<h4 class="m-t-5">
                	<i class="fa fa-home"></i>
                    	New Form Details
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

<select name="schedule" class="form-control selectc1">
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

<br>
<br>

<table border="1" class="tablec1">
<tr>
<th  style="width: 10%;">COURSE</th>
<%
if(terms!=null)
{
for(int k=0 ; k<terms.size(); k++)
{
%>
<th style="width: 30%;"><%=terms.get(k).getName() %></th>
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
	<label class="switch">
		<input type="checkbox" name="selection" value="<%=subjects.get(k).getSubjectID()%>,<%=terms.get(j).getWeb_termID() %>" onClick="displayNotes(this.value);"/>
		<span class="slider round"></span>
	</label>
	<input type="text" class="widthc2 form-control" style="margin: auto;display: none;" name="notes<%=subjects.get(k).getSubjectID()%>,<%=terms.get(j).getWeb_termID() %>" id="<%=subjects.get(k).getSubjectID()%>,<%=terms.get(j).getWeb_termID() %>" style="display: none;" placeholder="Note(optional)"/>
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

<br>	

<input type="submit" class="btn btn-success" value="Create Form"/>
<input type="reset" class="btn btn-light" value="Cancel"/>

</form>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>