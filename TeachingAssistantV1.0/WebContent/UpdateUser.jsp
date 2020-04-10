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

<header class="head">
	<div class="main-bar">
    	<div class="row no-gutters">
        	<div class="col-6">
            	<h4 class="m-t-5">
                	<i class="fa fa-home"></i>
                    	Update User Details
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
<form action="register.php" method="post">
<input type="hidden" name="q" value="updateaccount">
<input type="hidden" name="userid" value="<%=user.getUserID()%>">

Name:
<input type="text" name="username" class="widthc1 form-control" placeholder="Enter Username" value="<%=user.getUserName()%>"/>
<div class="spacec1"></div>
Email:
<input type="text" name="emailID" class="widthc1 form-control" placeholder="Enter EmailID" value="<%=user.getUserEmail()%>"/>
<br>

Ph.No:
<input type="text" name="contact" class="widthc1 form-control" placeholder="Enter Phone Number" value="<%=user.getUserContact()%>"/>
<div class="spacec1"></div>
Role:
<select name="role" class="form-control selectc1" style="margin-left: 13px;">
<option value="">Select Role</option>
<option  <% if(user.getUserRole().equals("faculty")){ %> selected="selected" <%} %>  value="faculty">faculty</option>
<option <% if(user.getUserRole().equals("admin")){ %> selected="selected" <%} %> value="admin">admin</option>
</select>

<br>
<br>
<input type="submit" class="btn btn-success" value="Submit" />
<input type="reset" class="btn btn-light" value="Reset" />
</form>


						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>