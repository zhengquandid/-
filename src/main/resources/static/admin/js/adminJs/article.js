$(document).ready(function () {


    $.ajax({
        url: "http://localhost:8080/admin/listCategory",
        type: "POST",
        dataType: "json",
        success: function (json) {
            $.each(json, function (i, item) {
                $('#articleCategories').append(
                    '<option categoryId=' + item.id + '>' + item.categoryName +
                    '</option>'
                );
                $('#articleCategory').append(
                    '<li><a onclick="optionCategory(' + item.id + ')">' + item.categoryName +
                    '</a></li>'
                );
            });
        }
    });

    $.ajax({
        url: "http://localhost:8080/admin/listArticle",
        type: "POST",
        dataType: "json",
        success: function (json) {
            $.each(json, function (i, item) {
                $('#article-visit').append(
                    '<tr><th>' + item.title +
                    '</th><th>' + item.traffic +
                    '</th><th>' + 0 +
                    '</th><th>' + item.updateTime +
                    '</th><th><a id="updateArticle" style="cursor:pointer" onClick="updateArticle(' + item.id + ')" >修改</a> <a rel="1" onClick="deleteArticle(' + item.id + ')">删除</a> </th></tr>'
                );
            });
            $('#article-table').dataTable();
        }
    });


});

$('#addArticle').click(function () {
    var articleTitle = $('#articleTitle').val();
    var articleSummary = $('#articleSummary').val();
    var articleTop = $('#articleTop').prop("checked");
    var articleCategoryId = $('#articleCategories').find("option:selected").attr("categoryId");
    var articleContent = $('#articleContent').val();
    console.log(articleTop);
    var article = {
        title: articleTitle,
        summary: articleSummary,
        isTop: articleTop,
        categoryId: articleCategoryId,
        content: articleContent,
    };
    $.ajax({
        url: "http://localhost:8080/admin/addArticle",
        type: "POST",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify(article),
        success: function () {
            // 刷新页面
            location.reload();
        },
        error: function () {
            location.reload();
        }
    });


});

//指定标签文章
function optionCategory(id) {
    $.ajax({
        url: "http://localhost:8080/admin/listArticle/" + id,
        type: "POST",
        dataType: "json",
        success: function (json) {
            $('#article-visit').html("");
            $.each(json, function (i, item) {
                $('#article-visit').append(
                    '<tr><th>' + item.title +
                    '</th><th>' + item.traffic +
                    '</th><th>' + 0 +
                    '</th><th>' + item.updateTime +
                    '</th><th><a id="updateArticle" style="cursor:pointer" onClick="updateArticle(' + item.id + ')" >修改</a> <a rel="1" onClick="deleteArticle(' + item.id + ')">删除</a> </th></tr>'
                );
            });
            $('#article-table').dataTable();
        }
    });
}

//删除文章
function deleteArticle(id) {
    $('#confirmBtn').attr("articleId", id);
    $('#deleteModal').modal();
};

$('#confirmBtn').click(function () {
    var id = $(this).attr("articleId");
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/admin/deleteArticle/" + id,
        success: function () {
            // 刷新页面
            location.reload();
        }
    });
});

//修改文章
function updateArticle(id) {
    $('#updateArticleModal').modal();
    $.ajax({
        url: "http://localhost:8080/admin/listCategory",
        type: "POST",
        dataType: "json",
        success: function (json) {
            $('#updateArticleCategories').html("");
            $.each(json, function (i, item) {
                $('#updateArticleCategories').append(
                    '<option categoryId=' + item.id + '>' + item.categoryName +
                    '</option>'
                );
            });
        }
    });
    $.ajax({
        url: "http://localhost:8080/admin/article/" + id,
        type: "POST",
        dataType: "json",
        success: function (json) {
            $('#updateArticle').attr("updateArticleId", id);
            $('#updateArticleTitle').val(json.title);
            $('#updateArticleSummary').val(json.summary);
            $('#updateArticleContent').val(json.content);
            if (json.isTop) {
                $('#updateArticleTop').attr("checked", true);
            }
            console.log(json.title);
            console.log(json);
            var select = $('#updateArticleCategories');

            for (var i = 0; i < select.find("option").size()
                ; i++) {
                if (select.find("option:eq(" + i + ")").attr("categoryId") == json.categoryId) {
                    select.find("option:eq(" + i + ")").attr("selected", true);
                    console.log(i);
                    break;
                }
            }
        }
    });
}

//更新文章
$('#updateArticle').click(function () {
    var articleId = $('#updateArticle').attr("updateArticleId");
    var articleTitle = $('#updateArticleTitle').val();
    var articleSummary = $('#updateArticleSummary').val();
    var articleTop = $('#updateArticleTop').prop("checked");
    var articleCategoryId = $('#updateArticleCategories').find("option:selected").attr("categoryId");
    var articleContent = $('#updateArticleContent').val();
    console.log(articleTop);
    var article = {
        id: articleId,
        title: articleTitle,
        summary: articleSummary,
        isTop: articleTop,
        categoryId: articleCategoryId,
        content: articleContent,
    };
    console.log(article)
    $.ajax({
        url: "http://localhost:8080/admin/updateArticle",
        type: "POST",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify(article),
        success: function () {
            // 刷新页面
            location.reload();
        },
        error: function () {
            location.reload();
        }
    });


});