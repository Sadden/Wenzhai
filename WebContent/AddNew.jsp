<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>欢迎来到创建检索系统，请配合我们的工作：</h1>
	<div class="main">
	<h2>输入新建图片的参数</h2>
		<form action="AddAction.action" method="post" class="base_form">
			

			<p>
				<label>UserID：</label> <input type="text" name="UserID" value="" />
			</p>
						<p>
				<label>PicID：</label> <input type="text" name="PicID" value="" />
			</p>
			<p>
				<label>Time：</label> <input type="text" name="Time" value="" />
			</p>
						<p>
				<label>URL：</label> <input type="text" name="URL" value="" />
			</p>
						<p>
				<label>Tag：</label> <input type="text" name="Tag" value="" />
			</p>
			<p>
				<input type="submit" value="确定" />
			</p>
		</form>

	</div>
</body>
</html>