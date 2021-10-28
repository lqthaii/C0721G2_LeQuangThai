<%--
  Created by IntelliJ IDEA.
  User: conghoang
  Date: 29/10/2021
  Time: 3:32 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Simple Calculator</title>
  </head>
  <body>
  <h2>Simple Calculator</h2>
  <form action="/cal">
    <input type="text" name="firtopera" placeholder="Number one">
    <select name="operator" >
      <option value="+">+</option>
      <option value="-">-</option>
      <option value="*">x</option>
      <option value="/">:</option>
    </select>
    <input type="text" name="secondopera" placeholder="Number two">
    <input type="submit" value="Submit">
  </form>
  </body>
</html>
