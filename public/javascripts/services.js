'use strict';

define(['angular'], function(angular) {
	angular.module('azApp.services', [])
		.factory('Products', ['$resource', '$http', function Contacts($resource, $http) {
			var endpointURI = '/api/products';
			return {
				list: function(options) {
					return $resource(endpointURI);
				}
			}
		}]);
});