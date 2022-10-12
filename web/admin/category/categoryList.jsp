<%@include file="../layout/index.jsp" %>
<div class="container-category">
    <div class="title">
        <button class="button-create" onclick="CreateCategory()" style="margin-left: 140px;">Create</button>
    </div>
    <div class="side-nav-categories">
        <form action="category_search" method="POST">
            <div class="search">
                <input name="search" class="text-search" type="text" placeholder="Name...">
                <button class="button-search">Search</button>
            </div>
        </form>
        <form action="category_list" method="GET">
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
        </form>
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
