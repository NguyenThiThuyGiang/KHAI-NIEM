(function() {
    "use strict";

    var app = angular.module("ConceptMap");
    // ---- Get thông tin tài khoản và danh sách concept map
    app.factory('accountService', function($http) {
        var loginHttp = function() {
            return $http.get("/data/login");
        };

        var accountHttp = function() {
            return $http.get("/data/account");
        };

          var logoutHttp = function() {
            return $http.get("/data/logout");
        };

        var updateHttp = function(data) {
            return $http.post("/data/account", data);
        };


        return {
            get: accountHttp,
            login: loginHttp,
            logout : logoutHttp,
            postEmail : updateHttp,
        };
    });

    // ---- Get, Post, Delele, Update Concept Map
    app.factory('cmapService', function($http) {
        var getHttp = function(id) {
            return $http.get("/data/cmaps/" + id);
        };

        var postHttp = function(data) {
            return $http.post("/data/cmaps", data);
        };

        var deleteHttp = function(id) {
            return $http.get("/data/cmaps/" + id + "/delete");
        };

        var shareHttp = function(id, list) {
            return $http.post("/data/cmaps/" + id + "/share", list);
        };

        var shareListHttp  = function(id) {
            return $http.get("/data/cmaps/" + id + "/members");
        };
        
         var unShareHttp = function(id, user) {
            return $http.get("/data/cmaps/" + id + "/unshare/" + user);
        };

        return {
            get: getHttp,
            post: postHttp,
            del: deleteHttp,
            share: shareHttp,
            shareList : shareListHttp,
            unShare : unShareHttp
        };
    });

    // ---- User Service
    app.factory('userService', function($http) {
        // --- Lấy user theo id
        var getHttp = function(id) {
            return $http.get("/data/users/" + id);
        };
        // --- TÌm kiếm member theo tên
        var findHttp = function(user_name) {
            return $http.post("/data/users/find", user_name);
        };
        // --- Hàm lấy danh sách tên tất cả thành viên cho autocomplete
        var listHttp = function() {
            return $http.get("/data/users/list");
        };

        return {
            get: getHttp,
            find: findHttp,
            list: listHttp,
        };
    });
})();
