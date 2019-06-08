$(document).ready(function () {
    var articleId = getUrlParam("articleId");
    $.ajax({

        url: "http://localhost:8080/api/article/sort/" + articleId,
        type: "post",
        dataType: "json",
        success: function (json) {
            $('#articleTitle').html(json.title);
            $('#articleCreateBy').html("创建时间:"+json.createTime);
            $('#articleContent').html(json.content);


        }
    });


});





function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]);
    return false; //返回参数值
}