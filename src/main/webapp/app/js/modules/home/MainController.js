'use strict';

app.controller('MainController', ['$scope', 'User', function ($scope, User) {
        this.activeUserId = 2;
        
//        $scope.user = User.get({userId: this.activeUserId}, function (user) {
//            $scope.dataUser = user;
//        });

    }]);
