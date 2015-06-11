'use strict';

controllers.controller('ApplicationController',
        function ($scope, USER_ROLES, AuthenticationService) {
            $scope.currentUser = null;
            $scope.userRoles = USER_ROLES;
            $scope.isAuthorized = AuthenticationService.isAuthorized;

            $scope.setCurrentUser = function (user) {
                $scope.currentUser = user;
            };
        });