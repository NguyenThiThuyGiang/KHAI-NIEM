(function() {
    'use strict';

    var app = angular.module("ConceptMap");

    app.controller('AssignCtrl', function($scope, $http, $localStorage, toaster, accountService) {
        console.log($scope.$account);
        $scope.assigns = $scope.$account.assigns;

    });

})();
