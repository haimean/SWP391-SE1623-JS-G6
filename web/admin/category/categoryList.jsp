<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../layout/index.jsp"  %>


<div class="container-category">
    <div class="title">
        <button class="button-create" onclick="CreateCategory()" style="margin-left: 140px;">Create</button>
    </div>
    <div class="side-nav-categories">
        <form id="form" action="category" method="GET">
            <div class="search">
                <input name="search" class="text-search" type="text" onkeyup="ValidateSearch()" placeholder="Name..." id="search-input">
                <button class="button-search">Search</button>
            </div><br>
            <span id="text-search"></span>
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
                            <button type="button" class="btn btn-info"  onclick="UpdateInfo(${c.id})" name="id" value="${c.id}">Update</button>
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
                                <button  type="submit" class="btn btn-danger" onclick="DeleteCategory(${c.id})" name="id" value="${c.id}">Delete</button>
                                <button type="submit" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </ul>
    </div>
    <div class="paging">
        <ul class="pagination justify-content-center">
            <c:forEach begin="1" end="${endpage}" var="p">
                <li class="page-item"><a class="page-link" href="category?page=${p}">${p}</a></li>
                </c:forEach>
        </ul>
    </div>
</div>
<div class="position-fixed w-100" id="alert-div">
    <c:if test="${status.equals('true')}">
        <button class="alert alert-success d-flex align-items-center position-absolute ms-3 pe-auto" role="alert" onclick="closeAlertModal()">
            <svg id="suc" class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Success:"><use xlink:href="#check-circle-fill"/></svg>
            <div>
                Successful!
            </div>
        </button>
    </c:if>
    <c:if test="${status.equals('false')}">
        <button class="alert alert-danger d-flex align-items-center position-absolute ms-3 pe-auto" id="alert" role="alert" onclick="closeAlertModal()">
            <svg id="fa" class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Danger:"><use xlink:href="#exclamation-triangle-fill"/></svg>
            <div>
                Failed!
            </div>
        </button>
    </c:if>
</div>
<script>
    function hideAlert(){
        var form = document.getElementById("alert-div");
        form.classList.remove("suc");
        form.classList.remove("fa");
    }
    function DeleteCategory(id) {
        window.location.href = "category/delete?id=" + id;
    }
    function CreateCategory() {
        window.location.href = "category/create";
    }
    function UpdateInfo(id) {
        window.location.href = 'category/update?id=' + id;
    }
    function closeAlertModal() {
        let modal = document.getElementById("alert");
        modal.classList.add("fadeOutLeft");
        console.log(modal);
    }
    function ValidateSearch() {
        var form = document.getElementById("form");
        var search = document.getElementById("search-input").value;
        var text = document.getElementById("text-search");
        var pattern = /^([^0-9!@#$%^&*()]*)$/;

        if (search.match(pattern)) {
            form.classList.add("valid");
            form.classList.remove("invalid");
            text.innerHTML = "Fullname valid!";
            text.style.color = "#00ff00";
        } else {
            form.classList.remove("valid");
            form.classList.add("valid");
            text.innerHTML = "Please enter fullname!";
            text.style.color = "#ff0000";
        }

        if (search === "") {
            form.classList.remove("valid");
            form.classList.remove("invalid");
            text.innerHTML = "";
            text.style.color = "#00ff00";
        }
    }
</script>
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
    .position-fixed .w-100{
        margin-top: 1500px;
    }
    #text-search{
        margin-left: 210px;
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
    .paging{
        margin-top: 100px;
        margin-right: 100px;
    }
    .hide{
        display: none;
    }
</style>