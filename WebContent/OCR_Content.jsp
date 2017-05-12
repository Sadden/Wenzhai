<%@ page language="java" contentType="text/html; charset=UTF-8"
import="com.sadden.lucene.*"
	import="sadden.wenzhai.servelet.*" import="java.util.*"
	import="sadden.wenzhai.action.*"
	import="java.io.File.*" import="java.util.Map.*"
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
<title>View the content</title>
</head>
<body>
	<!-- ${pageContext.request.contextPath}/upload/execute_upload.do -->
	<!-- ${pageContext.request.contextPath}/upload2/upload2.do -->
	<div class="main" align="center">
	<%if(request.getAttribute("Picture")!=null && request.getAttribute("TagList")!=null){
		Picture pic=(Picture)request.getAttribute("Picture");
		String TagList = (String)request.getAttribute("TagList");
		if(pic!=null)
		{
			
			 String userId = pic.getUserId();
				String PicId = pic.getPicId();
				String Time = pic.getTime();
				String URL = pic.getURL();
				String Tag = pic.getTag();
				String Content = pic.getContent();
			%>
			<h2>Check below:</h2>
		<form class="text-center" action="DoOCR.action" enctype="multipart/form-data" method="post" >
			<img src="<%=request.getServletContext().getContextPath()+"/images/"+URL%>" style="margin-right: auto;margin-left:auto" width="200px" height="200px">
			<h4>Content:<%=Content %></h4>
			<br>
			<font size=8>Auto Tag is: <%=TagList %></font>
			<br>
			<table class="table table-bordered table-hover">
				<tr>
					<th class="text-center">UserID</th>
					<th class="text-center">PicId</th>
					<th class="text-center">Time</th>
					<th class="text-center">URL</th>
					<th class="text-center">Tag</th>
				</tr>
				<tr>
					<td><%=userId %></td>
					<td><%=PicId %></td>
					<td><%=Time %></td>
					<td><%=URL %></td>
					<td><%=Tag %></td>
				</tr>
				</table>
			 <input type="submit" class="btn btn-success"value="Confirm"/>
		</form>
			<% 
		}
	}
	%>
	

	</div>
</body>
</html>