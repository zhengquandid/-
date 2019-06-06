$(document).ready(function () {

    $.ajax({
        url: "http://localhost:8080/admin/listCategory",
        type: "POST",
        dataType: "json",
        success: function (json) {
            $.each(json, function (i, item) {
                $('#category-visit').append(
                    '<tr><td>' + item.id +
                    '</td><td>' + item.categoryName +
                    '</td><td>' + item.number +
                    '</td><td><a id="updateCategory" style="cursor:pointer" onclick="updateCategory(\''+item.categoryName+'\','+item.id+')" >修改</a> <a rel="1" onclick="deleteCategory(' + item.id + ')">删除</a></td></tr>'
                );
            });
            $('#category-table').dataTable({
                responsive: true
            });
        }
    });


});

function deleteCategory(id) {
    $('#confirmBtn').attr("categoryId", id);
    $('#deleteModal').modal();
};

$('#confirmBtn').click(function () {
    var id = $(this).attr("categoryId");
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/admin/category/" + id,
        success: function () {
            // 刷新页面
            location.reload();
        }
    });
});

$('#submitCategory').click(function () {
    var name = $('#categoryName').val();


    $.ajax({
        url: "http://localhost:8080/admin/addCategory/" + name,
        type: "POST",
        success: function () {
            // 刷新页面
            location.reload();
        }
    });
});


function updateCategory(name,id) {
    $('#oldCategory').text(name);
    $('#oldCategory').attr("updateCategoryId",id)
    $('#updateModal').modal();
}

$('#updateCategoryBtn').click(function () {
    var name = $('#updateName').val();
    var id = $('#oldCategory').attr("updateCategoryId")

    var category = {
        categoryName: name,
        id: id
    };

    $.ajax({
        url: "http://localhost:8080/admin/updateCategory",
        type: "POST",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify(category),

        success: function () {
            // 刷新页面
            location.reload();
        },
        error :function () {
            location.reload();
        }
    });
});