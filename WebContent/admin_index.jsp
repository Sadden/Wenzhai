<%@  page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Administer sadden online</title>
</head>
<body>
<h1> admin search </h1>
<div class="main">
    <form action="SearchAction.action" method="post" class="base_form">
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
    <form action="SearchAction_Content.action" method="post" class="base_form">
		<p>
			<label>搜索Content：</label>
			<input type="text" name="Content" value="" /> 
		</p>
		
		<p> 
			<input type="submit" value="确定" />
		</p>
    </form>
    <form action="ToAddAction.action" method="post" class="base_form">
    <p>
    <label> 增加图片文摘（建立新的索引）</label>
    <input type="submit" value="add"/>
    
    </p>
    </form>
    
    
    
</div>
</body>
</html>