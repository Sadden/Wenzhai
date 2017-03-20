<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<title>OCR new Content</title>
</head>
<body>
	<!-- ${pageContext.request.contextPath}/upload/execute_upload.do -->
	<!-- ${pageContext.request.contextPath}/upload2/upload2.do -->
	<h1>欢迎来到创建检索系统，请配合我们的工作：</h1>
	<div class="main">
	<h2>输入新建图片的参数</h2>
		<form action="AddAction.action" enctype="multipart/form-data" method="post" >
			

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
				<label>Upload Picture：</label> 
						<input type="file" name="image" /> 
			</p>
						<p>
				<label>Tag：</label> <input type="text" name="Tag" value="" />
			</p>
			<p>
				<input type="submit" value="Generate Content" />
			</p>
		</form>

	</div>
</body>
</html>