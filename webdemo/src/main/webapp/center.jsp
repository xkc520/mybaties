<%--
  Created by IntelliJ IDEA.
  User: 22138
  Date: 2022/7/30
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>个人中心</title>
    <link rel="stylesheet" href="css/navigation bar.css">
    <link rel="stylesheet" href="css/center.css">
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
        <a href="login.html">登录</a>
    </div>
</div>

<div class="主体区">
    <div class="注册框">
        <h2>个人中心</h2>
        <div>
            <span>名称</span>
            <input type="button" class="text author-username" name="username" >
        </div>
        <div>
            <span>年龄</span>
            <input type="button" class="text author-userAge" name="age" >
        </div>
        <div>
            <span>性别</span>
            <input type="button" class="text author-userSex" name="sex" >

        </div>
        <div>
            <span>爱好</span>
            <input type="button" class="text author-userHobby" name="hobby">
        </div>
        <div>
            <span>职业</span>
            <input type="button" class="text author-userOccupation" name="hobby">
        </div>
        <div>
            <span>帖子数</span>
            <input type="button" class="text author-userPoint" name="occupation">
        </div>
        <div>
            <span>等级</span>
            <input type="button" class="text author-userClass" name="occupation">
        </div>
        <div>
            <span>用户注册时间</span>
            <input type="button" class="text author-userRegister" name="occupation">
        </div>
        <!--                <div>-->
        <!--                    <span>Email</span>-->
        <!--                    <input type="text" class="text" placeholder="请输入Email" name="email">-->
        <!--                </div>-->

        <!--                <div>-->
        <!--                    <button class="提交">注册</button>-->
        <!--                </div>-->
    </div>
</div>

<script src="js/center.js"></script>
</body>
</html>