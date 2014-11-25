<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="javax.servlet.jsp.PageContext" %>
<!DOCTYPE html>
<html>
<head>
    <title>Example</title>
    <link rel="stylesheet" href="static/styles/bootstrap.css" media="screen">
    <link rel="stylesheet" href="static/styles/main.css" media="screen">
</head>
     
<body>
	<jsp:include page="template/menu.jsp"></jsp:include>
    <div class="container">

      <div class="page-header" id="banner" style="padding-top: 20px;">
         <h1>Welcome Title</h1>
         <p class="lead">Welcome title description</p>
      </div>
      
      <div class="page-content">
        <h2>Welcome Content Title</h2>        
      </div>
	</div>
	<jsp:include page="template/footer.jsp"></jsp:include>
	
</body>
</html>