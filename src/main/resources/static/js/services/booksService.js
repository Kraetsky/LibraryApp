angular.module('libraryApp')
    .factory("booksService", function ( $http) {
        var booksService = {};

        booksService.showAll = function () {
            return $http.get("/books/showAll");
        };

        return booksService;
    });
