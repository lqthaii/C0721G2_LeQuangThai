<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/11/2021
  Time: 2:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Email</th>
        <th>Địa chỉ</th>
    </tr>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.getId()}</td>
            <td><a href="/users?id=${user.getId()}&action=view">${user.getName()}</a></td>
            <td>${user.getEmail()}</td>
            <td>${user.getCountry()}</td>
        </tr>
    </c:forEach>
</table>
<button onclick="window.location.href='/users?action=create'">Create</button>
<td><button onclick="window.location.href='/?action=sortbyname'">Sắp xếp theo tên</button></td>
<td><button onclick="window.location.href='/?action=country'">Tìm kiếm theo địa chỉ</button></td>
</body>
</html>
