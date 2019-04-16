<%--
  Created by IntelliJ IDEA.
  User: lihao
  Date: 2019/3/27
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
</head>
<body>
<%--    <form name = "user" method="post">
        <input type="text" id = "username" placeholder="请输入用户名"/><br/>
        <input type="password" placeholder="请输入密码" id = "password"/><br/>
        <input type="text" placeholder="请输入验证码" id = "code"/><img src="../user/code" alt="换一张"  id="validationImage"><button onclick="change()">换着一张</button><br/>
        <input type="submit" value="登录" id ="login">
        <p>${user.id}</p>
        <p>${user.name}</p>
        <p>${user.password}</p>

    </form>--%>
<form action="/user/uploadfiles" method="post" enctype="multipart/form-data">
    <p>
        选择文件：<input type="file" name="files">
    </p>
    <p>
        选择文件：<input type="file" name="files">
    </p>
    <p>
        选择文件：<input type="file" name="files">
    </p>
    <input type="submit" value="提交">
</form>
</body>
<script>
    $(document).ready(function () {
        console.log(1);
        change();
    });
    function change() {
        console.log(11);
        $("#validationImage").attr('src', $("#validationImage").attr('src') + "?" + new Date().getTime());
    }
</script>
</html>
