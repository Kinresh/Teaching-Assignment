<%@page import="java.util.ArrayList"%>
<%@page import="com.abc.model.UserDetailsModel"%>
<%@page import="java.util.List"%>
<script type="text/javascript">

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
List<UserDetailsModel> users = null;
users =(ArrayList) request.getAttribute("users");
%>
<input type="button" onclick="deleteSelected()" value="Delete Selected" />
<table border="1">
<tr>

<th>CHECKBOX</th>

<th>SR NO.</th>

<th>FULLNAME</th>

<th>EMAIL-ID</th>

<th>CONTACT</th>

<th>DOB</th>

<th>ROLE</th>

<th>ACTION</th>

</tr>
<%
if(users != null)
{
for(int k = 0;k<users.size();k++)
{
%>
<tr>

<td><input type="checkbox" name="select" value="<%= users.get(k).getUserID() %>"/></td>

<td><%=i%></td>

<td><%=users.get(k).getUserName()%></td>

<td><%=users.get(k).getUserEmail()%></td>

<td><%=users.get(k).getUserContact()%></td>

<td><%=users.get(k).getUserDob()%></td>

<td><%=users.get(k).getUserRole()%></td>

<%
if(users.get(k).getActive() == 1)
{
%>
<td>
<input type="button" onclick="permanentDeleteAccount(<%=users.get(k).getUserID() %>)" value="Delete" />
<input type="button" onclick="disableAccount(<%=users.get(k).getUserID() %>)" value="Disable" />
<input type="button" onclick="updateAccount(<%=users.get(k).getUserID() %>)" value="Update" />
</td>
<%
}
else
{
%>
<td style="background: red;">
<input type="button" onclick="permanentDeleteAccount(<%=users.get(k).getUserID() %>)" value="Delete" />
<input type="button" onclick="enableAccount(<%=users.get(k).getUserID() %>)" value="Enable" />
<input type="button" onclick="updateAccount(<%=users.get(k).getUserID() %>)" value="Update" />
</td>
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