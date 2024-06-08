$(function () {
    $(".schoolGate-checkbox-all").unbind("change").bind("change", function () {
        var checked = $(this).prop("checked");
        $(".schoolGate-checkbox-item").prop("checked", checked);
        $(".schoolGate-checkbox-group").prop("checked", checked);
    });

    $(".schoolGate-checkbox-group").unbind("change").bind("change", function () {
        var $this = $(this);
        var $parent = $this.closest(".schoolGate-group");
        var checked = $this.prop("checked");
        $parent.find(".schoolGate-checkbox-item").prop("checked", checked);

        check();
    });

    $(".schoolGate-checkbox-item").unbind("change").bind("change", function () {
        var $this = $(this);
        var $parent = $this.closest(".schoolGate-group");

        var length0 = $parent.find(".schoolGate-checkbox-item:checked").length;
        var length1 = $parent.find(".schoolGate-checkbox-item").length;
        $parent.find(".schoolGate-checkbox-group").prop("checked", length0 === length1);

        check();
    });
});

function check() {
    var $all = $(".gates");
    var length0 = $all.find(".schoolGate-checkbox-item:checked").length;
    var length1 = $all.find(".schoolGate-checkbox-item").length;
    $(".schoolGate-checkbox-all").prop("checked", length0 === length1);
}