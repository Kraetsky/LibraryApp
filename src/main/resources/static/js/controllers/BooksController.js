angular.module('libraryApp')
    .controller("BooksController", function ($scope, booksService) {
        var vm = this;
        vm.booksList = [];
        vm.bookFilterModel = {
            bookAuthor: "",
            bookTitle: ""
        };

        booksService.showAll().then(function (responce) {
            vm.booksList = responce.data;
        });


    });
