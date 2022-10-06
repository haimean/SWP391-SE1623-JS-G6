<%-- 
    Document   : CreateCetegory
    Created on : Sep 30, 2022, 2:30:11 AM
    Author     : Mr Tuan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../layout/index.jsp"  %>
<link href="<%=request.getContextPath()%>/admin/category/create/css/style.css" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">


<div class="container-category">
    <div class="side-nav-categories">
        <form action="category_create" method="POST">
            <div class="div-title">
                <h1 class="title">Create Category</h1>
            </div>
            <div class="div-name">
                <h3 class="title-name">Name</h3>
                <input class="text-name" type="text"  placeholder="Name..." name="txt">
            </div>
            <input type="submit" class="btn btn-primary" style="font-family: serif;color: #fff;" value="Create">
        </form>
    </div>
</div>



