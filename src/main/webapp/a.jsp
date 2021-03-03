<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/27
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<a href="account/findAll">测试查询</a>--%>
<%--<h3>测试包</h3>--%>
<%--<form action="account/save" method="post"><br/>--%>
<%--    姓名:<input type="text" name="name"><br/>--%>
<%--    金额:<input type="text" name="money"><br/>--%>
<%--    <input type="submit" value="保存"><br/>--%>
<%--</form>--%>

<form method="post" action="/fileupload4" enctype="multipart/form-data">
    选择文件：<input type="file" name="uploadFile">
    <input type="submit" value="哈">
</form>

</body>
</html>