<%@page import="java.util.ArrayList"%>
<%@page import="com.abc.model.ProgramModel"%>
<%@page import="java.util.List"%>
<script type="text/javascript">

function permanentDelete(id)
{
	if(confirm("Delete this program permanently?"))
		{
		window.location.href="subject?q=deleteprogram&id="+id;
		}
}
function enable(id)
{
	if(confirm("Activate program?"))
		{
		window.location.href="subject?q=enableprogram&id="+id;
		}
}
function disable(id)
{
	if(confirm("Disable program?"))
		{
		window.location.href="subject?q=disableprogram&id="+id;
		}
}
function update(id)
{
	if(confirm("Update program details?"))
		{
		window.location.href="forward?q=updateprogram&id="+id;
		}
}
function deleteSelected()
{
	var u = new Array();
	var t=0;
	var ar = document.getElementsByName('select');
	for(var j=0 ; j<ar.length ; j++)
		{
		
			if(ar[j].checked)
			{
				u.push(ar[j].value);
				t=1;
				
			}
		}
	
	if(t==1)
		{
		if(confirm("Delete selected programs permenantly?"))
			{
			window.location.href="subject?q=multipledeleteprograms&ids="+u;
			}
		}
	else
		alert("No account selected.");
}</script>
<%
int i = 1;
List<ProgramModel> programs = null;
programs =(ArrayList) request.getAttribute("programs");
%>
<input type="button" onclick="deleteSelected()" value="Delete Selected" />
<input type="button" onclick="window.location.href = 'forward?q=addnewprogram'" value="Add New Program" />
<table border="1">
<tr>

<th>CHECKBOX</th>

<th>SR NO.</th>

<th>PROGRAM-NAME</th>

<th>TOTAL TERMS</th>

<th>OFFERED IN</th>

<th>ACTION</th>

</tr>
<%
if(programs != null)
{
for(int k = 0;k<programs.size();k++)
{
%>
<tr>

<td><input type="checkbox" name="select" value="<%= programs.get(k).getProgramID() %>"/></td>

<td><%=i%></td>

<td><%=programs.get(k).getProgramName()%></td>

<td><%=programs.get(k).getTotalTerms()%></td>

<td><%
if(programs.get(k).getWinter() == 1)
{
%>
<div>Winter</div>
<%
}
if(programs.get(k).getSummer() == 1)
{
%>
<div>Summer</div>
<%
}
if(programs.get(k).getFall() == 1)
{
%>
<div>Fall</div>
<%
}
%></td>


<%
if(programs.get(k).getActive_flag() == 1)
{
%>
<td>
<input type="button" onclick="permanentDelete(<%=programs.get(k).getProgramID() %>)" value="Delete" />
<input type="button" onclick="disable(<%=programs.get(k).getProgramID() %>)" value="Disable" />
<input type="button" onclick="update(<%=programs.get(k).getProgramID() %>)" value="Update" />
</td>
<%
}
else
{
%>
<td style="background: red;">
<input type="button" onclick="permanentDelete(<%=programs.get(k).getProgramID() %>)" value="Delete" />
<input type="button" onclick="enable(<%=programs.get(k).getProgramID() %>)" value="Enable" />
<input type="button" onclick="update(<%=programs.get(k).getProgramID() %>)" value="Update" /></td>
<%
}
%>

</tr>
<%
i++;
}
}
else{
	%>
	<tr>
	<td colspan="5"> 
	no record found
	</td>
	</tr>
	<% 
}
%>
</table>