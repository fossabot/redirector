/**
 * Copyright 2016 Comcast Cable Communications Management, LLC 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
(function () {
    'use strict';
    
    angular
        .module('uxData.modelInitializer')
        .factory('modelInitializerService', ModelInitializerService);

    ModelInitializerService.$inject = ['$q', '$filter', 'modelInitializerRequestService'];
    function ModelInitializerService($q, $filter, modelInitializerRequestService) {

        var hostnameAndIP = $filter('hostnameAndIP');

        var service = {
            getAllExistingApplications: getAllExistingApplications,
            createDefaultModel: createDefaultModel,
            defaultModelConstructionDetails: defaultModelConstructionDetails,
            validateApplication: validateApplication
        };
        return service;

        function getAllExistingApplications() {
            var defer = $q.defer();
            modelInitializerRequestService.getAllExistingApplications()
                .then(function (data) {
                    defer.resolve(data);
                }, function (reason) {
                    defer.reject({message: reason.data, status: reason.status});
                });
            return defer.promise;
        }

        function createDefaultModel(appName) {
            var defer = $q.defer();
            modelInitializerRequestService.createDefaultModel(appName)
                .then(function (data) {
                    defer.resolve(data);
                }, function (reason) {
                    defer.reject({message: reason.data, status: reason.status});
                });
            return defer.promise;
        }

        function defaultModelConstructionDetails(appName) {
            var defer = $q.defer();
            modelInitializerRequestService.defaultModelConstructionDetails(appName)
                .then(function (data) {
                    defer.resolve(data);
                }, function (reason) {
                    defer.reject(reason);

                });
            return defer.promise;
        }

        function validateApplication(appName) {
            var defer = $q.defer();
            modelInitializerRequestService.validateApplication(appName)
                .then(function (data) {
                    defer.resolve(data);
                }, function (reason) {
                    defer.reject(reason);

                });
            return defer.promise;
        }
    }
    
}());