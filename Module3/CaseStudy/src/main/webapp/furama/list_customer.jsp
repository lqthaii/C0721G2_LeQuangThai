<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/11/2021
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
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
                <a class="nav-link ml-4" href="#">Employee<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link ml-4" href="#">Customer <span class="sr-only">(current)</span></a>
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
    <div id="list-example" class="list-group col-4">
        <a class="list-group-item list-group-item-action" href="#list-item-1">Item 1</a>
        <a class="list-group-item list-group-item-action" href="#list-item-2">Item 2</a>
        <a class="list-group-item list-group-item-action" href="#list-item-3">Item 3</a>
    </div>
    <div data-spy="scroll" data-target="#list-example" data-offset="0" class="scrollspy-example col-8">
        <table class="table caption-top">
            <caption>List of users</caption>
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Type Customer</th>
                <th scope="col">Name</th>
                <th scope="col">Birthday</th>
                <th scope="col">Identity card number</th>
                <th scope="col">Number Phone</th>
                <th scope="col">Email</th>
                <th scope="col">Address</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${customerList}" var="customer">
                <tr>
                    <th scope="col">${customer.getId()}</th>
                    <td>${customer.getIdTypeCustomer()}</td>
                    <td>${customer.getName()}</td>
                    <td>${customer.getBirthday()}</td>
                    <td>${customer.getIdentity()}</td>
                    <td>${customer.getNumberPhone()}</td>
                    <td>${customer.getEmail()}</td>
                    <td>${customer.getAddress()}</td>
                </tr>
            </c:forEach>
            </tbody>
            <c:if test="${messager}!=null">
                <tr>
                    <td>${messager}</td>
                </tr>
            </c:if>
            <tr>
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">Thêm khách hàng</button>

                <div class="modal fade bd-example-modal-lg" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">New message</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form method="post">
                                    <div class="form-group">
                                        <label for="id_customer" class="col-form-label">ID:</label>
                                        <input type="text" class="form-control" id="id_customer" name="id">
                                    </div>
                                    <div class="form-group">
                                        <label for="name_customer" class="col-form-label">Họ và tên:</label>
                                        <input type="text" class="form-control" id="name_customer" name="name">
                                    </div>
                                    <div class="form-group">
                                        <label for="birthday_customer" class="col-form-label">Ngày sinh:</label>
                                        <input type="text" class="form-control" id="birthday_customer" name="birthday">
                                    </div>
                                    <div class="form-group">
                                        <label for="identity_card_customer" class="col-form-label">Số Chứng Minh Nhân Dân:</label>
                                        <input type="text" class="form-control" id="identity_card_customer" name="identity_card">
                                    </div>
                                    <div class="form-group">
                                        <label for="number_phone_customer" class="col-form-label">Số Chứng Minh Nhân Dân:</label>
                                        <input type="text" class="form-control" id="number_phone_customer" name="number_phone">
                                    </div>
                                    <div class="form-group">
                                        <label for="email_customer" class="col-form-label">Email:</label>
                                        <input type="text" class="form-control" id="email_customer" name="email">
                                    </div>
                                    <div class="form-group">
                                        <label for="address_customer" class="col-form-label">Địa Chỉ:</label>
                                        <input type="text" class="form-control" id="address_customer" name="address">
                                    </div>
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-primary">Thêm khách hàng</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </tr>
        </table>
    </div>
</div>
<div class="row">
    <div class="mx-auto" style="width: 200px;">
        Footer
    </div>
</div>
<script>
    $('#exampleModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) // Button that triggered the modal
        var recipient = button.data('whatever') // Extract info from data-* attributes
        // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
        // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
        var modal = $(this)
        modal.find('.modal-title').text('Thêm khách hàng ')
        modal.find('.modal-body input').val(recipient)
    })
</script>
</body>
</html>
