'use strict'
# Init the application configuration module for AngularJS application
ApplicationConfiguration = do ->
  # Init module configuration options
  #applicationModuleName = 'mean'
  applicationModuleName = 'santo'


  applicationModuleVendorDependencies = [
    'ngResource'
    'ngAnimate'
    'ngMessages'
    'ui.router'
    'ui.bootstrap'
    'ui.utils'
    'angularFileUpload'
  ]

  
  # Add a new vertical module
  registerModule = (moduleName, dependencies) ->
    # Create angular module
    angular.module moduleName, dependencies or []
    # Add the module to the AngularJS configuration file
    angular.module(applicationModuleName).requires.push moduleName
    return

  {
    applicationModuleName: applicationModuleName
    applicationModuleVendorDependencies: applicationModuleVendorDependencies
    registerModule: registerModule
  }
