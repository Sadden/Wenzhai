<%@  page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administer sadden online</title>
</head>
<body>
<h1> admin search </h1>
<div class="main">
    <form action="servlet/search_tag" method="post" class="base_form">
		<p>
			<label>搜索tag：</label>
			<input type="text" name="tag" value="" /> 
		</p>
		
		<p> 
			<input type="submit" value="确定" />
		</p>
    </form>
    <%
    String TagContent=request.getParameter("tag");
    if(TagContent==null)
    {
    	TagContent="0";
    }   
    %>
    
    
    
</div>
</body>
</html>