<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="javax.servlet.jsp.PageContext" %>
<!DOCTYPE html>
<html ng-app="bookApp">
<head>
    <title>Example</title>
    <link rel="stylesheet" href="/static/styles/bootstrap.css" media="screen">
    <link rel="stylesheet" href="/static/styles/main.css" media="screen">
</head>
     
<body>
	<jsp:include page="template/menu.jsp"></jsp:include>
    <div class="container" ng-controller="BookController">

      <div class="page-header" id="banner" style="padding-top: 20px;">
         <h1>Welcome ${pageContext.request.userPrincipal.name} in Books</h1>
         <p class="lead">${message}</p>
      </div>
      
      <div class="page-content">
      
    <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#saveBookModal" ng-click="clear()">
        <span class="glyphicon glyphicon-flash"></span> Create a new Book
    </button>
    <div class="modal fade" id="saveBookModal" tabindex="-1" role="dialog" aria-labelledby="myBookLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form name="form" role="form" novalidate
                      class="ng-scope ng-invalid ng-invalid-required ng-dirty ng-valid-minlength"
                      ng-submit="create()">

                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"
                                ng-click="clear()">&times;</button>
                        <h4 class="modal-title" id="myBookLabel">Create or edit a Book</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label>ID</label>
                            <input type="text" class="form-control" name="id"
                                   ng-model="book.id" readonly>
                        </div>

                        <div class="form-group">
                            <label>Name</label>
                            <input type="text" class="form-control"
                                   ng-model="book.name">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal" ng-click="clear()">
                            <span class="glyphicon glyphicon-ban-circle"></span> Cancel
                        </button>
                        <button type="submit" ng-disabled="form.$invalid" class="btn btn-primary">
                            <span class="glyphicon glyphicon-save"></span> Save
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                </tr>
            </thead>
            <tbody>
                <tr ng-repeat="book in books">
                    <td>{{book.id}}</td>
                    <td>{{book.name}}</td>
                    <td>
                        <button type="submit"
                                ng-click="update(book.id)"
                                class="btn btn-default">
                            <span class="glyphicon glyphicon-pencil"></span> Edit
                        </button>
                        <button type="submit"
                                ng-click="delete(book.id)"
                                class="btn btn-danger">
                            <span class="glyphicon glyphicon-remove-circle"></span> Delete
                        </button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
		 
      </div>
	</div>
	
	<jsp:include page="template/footer.jsp"></jsp:include>
	<script src="/static/controller_book.js"></script>

</body>
</html>
