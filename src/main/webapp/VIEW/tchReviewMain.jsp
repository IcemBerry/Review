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
        <li><a href="/tchUpload">范例上传</a></li>
        <li><a href="/tchDownload">交付物下载</a></li>
        <li class="active"><a href="/tchReview">成绩审核</a></li>
    </ul>

    <div class="col-gold-lg">
        <div class="alert alert-info">
            <p>学生姓名：
                <mark>${review.userName}</mark>
            </p>
            <p>题目：
                <mark id="title">${review.topic}</mark>
            </p>
        </div>
        <textarea class="form-control" rows="3" readonly>${review.lastDesc}</textarea>
        <table class="table">
            <thead>
            <th>#</th>
            <th>类型</th>
            <th>时间</th>
            <th>操作</th>
            </thead>
            <tbody>
            <c:forEach items="${review.deliveryLiteList}" var="list" varStatus="dex">
                <tr>
                    <td>${dex.index+1}</td>
                    <td>${list.type}</td>
                    <td>${list.time}</td>
                    <td><a href="/download?deliveryName=${list.path}">下载</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>

    <div class="col-gold-sm">
        <div class="well">
            <form class="form-horizontal" id="message" action="/submitReview" method="post">
                <fieldset>
                    <legend id="stage">评审意见</legend>

                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="number" class="form-control" name="scoreNum" placeholder="分数（仅限论文审核）">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-12">
                            <textarea class="form-control" rows="3" name="msg" placeholder="评语/修改意见（选填）"></textarea>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="radio">
                                <label>
                                    <input type="radio" name="judge" value="pass" checked>
                                    通过评审，进入下一阶段
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="judge" value="notPass">
                                    不通过评审，依据修改意见进行修改
                                </label>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-gold-sm">
                            <input type="hidden" name="stuId" value="${stu.userId}">
                            <input type="hidden" name="stuState" value="${stu.userState}">
                            <input type="hidden" name="topic" value="${review.lastDesc}">
                            <input type="hidden" name="scoreId" value="${review.scoreId}">
                            <input type="submit" class="btn btn-primary" value="确认评审意见">
                        </div>
                    </div>

                </fieldset>
            </form>
        </div>
    </div>
</div>

<footer class="footer">
    <div class="container">
        <p class="text-muted" id="footerText">Review System&emsp;&copy;2017 Niu Bing. All rights reserved.</p>
    </div>
</footer>

</body>
</html>