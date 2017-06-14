angular.module('libraryApp')
    .controller("BooksController", function ($scope, booksService) {
        var vm = this;
        vm.booksList = [];
        booksService.showAll().then(function (responce) {
            vm.booksList = responce.data;
        });


    });
