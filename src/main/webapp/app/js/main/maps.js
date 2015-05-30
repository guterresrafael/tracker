'use strict';

var app = angular.module('maps', ['uiGmapgoogle-maps']).config(function (uiGmapGoogleMapApiProvider) {
    uiGmapGoogleMapApiProvider.configure({
        key: 'AIzaSyCen8-FkoRbxbWZLTmDM-MwX6jSnL_1o5g',
        v: '3.17',
        libraries: 'weather,geometry,visualization'
    });
});