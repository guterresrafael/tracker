'use strict';

app.controller('LoginController',
        ['$scope', '$rootScope', '$location', 'AuthenticationService',
            function ($scope, $rootScope, $location, AuthenticationService) {
                // reset login status
                AuthenticationService.ClearCredentials();

                $scope.login = function () {
                    AuthenticationService.SetCredentials($scope.username, $scope.password);
                    AuthenticationService.Login(function (response) {
                        if (response.success) {
                            $location.path('/home');
                        } else {
                            $scope.error = response.message;
                        }
                    });
                };
            }]);