$(document).ready(function () {
    getData();
})

function getData() {
    $.ajax({
        url: "/tchReview",
        type: 'POST',
        dataType: 'json',
        success: function (json) {
            var studentList = json.studentList;
            initTable(studentList)
        }
    });
}

function initTable(studentList) {
    $('#tchReviewTable').bootstrapTable('destroy');
    $('#tchReviewTable').bootstrapTable({
        data: studentList,
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
            title: "学号",//标题
            field: "stuLoginName",
            sortable: true,
            order: "desc"
        }, {
            title: "姓名",
            field: "stuName",
            sortable: true,
            order: "desc"
        }, {
            title: "学生状态",
            field: "stuStage",
            sortable: true,
            order: "desc"
        }, {
            title: "操作",
            align: 'center',
            field: "bookId",
            formatter: function (value, row, index) {
                return '<a href="/review?stuId=' + row.stuId + '">审核</a>'
            }
        }]
    });
}