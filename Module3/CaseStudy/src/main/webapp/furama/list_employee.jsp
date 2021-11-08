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
    <link rel="stylesheet" href="cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
    <script src="cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row header">
        <div class="col-1"></div>
        <div class="col-1">
            <a class="navbar-brand" href="">
                <img src="img/logo.png" width="50" height="50" alt="">
            </a>
        </div>
        <div class="col-8"></div>
        <div class="col-2">
            <a class="navbar-brand" href="">Lê Quang Thái</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>
    </div>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href=""></a>
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
            <form class="form-inline my-2 my-lg-0" method="post" action="/employee?actionUser=search">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
    <div class="row mt-3 ml-3 mr-3">
        <div id="list-example" class="list-group col-2">
            <a class="list-group-item list-group-item-action" href="/employee">Employee</a>
            <a class="list-group-item list-group-item-action" href="/customer">Customer</a>
            <a class="list-group-item list-group-item-action" href="/service">Service</a>
            <a class="list-group-item list-group-item-action" href="/contract">Contract</a>
        </div>
        <div data-spy="scroll" data-target="#list-example" data-offset="0" class="scrollspy-example col-10">
            <table class="table caption-top" id="tableCustomer">
                <thead>
                <tr>
                    <th scope="col" class="col-1">ID</th>
                    <th scope="col" class="col-1">Name</th>
                    <th scope="col" class="col-1">Position</th>
                    <th scope="col" class="col-1">Level</th>
                    <th scope="col" class="col-1">Part</th>
                    <th scope="col" class="col-1">Birthday</th>
                    <th scope="col" class="col-1">Identity card number</th>
                    <th scope="col" class="col-1">Salary</th>
                    <th scope="col" class="col-1">Number Phone</th>
                    <th scope="col" class="col-1">Email</th>
                    <th scope="col" class="col-1">Address</th>
                    <th scope="col" class="col-1">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${employeeList}" var="employee">
                    <tr>
                        <th scope="col">${employee.getId()}</th>
                        <td>${employee.getName()}</td>
                        <td>${employee.getPosition().getNamePosition()}</td>
                        <td>${employee.getLevel().getLevel()}</td>
                        <td>${employee.getPart().getPart_name()}</td>
                        <td>${employee.getBirthday()}</td>
                        <td>${employee.getIdentity()}</td>
                        <td>${employee.getSalary().toString()}</td>
                        <td>${employee.getNumberPhone()}</td>
                        <td>${employee.getEmail()}</td>
                        <td>${employee.getAddress()}</td>
                        <td>
                            <!-- Button trigger modal -->
                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal-${employee.getId()}">
                                Delete
                            </button>
                            <!-- Modal -->
                            <div class="modal fade" id="exampleModal-${employee.getId()}" tabindex="-1" role="dialog"
                                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Xác nhận xoá</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            Bạn có chắc muốn xóa Nhân Viên có ID: ${employee.id} và Tên: ${employee.name}
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                            <button type="button" class="btn btn-danger" onclick="window.location.href='/employee?actionUser=delete&id=${employee.id}'">Xác nhận</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <button type="button" class="btn btn-info" onclick="window.location.href='/employee?actionUser=edit&id=${employee.getId()}'">Edit</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
                <c:if test="${messager}!=null">
                    <tr>
                        <td>${messager}</td>
                    </tr>
                </c:if>
                <tr>
                    <td>
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" onclick="window.location.href='/employee?actionUser=create'">Thêm nhân viên</button>
                    </td>
                </tr>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="mx-auto" style="width: 200px;">
            Footer
        </div>
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
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 10
        });
    });
</script>
</body>
</html>
