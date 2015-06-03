'use strict';

app.controller('HomeController', ['$scope', 'UserService', '$controller', function ($scope, UserService, MapController) {
        var mapController = MapController("MapController");

        $scope.date = new Date();

        mapController.SetPosition(-31.754422, -52.3773069);

        UserService.FindUser(function (data, response) {
            if (response === 200) {
                $scope.data = data;
            } else {
                console.log("ERRROOO!!");
            }
        });

    }]);
