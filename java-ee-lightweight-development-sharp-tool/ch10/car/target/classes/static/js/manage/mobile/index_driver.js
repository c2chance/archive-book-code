$(function () {
    var addListeners = function () {
        $("#second-part").unbind("click").bind("click", function (e) {
            window.location = "/mobile/mine/driver/" + driverId;
            e.preventDefault();
            e.stopPropagation();
            return false;
        });

        $("#first-part-left").unbind("click").bind("click", function (e) {
            window.location = "/mobile/passports/workers/" + driverId;
            e.preventDefault();
            e.stopPropagation();
            return false;
        });

        $("#first-part-right-1").unbind("click").bind("click", function (e) {
            window.location = "/mobile/mine/help";
            e.preventDefault();
            e.stopPropagation();
            return false;
        });

        $(".first-part-right-2").unbind("click").bind("click", function (e) {
            window.location = "/mobile/passports/schedule/" + driverId;
            return false;
        });

        $("#third-left").unbind("click").bind("click", function (e) {
            window.location = "/mobile/vehicleViolation/driver/mobileIndex/" + driverId;
            e.preventDefault();
            e.stopPropagation();
            return false;
        });

        $("#third-part-right-1").unbind("click").bind("click", function (e) {
            window.location = "/car/noticeManager/mobile";
            e.preventDefault();
            e.stopPropagation();
            return false;
        });

        $(".third-part-right-2").unbind("click").bind("click", function (e) {
            window.location = "/mobile/movingVehicle/index/" + driverId;
            e.preventDefault();
            e.stopPropagation();
            return false;
        });
    };

    addListeners();
});
