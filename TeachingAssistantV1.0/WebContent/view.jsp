<%@page import="java.util.ArrayList"%>
<%@page import="com.abc.model.userModel"%>
<%@page import="java.util.List"%>
<script type="text/javascript">

function abcfcb(ghhh)
{
	if(confirm("kharekahr delete karvu 6??"))
		{
		window.location.href="insert.php?a=1&id="+ghhh;
		}
}
function abcdfcb(ghhh)
{
	if(confirm("kharekahr bivadavo 6??"))
		{
		window.location.href="insert.php?a=2&id="+ghhh;
		}
}
function permission()
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
		if(confirm("Multiple delete karvu 6??"))
			{
			window.location.href="insert.php?a=4&b="+u;
			}
		}
	else
		alert("select first...");
}
</script>
<%
int i = 1;
List<userModel> l = null;
l =(ArrayList) request.getAttribute("list");
%>
<input type="button" onclick="permission()" value="Delete All" />
<table border="1">
<tr>

<th>CHECKBOX</th>

<th>SR NO.</th>

<th>FULLNAME</th>

<th>NUMBER</th>

<th>GENDER</th>

<th>HOBBIES</th>

<th>ACTION</th>

</tr>
<%
if(l != null)
{
for(int k = 0;k<l.size();k++)
{
%>
<tr>

<td><input type="checkbox" name="select" value="<%=l.get(k).getId() %>"/></td>

<td><%=i%></td>

<td><%=l.get(k).getFname()%></td>

<td><%=l.get(k).getNumber()%></td>

<td><%=l.get(k).getGender()%></td>

<td>
<%
String[] j = l.get(k).getHob().split(",");
for(String n:j)
{
%>
<%=n%>
<br/>
<%
}
%>
</td>

<%
if(l.get(k).getActive_flag() == 0)
{
%>
<td><input type="button" onclick="abcfcb(<%=l.get(k).getId() %>)" value="delete" /></td>
<%
}
else
{
%>
<td style="background: red;">
<input type="button" onclick="abcfcb(<%=l.get(k).getId() %>)" value="delete" />
<input type="button" onclick="abcdfcb(<%=l.get(k).getId() %>)" value="retrive" />
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