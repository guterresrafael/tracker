'use strict';

app.factory('DeviceService',
        ['$http', function ($http) {
                var service = {};
                
                service.FindDevice = function (callback) {
                    $http.get('/api/devices/')
                            .success(function (data, status) {
                                callback(data, status);
                            }).error(function(data, status){
                                callback(data, status);
                            });
                };
                
                return service;
            }
        ]);