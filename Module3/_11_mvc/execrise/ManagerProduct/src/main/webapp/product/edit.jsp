<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/10/2021
  Time: 7:31 PM
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
            <td>ID: </td>
            <td><input type="text" name="id" value="${requestScope["product"].getId()}" readonly></td>
        </tr>
        <tr>
            <td>Name: </td>
            <td><input type="text" name="name" value="${requestScope["product"].getName()}"></td>
        </tr>
        <tr>
            <td>Price: </td>
            <td><input type="text" name="price" value="${requestScope["product"].getPrice().toString()}"></td>
        </tr>
        <tr>
            <td>Description: </td>
            <td><input type="text" name="description" value="${requestScope["product"].getDescription()}"></td>
        </tr>
    </table>
    <input type="submit" value="Cập nhật"><br>
    <a href="/products">Back to Product list</a>
</form>
<p>
    <c:if test='${requestScope["messager"]!=null}'>
        <span>${messager}</span>
    </c:if>
</p>
</body>
</html>