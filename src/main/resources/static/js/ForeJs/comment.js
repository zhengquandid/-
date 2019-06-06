$('#addComment').click(function () {
    var name = $('#name').val();
    var email = $('#email').val();
    var content = $('#commentContent').val();


    var comment = {
        name: name,
        email: email,
        content: content
    };


    $.ajax({
        url: "http://localhost:8080/api/addComment",
        type: "POST",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify(comment),
        success: function () {
            // 显示成功提示信息
            $('#addModal').modal();
        },
        error: function () {
            $('#addModal').modal();
        }
    });
});