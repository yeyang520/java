<%--
  Created by IntelliJ IDEA.
  User: boy
  Date: 2022/12/30
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <input type="button" value="新增" id="add"><br>
    <hr>

    <table border="1" cellpadding="0" width="80%">
        <tr>
            <th>序号</th>
            <th>品牌名称</th>
            <th>企业名称</th>
            <th>排序</th>
            <th>品牌</th>
            <th>状态</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${brands}" var="brand" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${brand.brandName}</td>
                <td>${brand.companyName}</td>
                <td>${brand.ordered}</td>
                <td>${brand.description}</td>
                <c:if test="${brand.status == 1}">
                    <td>启用</td>
                </c:if>
                <c:if test="${brand.status != 1}">
                    <td>禁用</td>
                </c:if>
                <td>
                    <a href="/brand-demo/selectByIdServlet?id=${brand.id}">修改</a>
                    <a href="/brand-demo/deleteServlet?id=${brand.id}">删除</a>
                </td>
            <tr>
        </c:forEach>

    </table>

    <script>

        document.getElementById("add").onclick = function (){
            location.href = "/brand-demo/addBrand.jsp";
        }

    </script>
</body>
</html>
