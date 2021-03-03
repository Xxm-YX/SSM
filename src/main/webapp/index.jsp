<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/3/6
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<div>
    <form action="login">
        <table>
            <tr>
                <td>用户名: </td>
                <td><input type="text" id="username" name="username" placeholder="输入用户名..."></td>
            </tr>
            <tr>
                <td>密码: </td>
                <td><input type="password" id="password" name="password" placeholder="请输入密码..."></td>
            </tr>
            <tr>
                <td><button type="submit">登陆</button></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

