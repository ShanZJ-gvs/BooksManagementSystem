<%--
  Created by IntelliJ IDEA.
  User: 单子健
  Date: 2020/12/29
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>图书馆-注册</title>
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

<body style="background-image: url('assets/img/avatars/img-8950fe813f67bd95f918e80b881a312c.jpg');background-repeat: no-repeat;background-size: cover;background-position: top;">
<div class="row m-auto register-form">
    <div class="col-md-8 offset-md-2">
        <form class="custom-form">
            <h1>注 &nbsp;册</h1>
            <div class="form-row form-group">
                <div class="col-sm-4 label-column">
                    <label class="col-form-label" for="name-input-field">昵称 </label>
                </div>
                <div class="col-sm-6 input-column">
                    <input class="form-control" type="text" id="name" onblur="exitName()">
                    <span id="nameInfo"></span>
                </div>
            </div>
            <div class="form-row form-group">
                <div class="col-sm-4 label-column">
                    <label class="col-form-label" for="email-input-field">用户名</label>
                </div>
                <div class="col-sm-6 input-column">
                    <input class="form-control" type="text" id="user" onblur="exitUser()">
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
                    <label class="col-form-label" for="repeat-pawssword-input-field">重输密码&nbsp;</label>
                </div>
                <div class="col-sm-6 input-column">
                    <input class="form-control" type="password" id="pwd2" onblur="exitPwd2()">
                    <span id="pwdInfo2"></span>
                </div>
            </div>
            <div class="form-row form-group">
                <div class="col-sm-4 label-column">
                    <label class="col-form-label" for="repeat-pawssword-input-field">邮箱</label>
                </div>
                <div class="col input-column">
                    <input class="form-control" type="email" id="email" onblur="exitEmail()">
                    <span id="emailInfo"></span>
                </div>
                <div class="col-2">
                    <div class="dropdown">
                        <button class="btn btn-light dropdown-toggle" data-toggle="dropdown" aria-expanded="false" type="button" style="height: 41px;">@gmail.com&nbsp;</button>
                        <div class="dropdown-menu" role="menu">
                            <a class="dropdown-item" role="presentation" href="#">@qq.com</a>
                            <a class="dropdown-item" role="presentation" href="#">@163.com</a>
                            <a class="dropdown-item" role="presentation" href="#">其他</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-row form-group">
                <div class="col-sm-4 label-column">
                    <label class="col-form-label" for="dropdown-input-field">性别 </label>
                </div>
                <div class="col-sm-4 d-xl-flex align-items-xl-center input-column">
                    <input type="radio" name="sex" style="height: 19px;"><label style="margin-right: 8px;">男</label>
                    <input type="radio" name="sex" style="height: 19px;"><label>女</label>
                </div>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" id="formCheck-3">
                <label class="form-check-label" for="formCheck-3">I've read and accept the terms and conditions</label>
            </div>
            <button class="btn btn-primary border rounded submit-button"
                                                                                                                                                                                                                          type="button">注册</button></form>
    </div>
</div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
