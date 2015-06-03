'use strict';

app.factory('MapService',
        ['$http', function ($http) {
                var service = {};

                service.setPosition = function (latitude, longitude) {
                    service.areaLat = latitude;
                    service.areaLng = longitude;
                };
                
                service.setZoom = function(zoom){
                    service.areaZoom = zoom;
                };

                return service;
            }
        ]);