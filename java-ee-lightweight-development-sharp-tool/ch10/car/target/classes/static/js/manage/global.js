var _opts = {
    "closeButton": true,
    "debug": false,
    "positionClass": "toast-top-right toast-default",
    "toastClass": "black",
    "onclick": null,
    "showDuration": "100",
    "hideDuration": "1000",
    "timeOut": "2000",
    "extendedTimeOut": "1000",
    "showEasing": "swing",
    "hideEasing": "linear",
    "showMethod": "fadeIn",
    "hideMethod": "fadeOut"
};

function _info(content) {
    jQuery(document).ready(function () {
        setTimeout(function () {
            toastr.info(content, _opts);
        }, 1000);
    });
}

function _warn(content) {
    jQuery(document).ready(function () {
        setTimeout(function () {
            toastr.warn(content, _opts);
        }, 1000);
    });
}

function _error(content) {
    jQuery(document).ready(function () {
        setTimeout(function () {
            toastr.error(content, _opts);
        }, 1000);
    });
}

$(document).ready(function() {
    var info = $("#__info").val();

    if(info) {
        _info(info);
        return;
    }

    var warn = $("#__warn").val();

    if(warn) {
        _warn(warn);
        return;
    }

    var error = $("#__error").val();

    if(error) {
        _error(error);
    }
});