<%@page import="java.util.ArrayList"%>
<%@page import="com.abc.model.SubjectModel"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Subject Details</title>
</head>
<body>

<%
SubjectModel subject = (SubjectModel) request.getAttribute("subject");
%>

<header class="head">
	<div class="main-bar">
    	<div class="row no-gutters">
        	<div class="col-6">
            	<h4 class="m-t-5">
                	<i class="fa fa-home"></i>
                    	Update Subject Details
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

<form action="subject" method="post">
<input type="hidden" name="subjectID" value="<%=subject.getSubjectID()%>"/>
Subject Code:
<input type="text" name="subjectCode" class="form-control widthc1" placeholder="Enter Subject Code"  value="<%=subject.getSubjectCode()%>"/>
Subject Name:
<input type="text" name="subjectName" class="form-control widthc1" placeholder="Enter Subject Name" value="<%=subject.getSubjectName()%>"/>
<br>
Description:
<input type="text" name="subjectDescription" class="form-control widthc1" style="margin-left:17px;" placeholder="Enter Subject Description" value="<%=subject.getSubjectDescription()%>"/>
Instructors:
<input type="text" name="maxInstructor" class="form-control widthc1" style="margin-left:25px;" placeholder="Max. No. of Instructors" value="<%=subject.getMaxInstructor()%>"/>
<br>
<br>
<input type="hidden" name="q" value="updatesubject"/>
<input type="submit" class="btn btn-success" value="Update" />
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