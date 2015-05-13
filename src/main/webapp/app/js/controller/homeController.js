'use strict';

app.controller('HomeController', ['$scope', 'Device', function ($scope, Device) {
        this.activeDeviceId = 2;
        
        $scope.date = new Date();
        
        $scope.device = Device.get({deviceId: this.activeDeviceId}, function (device) {
            $scope.dataDevice = device;
        });
        

    }]);
