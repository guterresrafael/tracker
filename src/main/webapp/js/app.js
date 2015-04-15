'use strict';

var app = angular.module('tracker', ['ngRoute']);
        
app.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/login', {templateUrl: 'partials/login.html'});
    $routeProvider.otherwise({redirectTo: '/login'});
}]);