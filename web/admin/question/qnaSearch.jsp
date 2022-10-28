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

<div class="container">
    <div class="table-responsive table-container mx-auto">
        <a type="button" class="btn btn-primary mt-4 ms-4" href="<%= request.getContextPath()%>/admin/qna/create">Create</a>
        <div class="shadow-sm p-3 mb-5 bg-white rounded px-5 py-5 d-flex flex-column align-items-center">
            <div class="w-75 pb-5">
                <form action="qna" method="post" class="d-flex flex-row">
                    <input type="search" name="search" class="form-control" placeholder="Search" value="${search}" required/>
                    <input type="hidden" name="mode" value="SEARCH"/>
                    <button class="btn-search px-3">Search</button>
                </form>
            </div>
            <c:if test="${size != 0}">
                <table class="table">
                    <thead class="align-middle text-center">
                        <tr>
                            <th>#</th>
                            <th>Question Type</th>
                            <th>Question</th>
                            <th>Answer</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody class="align-middle text-center">
                        <c:forEach items="${listQna}" var="q">
                            <tr>
                                <th>${q.id}</th>
                                <td>${q.name}</td>
                                <td>${q.question}</td>
                                <td>${q.answer}</td>
                                <td>
                                    <form action="qna/update" method="post">
                                        <button type="submit" class="btn btn-primary">Update</button>
                                        <input type="hidden" value="NORMAL" name="mode"/>
                                        <input type="hidden" value="${q.id}" name="id"/>
                                    </form>
                                </td>
                                <td><button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#modal${q.id}">Delete</button></td>
                            </tr>
                        <div class="modal fade" id="modal${q.id}" tabindex="-1">   
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title">Delete comfirm</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <form action="qna" method="post" id="form-delete">
                                            <input type="hidden" name="id" value="${q.id}"/>
                                            <input type="hidden" name="mode" value="DELETE"/>
                                        </form>
                                        <p>Do you agree to delete this question?</p>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        <a type="submit" class="btn btn-danger" id="btn-delete">Delete</a>
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
                                <a class="page-link" href="<%= request.getContextPath()%>/admin/qna?page=1" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>

                        <c:forEach begin="1" end="${endP}" var="i">
                            <li class="page-item ${tag == i ? "active" : ""}"><a class="page-link" href="<%= request.getContextPath()%>/admin/qna?page=${i}&search=${search}&mode=SEARCH">${i}</a></li>
                            </c:forEach>
                            <c:if test="${tag < endP}">
                            <li class="page-item">
                                <a class="page-link" href="<%= request.getContextPath()%>/admin/qna?page=${endP}" aria-label="Next">
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

<script>
    let formsDelete = document.querySelectorAll("#form-delete");
    let btnsDelete = document.querySelectorAll("#btn-delete");

    btnsDelete.forEach((btn, index1) => {
        btn.addEventListener("click", () => {
            formsDelete.forEach((form, index2) => {
                if (index1 === index2) {
                    form.submit();
                }
            });
        });
    });
</script>
