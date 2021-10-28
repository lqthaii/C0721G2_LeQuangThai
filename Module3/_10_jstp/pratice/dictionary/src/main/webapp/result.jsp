<%--
  Created by IntelliJ IDEA.
  User: conghoang
  Date: 29/10/2021
  Time: 2:46 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p> Search:
     <c:out value="${search}" />
</p>
<p> Result:
     <c:out value="${result}" />
</p>
</body>
</html>
