<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/26/2021
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product Discount Calculator</title>
  </head>
  <body>
  <form action="/cal" method="post">
    <h2>Product Discount Calculator</h2>
    <label>Product Description</label>
    <input type="text" placeholder="Product Description" name="description"><br>
    <label>List Price</label>
    <input type="text" placeholder="List Price" name="price"><br>
    <label>Discount Percent</label>
    <input type="text" placeholder="Discount Percent" name="discount"><br>
    <input type="submit" value="Calculate Discount">
  </form>
  </body>
</html>
