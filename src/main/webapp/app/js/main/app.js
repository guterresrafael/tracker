'use strict';
/**
 * Módulo principal da aplicação
 * Injeções de módulos auxiliares devem ser feitas aqui
 */
var services = angular.module('services', []);
var controllers = angular.module('controllers', []);

var app = angular.module('trackerApp', [
    'routes',
    'ngCookies',
    'maps',
    'controllers',
    'services'
]);
