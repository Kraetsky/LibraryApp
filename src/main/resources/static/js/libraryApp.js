var libraryApp = angular.module('libraryApp', ["ngRoute"]);
angular.module('libraryApp').config(function($routeProvider, $locationProvider){
    $routeProvider.when('/users',{
        controller:'UsersController',
        controllerAs:'usersCtrl',
        templateUrl:'/templates/users.html'
    }).when('/books',{
        controller: 'BooksController',
        controllerAs:'booksCtrl',
        templateUrl: '/templates/books.html'
    });
    $locationProvider.html5Mode({
        enabled: true,
        requireBase: false
    });
});
