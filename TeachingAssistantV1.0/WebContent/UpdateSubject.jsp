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


<form action="subject" method="post">
<input type="hidden" name="subjectID" value="<%=subject.getSubjectID()%>"/>
<input type="text" name="subjectCode" placeholder="Enter Subject Code"  value="<%=subject.getSubjectCode()%>"/>
<input type="text" name="subjectName" placeholder="Enter Subject Name" value="<%=subject.getSubjectName()%>"/>
<input type="text" name="subjectDescription" placeholder="Enter Subject Description" value="<%=subject.getSubjectDescription()%>"/>
<input type="text" name="maxInstructor" placeholder="Max. No. of Instructors" value="<%=subject.getMaxInstructor()%>"/>

<input type="hidden" name="q" value="updatesubject"/>
<input type="submit" value="Update" />
<input type="reset" value="Reset" />
</form>

</body>
</html>