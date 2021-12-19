<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/12/2021
  Time: 8:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>SandWich Condiments</h1>
<form action="/sandwich" method="get">
    <input type="checkbox" id="sandwich1" name="sandwich" value="Lettuce">
    <label for="sandwich1">Lettuce</label>
    <input type="checkbox" id="sandwich2" name="sandwich"  value="Tomato">
    <label for="sandwich2">Tomato</label>
    <input type="checkbox" id="sandwich3" name="sandwich"  value="Mustard">
    <label for="sandwich3">Mustard</label>
    <input type="checkbox" id="sandwich4" name="sandwich"  value="Sprouts">
    <label for="sandwich4">Sprouts</label><br>
    <button type="submit">Xác nhận</button>
</form>
</body>
</html>
