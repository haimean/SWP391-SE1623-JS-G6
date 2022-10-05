<%@include file="../layout/index.jsp" %>
<div class="container-category">
    <div class="title">
        <a class="btn btn-primary" href="create" role="button">Link</a>
    </div>
    <div class="side-nav-categories">
        <form action="category" method="GET">
            <div class="search">
                <input name="search" class="text-search" type="text" placeholder="Name...">
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
                                <button type="button" class="btn btn-info" onclick="UpdateInfo(${c.id})">Info</button>
                            </div>
                        </div>
                    </li>
                    <div class="modal fade" id="exampleModal${c.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Delete Category</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    Do you want delete?
                                </div>
                                <div class="modal-footer">
                                    <button  type="button" class="btn btn-danger"><a href="category/delete?id=${c.id}">Delete</a></button>
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </ul>
    </div>
    <script>
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
        background-color: rgb(255, 165, 0);
        margin-right: 650px;
        color: white;
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
        background-color: rgb(255, 165, 0);
        margin-left: 10px;
        color: white;
    }

    .side-nav-categories {
        border-radius: 10px;
        text-align: left;
        padding: 0px;
        position: relative;
        margin-top: 0px;
        padding-bottom: 0px;
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
        /*margin-left: 570px;*/
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
</style>