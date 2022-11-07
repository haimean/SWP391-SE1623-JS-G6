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

    table th:not(:nth-last-child(-n+2)):hover{
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

    .alert{
        bottom: -25rem;
        left: -3rem;
    }
</style>
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

<div class="container">
    ${test}
    <div class="table-responsive table-container mx-auto">
        <a type="button" class="btn btn-primary mt-4 ms-4" href="<%= request.getContextPath()%>/admin/qna-type/create">Create</a>
        <div class="shadow-sm p-3 mb-5 bg-white rounded px-5 py-5 d-flex flex-column align-items-center">
            <div class="w-75 pb-5">
                <form action="qna-type" method="post" class="d-flex flex-row">
                    <input type="search" name="search" class="form-control" placeholder="Search" value="${search}" required/>
                    <input type="hidden" name="mode" value="SEARCH"/>
                    <button class="btn-search px-3">Search</button>
                </form>
            </div>
            <table class="table">
                <thead class="align-middle text-center">
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody class="align-middle text-center">
                    <c:forEach items="${listQnaType}" var="qt">
                        <tr>
                            <td>${qt.id}</td>
                            <td>${qt.name}</td>
                            <td class="d-flex justify-content-end">
                                <form action="qna-type/update" method="post">
                                    <button type="submit" class="btn btn-primary">Update</button>
                                    <input type="hidden" value="NORMAL" name="mode"/>
                                    <input type="hidden" value="${qt.id}" name="id"/>
                                </form>
                                <button type="button" class="btn btn-danger ms-3" data-bs-toggle="modal" data-bs-target="#modal${qt.id}">Delete</button>
                            </td>
                        </tr>
                    <div class="modal fade" id="modal${qt.id}" tabindex="-1">   
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title">Delete comfirm</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <form action="qna-type" method="post" id="form-delete">
                                        <input type="hidden" name="id" value="${qt.id}"/>
                                        <input type="hidden" name="mode" value="DELETE"/>
                                    </form>
                                    <p>Do you agree to delete?</p>
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
                            <a class="page-link" href="<%= request.getContextPath()%>/admin/qna-type?page=1" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>

                    <c:forEach begin="1" end="${endP}" var="i">
                        <li class="page-item ${tag == i ? "active" : ""}"><a class="page-link" href="<%= request.getContextPath()%>/admin/qna-type?page=${i}">${i}</a></li>
                        </c:forEach>
                        <c:if test="${tag < endP}">
                        <li class="page-item">
                            <a class="page-link" href="<%= request.getContextPath()%>/admin/qna-type?page=${endP}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                </ul>
            </nav>
            <div class="position-fixed w-100">
                <c:if test="${status eq 'true'}">
                    <button class="alert alert-success d-flex align-items-center position-absolute ms-3 pe-auto" id="alert" role="alert" onclick="closeAlertModal()">
                        <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Success:"><use xlink:href="#check-circle-fill"/></svg>
                        <div>
                            Action Succeeded!
                        </div>
                    </button>
                </c:if>
                <c:if test="${status eq 'false'}">
                    <button class="alert alert-danger d-flex align-items-center position-absolute ms-3 pe-auto" id="alert" role="alert" onclick="closeAlertModal()">
                        <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Danger:"><use xlink:href="#exclamation-triangle-fill"/></svg>
                        <div>
                            Action Failed!
                        </div>
                    </button>
                </c:if>
            </div>
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

    function closeAlertModal() {
        let modal = document.getElementById("alert");
        modal.classList.add("fadeOutLeft");
    }
</script>
