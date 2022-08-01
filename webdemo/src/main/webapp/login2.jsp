<%--
  Created by IntelliJ IDEA.
  User: 22138
  Date: 2022/7/30
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="css/navigation bar.css">
    <link rel="stylesheet" href="css/logindemo.css">
</head>
<body>

<div class="导航栏">
    <div class="left-logo">
        <div class="logo"><img src="img/系统图标.png" width="45"></div>
        <p>论坛管理信息系统</p>
    </div>

    <div class="占位"></div>

    <div class="right-function">
        <span class="center"></span>
        <a href="list.html">主页</a>
        <a href="editor.html" target="_blank">写帖子</a>
        <a href="logon.html">注册</a>
    </div>
</div>

<div class="主体区">
    <div class="登录框">
        <form action="/web/login" method="post">
            <h2>登录</h2>
            <div>
                <span>用户名</span>
                <input type="text" class="text" name="username" value="${cookie.c_username.value}">
            </div>
            <div>
                <span>密码</span>
                <input type="password" class="text" name="password" value="${cookie.c_password.value}">
            </div>
            <div>
                <button class="提交" type="submit">登录</button>
            </div>
        </form>
    </div>
</div>

</body>
</html>