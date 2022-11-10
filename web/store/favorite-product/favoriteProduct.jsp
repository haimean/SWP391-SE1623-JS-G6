<%-- 
    Document   : index
    Created on : Oct 13, 2022, 8:29:51 PM
    Author     : PiPi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../layout/index.jsp"  %>

<style>
    #inputQuantity::-webkit-outer-spin-button,
    #inputQuantity::-webkit-inner-spin-button {
        -webkit-appearance: none;
        margin: 0;
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

<div class="modal fade" id="modal-all-delete" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5 text-danger" id="exampleModalLabel">Do you want to remove all products?</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="favorite" method="post" id="form-all-delete">
                <input type="hidden" name="mode" value="ALL_DELETE"/>
            </form>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                <button type="submit" class="btn btn-danger" id="btn-all-delete">Delete</button>

            </div>  

        </div>
    </div>
</div>
<section class="h-100 h-custom">
    <c:if test="${size != 0 && size != null}">
        <div class="container h-100 py-5">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col">
                    <div class="table-responsive">
                        <table class="table">
                            <thead class="text-muted">
                                <tr>
                                    <th scope="col">Product</th>
                                    <th scope="col" class="text-center">Unit Price</th>
                                    <th scope="col" class="text-center">
                                        <button type="submit" class="btn btn-outline-danger btn-sm" data-bs-toggle="modal" data-bs-target="#modal-all-delete">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                                <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"></path>
                                                <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"></path>
                                            </svg>
                                        </button>
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${list}" var="product">
                                    <tr class="text-center">
                                        <th scope="row">
                                            <div class="d-flex align-items-center">
                                                <a href="product/detail?id=${product.id}&categoryId=${product.categoryID}"><img src="${product.proImg}" class="img-fluid rounded-3"
                                                        style="width: 120px;" alt="Image"></a>
                                                    <div class="flex-column ms-4">
                                                        <p class="mb-2">${product.name}</p>
                                                    </div>
                                            </div>
                                        </th>
                                        <td class="align-middle">
                                            <p class="mb-0" style="font-weight: 500;">${product.price}</p>
                                        </td>
                                        <td class="align-middle">
                                            <button type="submit" class="btn btn-outline-danger btn-sm" data-bs-toggle="modal" data-bs-target="#modal-single-delete${product.id}">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                                    <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"></path>
                                                    <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"></path>
                                                </svg>
                                            </button>
                                        </td>
                                        <div class="modal fade" id="modal-single-delete${product.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h1 class="modal-title fs-5 text-danger" id="exampleModalLabel">Do you want to remove this product?</h1>
                                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <form action="favorite" method="post" id="form-delete">
                                                            <input type="hidden" name="id" value="${product.id}"/>
                                                            <input type="hidden" name="id" value="${product.categoryID}"/>
                                                            <input type="hidden" name="mode" value="SINGAL_DELETE"/>
                                                            ${product.name}
                                                        </form>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                                                        <button type="submit" class="btn btn-danger" id="btn-delete">Delete</button>

                                                    </div>  

                                                </div>
                                            </div>
                                        </div>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </c:if>
    <c:if test="${size == 0 || size == null}">
        <div class="py-6 pt-5 py-lg-12">
            <div class="container">
                <div class="row">
                    <div class="offset-lg-3 col-lg-6 col-md-12 col-12 text-center">
                        <img src="https://res.cloudinary.com/dms5zzrlb/image/upload/v1668053931/Home/images/products/no-favorite_rsrbxj.png" alt="" class="img-fluid mb-4" style="height: 10rem; width: 10rem; opacity: 0.7;">
                            <h2>You have no favorite products</h2>
                            <p class="mb-4">
                                Return to the store to pick product you like right now.
                            </p>
                            <a href="<%= request.getContextPath()%>" class="btn btn-primary">Explore Products</a>
                    </div>
                </div>
            </div>
        </div>  
    </c:if>
</section>

<script>
    let formAllDelete = document.getElementById("form-all-delete");
    let formsSingelDelete = document.querySelectorAll("#form-delete");
    let btnAllDelete = document.getElementById("btn-all-delete");
    let btnsSingelDelete = document.querySelectorAll("#btn-delete");

    btnAllDelete.addEventListener("click", () => {
        formAllDelete.submit();
    });

    btnsSingelDelete.forEach((btn, index1) => {
        btn.addEventListener("click", () => {
            formsSingelDelete.forEach((form, index2) => {
                if (index1 === index2) {
                    form.submit();
                }
            });
        });
    });
</script>
