<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 
<title>Login</title>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
</head>
<body>
<h1 class="text-center">Welcome to So-link Abstract system</h1>
<br>
<div class="main">
    <form action="LoginAction.action" method="post" class="base_form">
		<p class="text-center">
			<label>UserID: &nbsp; &nbsp; &nbsp;</label>
			<input type="text" name="phone" placeholder="Enter your UserID" /> 
		</p>
		<p class="text-center">
			<label>Password: </label>
			<input type="password" name="password" placeholder="Enter your password"  />	
		</p>
		<p class="text-center" > 
			<input type="submit" class="btn btn-primary" value="Login" />
		</p>
    </form>
</div>
</body>
</html>