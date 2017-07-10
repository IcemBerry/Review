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
        <li class="active"><a href="/adminAddStu">添加学生</a></li>
        <li><a href="/adminStuManage">学生管理</a></li>
        <li><a href="/adminAddTch">添加教师</a></li>
        <li><a href="/adminTchManage">教师管理</a></li>
    </ul>

    <div class="well well-sm">
        <form class="form-horizontal" enctype="multipart/form-data" action="/addUser" method="post">
            <fieldset>
                <legend>添加学生</legend>
                <div class="form-group">
                    <label for="userName" class="col-md-2 control-label">学生姓名</label>
                    <div class="col-md-10">
                        <input type="text" class="form-control" id="userName" name="userName">
                    </div>
                </div>
                <div class="form-group">
                    <label for="userNum" class="col-md-2 control-label">学生学号</label>
                    <div class="col-md-10">
                        <input type="number" class="form-control" id="userNum" name="userNum">
                    </div>
                </div>
                <div class="form-group">
                    <label for="userLead" class="col-md-2 control-label">指导老师</label>
                    <div class="col-md-10">
                        <select class="form-control" id="userLead" name="userLead">
                            <c:forEach items="${teacherList}" var="teach">
                                <option value="${teach.userId}">${teach.userName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="userCollege" class="col-md-2 control-label">学生院系</label>
                    <div class="col-md-10">
                        <input type="text" class="form-control" id="userCollege" name="userCollege">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-10 col-md-offset-2">
                        <input type="submit" class="btn btn-primary">
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