<%@  page language="java" import="com.sadden.lucene.*"
	import="sadden.wenzhai.servelet.*" import="java.util.*"
	import="sadden.wenzhai.action.*"
	contentType="text/html; charset=UTF-8 " pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
<title>show result</title>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
</head>

<body>
	<h1 class="text-center">Search Result</h1>
	<!-- this is the result table  -->
	<div class="text-center">
		<%
			if (request.getAttribute("PictureList") != null) {
				ArrayList<Picture> piclist = (ArrayList<Picture>) request.getAttribute("PictureList");
				if (!piclist.isEmpty()) {
					for (Picture pic : piclist) {

						String userId = pic.getUserId();
						String PicId = pic.getPicId();
						String Time = pic.getTime();
						String URL = pic.getURL();
						String Tag = pic.getTag();
						String Content = pic.getContent();
		%>

		<table class="table table-bordered table-hover">
			<tr class="active">
				<th class="text-center">UserID</th>
				<th class="text-center">PicId</th>
				<th class="text-center">Time</th>
				<th class="text-center">URL</th>
				<th class="text-center">Tag</th>
				<th class="text-center">Content</th>
				<th class="text-center">Delete</th>
				<th class="text-center">Update</th>
			</tr>

			<tr class="info">
				<td><%=userId%></td>
				<td><%=PicId%></td>
				<td><%=Time%></td>
				<td><%=URL%></td>
				<td><%=Tag%></td>
				<td><%=Content%></td>
				<td>
					<form action="Delete.action" method="post" class="base_form">
						<input id="PicID" type="hidden" name="PicID"
							value=<%=pic.getPicId()%> /> <input id="UserID" type="hidden"
							name="UserID" value=<%=userId%> /> <input type="submit"
							class="btn btn-danger" value="Delete" />
					</form>
				</td>
				<td>
					<form action="ToUpdate.action" method="post" class="base_form">
						<input id="PicID" type="hidden" name="PicID"
							value=<%=pic.getPicId()%> /> <input id="UserID" type="hidden"
							name="UserID" value=<%=userId%> /> <input id="Time"
							type="hidden" name="Time" value=<%=Time%> /> <input id="Tag"
							type="hidden" name="Tag" value=<%=Tag.replaceAll(" ","&nbsp;")%> /> <input id="Content"
							type="hidden" name="Content" value=<%=Content.replaceAll(" ","&nbsp;")%> /> <input
							id="URL" type="hidden" name="URL" value=<%=URL%> /> <input
							type="submit" class="btn btn-warning" value="ToUpdate"/>
					</form>
				</td>
			</tr>
			<tr>
				<img height="60%" width="60%"
					src="<%=request.getServletContext().getContextPath()+"/images/"+URL%>" />
			</tr>
			<%
					}
				%>
		</table>
	</div>
	<%
			} else {
		%>
	<h1>No result found</h1>
	<%
			}
			} else {
		%>
	<h1>No result found</h1>
	<%
}
%>


</body>
</html>