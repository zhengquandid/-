$(document).ready(function () {

    $.ajax({
        url: "http://localhost:8080/admin/summary",
        type: "GET",
        dataType: "json",
        success: function (json) {
            $('#articleSum').html("共"+json.blogSum+"篇");
            $('#articleCommentSum').html("共"+json.blogCommentSum+"条");
            $('#commentSum').html("共"+json.commentSum+"条");
            $('#visitSum').html(json.visitSum);
        }
    });

    $.ajax({
        url: "http://localhost:8080/admin/comment",
        type: "POST",
        dataType: "json",
        success: function (json) {
            $.each(json, function (i, item) {
                $('#comment-visits').append(
                    '<tr><td>' + item.name +
                    '</td><td>' + item.content +
                    '</td><td>' + item.email +
                    '</td><td>' + item.createTime + '</td></tr>');
            });
        }
    });

});