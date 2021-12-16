<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/12/2021
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<form action="/research" method="get">
    <label for="name">Điền từ cần tìm</label>
    <input type="text" id="name" name="dictionary" placeholder="Điền từ cần tìm"><br>
    <button type="submit">Tìm kiếm</button>
</form>
<p>${result}</p>
</body>
</html>
