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
    <div class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <a href="../" class="navbar-brand">Example</a>
          <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        </div>
        <div class="navbar-collapse collapse" id="navbar-main">
          <ul class="nav navbar-nav">
          </ul>
        </div>
      </div>
    </div>
    <div class="container">

      <div class="page-header" id="banner" style="padding-top: 20px;">
         <h1>Login Title</h1>
         <p class="lead">Login title description</p>
      </div>
      
      <div class="page-content">
        <h2>Login Form Title</h2>        
        <form name="form" role="form" action="<c:url value='/spring_auth_check'/>" method="POST">
        	<c:if test="${not empty param}">
			<div class="text-danger"><strong>
				<c:if test="${not empty param.err}">
					<div>
						<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
					</div>
				</c:if>
				<c:if test="${not empty param.out}">
					<div>You've logged out successfully.</div>
				</c:if>
				<c:if test="${not empty param.time}">
					<div>You've been logged out due to inactivity.</div>
				</c:if>
			</strong></div>
			</c:if>
			<div class="form-group">
	            <label>Username:</label>
	            <input class="form-control" type="text" name="username" value=""/>
	        </div>
	        <div class="form-group">
	        	<label>Password:</label>
	        	<input class="form-control" type="password" name="password" value=""/>
            </div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
             
            <input class="btn btn-default" value="Login" name="submit" type="submit"/>

        </form>
        
      </div>
	</div>
	<jsp:include page="template/footer.jsp"></jsp:include>
	
</body>
</html>