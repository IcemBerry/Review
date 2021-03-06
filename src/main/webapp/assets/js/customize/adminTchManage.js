$(document).ready(function () {
    getData();
})

function getData() {
    $.ajax({
        url: "/getTchManager",
        type: 'POST',
        dataType: 'json',
        success: function (json) {
            var teacherList = json.teacherList;
            initTable(teacherList)
        }
    });
}

function initTable(teacherList) {
    $('#adminTchTable').bootstrapTable('destroy');
    $('#adminTchTable').bootstrapTable({
        data: teacherList,
        cache: false,
        pagination: true,
        pageSize: 5,
        pageList: [5, 10, 20],
        search: true,
        formatShowingRows: function (pageFrom, pageTo, totalRows) {
            return '';
        },
        columns: [{
            title: "#",
            formatter: function (value, row, index) {
                return index + 1;
            }
        }, {
            title: "职工卡号",//标题
            field: "userLoginName",//键名
            sortable: true,//是否可排序
            order: "desc"//默认排序方式
        }, {
            title: "姓名",//标题
            field: "userName",//键名
            sortable: true,//是否可排序
            order: "desc"//默认排序方式
        }, {
            title: "操作",//标题
            align: 'center',
            field: "bookId",//键名
            formatter: function (value, row, index) {
                return '<a id="download" href="/reset?userId=' + row.userId + '">重置密码</a>'
            }
        }]
    });
}