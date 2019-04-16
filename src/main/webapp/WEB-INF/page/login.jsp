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
        <span>用户名：</span><input type="text" id= "name" placeholder="请输入用户名"/><br/>
        <span>密码：</span><input type="password" placeholder="请输入密码" id = "password"/><br/>
        <span>验证码：</span><input type="text" placeholder="请输入验证码" id = "code"/><img src="../user/code" alt="换一张"  id="validationImage"><button onclick="change()">换一张</button><br/>
        <input type="submit" value="登录" id ="login" onclick="login()">
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
    function  login() {
        var name = $("#name").val();
        var password =$("#password").val();
        var code =$("#code").val();
        console.log(name);
        console.log(password);
        console.log(code);
        var param ={
            name : name,
            password :password,
            code : code
        }
        $.ajax({
            url:"../user/loginin",
            type:"POST",
            data:param,
            success:function (res) {
                if(res.data =="登录成功"){
                    window.location.href = "../home/index"
                }
            }
        });


    }
</script>
</html>
