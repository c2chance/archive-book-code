var images = new Array();
$(function () {
    var delParent;
    var defaults = {
        fileType: ["jpg", "png", "bmp", "jpeg"],   // 上传文件的类型
        fileSize: 1024 * 1024 * 5                  // 上传文件的大小 5M
    };
    /*点击图片的文本框*/
    $(".file").change(function () {
        var idFile = $(this).attr("id");
        var file = document.getElementById(idFile);
        var imgContainer = $(this).parents(".z_photo"); //存放图片的父亲元素
        var fileList = file.files; //获取的图片文件
        var input = $(this).parent();//文本框的父亲元素
        var imgArr = [];
        //遍历得到的图片文件
        var numUp = imgContainer.find(".up-section").length;
        var totalNum = numUp + fileList.length;  //总的数量
        if (fileList.length > 3 || totalNum > 3) {
            alert("上传图片数目不可以超过3个，请重新选择");  //一次选择上传超过3个 或者是已经上传和这次上传的到的总数也不可以超过3个
        }
        else if (numUp < 3) {
            fileList = validateUp(fileList);
            for (var i = 0; i < fileList.length; i++) {
                var imgUrl = window.URL.createObjectURL(fileList[i]);
                //转base64
                changeData(imgUrl);
                imgArr.push(imgUrl);
                var $section = $("<section class='up-section fl loading'>");
                imgContainer.prepend($section);
                var $span = $("<span class='up-span'>");
                $span.appendTo($section);

                var $img0 = $("<img class='close-upimg'>").on("click", function (event) {
                    event.preventDefault();
                    event.stopPropagation();
                    $(".works-mask").show();
                    delParent = $(this).parent();
                });
                $img0.attr("src", "/js/jQueryImage/img/a7.png").appendTo($section);
                var $img = $("<img class='up-img up-opcity'>");
                $img.attr("src", imgArr[i]);
                $img.appendTo($section);
                var $p = $("<p class='img-name-p'>");
                $p.html(fileList[i].name).appendTo($section);
                var $input = $("<input id='taglocation' name='taglocation' value='' type='hidden'>");
                $input.appendTo($section);
                var $input2 = $("<input id='tags' name='tags' value='' type='hidden'/>");
                $input2.appendTo($section);
                //alert(imgArr);
            }
        }
        setTimeout(function () {
            $(".up-section").removeClass("loading");
            $(".up-img").removeClass("up-opcity");
        }, 450);
        numUp = imgContainer.find(".up-section").length;
        if (numUp >= 3) {
            $(this).parent().hide();
        }
    });


    $(".z_photo").delegate(".close-upimg", "click", function () {
        $(".works-mask").show();
        delParent = $(this).parent();
    });

    $(".wsdel-ok").click(function () {
        $(".works-mask").hide();
        var numUp = delParent.siblings().length;
        if (numUp < 4) {
            delParent.parent().find(".z_file").show();
        }
        delParent.remove();
        var delId = delParent.find('img')[1];
        images.del(function (obj) {
            return obj.id == delId;
        });
        //console.info("===delete=====images========" + JSON.stringify(images));
    });

    $(".wsdel-no").click(function () {
        $(".works-mask").hide();
    });

    function validateUp(files) {
        var arrFiles = [];//替换的文件数组
        for (var i = 0, file; file = files[i]; i++) {
            //获取文件上传的后缀名
            var newStr = file.name.split("").reverse().join("");
            if (newStr.split(".")[0] != null) {
                var type = newStr.split(".")[0].split("").reverse().join("");
                //console.log(type + "===type===");
                if (jQuery.inArray(type, defaults.fileType) > -1) {
                    // 类型符合，可以上传
                    if (file.size >= defaults.fileSize) {
                        //alert(file.size);
                        alert('您这个"' + file.name + '"文件大小过大');
                    } else {
                        // 在这里需要判断当前所有文件中
                        arrFiles.push(file);
                    }
                } else {
                    alert('您这个"' + file.name + '"上传类型不符合');
                }
            } else {
                alert('您这个"' + file.name + '"没有类型, 无法识别');
            }
        }
        return arrFiles;
    }

    // 转base64
    function changeData(url) {
        var canvas = document.createElement('CANVAS'),
            ctx = canvas.getContext('2d'),
            img = new Image;
        img.crossOrigin = 'Anonymous';
        img.onload = function () {
            var height = img.height;
            //console.log("========原始高========" + height);
            var width = img.width;
            //console.log("========原始宽========" + width);
            if (height > width) {
                height = img.width;
                width = img.height;
                //console.log("====" + width + "====转换height========" + height + "===" + height + "==转换width======" + width);
            }
            var scale = width / height;
            //console.log("--比例--" + scale);
            // 图片宽度压缩
            var width1 = img.width;
            if (width < 1000) {
                width1 = width;
            } else if (width < 2000) {
                width1 = width / 3;
            } else if (width < 3000) {
                width1 = width / 5;
            } else if (width < 4000) {
                width1 = width / 8;
            } else if (width < 5000) {
                width1 = width / 10;
            }
            //console.log("========调整后宽========" + width1);
            //console.log("========调整后高========" + parseInt(width1 / scale));

            // 创建属性节点
            var anw = document.createAttribute("width");
            anw.nodeValue = width1;
            var anh = document.createAttribute("height");
            anh.nodeValue = parseInt(width1 / scale);
            canvas.setAttributeNode(anw);
            canvas.setAttributeNode(anh);
            ctx.drawImage(img, 0, 0, width1, parseInt(width1 / scale));
            var base64 = canvas.toDataURL('image/jpeg', 0.7);
            if (base64 != null && base64 != "" && base64 != "undefined") {
                var data = new Object();
                data.id = url;
                data.module = base64;
                images.push(data);
                //console.log("========base64========" + base64);
                //console.info("========images========" + JSON.stringify(images));
            }
            canvas = null;
        };
        img.src = url;
    }

    // 删除指定id的数组
    Array.prototype.del = function (filter) {
        var idx = filter;
        if (typeof filter == 'function') {
            for (var i = 0; i < this.length; i++) {
                if (filter(this[i], i)) idx = i;
            }
        }
        this.splice(idx, 1);
    };
});
