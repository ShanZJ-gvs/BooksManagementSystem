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
    <title> LOGIN</title>
    <link rel="stylesheet" type="text/css" href="static/css/NewLogin.css" />
    <link rel="stylesheet" type="text/css" href="static/css/font-awesome.css"/>
    <style type="text/css">
        body{
            background-image: url("static/image/1.jpg");
            background-repeat:no-repeat;
            background-size: 100% auto;
        }
    </style>

</head>
<body>
<div id="login_box">
    <h2> LOGIN</h2>
    <div id="form">
        <div class="input_box">
            <i class="fas fa-user"></i>
            <input type="text" placeholder="Username">
        </div>
        <div class="input_box">
            <i class="fas fa-lock"></i>
            <input type="password" placeholder="Password">
        </div>
    </div>
    <button>Sign in</button>
    <div id="sign-in">
        <a href="#">忘记密码？</a>
    </div>
</div>
</body>
</html>
