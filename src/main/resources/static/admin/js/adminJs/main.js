$(document).ready(function () {

    $.ajax({
        url: "http://localhost:8080/admin/summary",
        type: "GET",
        dataType: "json",
        success: function (json) {
            $('#articleSum').html("共" + json.blogSum + "篇");
            $('#articleCommentSum').html("共" + json.blogCommentSum + "条");
            $('#commentSum').html("共" + json.commentSum + "条");
            $('#visitSum').html(json.visitSum);
        }
    });

    $.ajax({
        url: "http://localhost:8080/admin/listComment",
        type: "POST",
        dataType: "json",
        success: function (json) {
            $.each(json, function (i, item) {
                $('#comment-visits').append(
                    '<tr><th>' + item.name +
                    '</th><th>' + item.content +
                    '</th><th>' + item.email +
                    '</th><th>' + item.createTime +
                    '</th><th><button class="btn btn-success" onclick="deleteComment(\'' + item.id + '\')"><i class="fa fa-trash-o"></i>删除</button></th></tr>'
                );
            });
            $('#comment-table').dataTable({
                responsive: true
            });
        }
    });

    $.ajax({
        url: "http://localhost:8080/admin/listLog",
        type: "POST",
        dataType: "json",
        success: function (json) {
            $.each(json, function (i, item) {
                $('#log-visits').append(
                    '<tr><th>' + item.ip +
                    '</th><th>' + item.createTime +
                    '</th><th>' + item.operateBy +
                    '</th></tr>'
                );
            });
            $('#log-table').dataTable();
        }
    });



});

function deleteComment(id) {
    $('#confirmBtn').attr("commentId", id);
    $('#commentModel').modal();
}

$('#confirmBtn').click(function () {
    var id = $(this).attr("commentId");
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/admin/comment/" + id,
        success: function () {
            // 刷新页面
            location.reload();
        }
    });
});