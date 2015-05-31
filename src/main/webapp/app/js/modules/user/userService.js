'use strict';

app.factory('UserService',
        ['$http', function ($http) {
                var service = {};
                
                service.FindUser = function (callback) {
                    $http.get('/api/users/2/devices')
                            .success(function (data, status) {
                                callback(data, status);
                            }).error(function(data, status){
                                callback(data, status);
                            });
                };
                
                return service;
            }
        ]);