$(document).ready(function () {
    getData();
})

function getData() {
    $.ajax({
        url: "/tchDownload",
        type: 'POST',
        dataType: 'json',
        success: function (json) {
            var tchDownloadList = json.tchDownloadList;
            initTable(tchDownloadList)
        }
    });
}

function initTable(tchDownloadList) {
    $('#tchDownTable').bootstrapTable('destroy');
    $('#tchDownTable').bootstrapTable({
        data: tchDownloadList,
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
            title: "姓名",//标题
            field: "stuName",//键名
            sortable: true,//是否可排序
            order: "desc"//默认排序方式
        }, {
            title: "学生状态",//标题
            field: "stuState",//键名
            sortable: true,//是否可排序
            order: "desc"//默认排序方式
        }, {
            title: "文档类别",//标题
            field: "deliveryType",//键名
            sortable: true,//是否可排序
            order: "desc"//默认排序方式
        }, {
            title: "上传时间",//标题
            field: "deliveryTime",//键名
            sortable: true,//是否可排序
            order: "desc"//默认排序方式
        }, {
            title: "操作",//标题
            align: 'center',
            field: "bookId",//键名
            formatter: function (value, row, index) {
                return '<a id="download" href="/download?deliveryName='+row.deliveryPath+'">下载</a>'
            }
        }]
    });
}