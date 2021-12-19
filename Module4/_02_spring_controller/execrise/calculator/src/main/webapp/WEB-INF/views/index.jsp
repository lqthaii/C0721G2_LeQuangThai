<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/12/2021
  Time: 9:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/calculator" method="post">
    <input type="number" name="number1">
    <select name="calculation">
      <option>Choose ...</option>
      <option value="+">Addition</option>
      <option value="-">Subtraction</option>
      <option value="*">Multiplication</option>
      <option value="/">Division</option>
    </select>
    <input type="number" name="number2">
    <button type="submit">Calculator</button>
  </form>
  <p>Result:${result}</p>
  </body>
</html>
