(function() {
    'use strict';

    var app = angular.module("ConceptMap");

    app.controller('HomeCtrl', function($scope, $http, $localStorage, $rootScope, $modal, toaster, accountService) {
	// --- Hàm xóa trắng dữ liệu
	var emptyData = function() {
            $rootScope.$account = null;
            // --- Xóa dữ liệu lưu trữ cache
            $localStorage.$reset();
        };
        //--- Thiết lập hàm tìm kiếm khái niệm
        $scope.key = "";
        // --- Lắng nghe biến key : nếu key thay đổi thì thông báo "search" và trả ra dữ key mới
        $scope.$watch("key", function(newVal) {
            $rootScope.$broadcast('search', newVal);
        });
        
        // --- Khi lấy dữ liệu thành công
        var success = function(response) {
            toaster.pop('success', "Thông báo", "Thiết lập kết nối dữ liệu thành công!");
            // --- Xóa trống những dữ liệu trước
            emptyData();
            // --- Khởi tạo $account chứa toàn bộ thông tin tài khoản
            $scope.$account = response;
            // --- Lưu trữ cache dữ liệu offline
            $localStorage.data = response;
            // --- Chuyển link về /#/cmap (Trang chính)
            $scope.$state.go("cmap");
            // --- Thông báo và chuyển danh sách cmap cho CMapCtrl
            $rootScope.$broadcast('data', response);

        };
        // --- Khi quá trình lấy dữ liệu thất bại
        var error = function() {
            emptyData();
            toaster.pop('success', "Thông báo", "Kết nối dữ liệu thất bại, vui lòng kiểm tra kết nối!");
        };
        // --- Gọi service lấy thông tin và dữ liệu chung từ server
        accountService.get().success(success).error(error);



    });

})();
