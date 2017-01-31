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
 * @author Alexey Smolenskiy (asmolenskiy@productengine.com)
 */


angular.module('uxData.diff-distribution').directive('diffDistributions',
    function(){
        return {
            restrict: 'E',
            replace: true,
            scope: {
                baseHeadTitle:'=?',
                baseDistributions: '=',
                changedHeadTitle: '=?',
                changedDistributions: '='
            },
            templateUrl: "../uxData/scripts/distribution-diff/distribution-diff.html",
            controller: "DiffDistributions",
            controllerAs: "vm",
            link: function link(scope, element, attrs, vm) {
                scope.$watch('baseDistributions', function (value) {
                    vm.refresh();
                }, true);
                scope.$watch('changedDistributions', function (value) {
                    vm.refresh();
                }, true);
            }
        }
    });

