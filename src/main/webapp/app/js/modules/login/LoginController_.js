'use strict';

controllers.controller('LoginController',
        ['$scope', '$rootScope', '$location', 'AuthenticationService',
            function ($scope, $rootScope, $location, AuthenticationService) {
                // reset login status
                AuthenticationService.ClearCredentials();

                $scope.login = function () {
                    AuthenticationService.SetCredentials($scope.username, $scope.password);
                    AuthenticationService.Login(function (response) {
                        if (response === 200) {
                            $location.path('/home');
                        } else {
                            $scope.error = "Falha na autenticação.";
                        }
                    });
                };
            }]);