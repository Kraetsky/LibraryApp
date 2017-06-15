angular.module('libraryApp')
    .controller("UsersController", function ($scope, usersService) {
        var vm = this;
        vm.usersList = [];

        usersService.showAll().then(function (responce) {
            vm.usersList = responce.data;
        });


    });