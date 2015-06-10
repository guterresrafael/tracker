'use strict';

controllers.controller('MapController',
        ['$scope', 'uiGmapGoogleMapApi', 'MapService',
            function ($scope, uiGmapGoogleMapApi, MapService) {

                uiGmapGoogleMapApi.then(function (maps) {
                    $scope.map = {center: {latitude: MapService.areaLat, longitude: MapService.areaLng}, zoom: MapService.zoom};
                    $scope.options = {scrollwheel: true};
                });

            }]);