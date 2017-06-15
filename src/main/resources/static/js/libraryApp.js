var libraryApp = angular.module('libraryApp',  ['ui.router']);



    libraryApp.config(function($stateProvider, $urlRouterProvider, $locationProvider) {


        $stateProvider.state('users', {

            url: '/users',
            controller: 'UsersController',
            controllerAs: 'usersCtrl',
            templateUrl: '/templates/users.html'
        }).state('books', {

            url: '/books',
            controller: 'BooksController',
            controllerAs: 'booksCtrl',
            templateUrl: '/templates/books.html'

        });

        $locationProvider.html5Mode({
            enabled: true,
            requireBase: false
        });

    });






/* $locationProvider.html5Mode({
 enabled: true,
 requireBase: false
 });*/

/*angular.module('libraryApp').config(function($routeProvider, $locationProvider){
 $routeProvider.when('/users',{
 controller:'UsersController',
 controllerAs:'usersCtrl',
 templateUrl:'/templates/users.html'
 }).when('/books',{
 controller: 'BooksController',
 controllerAs:'booksCtrl',
 templateUrl: '/templates/books.html'
 });*/