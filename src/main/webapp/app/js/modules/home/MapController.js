'use strict';

var app = app.controller("MapController", function ($scope, uiGmapGoogleMapApi) {

    // Define variables for our Map object
    var areaLat = -31.754422,
            areaLng = -52.3773069,
            areaZoom = 13;

    uiGmapGoogleMapApi.then(function (maps) {
        $scope.map = {center: {latitude: areaLat, longitude: areaLng}, zoom: areaZoom};
        $scope.options = {scrollwheel: true};
    });

});