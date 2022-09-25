<%--<%@include file="../layout/index.jsp"  %>--%>
<%@include file="index.jsp"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--<link href="<%=request.getContextPath()%>/admin/category/css/style.css" rel="stylesheet">-->
<link href="style.css" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<form action="category" method="POST">
    <div class="side-nav-categories" style="width: 1500px;height: 800px">
        <div class="title"><strong>Category</strong></div>
        <ul class="w3-ul w3-card-4">
            <c:forEach items="${requestScope.cate}" var="ca">
                <li>${ca.getName()}</li>
                </c:forEach>
        </ul>
        <div id="footer-button-category">
            <button class="button create-category">Create New Category</button>
            <button class="button update-category">Update Category</button>
        </div>
    </div>
</form>
