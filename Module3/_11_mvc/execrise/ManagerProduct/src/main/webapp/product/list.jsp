<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/10/2021
  Time: 6:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>PRODUCT MANAGER</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Giá</th>
        <th>Mô Tả</th>
    </tr>
    <c:forEach var="product" items='${requestScope["productList"]}'>
        <tr>
            <td><a href="/products?action=view&id=${product.getId()}">${product.getId()}</a></td>
            <td>${product.getName()}</td>
            <td>${product.getPrice().toString()}</td>
            <td><button onclick="window.location.href='/products?action=delete&id=${product.getId()}'">Xoá</button></td>
            <td><button onclick="window.location.href='/products?action=edit&id=${product.getId()}'">Sửa</button></td>
        </tr>
    </c:forEach>
</table>
<td><button onclick="window.location.href='/products?action=create'">Thêm sản phẩm</button></td>
</body>
</html>
