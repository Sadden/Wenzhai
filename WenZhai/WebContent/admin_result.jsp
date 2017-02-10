<%@  page language="java" import="com.sadden.lucene.*"
	import="sadden.wenzhai.servelet.*" import="java.util.*"
contentType="text/html; charset=UTF-8 "
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
				</tr>
				<%
			 String userId = pic.getUserId();
				String PicId = pic.getPicId();
				String Time = pic.getTime();
				String URL = pic.getURL();
				String Tag = pic.getTag();
			%>
				<tr>
					<td><%=userId %></td>
					<td><%=PicId %></td>
					<td><%=Time %></td>
					<td><%=URL %></td>
					<td><%=Tag %></td>
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