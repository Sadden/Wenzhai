<%@ page language="java" 

import="andrew.retrieve.structure.*" import="java.util.*"
contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
<title>retrieve result</title>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
</head>	
<body>
<h1 class="text-center">Search Result</h1>
	<!-- this is the result table  -->
	<div class="text-center">
		<%
			if (request.getAttribute("ResultList") != null) {
				List<Paper> list = (List<Paper>) request.getAttribute("ResultList");
				if (!list.isEmpty()) {
					for (Paper p : list) {

						String title = p.title;
						String authors = p.authors;
						String subject = p.subject;
						String URL = p.url;
						String description = p.description;
		%>

		<table class="table table-bordered table-hover">
			<tr class="active">
			<h3><a href=<%=URL %>><%=title %></a> </h3>
			<p>
			<h3><%=description %></h3>
			</p>
			<p>
			<h3><%=authors %></h3>
			</p>
			<p>
			<h3><%=subject %></h3>
			</p>

			
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
	<h1 class="text-center">No result found</h1>
	<%
}
%>

</body>
</html>