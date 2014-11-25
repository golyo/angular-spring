<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
          <c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
          	<li><a href="/adminBook">Admin Books</a></li>
          </c:if>
          <c:if test="${pageContext.request.isUserInRole('ROLE_DBA')}">
            <li><a href="/dbaBook">Dba Books</a></li>
          </c:if>
          </ul>
          
          <ul class="nav navbar-nav navbar-right">
		       <c:choose>
		            <c:when test="${not empty pageContext.request.userPrincipal}">
		                <li><a href="/logout">Logout</a></li>
		            </c:when>
		            <c:otherwise>
		                <li><a href="/login">Login</a></li>
		            </c:otherwise>
		        </c:choose>
                    
            
          </ul>
          
        </div>
      </div>
    </div>

