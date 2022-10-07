<%-- 
    Document   : UpdateInfo
    Created on : Sep 30, 2022, 3:01:00 AM
    Author     : Mr Tuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../layout/index.jsp"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<%=request.getContextPath()%>/admin/category/updateinfo/css/style.css" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>

<form action="update" method="POST">
    <div class="side-nav-categories">
        <c:forEach items="${requestScope.updateinfo}" var="u">
            <div class="div-title">
                <h1 class="title">${u.getName()}</h1>
            </div>
            <div class="div-id">
                <h3 class="title-id">ID</h3>
                <input class="text-id" type="text"  value="${u.id}" name="id" disabled>
            </div>
            <div class="div-name">
                <h3 class="title-name">Name</h3>
                <input class="text-name" type="text"  placeholder="Name..." value="${u.name}"name="namenew">
            </div>
        </c:forEach>
        <button type="submit" class="btn btn-primary"  style="font-family: serif;color: #fff;">Update</button>
    </div>
</form>
