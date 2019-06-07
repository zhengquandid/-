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
                var categoryId = getQueryVariable("categoryId");
                //			alert(categoryId);
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

function showAllArticleInfo() {

    $.ajax({
        type: "get",
        url: "http://localhost:8080/api/article/list",
        dataType: "json",
        success: function (json) {
            $.each(json, function (i, item) {
                // 填充文章信息
                var articleInfo = document.querySelector("#articleInfo");
                articleInfo.content.querySelector("img").src = item.pictureUrl;
                if (item.top == true) {
                    articleInfo.content.querySelector("h5").innerHTML =  item.title;
                    //					articleInfo.content.querySelector("h5").style.fontWeight = "bold";
                } else {
                    articleInfo.content.querySelector("h5").innerHTML = item.title;
                }
                articleInfo.content.querySelector("h6").innerHTML = item.id;
                document.getElementById("articleInfos").appendChild(articleInfo.content.cloneNode(true));

            });
        }
    });
}