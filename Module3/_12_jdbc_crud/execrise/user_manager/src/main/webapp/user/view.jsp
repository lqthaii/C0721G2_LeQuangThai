<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/11/2021
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
    <table border="1">
        <tr>
            <td>ID</td>
            <td>Tên</td>
            <td>Email</td>
            <td>Country</td>

        </tr>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getName()}</td>
                <td>${user.getEmail()}</td>
                <td>${user.getCountry()}</td>
            </tr>
        </c:forEach>
        <tr>
            <td><a href="/users">Back to list</a></td>
        </tr>
    </table>
</form>
</body>
</html>
