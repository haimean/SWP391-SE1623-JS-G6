<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../layout/index.jsp"  %>
<link href="<%=request.getContextPath()%>/admin/category/css/style.css" rel="stylesheet">

${search}
<div class="content-wrap d-flex" >
    <div class="container">
        <div class="table-responsive table-container mx-auto">
            <div class="shadow-sm p-3 mb-5 bg-white rounded px-5 py-5 d-flex flex-column align-items-center">
                <form action="<%=request.getContextPath()%>/admin/category" method="get">
                    <div class="d-flex mb-4" style=" justify-content: center; align-items: center;">
                        <input type="text" name="search" class="form-control" placeholder="Search"/>
                        <input class="btn btn-primary" type="submit" style="margin-left: 1rem;" value="Search">
                    </div>
                </form>
                <table class="table">
                    <thead class="text-center">
                        <tr class="user-select-none">
                            <th onclick="sortTable(this)">#</th>
                            <th onclick="sortTable(this)">Name</th>

                            <th></th>   
                        </tr>
                    </thead>
                    <tbody class="align-middle text-center">
                        <c:forEach items="${categories}" var="c">
                            <tr>
                                <td>${c.getId()}</td>
                                <td>${c.getName()}</td>
                                <td>
                                    <button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#modal${c.id}">Delete</button>
                                    <a class="btn btn-info" href="category/update?id=${c.id}" role="button">Update</a>
                                </td>
                            </tr>
                        <div class="modal fade" id="modal${c.id}" tabindex="-1">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title">Ban comfirm</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <p>Do you agree to ban this user?</p>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        <a class="btn btn-danger" href="category/delete?id=${c.id}" role="button">Delete</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>