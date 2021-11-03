<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/11/2021
  Time: 5:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <p>Thêm người dùng</p>
    <table>
        <tr>
            <th>ID</th>
            <td><input type="text" name="id" value="${id}" readonly></td>
        </tr>
        <tr>
            <th>Tên</th>
            <td><input type="text" name="name" placeholder="Vui lòng nhập tên"></td>
        </tr>
        <tr>
            <th>Email</th>
            <td><input type="text" name="email" placeholder="Vui lòng nhập Email"></td>
        </tr>
        <tr>
            <th>Country</th>
            <td><input type="text" name="country" placeholder="Vui lòng nhập địa chỉ"></td>
        </tr>
        <c:if test="${requestScope['messager']!=null}">
            <td><p>${messager}</p></td>
        </c:if>
        <tr><td><input type="submit" value="Sửa"></td></tr>
        <tr><td><a href="/users">Back to list</a></td></tr>
    </table>
</form>
</body>
</html>
