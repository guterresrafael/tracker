angular.module('userService', ['ngResource'])
        .factory('Users', function ($resource) {
            return $resource('api/users/userId', {});
        });