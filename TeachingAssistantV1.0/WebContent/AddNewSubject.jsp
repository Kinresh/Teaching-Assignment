<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Subject</title>
</head>
<body>

<form action="subject" method="post">
<input type="text" name="subjectCode" placeholder="Enter Subject Code"/>
<input type="text" name="subjectName" placeholder="Enter Subject Name"/>
<input type="text" name="subjectDescription" placeholder="Enter Subject Description"/>
<input type="text" name="maxInstructor" placeholder="Max. No. of Instructors"/>

<input type="hidden" name="q" value="addnewsubject"/>
<input type="submit" value="Add Subject" />
<input type="reset" value="Reset" />
</form>

</body>
</html>