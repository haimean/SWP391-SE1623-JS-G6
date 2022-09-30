<%-- 
    Document   : index
    Created on : 18-09-2022, 23:04:55
    Author     : haimi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<%@include file="../layout/index.jsp"  %>
<link href="<%=request.getContextPath()%>/admin/user/style.css" rel="stylesheet">


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
<div class="content-wrap">
    <div class="container">
        <div class="table-responsive table-container mx-auto">
            <div class="shadow-sm p-3 mb-5 bg-white rounded px-5 py-5 d-flex flex-column align-items-center">
                <div class="d-flex">
                    <input type="search" id="search" class="form-control mb-4" placeholder="Search"/>
                    <button class="btn btn-primary">Search</button>
                </div>
                <table class="table">
                    <thead class="text-center">
                        <tr class="user-select-none">
                            <th onclick="sortTable(this)">#</th>
                            <th onclick="sortTable(this)">Email</th>
                            <th >Role</th>
                            <th>Ban</th>   
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
                                        <option value="1" selected="">One</option>
                                        <option value="2">Two</option>
                                        <option value="3">Three</option>
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
</div>
<script src="<%=request.getContextPath()%>/admin/user/script.js"></script>


