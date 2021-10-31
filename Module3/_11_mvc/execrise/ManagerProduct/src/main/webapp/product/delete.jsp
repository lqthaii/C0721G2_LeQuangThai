<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/10/2021
  Time: 8:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <th>ID</th>
            <td>${requestScope["product"].getId()}</td>
        </tr>
        <tr>
            <th>Name</th>
            <td>${requestScope["product"].getName()}</td>
        </tr>
        <tr>
            <th>Price</th>
            <td>${requestScope["product"].getPrice().toString()}</td>
        </tr>
        <tr>
            <th>Description</th>
            <td>${requestScope["product"].getDescription()}</td>
        </tr>
    </table>
    <input type="submit" value="Xoá">
</form>
</body>
</html>
