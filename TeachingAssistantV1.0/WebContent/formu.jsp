<%@page import="com.abc.model.userModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.abc.model.countryModel"%>
<%@page import="com.abc.model.hobbieModel"%>

<%
userModel lm = (userModel) request.getAttribute("li");
%>

<%@page import="java.util.List"%>
<form action="insert.php" method="post">
<input type="hidden" value="<%=lm.getId()%>" name="hid" /> 
<input type="text" value="<%=lm.getFname() %>" name="fname" placeholder="Enter name"/>
<input type="text" value="<%=lm.getNumber() %>" name="number" placeholder="Enter number"/>

<input type="text" value="<%=lm.getBdate()%>" name="bdate" placeholder="Enter birthdate"/>
<%-- 
<textarea><%=lm.getFname() %></textarea> --%>

<input type="radio" <% if(lm.getGender().equals("male")){ %> checked="checked" <%} %> name="gender" value="male"/>Male
<input type="radio" <% if(lm.getGender().equals("female")){ %> checked="checked" <%} %> name="gender" value="female"/>Female
<input type="radio" <% if(lm.getGender().equals("others")){ %> checked="checked" <%} %> name="gender" value="others"/>Others

<input type="hidden" name="action" value="uu" />


<% 
List<String> bv = (ArrayList)request.getAttribute("liq");
List<hobbieModel> lmy = null;
lmy = (ArrayList) request.getAttribute("list2");
if(lmy!=null)
{
	for(int k = 0 ; k<lmy.size() ; k++)
	{
		int ik = 0;
		for(int n= 0;n<bv.size();n++)
		{
			if(bv.get(n).equals(lmy.get(k).getHname()))
			{
%>
<input type="checkbox" checked="checked" name="hob" value="<%=lmy.get(k).getHname()%>"/><%=lmy.get(k).getHname()%>
<% 
              ik = 1;
			}
		}
		if(ik == 0)
		{
			%>
			<input type="checkbox" name="hob" value="<%=lmy.get(k).getHname()%>"/><%=lmy.get(k).getHname()%>
			<%			
		}
	}
}
%>

<select name="cid">
<option value="">select country</option>
<%

out.print("ss=="+lm.getCid());

List<countryModel> l = null;
l =(ArrayList) request.getAttribute("kin");
if(l != null)
{
for(int k = 0;k<l.size();k++)
{
%>
<option  <% if(lm.getCid() == l.get(k).getCid()){ %> selected="selected" <%} %>  value="<%=l.get(k).getCid()%>"><%=l.get(k).getCname()%></option>
<%
}
}
%>
</select>



<input type="submit" value="Update"/>
<input type="reset" value="cancel"/>

</form>