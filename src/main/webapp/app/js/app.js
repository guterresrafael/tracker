'use strict';

var app = angular.module('tracker', ['ngRoute', 'ngResource']);

app.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/', {templateUrl: 'partials/registration.html'});
        $routeProvider.when('/login', {templateUrl: 'partials/login.html'});
        $routeProvider.when('/home', {templateUrl: 'partials/home.html'});
        $routeProvider.otherwise({redirectTo: '/login'});
    }]);