'use strict';

app.factory('DeviceService',
        ['$http', function ($http) {
                var service = {};

                service.FindDevice = function (id, callback) {
                    $http({
                        url: '/api/users/:id/devices',
                        method: "GET",
                        params: {id: id}
                    })
                            .success(function (data, status) {
                                callback(data, status);
                            }).error(function (data, status) {
                        callback(data, status);
                    });
                };

                return service;
            }
        ]);