<%

response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setHeader("Expires", "0");

if(session.getAttribute("name") != null)
{
	response.sendRedirect("papa.php?a=0");
}
if(session.getAttribute("msg") != null)
{
	%>
	<h1 style="color: red;"><%=session.getAttribute("msg") %></h1>
	<% 
	session.removeAttribute("msg");
	session.invalidate();
}

%>



<form action="insert.php" method="post">

<input type="text" name="fname" placeholder="Enter username"/>
<input type="password" name="number" placeholder="Enter password"/>


<input type="submit" name="action" value="Login"/>

</form>