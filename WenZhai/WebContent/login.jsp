<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>Welcome to So-link Abstract system</h1>
<br>
<div class="main">
    <form action="servlet/Login" method="post" class="base_form">
		<p>
			<label>账号: </label>
			<input type="text" name="phone" value="" /> 
		</p>
		<p>
			<label>密码: </label>
			<input type="password" name="password" value="" />	
		</p>
		<p> 
			<input type="submit" value="登录" />
		</p>
    </form>
</div>
</body>
</html>