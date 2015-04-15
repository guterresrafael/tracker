function UsersController($scope, $http, Users) {
    $scope.refresh = function() {
        $scope.users = Users.query();
    };
    $scope.reset = function() {
        $scope.newUser = {};
    };
    $scope.register = function() {
        $scope.successMessages = '';
        $scope.errorMessages = '';
        $scope.errors = {};
        Users.save($scope.newUser, function(data) {
            $scope.successMessages = [ 'User Registered' ];
            $scope.refresh();
            $scope.reset();
        }, function(result) {
            if ((result.status == 409) || (result.status == 400)) {
                $scope.errors = result.data;
            } else {
                $scope.errorMessages = [ 'Unknown server error' ];
            }
            $scope.$apply();
        });
    };
    
    $scope.refresh();
    $scope.reset();
    $scope.orderBy = 'name';
}