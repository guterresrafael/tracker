app.factory('User', ['$resource',
    function ($resource) {
        return $resource('../api/traccar/users/:userId', {}, {
            query: {method: 'GET', params: {userId: 'users'}}
        });
    }]);