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
        <li class="active"><a href="/tchInfo">答辩信息</a></li>
        <li><a href="/tchUpload">范例上传</a></li>
        <li><a href="/tchDownload">交付物下载</a></li>
        <li><a href="/tchReview">成绩审核</a></li>
    </ul>

    <div class="alert alert-info">
        <p>答辩组共有<mark id="successNum">${successNum}</mark>名同学完成阶段任务</p>
        <p>其中有</p>
        <p><mark id="state0">${state0}</mark>名同学尚未选题</p>
        <p><mark id="state1">${state1}</mark>名同学选题成功</p>
        <p><mark id="state2">${state2}</mark>名同学开题成功</p>
        <p><mark id="state3">${state3}</mark>名同学通过中期检查</p>
    </div>
    <div class="alert alert-success">
        <p>答辩组内共有<mark id="state4">${state4}</mark>名同学已完成答辩</p>
    </div>
    <div class="alert alert-danger">
        <p>答辩组内共有<mark id="failNum">${failNum}</mark>名同学未完成阶段任务</p>
        <p>其中有</p>
        <p><mark id="stateN1">${stateN1}</mark>名同学选题失败</p>
        <p><mark id="stateN2">${stateN2}</mark>名同学开题失败</p>
        <p><mark id="stateN3">${stateN3}</mark>名同学未通过中期检查</p>
        <p><mark id="stateN4">${stateN4}</mark>名同学未通过论文审核</p>
    </div>

</div>

<footer class="footer">
    <div class="container">
        <p class="text-muted" id="footerText">Review System&emsp;&copy;2017 Niu Bing. All rights reserved.</p>
    </div>
</footer>

</body>
</html>