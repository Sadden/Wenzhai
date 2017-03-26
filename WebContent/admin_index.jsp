<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<title>Search online</title>
</head>
<body>
	<h1 class="text-center">Index Search</h1>
	<div class="text-center">
		<form action="SearchAction.action" method="post" class="base_form">
			<p>
				<label>搜索tag：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input type="text" name="tag" />
				<input type="submit" class="btn btn-info" value="Search" />
			</p>
		</form>
		<form action="SearchAction_Content.action" method="post"class="base_form">
			<p>
				<label>搜索Content：</label> <input type="text" name="Content" />
				<input type="submit" class="btn btn-info" value="Search" />
			</p>
		</form>
		<form action="SearchAction_UserID.action" method="post" class="base_form">
			<p>
				<label>搜索UserID：&nbsp;&nbsp;</label> <input type="text" name="UserID" />
				<input type="submit" class="btn btn-info" value="Search" />
			</p>
		</form>
		<form action="ToAddAction.action" method="post" class="base_form">
			<p>
				<label> 增加图片文摘（建立新的索引）</label> <input type="submit" class="btn btn-success" value="Add" />
			</p>
		</form>



	</div>
</body>
</html>