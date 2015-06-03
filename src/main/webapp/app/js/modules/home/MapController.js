'use strict';

app.controller('MapController',
        ['uiGmapGoogleMapApi', 'DeviceService',
            function (uiGmapGoogleMapApi, DeviceService) {
                var map = {};
                var options = {};
                var zoomMap = 14;
                var areaLat, areaLng, areaZoom;
                // metodo responsavel por definir Latitude e Logitude do device
                this.SetPosition = function (latitude, longitude) {
                    areaLat = latitude;
                    areaLng = longitude;
                    areaZoom = zoomMap;
                };


                uiGmapGoogleMapApi.then(function (maps) {
                    map.map = {center: {latitude: areaLat, longitude: areaLng}, zoom: areaZoom};
                    map.options = {scrollwheel: true};
                });

            }]);