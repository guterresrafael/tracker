app.factory('Device', ['$resource',
    function ($resource) {
        return $resource('../api/devices/:deviceId', {}, {
            query: {method: 'GET', params: {deviceId: 'devices'}}
        });
    }]);