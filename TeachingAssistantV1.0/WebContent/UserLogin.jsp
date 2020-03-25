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



<form action="register.php" method="post">
<input type="text" name="username" placeholder="Enter username or email"/>
<input type="password" name="password" placeholder="Enter password"/>


<input type="submit" name="q" value="Login"/>

</form>

<a href="register.php?q=signup">Sign up</a>