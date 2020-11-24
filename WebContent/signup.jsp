<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
body{
 font-family: Arial, Helvetica;;
}



</style>
<meta charset="UTF-8">
<title>TutorDemo</title>
</head>
<body>
<div style="text-align:center" class="log-form">
	<h1>Sign up</h1>
	<form method="post" action="SingupServlet">
		<h4> Username: <input type="text" name="username" /></h4>
		<h4> Password: <input type="password" name="password" /></h4>
		<h4> Repeat password: <input type="password" name="password2" /></h4>
		<select name="gender">
                    <option value="MALE">MALE</option>
                    <option value="FEMALE">FEMALE</option>
                    <option value="NONBINARY">NONBINARY</option>
            </select>
		<h4> Age: <input type="number" name="age"/></h4>
		<button type="submit" class="btn">Sign up</button>
		<br>
	</form>
</div>
</body>
</html>