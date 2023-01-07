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
        <form action="/new-register-demo/loginServlet" >
            <h1>Login</h1>

            <div>${login_msg}${register_msg}</div>

            <p>Username: <input type="text" name="username" value="${cookie.username.value}"> </p>
            <p>password: <input type="password" name="password" value="${cookie.password.value}"> </p>
            <p>记住我: <input type="checkbox" name="remember" value="1"> </p>
            <p><a href="register.jsp">点我注册</a> </p>

            <div>
                <input type="submit" value="login up">
                <input type="reset" value="reset">
            </div>
        </form>
    </div>
</body>
</html>
