<%@page import="java.util.ArrayList"%>
<%@page import="com.abc.model.countryModel"%>
<%@page import="com.abc.model.hobbieModel"%>

<%@page import="java.util.List"%>
<form action="insert.php" method="post">

<input type="text" name="fname" placeholder="Enter name"/>
<input type="text" name="number" placeholder="Enter number"/>

<input type="text" name="bdate" placeholder="Enter birthdate"/>


<input type="radio" name="gender" value="male"/>Male
<input type="radio" name="gender" value="female"/>Female

<input type="hidden" name="action" value="a" />


<% 
List<hobbieModel> lmy = null;
lmy = (ArrayList) request.getAttribute("list2");
if(lmy!=null)
{
	for(int k = 0 ; k<lmy.size() ; k++)
	{
%>
<input type="checkbox" name="hob" value="<%=lmy.get(k).getHname()%>"/><%=lmy.get(k).getHname()%>
<%
	}
}
%>

<select name="cid">
<option value="">select country</option>
<%
List<countryModel> l = null;
l =(ArrayList) request.getAttribute("kin");
if(l != null)
{
for(int k = 0;k<l.size();k++)
{
%>
<option value="<%=l.get(k).getCid()%>"><%=l.get(k).getCname()%></option>
<%
}
}
%>
</select>



<input type="submit" value="Add"/>
<input type="reset" value="cancel"/>

</form>