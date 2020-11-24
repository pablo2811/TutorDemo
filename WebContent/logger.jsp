<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
body{
 font-family: Arial, Helvetica;
}

</style>
<meta charset="UTF-8">
<title>TutorDemo</title>
</head>
<body>
<div style="text-align:center" class="log-form">
	<h1>TutorDemo</h1>
	<form method="post" action="LoginServlet">
		<h3> Username: <input type="text" name="username" /></h3><br>
		<h3> Password: <input type="password" name="password" /></h3><br>
		<button type="submit" class="btn">Login</button><br>
		<br>
    	<a class="new" href="signup.jsp">Create account</a>
	</form>
</div>
</body>
</html>