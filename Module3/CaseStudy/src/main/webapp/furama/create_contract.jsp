<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/11/2021
  Time: 6:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-1"></div>
        <div class="col-1">
            <a class="navbar-brand" href="">
                <img src="img/logo.png" width="50" height="50" alt="">
            </a>
        </div>
        <div class="col-8"></div>
        <div class="col-2">
            <a class="navbar-brand" href="#">Lê Quang Thái</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>
    </div>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="#"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link ml-4" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link ml-4" href="/employee?actionUser=listEmployee">Employee<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link ml-4" href="/customer?actionUser=listCustomer">Customer <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link ml-4" href="/service">Service <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link ml-4" href="/contract">Contract <span class="sr-only">(current)</span></a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
    <div class="row mt-3">
        <div id="list-example" class="list-group col-2">
            <a class="list-group-item list-group-item-action" href="/employee?actionUser=listEmployee">Employee</a>
            <a class="list-group-item list-group-item-action" href="/customer?actionUser=listCustomer">Customer</a>
            <a class="list-group-item list-group-item-action" href="/service">Service</a>
        </div>
        <div data-spy="scroll" data-target="#list-example" data-offset="0" class="scrollspy-example col-10">
            <form method="post" action="/contract?actionUser=create">
                <div class="form-group">
                    <label for="idService">ID</label>
                    <input type="text" class="form-control" id="idService" placeholder="1" name="id">
                </div>
                <div class="form-group">
                    <label for="employee">Nhân viên</label>
                    <select class="form-control" id="employee" name="employee">
                        <c:forEach var="type" items="${employees}">
                            <option value="${type.getId()}" >${type.getId()}-${type.getName()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="customer">Khách hàng</label>
                    <select class="form-control" id="customer" name="customer">
                        <c:forEach var="type" items="${customers}">
                            <option value="${type.getId()}" >${type.getId()}-${type.getName()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="service">Dịch vụ</label>
                    <select class="form-control" id="service" name="service">
                        <c:forEach var="type" items="${services}">
                            <option value="${type.getId()}" >${type.getId()}-${type.getArea()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="dateCreateContract">Ngày làm hợp đồng</label>
                    <input type="date" class="form-control" id="dateCreateContract" name="dateCreateContract">
                </div>
                <div class="form-group">
                    <label for="dateEnd">Ngày kết thúc</label>
                    <input type="date" class="form-control" id="dateEnd" name="dateEnd">
                </div>
                <div class="form-group">
                    <label for="deposits">Tiền đặt cọc</label>
                    <input type="number" class="form-control" id="deposits" placeholder="50000" name="deposits">
                </div>
                <div class="form-group">
                    <label for="totalMoney">Tổng tiền</label>
                    <input type="number" class="form-control" id="totalMoney" placeholder="100000" name="totalMoney">
                </div>
                <button type="button" class="btn btn-secondary" onclick="window.location.href='/index.jsp'">Quay lại Trang Chủ</button>
                <button type="submit" class="btn btn-primary">Thêm dịch vụ</button>
            </form>
        </div>
    </div>
    <div class="row mb-0">
        <div class="mx-auto" style="width: 200px;">
            Footer
        </div>
    </div>
</div>
</body>
</html>

