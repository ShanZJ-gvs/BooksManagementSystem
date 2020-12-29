<%--
  Created by IntelliJ IDEA.
  User: 单子健
  Date: 2020/12/3
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>登录</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/Pretty-Registration-Form.css">
    <link rel="stylesheet" href="assets/css/styles.css">

    <script>
        function exitName() {
            $.post({
                url:"${pageContext.request.contextPath}/login",
                data:{"name":$("#name").val()},
                success:function (data) {
                    console.log(data);

                    if (data.toString()==="UserNameOK"){
                        $("#userInfo").css("color","green");

                    }
                    $("#userInfo").html(data);
                }

            })

        }

        function exitPwd() {
            $.post({
                url:"${pageContext.request.contextPath}/login",
                data:{"pwd":$("#pwd").val()},
                success:function (data) {
                    console.log(data);
                    if (data.toString()=="UserPwdOK"){
                        $("#pwdInfo").css("color","green");

                    }
                    $("#pwdInfo").html(data);
                }
            })
        }
    </script>
</head>

<body style="background-image: url('assets/img/avatars/img-8950fe813f67bd95f918e80b881a312c.jpg');background-repeat: no-repeat;background-size: cover;background-position: right;">
<div class="row m-auto register-form">
    <div class="col-md-8 offset-md-2">
        <form class="custom-form"  action="${pageContext.request.contextPath}/login" method="post">
            <h1>登 &nbsp;录</h1>
            <div class="form-row form-group">
                <div class="col-sm-4 label-column">
                    <label class="col-form-label" for="email-input-field">用户名</label>
                </div>
                <div class="col-sm-6 input-column">
                    <input class="form-control" type="text" id="name" onblur="exitName()">
                    <span id="userInfo"></span>
                </div>
            </div>
            <div class="form-row form-group">
                <div class="col-sm-4 label-column">
                    <label class="col-form-label" for="pawssword-input-field">密码 </label>
                </div>
                <div class="col-sm-6 input-column">
                    <input class="form-control" type="password" id="pwd" onblur="exitPwd()">
                    <span id="pwdInfo"></span>
                </div>
            </div>
            <div class="form-row form-group">
                <div class="col-sm-4 label-column">
                    <label class="col-form-label" for="email-input-field">验证码</label>
                </div>
                <div class="col-sm-6 input-column">
                    <input class="form-control" type="text">
                </div>
            </div>
            <button class="btn btn-primary border rounded submit-button" type="submit">登录</button>
            <button class="btn btn-primary border rounded submit-button" type="button">注册</button></form>
    </div>
</div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>
