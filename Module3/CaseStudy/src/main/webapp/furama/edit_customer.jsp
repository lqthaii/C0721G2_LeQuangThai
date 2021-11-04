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
        <div class="col-1">
            <a class="navbar-brand" href="#">
                <img src="/docs/4.1/assets/brand/bootstrap-solid.svg" width="30" height="30" alt="">
            </a>
        </div>
        <div class="col-9"></div>
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
                    <a class="nav-link ml-4" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link ml-4" href="/employee?actionUser=listEmployee">Employee<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link ml-4" href="/customer?actionUser=listCustomer">Customer <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link ml-4" href="#">Service <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link ml-4" href="#">Contract <span class="sr-only">(current)</span></a>
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
            <a class="list-group-item list-group-item-action" href="#list-item-3">Item 3</a>
        </div>
        <div data-spy="scroll" data-target="#list-example" data-offset="0" class="scrollspy-example col-10">
            <form method="post">
                <div class="form-group">
                    <label for="idCustomer">ID</label>
                    <input type="text" class="form-control" id="idCustomer"  name="id" value="${customer.getId()}" readonly>
                </div>
                <div class="form-group">
                    <label for="nameCustomer">Họ và tên</label>
                    <input type="text" class="form-control" id="nameCustomer" value="${customer.getName()}" name="name">
                </div>
                <div class="form-group">
                    <label for="typeCustomer">Loại khách hàng</label>
                    <select class="form-control" id="typeCustomer" name="typeCustomer">
                        <c:forEach var="type" items="${typeCustomer}">
                            <option value="${type.getId()}" >${type.getId()}-${type.getName()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="birthdayCustomer">Ngày sinh</label>
                    <input type="date" class="form-control" id="birthdayCustomer" value="${customer.getBirthday()}" name="birthday">
                </div>
                <div class="form-group">
                    <label for="identityCustomer">Số chứng minh nhân dân</label>
                    <input type="text" class="form-control" id="identityCustomer" value="${customer.getIdentity()}" name="identity_card">
                </div>
                <div class="form-group">
                    <label for="numberPhoneCustomer">Số điện thoại</label>
                    <input type="text" class="form-control" id="numberPhoneCustomer" value="${customer.getNumberPhone()}" name="number_phone">
                </div>
                <div class="form-group">
                    <label for="emailCustomer">Email</label>
                    <input type="email" class="form-control" id="emailCustomer" value="${customer.getEmail()}" name="email">
                </div>
                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Địa Chỉ</label>
                    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="address"></textarea>
                </div>
                <button type="button" class="btn btn-secondary" onclick="window.location.href='/customer'">Quay lại</button>
                <button type="submit" class="btn btn-primary">Sửa khách hàng</button>
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

