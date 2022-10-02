<%-- 
    Document   : index
    Created on : 18-09-2022, 23:04:55
    Author     : haimi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<%@include file="../layout/index.jsp"  %>
<link href="<%=request.getContextPath()%>/admin/user/css/style.css" rel="stylesheet">


<div class="modal fade" id="modal" tabindex="-1">
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
                <button type="button" class="btn btn-warning text-white ">Ban</button>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="table-responsive table-container mx-auto">
        <div class="shadow-sm p-3 mb-5 bg-white rounded px-5 py-5 d-flex flex-column align-items-center">
            <div class="w-75 pb-5">
                <form action="user-search" method="post" class="d-flex flex-row">
                    <input type="search" name="search" class="form-control" placeholder="Search"/>
                    <button class="btn-search px-3">Search</button>
                </form>
            </div>
            <table class="table">
                <thead class="text-center">
                    <tr class="user-select-none">
                        <th onclick="sortTable(this)">#</th>
                        <th onclick="sortTable(this)">Email</th>
                        <th onclick="sortTable(this)">Role</th>
                        <th onclick="sortTable(this)">Ban</th>   
                        <th></th>   
                    </tr>
                </thead>

                <tbody class="align-middle text-center">
                    <c:forEach items="${listU}" var="u">
                        <tr>
                            <td>${u.id}</td>
                            <td>${u.email}</td>
                            <td>
                                <select class="form-select">
                                    <option value="1" ${u.role == 1 ? "selected" : ""}>Admin</option>
                                    <option value="2" ${u.role == 2 ? "selected" : ""}>Seller</option>
                                    <option value="3" ${u.role == 3 ? "selected" : ""}>Customer</option>
                                </select>
                            </td>
                            <td>ban</td>
                            <td><button class="btn btn-warning text-white" data-bs-toggle="modal" data-bs-target="#modal">Ban</button></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="<%=request.getContextPath()%>/admin/user/js/script.js"></script>
