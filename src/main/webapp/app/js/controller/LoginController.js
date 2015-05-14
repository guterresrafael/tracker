app.controller('LoginController', function ($scope, UsersApi) {

  this.cancel = $scope.$dismiss;

  this.submit = function (login, password) {
    UsersApi.login(login, password).then(function (user) {
      $scope.$close(user);
    });
  };

});