<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>My JSP 'upload.jsp' starting page</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</head>
<body>
	<!-- ${pageContext.request.contextPath}/upload/execute_upload.do -->
	<!-- ${pageContext.request.contextPath}/upload2/upload2.do -->
	<form action="Upload_test.action" method="post"
		enctype="multipart/form-data" >
		请选择上传的图片或文件:<input type="file" name="image" /> <input
			type="submit" value="上传" />
	</form>
	<br />
	<s:fielderror />
</body>
</html>