angular.module('libraryApp')
    .factory("usersService", function ( $http) {
        var usersService = {};

        usersService.showAll = function () {
            return $http.get("/users/showAll");
        };

        return usersService;
    });