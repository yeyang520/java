<%--
  Created by IntelliJ IDEA.
  User: boy
  Date: 2022/12/28
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Hello world</h1>

    <%
        System.out.println("hello world");
        String a = "加油";
        for(int i=0;i<10;++i){
    %>
        <table border="1">
            <tr>
                <td>a</td>
            </tr>
        </table>
    <%
        }
    %>

</body>
</html>
