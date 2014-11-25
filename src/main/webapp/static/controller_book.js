'use strict';

var bookApp = angular.module('bookApp',['ngResource']);

bookApp.factory('Book', function ($resource) {
    return $resource('app/rest/books/:id', {}, {
        'query': { method: 'GET', isArray: true},
        'get': { method: 'GET'}
    });
});

bookApp.controller('BookController', function ($scope, Book) {
		Book.query(function(data) {
			$scope.books = data;
		});
        $scope.create = function () {
            Book.save($scope.book,
                function () {
                    $scope.books = Book.query();
                    $('#saveBookModal').modal('hide');
                    $scope.clear();
                });
        };

        $scope.update = function (id) {
            $scope.book = Book.get({id: id});
            $('#saveBookModal').modal('show');
        };

        $scope.delete = function (id) {
            Book.delete({id: id},
                function () {
                    $scope.books = Book.query();
                });
        };

        $scope.clear = function () {
            $scope.book = {name: null, id: null};
        };
    });
