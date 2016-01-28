'use strict';

define(['angular'], function(angular) {
	angular.module('azApp.controllers', [])
		.controller('ProductsCtrl', ['$scope', 'Products', function($scope, Products) {
			$scope.products = Products.list().query();
		}]);
});