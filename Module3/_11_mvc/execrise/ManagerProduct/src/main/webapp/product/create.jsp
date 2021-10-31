<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/10/2021
  Time: 8:49 PM
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
            <td><label>ID</label></td>
            <td><input type="text" name="id" placeholder="Vui lòng nhập ID tại đây"></td>
        </tr>
        <tr>
            <td><label>Tên sản phâm</label></td>
            <td><input type="text" name="name" placeholder="Vui lòng nhập tên tại đây"></td>
        </tr>
        <tr>
            <td><label>Giá</label></td>
            <td><input type="text" name="price" placeholder="Vui lòng nhập giá tại đây"></td>
        </tr>
        <tr>
            <td><label>Mô tả sản phẩm</label></td>
            <td><input type="text" name="description" placeholder="Vui lòng nhập mô tả tại đây"></td>
        </tr>
    </table>
    <input type="submit" value="Tạo sản phẩm">
    <p><c:if test="${requestScope['message']!=null}">
        <span>  <span class="message">${requestScope["message"]}</span></span>
    </c:if></p>
    <a href="/products">Back to list</a>
</form>
</body>
</html>
