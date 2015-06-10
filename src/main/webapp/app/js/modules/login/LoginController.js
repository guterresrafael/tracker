'use strict';

controllers.controller('LoginController',
        function ($scope, $rootScope, $location, AUTH_EVENTS, AuthenticationService) {
            $scope.credentials = {
                username: '',
                password: ''
            };

            $scope.login = function (credentials) {
                AuthenticationService.SetCredentials(credentials);

                AuthenticationService.login().then(function (user) {
                    $rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
                    $scope.setCurrentUser(user);
                    $location.path('/home');
                }, function () {
                    $scope.error = "Falha na autenticação.";
                    $rootScope.$broadcast(AUTH_EVENTS.loginFailed);
                });
            };

        })