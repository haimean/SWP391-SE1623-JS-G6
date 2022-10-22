<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../layout/index.jsp"  %>

<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
    <symbol id="check-circle-fill" fill="currentColor" viewBox="0 0 16 16">
        <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
    </symbol>
    <symbol id="info-fill" fill="currentColor" viewBox="0 0 16 16">
        <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
    </symbol>
    <symbol id="exclamation-triangle-fill" fill="currentColor" viewBox="0 0 16 16">
        <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
    </symbol>
</svg>

<div class="container-category">
    <div class="title">
        <button class="button-create" onclick="CreateCategory()" style="margin-left: 140px;">Create</button>
    </div>
    <div class="side-nav-categories">
        <form action="category" method="GET">
            <div class="search">
                <input name="txt" class="text-search" type="text" placeholder="Name..." value="${value}">
                    <button class="button-search">Search</button>
            </div>
        </form>
        <ul id="category-tabs">
            <li><a>#</a>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&ensp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a>Name</a></li>
                <c:set var="i" value="0"></c:set>
                <c:forEach items="${requestScope.categories}" var="c">
                    <c:set var="i" value="${i+1}"></c:set>
                    <li>
                        <div class="items">
                            <div class="id" id="id" style="width: 50px;">${i}</div>
                        <div class="name" style="margin-left: 150px;width: 200px;">${c.name}</div>
                        <div class="footer-category" style="margin-left: 200px;">
                            <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal${c.id}">Delete</button>
                            <button type="button" class="btn btn-info" onclick="UpdateInfo(${c.id})">Update</button>
                        </div>
                    </div>
                </li>
                <div class="modal fade" id="exampleModal${c.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title"  id="exampleModalLabel">Delete Category</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                Do you want delete '${c.name}' ?
                            </div>
                            <div class="modal-footer">
                                <button  type="button" class="btn btn-danger"><a href="<%=request.getContextPath()%>/admin/category/delete?id=${c.id}">Delete</a></button>
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </ul>

    </div>
    <div class="position-fixed w-100">
        <c:if test="${status == true}">
            <button class="alert alert-success d-flex align-items-center position-absolute ms-3 pe-auto" role="alert">
                <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Success:"><use xlink:href="#check-circle-fill"/></svg>
                <div>
                    Delete Succeeded!
                </div>
            </button>
        </c:if>
        <c:if test="${status == false}">
            <button class="alert alert-danger d-flex align-items-center position-absolute ms-3 pe-auto" id="alert" role="alert" onclick="closeAlertModal()">
                <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Danger:"><use xlink:href="#exclamation-triangle-fill"/></svg>
                <div>
                    Delete Failed!
                </div>
            </button>
        </c:if>

    </div>

    <script>
        function closeAlertModal() {
            let modal = document.getElementById("alert");
            modal.classList.add("fadeOutLeft");
            console.log(modal);
        }
        function CreateCategory() {
            window.location.href = "category/create";
        }
        function UpdateInfo(id) {
            window.location.href = 'category/update?id=' + id;
        }
    </script>
</div>

<style>
    ul{
        list-style:none;
    }

    .container-category{
        text-align: center;
    }
    .title{
        display: inline-flex;
        margin-top: 150px;
        width: 1200px;
        margin-left: 35px;
    }

    .button-create{
        background-color: rgb(119, 73, 248);
        width: 80px;
        height: 35px;
        border: none;
        color: white;
        text-align: center;
        text-decoration: none;
        font-size: 15px;
        margin-right: 650px;
        transition-duration: 0.4s;
        cursor: pointer;
        border-radius: 10px;
    }
    .button-create:hover{
        background-color: rgb(69, 192, 252);
        margin-right: 650px;
        color: black;
    }
    .search{
        display: inline-flex;
        margin-top: 10px;
        margin-left: 200px;
    }
    .text-search{
        width: 300px;
        height: 35px;
        margin-left: 10px;
    }
    .button-search{
        background-color: rgb(23, 162, 184);
        width: 80px;
        height: 35px;
        border: none;
        color: white;
        text-align: center;
        text-decoration: none;
        font-size: 15px;
        transition-duration: 0.4s;
        cursor: pointer;
        border-radius: 10px;
        margin-left: 10px;
    }
    .button-search:hover{
        background-color: rgb(49, 210, 242);
        margin-left: 10px;
        color: black;
    }

    .side-nav-categories {
        border-radius: 10px;
        text-align: left;
        position: relative;
        background-color: #fff;
        border-width: 1px;
        border-style: solid;
        border-color: #f5f5f5 #eee #d5d5d5 #eee;
        box-shadow: 0 5px 0 rgba(200,200,200,.2);
        width: 800px;
        margin: auto;
        top:15px;
        left: 20px;

    }

    ul#category-tabs {
        list-style: none;
        padding: 0;
        margin: 0;
        padding: 0;
    }

    ul#category-tabs li {
        display: block;
        position: relative;
        margin: 0;
        border-bottom: 1px #ececec solid;
        padding: 10px 18px;
    }
    ul.sub-category-tabs li {
        padding: 2px  !important;
    }
    ul.sub-category-tabs li {
        border-bottom: 0px !important;
    }

    ul#category-tabs li a {
        color: #333;
        font-weight: 700;
        margin-bottom: 0;
        font-size: 12px;
    }

    ul#category-tabs li a i {
        top: 12px;
        right: 18px;
        position: absolute;
        cursor: pointer;
        width: 16px;
        height: 16px;
        padding: 2px;
        color: #ed6663;
    }

    .footer-category{
        display: inline-flex;
    }

    .btn-danger{
        border: none;
        border-radius: 5px;
        background-color: rgb(220, 53, 69);
        margin-right: 10px;
        margin-left: 10px;
    }
    .btn-info{
        border: none;
        border-radius: 5px;
        background-color: rgb(23, 162, 184);
        color: #fff;
    }
    .items{
        display: flex;
    }
    .fadeOutLeft{
        animation: fadeOutLeft 0.3s ease-in;
        animation-fill-mode: forwards;
    }
    @keyframes fadeOutLeft {
        0% {
            opacity: 1;
            transform: translateX(0);
        }
        50%{
            opacity: 1;
            transform: skewX(-5deg);
        }
        75%{
            opacity: 1;
            transform: skewX(5deg);
        }
        100% {
            opacity: 0;
            transform: translateX(-100%);
        }
    }
    
</style>