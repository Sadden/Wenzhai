<%@  page language="java" import="com.sadden.lucene.*"
	import="sadden.wenzhai.servelet.*" import="java.util.*"
	import="sadden.wenzhai.action.*"
contentType="text/html; charset=UTF-8 "
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Administer sadden online</title>
</head>

<body>
	<h1>admin search result</h1>
	<!-- this is the result table  -->
	<div class="main">
<%if(request.getAttribute("PictureList")!=null){
		ArrayList<Picture> piclist=(ArrayList<Picture>)request.getAttribute("PictureList");
		if(!piclist.isEmpty()){
			for(Picture pic:piclist){		
	%><div>
			<table class="base_table">
				<tr>
					<th>UserID</th>
					<th>PicId</th>
					<th>Time</th>
					<th>URL</th>
					<th>Tag</th>
					<th>Content</th>
				</tr>
				<%
			 String userId = pic.getUserId();
				String PicId = pic.getPicId();
				String Time = pic.getTime();
				String URL = pic.getURL();
				String Tag = pic.getTag();
				String Content = pic.getContent();
			%>
				<tr>
					<td><%=userId %></td>
					<td><%=PicId %></td>
					<td><%=Time %></td>
					<td><%=URL %></td>
					<td><%=Tag %></td>
					<td><%=Content %></td>
				</tr>
				
				<img src="<%=URL%>">
				<%
			}
			%>
			</table>
		</div>
<%
}else{
	%>
	<h1> No result found</h1>
	<%
		}
	}
else{
	%>
	<h1> No result found</h1>
	<%
}
%>
	</div>

</body>
</html>