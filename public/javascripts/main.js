'use strict';

requirejs.config({
	paths: {
		'angular': ['../lib/angularjs/angular'],
		'angular-route': ['../lib/angularjs/angular-route'],
		'angular-resource': ['../lib/angularjs/angular-resource.min']
	},
	shim: {
		'angular': {
			exports : 'angular'
		},
		'angular-route': {
			deps: ['angular'],
			exports : 'angular'
		},
		'angular-resource': {
			deps: ['angular'],
			exports : 'angular'
		}
	}
});

require(['angular', 'angular-route', 'angular-resource', './services', './controllers'], function(angular) {
	angular.module('azApp', ['ngRoute', 'ngResource', 'azApp.services', 'azApp.controllers' ])
		.config(['$routeProvider', '$locationProvider', '$httpProvider', function($routeProvider, $locationProvider, $httpProvider) {
			$routeProvider
				.when('/', {
					templateUrl: 'assets/javascripts/partials/products.html',
					controller: 'ProductsCtrl'
				})
		}]);
	angular.bootstrap(document, ['azApp']);
});