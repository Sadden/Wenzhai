<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<h1>Welcome to So-link Abstract system</h1>
<br>
<div class="main">
	<h1>添加成功</h1>
    <form action="ToAddAction.action" method="post" class="base_form">
    <p>
    <label> 继续添加图片</label>
    <input type="submit" value="add"/>
    </p>
    </form>
    <form action="admin_index.jsp" method="post" class="base_form">
    <p>
    <label> 返回搜索按钮</label>
    <input type="submit" value="return"/>
    </p>
    </form>
    
    
</div>
</body>
</html>