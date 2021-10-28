<%--
  Created by IntelliJ IDEA.
  User: conghoang
  Date: 29/10/2021
  Time: 3:04 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Manager Customer</title>
  </head>
  <body>
  <table>
    <tr>
      <th>Tên</th>
      <th>Ngày sinh</th>
      <th>Địa chỉ</th>
    </tr>
    <c:forEach var="customer" items="${customerServlet}">
    <tr>
      <td>${customer.name}</td>
      <td><c:out value="${customer.dateOfBirth}"/></td>
      <td><c:out value="${customer.address}"/></td>
    </tr>
    </c:forEach>
  </table>
  </body>
</html>
