'use strict';
/* 
 * Rotas devem ser definidas neste arquivo
 */
var app = angular.module("routes", [
    'ngRoute',
    'ngResource'
]);

app.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/', {templateUrl: 'partials/login.html', controller: 'LoginController'});
        $routeProvider.when('/login', {templateUrl: 'partials/login.html', controller: 'LoginController'});
        $routeProvider.when('/home', {templateUrl: 'partials/home.html', controller: 'HomeController as data'});
        $routeProvider.otherwise({redirectTo: '/login'});
    }]);


