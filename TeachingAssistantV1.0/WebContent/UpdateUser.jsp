<%@page import="java.util.ArrayList"%>
<%@page import="com.abc.model.UserDetailsModel"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Account Details</title>
</head>
<body>

<%
UserDetailsModel user = (UserDetailsModel) request.getAttribute("user");
%>


<form action="register.php" method="post">
<input type="hidden" name="q" value="updateaccount">
<input type="hidden" name="userid" value="<%=user.getUserID()%>">

<input type="text" name="username" placeholder="Enter Username" value="<%=user.getUserName()%>"/>
<input type="text" name="emailID" placeholder="Enter EmailID" value="<%=user.getUserEmail()%>"/>
<input type="text" name="contact" placeholder="Enter Phone Number" value="<%=user.getUserContact()%>"/>

<select name="role">
<option value="">Select Role</option>
<option  <% if(user.getUserRole().equals("faculty")){ %> selected="selected" <%} %>  value="faculty">faculty</option>
<option <% if(user.getUserRole().equals("admin")){ %> selected="selected" <%} %> value="admin">admin</option>
</select>

<input type="submit" value="Submit" />
<input type="reset" value="Reset" />
</form>

</body>
</html>