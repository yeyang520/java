<%--
  Created by IntelliJ IDEA.
  User: boy
  Date: 2023/1/1
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>登录</title>
</head>
<body>
    <div>
        <form action="/new-register-demo/registerServlet" >
            <h1>Login</h1>

            <div>${register_msg}</div>

            <p>Username: <input type="text" name="username"> </p>
            <p>password: <input type="password" name="password"> </p>

            <p>验证码：
                <input type="text" name="checkCode">
                <img src="/new-register-demo/checkCodeServlet" alt="#" id="changeCode">
                <a href="#" id="changeCodeImage">看不清</a>
            </p>

            <div>
                <input type="submit" value="login up">
                <input type="reset" value="reset">
            </div>
        </form>
    </div>
    <script>
        // 点击看不清时更换图片
        document.getElementById("changeCodeImage").onclick = function (){
            //每次加上时间，如果不加 图片会加入缓存，点击后不会更换图片
            document.getElementById("changeCode").src="/new-register-demo/checkCodeServlet?"+new Date().getMilliseconds();
        }



    </script>
</body>
</html>
