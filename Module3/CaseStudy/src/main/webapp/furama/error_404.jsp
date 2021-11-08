<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/11/2021
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        p a{
            color:#eee;
            font-size:13px;
            margin-left:30px;
            padding:5px;
            background:#FF3366;
            text-decoration:none;
            -webkit-border-radius:.3em;
            -moz-border-radius:.3em;
            border-radius:.3em;
        }
        p a:hover{
            color: #fff;
        }
    </style>
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
                    <a class="nav-link ml-4" href="/employee">Employee<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link ml-4" href="/customer">Customer <span class="sr-only">(current)</span></a>
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
    <div class="row mt-3 ml-3 mr-3">
        <div id="list-example" class="list-group col-2">
            <a class="list-group-item list-group-item-action" href="/employee">Employee</a>
            <a class="list-group-item list-group-item-action" href="/customer">Customer</a>
            <a class="list-group-item list-group-item-action" href="/service">Service</a>
            <a class="list-group-item list-group-item-action" href="/contract">Contract</a>
        </div>

        <div data-spy="scroll" data-target="#list-example" data-offset="0" class="scrollspy-example col-10">
                    <img src="img/404.png" width="500px" alt="">
                    <p><a href="/index.jsp">Go back to Home</a></p>
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
