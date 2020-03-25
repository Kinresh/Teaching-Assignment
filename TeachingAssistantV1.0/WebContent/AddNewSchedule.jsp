<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Schedule</title>
</head>
<body>

<form action="schedule" method="post">
<input type="text" name="scheduleName" placeholder="Enter Schedule Name"/>
<select name="year">
<option value="0">Select Year</option>
<option value="2020">2020</option>
<option value="2021">2021</option>
<option value="2022">2022</option>
<option value="2023">2023</option>
<option value="2024">2024</option>
<option value="2025">2025</option>
<option value="2026">2026</option>
<option value="2027">2027</option>
<option value="2028">2028</option>
<option value="2029">2029</option>
<option value="2030">2030</option>
</select>

<input type="hidden" name="q" value="addnewschedule"/>
<input type="submit" value="Create Schedule" />
<input type="reset" value="Reset" />
</form>

</body>
</html>