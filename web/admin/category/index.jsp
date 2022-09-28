<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../layout/index.jsp"  %>
<link href="<%=request.getContextPath()%>/admin/category/css/style.css" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">


<div class="container-category">
    <div class="title">
        <button class="button-create">Create</button>
        <div class="search">
            <input class="text-search" type="text" required="name...">
            <button class="button-search">Search</button>
        </div>
    </div>
    <div class="side-nav-categories">
        <ul id="category-tabs">
            <li><a>#</a>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a>Name</a></li>
            <li>Ban
                <div class="footer-category">
                    <button class="button-delete" id="${category.getId()}" onclick="AlertDelete(${category.getId()})">Delete</button>
                    <button class="button-info" onclick="">Info</button>
                </div>
            </li>
            <li>Ghe
                <div class="footer-category">
                    <button class="button-delete" onclick="AlertDelete()">Delete</button>
                    <button class="button-info" onclick="">Info</button>
                </div>
            </li>
            <li>Chuot
                <div class="footer-category">
                    <button class="button-delete" onclick="AlertDelete()">Delete</button>
                    <button class="button-info" onclick="">Info</button>
                </div>
            </li>
            <li>Ban Phim
                <div class="footer-category">
                    <button class="button-delete" onclick="AlertDelete()">Delete</button>
                    <button class="button-info" onclick="">Info</button>
                </div>
            </li>
        </ul>
    </div>
    <script>
        function AlertDelete(id){
            var result = confirm("Do you want delete ${category.getName()} ?");
            if (result === true) {
                alert("Delete");
                const element = document.getElementById(id);
                element.removeAttribute(id);
            } else {
                alert("Cancel");
            }
        }
    </script>
</div>