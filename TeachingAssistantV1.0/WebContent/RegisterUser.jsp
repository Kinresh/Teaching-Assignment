<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register/Sign-Up</title>
</head>
<body>

<form action="register.php" method="post">
<input type="text" name="username" placeholder="Enter Username"/>
<input type="text" name="emailID" placeholder="Enter EmailID"/>
<input type="text" name="contact" placeholder="Enter Phone Number"/>
<input type="radio" name="gender" value="male" />Male
<input type="radio" name="gender" value="female" />Female
<select name="country">
<option value="">Select Country</option>
<option value="Canada">Canada</option>
<option value="USA">USA</option>
<option value="Australia">Australia</option>
<option value="India">India</option>
<option value="spain">Spain</option>
</select>
<input type="password" name="password" placeholder="Enter Password"/>
<input type="password" name="confirmPassword" placeholder="Confirm Password"/>

<input type="submit" name="q" value="SignUp" />
<input type="reset" value="Reset" />
</form>

</body>
</html>