<%@include file="../layout/index.jsp" %>
<div class="container-category">
    <div class="title">
        <a class="btn btn-primary" href="create" role="button">Link</a>
    </div>
    <div class="side-nav-categories">
        <form action="category" method="GET">
            <div class="search">
                <input name="search" class="text-search" type="text" placeholder="Name...">
                <input class="btn btn-primary" type="button" value="Input">
            </div>
        </form>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <tbody>
                <c:set var="i" value="0"></c:set>
                <c:forEach items="${requestScope.categories}" var="c">
                    <c:set var="i" value="${i+1}"></c:set>
                        <tr>
                            <th >${i}</th>
                        <td>${c.name}</td>
                        <td>  
                            <div class="footer-category" style="margin-left: 200px;">
                                <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal${c.id}">Delete</button>
                                <a class="btn btn-primary" href="update?id=${c.id}" role="button">Update</a>
                                <div class="modal fade" id="exampleModal${c.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body">
                                                ...
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                <a class="btn btn-primary" href="delete?id=${c.id}" role="button">Delete</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
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
    .container-category{
        text-align: center;
    }
    .title{
        display: inline-flex;
        margin-top: 150px;
        width: 1200px;
        margin-left: 35px;
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
    .side-nav-categories {
        border-radius: 10px;
        text-align: left;
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
    .footer-category{
        display: inline-flex;
        /*margin-left: 570px;*/
    }
</style>