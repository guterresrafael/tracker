'use strict';

controllers.controller('HomeController', ['$scope', 'UserService', 'DeviceService', 'MapService',
    function ($scope, UserService, DeviceService, MapService) {
        $scope.date = new Date();
        MapService.zoom = 14;

        MapService.setPosition(-31.754422, -52.3773069);

        UserService.FindUser(function (data, response) {
            if (response === 200) {
                $scope.user = data.user;
            } else {
                console.log("ERRROOO!!");
            }
        });

    }]);
