'use strict';
/* 
 * Rotas devem ser definidas neste arquivo
 */
(function () {
    var app = angular.module("routes", [
        'ngRoute',
        'ngResource'
    ]);

    app.config(['$routeProvider', function ($routeProvider) {
            $routeProvider.when('/', {templateUrl: 'partials/registration.html'});
            $routeProvider.when('/login', {templateUrl: 'partials/login.html'});
            $routeProvider.when('/home', {templateUrl: 'partials/home.html', controller: 'HomeController as data'});
            $routeProvider.otherwise({redirectTo: '/login'});
        }]);

})();


