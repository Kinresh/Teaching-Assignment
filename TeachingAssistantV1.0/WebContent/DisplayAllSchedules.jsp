<%@page import="java.util.ArrayList"%>
<%@page import="com.abc.model.ScheduleModel"%>
<%@page import="java.util.List"%>
<script type="text/javascript">

function selectSchedule(scheduleID)
{
	//alert(scheduleID);
	window.location.href="forward?q=displayinputform&scheduleID="+scheduleID;
}

function permanentDeleteAccount(userid)
{
	if(confirm("Delete this account permanently?"))
		{
		window.location.href="action?q=deleteaccount&userid="+userid;
		}
}
function enableAccount(userid)
{
	if(confirm("User will now be able to Login?"))
		{
		window.location.href="action?q=enableaccount&userid="+userid;
		}
}
function disableAccount(userid)
{
	if(confirm("User will not be able to Login?"))
		{
		window.location.href="action?q=disableaccount&userid="+userid;
		}
}
function updateAccount(userid)
{
	if(confirm("Update account details?"))
		{
		window.location.href="forward?q=updateaccount&userid="+userid;
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
		if(confirm("Delete selected accounts permenantly?"))
			{
			window.location.href="action?q=multipledeleteaccounts&ids="+u;
			}
		}
	else
		alert("No account selected.");
}</script>
<%
int i = 1;
List<ScheduleModel> schedules = null;
schedules =(ArrayList) request.getAttribute("schedules");
%>
<table border="1">
<tr>

<th>SR NO.</th>

<th>SCHEDULE NAME</th>

<th>ACTION</th>

</tr>
<%
if(schedules != null)
{
for(int k = 0;k<schedules.size();k++)
{
%>
<tr>

<td><%=i%></td>

<td><a href="forward?q=displayinputform&scheduleID="+<%=schedules.get(k).getSyID() %>"><%=schedules.get(k).getName()%></a></td>

<td><input type="button" onclick="selectSchedule(<%=schedules.get(k).getSyID() %>);" value="Select" /></td>

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