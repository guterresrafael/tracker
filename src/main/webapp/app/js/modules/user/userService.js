'use strict';

services.factory('UserService',
        ['$http', function ($http) {
                var service = {};
                
                service.FindUser = function (callback) {
                    $http.get('/api/users/1/')
                            .success(function (data, status) {
                                callback(data, status);
                            }).error(function(data, status){
                                callback(data, status);
                            });
                };
                
                return service;
            }
        ]);