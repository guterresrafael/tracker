'use strict';

app.controller('HomeController', ['$scope', 'UserService', function ($scope, UserService) {
        $scope.date = new Date();

        UserService.FindUser(function (data, response) {
            if (response === 200) {
                $scope.device = data;
            } else {
                console.log("ERRROOO!!");
            }
        });

    }]);
