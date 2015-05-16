app.factory('Device', ['$resource',
    function ($resource) {
        return $resource('../api/traccar/devices/:deviceId', {}, {
            query: {method: 'GET', params: {deviceId: 'devices'}}
        });
    }]);