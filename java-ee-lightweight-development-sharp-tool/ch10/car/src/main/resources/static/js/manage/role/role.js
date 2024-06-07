$(function () {
    $(".role-checkbox-all").unbind("change").bind("change", function () {
        var checked = $(this).prop("checked");
        $(".role-checkbox-item").prop("checked", checked);
        $(".role-checkbox-group").prop("checked", checked);
    });

    $(".role-checkbox-group").unbind("change").bind("change", function () {
        var $this = $(this);
        var $parent = $this.closest(".role-group");
        var checked = $this.prop("checked");
        $parent.find(".role-checkbox-item").prop("checked", checked);

        check();
    });

    $(".role-checkbox-item").unbind("change").bind("change", function () {
        var $this = $(this);
        var $parent = $this.closest(".role-group");

        var length0 = $parent.find(".role-checkbox-item:checked").length;
        var length1 = $parent.find(".role-checkbox-item").length;
        $parent.find(".role-checkbox-group").prop("checked", length0 === length1);

        check();
    });
});

function check() {
    var $all = $(".permissions");
    var length0 = $all.find(".role-checkbox-item:checked").length;
    var length1 = $all.find(".role-checkbox-item").length;
    $(".role-checkbox-all").prop("checked", length0 === length1);
}