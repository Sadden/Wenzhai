<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
 <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<title>Add a new Picture</title>
</head>
<body>
	<!-- ${pageContext.request.contextPath}/upload/execute_upload.do -->
	<!-- ${pageContext.request.contextPath}/upload2/upload2.do -->
	<div align="center">
	<h2>Upload the Picture </h2>
		<form action="AddAction.action" enctype="multipart/form-data" method="post" >
			<p>
				<label>UserID：</label> <input type="text" name="UserID"  />
			</p>
			<p>
				<input type="file"  class="btn btn-prime"name="image" /> 
			</p>
			<p>
				<label>Tag：</label> <input type="text" name="Tag" value="" />
			</p>
			<p>
				<input type="submit" class="btn btn-info" value="Generate Content" />
			</p>
		</form>

	</div>
</body>
</html>