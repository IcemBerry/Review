<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登陆</title>


    <link href="${pageContext.request.contextPath}/assets/css/goldbootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap-table.min.css" rel="stylesheet">


    <script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap-table.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap-table-zh-CN.min.js"></script>


    <link href="${pageContext.request.contextPath}/assets/css/footer.css" rel="stylesheet">
</head>

<body>
<div class="container">

    <div class="well col-md-6 col-md-offset-3" id="loginBox">

        <div class="alert alert-info">
            <p>请输入原密码</p>
            <p>原密码输入正确方可修改新密码</p>
        </div>

        <form class="form-horizontal" action="/editUser" method="post">

            <div class="form-group">
                <label for="oldPassword" class="col-md-2 control-label">原密码</label>
                <div class="col-md-10">
                    <input type="password" name="oldPassword" id="oldPassword" class="form-control" placeholder="原密码">
                </div>
            </div>

            <div class="form-group">
                <label for="newPassword" class="col-md-2 control-label">新密码</label>
                <div class="col-md-10">
                    <input type="password" name="newPassword" id="newPassword" class="form-control" placeholder="新密码">
                </div>
            </div>

            <div class="form-group">
                <div class="col-md-10 col-md-offset-2">
                    <input type="submit" class="btn btn-success" name="submitDesc" value="确认修改">
                </div>
            </div>
        </form>
    </div>

</div>

</body>
</html>