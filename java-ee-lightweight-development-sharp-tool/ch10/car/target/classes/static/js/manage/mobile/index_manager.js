$(function () {
    var addListeners = function () {
        $("#second-part").unbind("click").bind("click", function (e) {
            window.location = "/mobile/mine/manager/" + managerId;
            e.preventDefault();
            e.stopPropagation();
            return false;
        });

        $("#first-part-left").unbind("click").bind("click", function (e) {
            window.location = "/car/passs?a=1";
            e.preventDefault();
            e.stopPropagation();
            return false;
        });

        $("#first-part-left-no").unbind("click").bind("click", function (e) {
            alert("您没有该权限");
            e.preventDefault();
            e.stopPropagation();
            return false;
        });

        $("#first-part-right-1").unbind("click").bind("click", function (e) {
            window.location = "/car/authorization/details";
            e.preventDefault();
            e.stopPropagation();
            return false;
        });

        $("#first-part-right-2").unbind("click").bind("click", function (e) {
            window.location = "/car/noticeManager/mobile";
            e.preventDefault();
            e.stopPropagation();
            return false;
        });

        $("#third-left").unbind("click").bind("click", function (e) {
            window.location = "/mobile/vehicleViolation/manager/query";
            e.preventDefault();
            e.stopPropagation();
            return false;
        });

        $("#third-right").unbind("click").bind("click", function (e) {
            window.location = "/car/hobbylistManager/mobile";
            e.preventDefault();
            e.stopPropagation();
            return false;
        });

        $("#third-right-2").unbind("click").bind("click", function (e) {
            window.location = "/car/abnormal/mobile";
            e.preventDefault();
            e.stopPropagation();
            return false;
        });

        $("#four-left").unbind("click").bind("click", function (e) {
            window.location = "/mobile/mine/help";
            return false;
        });

    };

    addListeners();
});