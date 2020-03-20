<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Program</title>
</head>
<body>

<form action="subject" method="post">
<input type="text" name="programName" placeholder="Enter Program Name"/>
<input type="text" name="totalTerms" placeholder="Enter Total Terms"/>
<input type="checkbox" name="offeredterm" value="winter"/>Winter
<input type="checkbox" name="offeredterm" value="summer"/>Summer
<input type="checkbox" name="offeredterm" value="fall"/>Fall

<input type="hidden" name="q" value="addnewprogram"/>
<input type="submit" value="Add Program" />
<input type="reset" value="Reset" />
</form>

</body>
</html>