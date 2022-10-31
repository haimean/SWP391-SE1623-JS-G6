<%-- Document : index Created on : 18-09-2022, 23:04:55 Author : haimi --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>

<%@include file="../layout/index.jsp"  %>
<style>
    *{
        padding: 0;
        margin: 0;
        box-sizing: border-box;
    }

    .table-container{
        padding: 8rem 4rem;
    }

    table th:hover{
        background-color: #f7f7f7;
        cursor: pointer;
    }

    .btn-search{
        background-color: rgb(23, 162, 184);
        width: 80px;
        height: auto;
        border: none;
        color: white;
        text-align: center;
        font-size: 15px;
        transition: 0.1s;
        border-radius: 0.375rem;
        margin-left: 2rem;
    }
    .btn-search:hover{
        background-color: rgb(255, 165, 0);
        color: white;
    }
    img{
        height: 4rem;
    }
    #title-not-found{
        background: linear-gradient(90deg, rgba(255,58,58,1) 0%, rgba(255,102,30,1) 100%);
        -webkit-background-clip: text;
        -webkit-text-fill-color: transparent;
    }
</style>

<script>
    function sortTable(el) {
        let thead = document.getElementsByTagName("thead")[0];
        let th = [...thead.getElementsByTagName("th")];
        let index = th.indexOf(el);
        let rows, switching, i, x, y, shouldSwitch, sort, switchcount = 0;
        let table = document.querySelector(".table");
        switching = true;
        sort = "asc";
        while (switching) {
            switching = false;
            rows = table.rows;
            for (i = 1; i < (rows.length - 1); i++) {
                shouldSwitch = false;
                x = rows[i].getElementsByTagName("td")[index];
                y = rows[i + 1].getElementsByTagName("td")[index];
                if (sort == "asc") {
                    if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                        shouldSwitch = true;
                        break;
                    }
                } else if (sort == "desc") {
                    if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                        shouldSwitch = true;
                        break;
                    }
                }
            }
            if (shouldSwitch) {
                rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
                switching = true;
                switchcount++;
            } else {
                if (switchcount == 0 && sort == "asc") {
                    sort = "desc";
                    switching = true;
                }
            }
        }
    }
    function changeRole(el, id) {
        let form = document.getElementById("form-role");
        let value = el.value;
        let url = 'user?id=' + id + '&role=' + value + '&mode=ROLE';
        form.action = url;
        form.submit();
    }
</script>
<p>${test}</p>
<div class="container">
    <div class="table-responsive table-container mx-auto">
        <div class="shadow-sm p-3 mb-5 bg-white rounded px-5 py-5 d-flex flex-column align-items-center">
            <div class="w-75 pb-5">
                <form action="user" method="post" class="d-flex flex-row">
                    <input type="search" name="search" class="form-control" placeholder="Search" value="${search}" required/>
                    <input type="hidden" name="mode" value="SEARCH"/>
                    <button class="btn-search px-3">Search</button>
                </form>
            </div>
            <c:if test="${size != 0}">
                <table class="table">
                    <thead class="text-center">
                        <tr class="user-select-none">
                            <th onclick="sortTable(this)">#</th>
                            <th onclick="sortTable(this)">Email</th>
                            <th onclick="sortTable(this)">Role</th>
                            <th onclick="sortTable(this)">Ban</th>   
                        </tr>
                    </thead>

                    <tbody class="align-middle text-center">
                        <c:forEach items="${listU}" var="u">
                            <tr>
                                <td>${u.id}</td>
                                <td>${u.email}</td>
                                <td>
                                    <form action="action" method="post" id="form-role">
                                        <select class="form-select" id="role" onchange="changeRole(this, ${u.id})">
                                            <option value="1" name="role" ${u.role == 1 ? "selected" : ""}>Admin</option>
                                            <option value="2" name="role" ${u.role == 2 ? "selected" : ""}>Seller</option>
                                            <option value="3" name="role" ${u.role == 3 ? "selected" : ""}>Customer</option>
                                        </select>
                                    </form>
                                </td>
                                <td><button id="btn-ban" class="btn btn-warning text-white" data-bs-toggle="modal" data-bs-target="#modal${u.id}">${u.status ? "Ban" : "UnBan"}</button></td>
                            </tr>
                        <div class="modal fade" id="modal${u.id}" tabindex="-1">   
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title">${u.status == true ? "Ban" : "Unban"} comfirm</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <p>Do you agree to ${u.status == true ? "ban" : "unban"} this user [id: ${u.id}]?</p>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        <a href="<%= request.getContextPath()%>/admin/user?id=${u.id}&status=${u.status}&mode=BAN" type="button" class="btn btn-warning text-white ">${u.status == true ? "Ban" : "Unban"}</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    </tbody>
                </table>
                <nav class="mt-5">
                    <ul class="pagination">
                        <c:if test="${tag > 1}">
                            <li class="page-item">
                                <a class="page-link" href="<%= request.getContextPath()%>/admin/user?page=1" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>

                        <c:forEach begin="1" end="${endP}" var="i">
                            <li class="page-item"><a class="page-link" href="<%= request.getContextPath()%>/admin/user?page=${i}&search=${search}&mode=SEARCH">${i}</a></li>
                            </c:forEach>
                            <c:if test="${tag < endP}">
                            <li class="page-item">
                                <a class="page-link" href="<%= request.getContextPath()%>/admin/user?page=${endP}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                    </ul>
                </nav>
            </c:if>
            <c:if test="${size == 0}">
                <div class="d-flex  align-items-center text-uppercase">
                    <div class="pe-2">
                        <img src="https://cdn-icons-png.flaticon.com/512/7188/7188143.png" alt="not found"/>
                    </div>
                    <h3 id="title-not-found">Not Found</h3>
                </div>

            </c:if>
        </div>
    </div>
</div>


