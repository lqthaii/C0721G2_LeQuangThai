<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/12/2021
  Time: 2:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Convert Money</title>
</head>
<body>
<form action="/convert" method="post">
    <h1>Ứng dụng chuyển đổi tiền tệ</h1>
    <label for="usd">USD:</label>
    <input type="number" id="usd" name="usd"><br><br>
    <button type="submit">Chuyển đổi</button>
</form>
<p>VND: ${vnd}</p>
</body>
</html>
