$(function () {
    var addListeners = function () {
        $("#first-left").unbind("click").bind("click", function (e) {
            window.location = "/mobile/vehicleViolation/index/" + driverId;
            e.preventDefault();
            e.stopPropagation();
            return false;
        });

        $("#first-right").unbind("click").bind("click", function (e) {
            window.location = "/mobile/vehicleViolation/search/" + driverId;
            e.preventDefault();
            e.stopPropagation();
            return false;
        });
    };
    addListeners();
});
