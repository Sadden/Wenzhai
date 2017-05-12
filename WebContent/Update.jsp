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
 <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<title>Update Picture</title>
</head>
<body>
	<!-- ${pageContext.request.contextPath}/upload/execute_upload.do -->
	<!-- ${pageContext.request.contextPath}/upload2/upload2.do -->
	<div class="main" align="center">
	<h2>Update below</h2>
	<%if(request.getAttribute("Picture")!=null){
		Picture pic =(Picture)request.getAttribute("Picture");
		String UserID = pic.getUserId();
		String PicID = pic.getPicId();
		String Time = pic.getTime();
		String URL = pic.getURL();
		String Content = pic.getContent();
		String Tag = pic.getTag();
			%>
		<form action="Update.action" enctype="multipart/form-data" method="post" >
			<p>
				<label>UserID：</label> <%=UserID %>
				<input id="UserID" type="hidden" name="UserID" value=<%=UserID%>/>
			</p>
			<p>
				<label>PicID：</label> <%=PicID %>
				<input id="PicID" type="hidden" name="PicID" value=<%=PicID%>/>
			</p>
			<p>
				<label>Time：</label> <%=Time %>
				<input id="Time" type="hidden" name="Time" value=<%=Time%>/>
			</p>
			<p>
				<label>Tag：</label>  <input type="text" name="Tag" value=<%=Tag %> />
			</p>
			<p>
				<img src="<%=request.getServletContext().getContextPath()+"/images/"+URL%>" style="margin-right: auto;margin-left:auto" width="30%" height="30%">				
				<input id="URL" type="hidden" name="URL" value=<%=URL%>/>
			</p>

			<p>
				<%--  <input type="text" name="Content" value=<%=Content %> /> --%>
				 <textarea class="form-control" rows="3" name="Content" ><%=Content %></textarea>
			</p>
			
			<p>
				 <input type="submit" class="btn btn-info" value="OK" />
			</p>
			
		</form>
		
		
		<form action="Delete.action" method="post" class="base_form">
			<input id="PicID" type="hidden" name="PicID" value=<%=PicID%> /> 	
			<input type="submit"class="btn btn-danger" value="Delete" />
		</form>
		<%
	}
		%>

	</div>
</body>
</html>