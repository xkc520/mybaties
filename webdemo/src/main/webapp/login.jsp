<%@ page import="util.sqlsessionfactory" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="mapper.usermapper" %>
<%@ page import="pojo.user" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: 22138
  Date: 2022/7/28
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="css/login.css" rel="stylesheet">
</head>

<body>
<div id="loginDiv" style="height: 350px">
    <form action="/web/login" id="form"  method="post">
        <h1 id="loginMsg">LOGIN IN</h1>
        <div id="errorMsg">${error}</div>
        <p>Username:<input id="username" name="username" type="text" value="${cookie.c_username.value}"></p>

        <p>Password:<input id="password" name="password" type="password"  value="${cookie.c_password.value}"></p>
        <p>Remember:<input id="remember" name="remember" type="checkbox"  value="1"></p>
        <div id="subDiv">
            <input type="submit" class="button" value="login up">
            <input type="reset" class="button" value="reset">&nbsp;&nbsp;&nbsp;
            <a href="/web/register.jsp">没有账号？</a>
        </div>
    </form>
</div>

</body>
</html>
