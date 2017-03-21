<%@ page language="java" contentType="text/html; charset=UTF-8"
import="com.sadden.lucene.*"
	import="sadden.wenzhai.servelet.*" import="java.util.*"
	import="sadden.wenzhai.action.*"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<title>View the content</title>
</head>
<body>
	<!-- ${pageContext.request.contextPath}/upload/execute_upload.do -->
	<!-- ${pageContext.request.contextPath}/upload2/upload2.do -->
	<h1>now will do ocr to generate content：</h1>
	<div class="main">
	<%if(request.getAttribute("ViewPicture")!=null){
		Picture pic=(Picture)request.getAttribute("ViewPicture");
		if(pic!=null)
		{
			
			 String userId = pic.getUserId();
				String PicId = pic.getPicId();
				String Time = pic.getTime();
				String URL = pic.getURL();
				String Tag = pic.getTag();
				String Content = pic.getContent();
			%>
			<h2>look below</h2>
		<form action="DoOCR.action" enctype="multipart/form-data" method="post" >
			<label>View Picture </label>
			<img src="<%=URL%>">
			<h1><%=Content %></h1>
			<input type="text" name="Content" value=<%=Content %> />
			<table class="base_table">
				<tr>
					<th>UserID</th>
					<th>PicId</th>
					<th>Time</th>
					<th>URL</th>
					<th>Tag</th>
				</tr>
				<tr>
					<td><%=userId %></td>
					<td><%=PicId %></td>
					<td><%=Time %></td>
					<td><%=URL %></td>
					<td><%=Tag %></td>
				</tr>
				</table>
			 <input type="submit" value="Confirm"/>
		</form>
			<% 
		}
	}
	%>
	

	</div>
</body>
</html>