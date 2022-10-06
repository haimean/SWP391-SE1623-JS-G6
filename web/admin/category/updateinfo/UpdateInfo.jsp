<%-- 
    Document   : UpdateInfo
    Created on : Sep 30, 2022, 3:01:00 AM
    Author     : Mr Tuan
--%>

<%@include file="../../layout/index.jsp"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<%=request.getContextPath()%>/admin/category/updateinfo/css/style.css" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<div class="container-category">
    <div class="side-nav-categories">
        <form action="category_update" method="POST">
            <c:forEach items="${requestScope.updateinfo}" var="u">
                <div class="div-title">
                    <h1 class="title">${u.getName()}</h1>
                </div>
                <div class="div-id">
                    <h3 class="title-id">ID</h3>
                    <input class="text-id" type="text"  value="${u.id}" name="id" readonly>
                </div>
                <div class="div-name">
                    <h3 class="title-name">Name</h3>
                    <input class="text-name" type="text"  placeholder="Name..." value="${u.name}"name="namenew">
                </div>
            </c:forEach>
            <input type="submit" class="btn btn-primary" style="font-family: serif;color: #fff;" value="Update">
        </form>
    </div>
</div>