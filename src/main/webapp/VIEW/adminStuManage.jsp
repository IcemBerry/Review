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


    <script src="${pageContext.request.contextPath}/assets/js/customize/adminStuManage.js"></script>
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
        <li><a href="/adminAddStu">添加学生</a></li>
        <li class="active"><a href="/adminStuManage">学生管理</a></li>
        <li><a href="/adminAddTch">添加教师</a></li>
        <li><a href="/adminTchManage">教师管理</a></li>
    </ul>

    <div class="alert alert-info">
        <p>学生状态<strong>影响答辩进度</strong>，在未获得正式授权函的情况下，请<strong>勿</strong>对<mark>重置状态</mark>进行操作</p>
    </div>


    <table id="adminStuTable"></table>

</div>

<footer class="footer">
    <div class="container">
        <p class="text-muted" id="footerText">Review System&emsp;&copy;2017 Niu Bing. All rights reserved.</p>
    </div>
</footer>

</body>
</html>