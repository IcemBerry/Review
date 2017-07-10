<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>毕业材料进度</title>


    <link href="${pageContext.request.contextPath}/assets/css/goldbootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap-table.min.css" rel="stylesheet">


    <script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap-table.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap-table-zh-CN.min.js"></script>


    <link href="${pageContext.request.contextPath}/assets/css/footer.css" rel="stylesheet">
</head>

<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand text-center" href="/stuProgress">
                Review
            </a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" role="button" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false">
                        ${user.userName}
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="/editUser">设置</a></li>
                        <li><a href="/logout">登出</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container" id="mainCon">

    <ul class="nav nav-pills" id="mainNav">
        <li><a href="/tchInfo">答辩信息</a></li>
        <li class="active"><a href="/tchUpload">范例上传</a></li>
        <li><a href="/tchDownload">交付物下载</a></li>
        <li><a href="/tchReview">成绩审核</a></li>
    </ul>

    <div class="alert alert-info">
        <p>
            附件上传时请注意选择上传附件类型
        </p>
    </div>

    <div class="well well-sm">
        <form class="form-horizontal" enctype="multipart/form-data" action="/tchUpload" method="post">
            <fieldset>
                <legend id="stage">模板上传</legend>
                <div class="form-group">
                    <label for="uploadType" class="col-md-2 control-label">模板类型</label>
                    <div class="col-md-10">
                        <select class="form-control" id="uploadType" name="uploadType">
                            <option value="1">开题报告</option>
                            <option value="2">中期验收报告</option>
                            <option value="3">实验报告/论文</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="uploadFile" class="col-md-2 control-label">模板文件</label>
                    <div class="col-md-10">
                        <input type="file" class="form-control" id="uploadFile" name="uploadFile">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-10 col-md-offset-2">
                        <input type="submit" class="btn btn-primary" value="上传">
                    </div>
                </div>
            </fieldset>
        </form>
    </div>

</div>

<footer class="footer">
    <div class="container">
        <p class="text-muted" id="footerText">Review System&emsp;&copy;2017 Niu Bing. All rights reserved.</p>
    </div>
</footer>

</body>
</html>