<%@page import="Model.*"
        import="Dal.*"
        import="java.util.ArrayList"
%>
<!DOCTYPE html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js" integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous"></script>
<style>

    .offcanvas-lg{
        --bs-offcanvas-width: none;
        --bs-offcanvas-border-width: 0px;
        --bs-offcanvas-padding-x: 0;
        --bs-offcanvas-padding-y: 0;
    }
    a{
        text-decoration: none;
        color: black
    }
</style>
<nav class="navbar  fixed-top bg-secondary">
    <div class="container-fluid">
        <div class="d-flex align-items-center">
            <button class="btn d-lg-none" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasResponsive" aria-controls="offcanvasResponsive">
                <span class="navbar-toggler-icon"></span>
            </button>
            <a class="" href=""><h3>Admin</h3></a>
        </div>
        <ul class="nav nav-pills">
            <li class="nav-item dropdown">
                <a class=" dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">email@gmail.com</a>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="<%= request.getContextPath()%>/admin/logout">Logout</a></li>
                </ul>
            </li>
        </ul>
    </div>
</nav>
<div class="offcanvas-lg offcanvas-start " tabindex="-1" id="offcanvasResponsive" aria-labelledby="offcanvasResponsiveLabel">
    <div class="offcanvas-body  bg-secondary" style="
         float: left;
         height: 100pc;
         padding-top: 56px"
         >
        <ul class="list-group  list-group-flush  bg-secondary">
            <li class="list-group-item  bg-secondary"><a href="<%= request.getContextPath()%>/admin"> <h4>Dashboard</h3></a></li>
            <li class="list-group-item  bg-secondary"><a href="<%= request.getContextPath()%>/category"> <h4>Category</h3></a></li>
            <li class="list-group-item  bg-secondary"><a href="<%= request.getContextPath()%>/admin/user"> <h4>User</h3></a></li>
        </ul>
    </div>
</div>