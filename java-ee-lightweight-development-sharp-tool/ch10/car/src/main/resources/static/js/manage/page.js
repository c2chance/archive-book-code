function paging() {
    $("#page").html("")
    var html = "";
    if (totalPages < 10) {
        for (var i = 0; i < totalPages; i++) {
            if (page == i) {
                html += "<li class=\"active\"><a href=\"#\">" + (i + 1) + "</a></li>"
            } else {
                html += "<li><a href=\"#\" onclick='to(" + i + ")'>" + (i + 1) + "</a></li>"
            }
        }
    } else {
        if (page <= 5) {
            for (var i = 0; i < 10; i++) {
                if (page == i) {
                    html += "<li class=\"active\"><a href=\"#\">" + (i + 1) + "</a></li>"
                } else {
                    html += "<li><a href=\"#\" onclick='to(" + i + ")'>" + (i + 1) + "</a></li>"
                }
            }
        } else {
            for (var i = page - 4; i < page + 6; i++) {
                if (i < totalPages) {
                    if (page == i) {
                        html += "<li class=\"active\"><a href=\"#\">" + (i + 1) + "</a></li>"
                    } else {
                        html += "<li><a href=\"#\" onclick='to(" + i + ")'>" + (i + 1) + "</a></li>"
                    }
                }
            }
        }
    }
    $("#page").append("<li><a href=\"#\" onclick=\"subtract()\"><i class=\"fa-angle-left\"></i></a></li>" +
        html + "<li><a href=\"#\" onclick=\"add()\"><i class=\"fa-angle-right\"></i></a></li>共" + totalPages + "页 共" + totalElements + "条")
}