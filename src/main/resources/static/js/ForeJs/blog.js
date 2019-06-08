$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/api/listCategory",
        type: "GET",
        dataType: "json",
        success: function (json) {
            // 先填充分类信息
            $.each(json, function (i, item) {
                // 填充分类信息
                var categoryInfo = document.querySelector("#categoryInfo");
                categoryInfo.content.querySelector("a").innerHTML = item.categoryName + "(" + item.number + ")";
                categoryInfo.content.querySelector("a").href = "?categoryId=" + item.id;
                document.getElementById("category").appendChild(categoryInfo.content.cloneNode(true));
            });

            // 判断当前分类情况
            var categoryId = getUrlParam("categoryId");
            //			alert(categoryId);
            console.log(categoryId);
            if (categoryId == false) {

                // 如果没有指定分类则获取全部文章
                showAllArticleInfo();
            } else {
                // 有指定分类则显示指定分类下的文章
                showArticleByCategoryId(categoryId);
            }

        }
    });


});

function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]);
    return false; //返回参数值
}

function showAllArticleInfo() {

    $.ajax({
        type: "get",
        url: "http://localhost:8080/api/article/list",
        dataType: "json",
        success: function (json) {
            $.each(json, function (i, item) {
                // 填充文章信息
                console.log(item);
                var articleInfo = document.querySelector("#articleInfo");
                articleInfo.content.querySelector("h5").innerHTML = item.title;
                articleInfo.content.querySelector("h7").innerHTML = item.id;
                articleInfo.content.querySelector("h6").innerHTML = item.summary;
                document.getElementById("articleInfos").appendChild(articleInfo.content.cloneNode(true));

            });
        }
    });
}

function showArticleByCategoryId(categoryId) {


    $.ajax({
        type: "get",
        url: "http://localhost:8080/api/article/list/" + categoryId,
        dataType: "json",
        success: function (json) {
            $.each(json, function (i, item) {
                // 填充文章信息
                console.log(item);
                var articleInfo = document.querySelector("#articleInfo");
                articleInfo.content.querySelector("h5").innerHTML = item.title;
                articleInfo.content.querySelector("h6").innerHTML = item.summary;
                articleInfo.content.querySelector("h7").innerHTML = item.id;
                document.getElementById("articleInfos").appendChild(articleInfo.content.cloneNode(true));
            });
        }
    });

}

function showArticle(_this) {
    var articleId = $(_this).children("h7").text();
    var url = "article.html?articleId=" + articleId;
    window.location.href = url;
}