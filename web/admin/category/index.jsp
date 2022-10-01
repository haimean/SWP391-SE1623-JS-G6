<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../layout/index.jsp"  %>
<link href="<%=request.getContextPath()%>/admin/category/css/style.css" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">


<!--<form action="category" method="POST">-->
<div class="title">
    <button class="button-create" onclick="CreateCategory()" >Create</button>
</div>
<!--</form>-->
<div class="container-category">
    <div class="side-nav-categories">
        <form action="search" method="POST">
            <div class="search">
                <input name="txt" class="text-search" type="text" placeholder="Name...">
                <button class="button-search">Search</button>
            </div>
        </form>
        <form action="category" method="GET">
            <ul id="category-tabs">
                <li><a>#</a>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&ensp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a>Name</a></li>
                    <c:set var="i" value="0"></c:set>
                    <c:forEach items="${requestScope.category}" var="c">
                        <c:set var="i" value="${i+1}"></c:set>
                        <li>
                            <div class="items">
                                <div class="id" id="id" style="width: 50px;">${i}</div>
                            <div class="name" style="margin-left: 150px;width: 200px;">${c.name}</div>
                            <div class="footer-category" style="margin-left: 200px;">
                                <button type="button" class="btn btn-danger"  onclick="AlertDelete(${c.id})">Delete</button>
                                <button type="button" class="btn btn-info" onclick="UpdateInfo(${c.id})">Info</button>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </form>
    </div>
    <script>
        function AlertDelete(id) {
            var result = confirm("Do you want to delete ?");
            if (result === true) {
                window.location.href = 'category_ud?id=' + id;
            }
        }
        function CreateCategory() {
            window.location.href = "<%= request.getContextPath()%>/admin/category/create/CreateCategory.jsp";
        }
        function UpdateInfo(id) {
            window.location.href = 'update?id=' + id;
        }
    </script>
</div>

