<%-- 
    Document   : productlist
    Created on : Oct 1, 2022, 8:54:35 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>All Product</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->
        <link rel="icon" type="image/png" href="images/icons/favicon.ico" />
        <!--===============================================================================================-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        
        <!--========================================
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css"> 
        =======================================================-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <style>
            a{
                text-decoration: none !important;
            }
        </style>
    </head>
    <body>
        <%@include file="/store/layout/index.jsp" %>
        <form action="product" method="get" name="frGate" class="mt-5 mb-5">

            <section class="section-content padding-y">
                <div class="container">

                    <div class="row" >
                        <aside class="col-md-3">

                            <div class="card" style="background: #EBE5FC">
                                <div class="input-group">
                                    <input name="search" type="text" class="form-control" placeholder="Search" value="${requestScope.searchname}">
                                    <div class="input-group-append">
                                        <button class="btn btn-light" type="submit"><i class="fa fa-search"></i></button>
                                    </div>
                                </div>
                                <article class="filter-group">
                                    <header class="card-header">
                                        <a href="#" data-toggle="collapse" data-target="#collapse_1" aria-expanded="true" class="" >
                                            <i class="icon-control fa fa-chevron-down"></i>
                                            <h6 class="title">Product type</h6>
                                        </a>
                                    </header>
                                    <div class="filter-content collapse show" id="collapse_1" style="">
                                        <div class="card-body">
                                            <div class="list-menu">
                                                <c:forEach var="category" items="${requestScope.categories}">
                                                    <c:if test="${category.id eq requestScope.category}">
                                                        <input type="radio" name="category" value="${category.id}" checked /> 
                                                        ${category.name} <br/>



                                                    </c:if>
                                                    <c:if test="${category.id != requestScope.category}">

                                                        <input type="radio" name="category" value="${category.id}"/> 
                                                        ${category.name}<br/>


                                                    </c:if>
                                                </c:forEach>
                                            </div>
                                        </div> <!-- card-body.// -->
                                    </div>
                                </article> <!-- filter-group  .// -->

                                <article class="filter-group">
                                    <header class="card-header">
                                        <a href="#" data-toggle="collapse" data-target="#collapse_3" aria-expanded="true" class="">
                                            <i class="icon-control fa fa-chevron-down"></i>
                                            <h6 class="title">Price range </h6>
                                        </a>
                                    </header>
                                    <div class="filter-content collapse show" id="collapse_3" style="">
                                        <div class="card-body">
                                            <div class="form-row">
                                                <div class="form-group col-md-6">
                                                    <label>Min</label>

                                                    <input name="beginp" class="form-control" placeholder="$0" type="number" min="0" value="${requestScope.beginprice}" />
                                                </div>
                                                <div class="form-group text-right col-md-6">
                                                    <label>Max</label>
                                                    <input name="endp" class="form-control" placeholder="$1,0000" type="number" min="0" value="${requestScope.endprice}"/>
                                                </div>
                                            </div> <!-- form-row.// -->

                                        </div><!-- card-body.// -->

                                    </div>
                                    <button class="btn btn-block btn-light bg-success text-white" type="submit">Apply</button>
                                </article> <!-- filter-group .// -->
                                <script type="text/javascript">
                                    function chGate()
                                    {
                                        frGate.submit();
                                    }
                                </script>

                            </div> <!-- card.// -->

                        </aside> <!-- col.// -->
                        <main class="col-md-9">

                            <header class="border-bottom mb-4 pb-3">
                                <div class="form-inline">
                                    <span class="mr-md-auto"><a href="home" style="color: #000; font-size: 2em;">Home</a></span>
                                    <select class="mr-2 form-control" name="sort" onchange="chGate()">
                                        <option value="1" ${sortname}>A-Z</option>
                                        <option value="3" ${sortdesc}>Price: High-Low</option>
                                        <option value="2" ${sortasc}>Price: Low-High</option>
                                        <option value="0" ${sortnew}>Newest</option>
                                    </select>
                                </div>
                            </header><!-- sect-heading -->

                            <div class="row">
                                <c:if test="${lstzsize>-1}">
                                    <c:forEach  var="i" begin="0" end="${lstzsize}" >
                                        <div class="col-md-4">
                                            <figure class="card card-product-grid" style="width: 250px; height: 400px">
                                                <div class="img-wrap" > 
                                                    <span class="badge badge-danger" > New </span>
<!--                                                    <a href="product-detail?productid=${requestScope.listP.get(i).id}">
                                                        <img src="${requestScope.listP.get(i).proImg}" style="width: 300px" alt="${requestScope.listP.get(i).proImg}" class="img-fluid reponsive"/>
                                                    </a>-->
                                                    <div class="col-lg-4 col-md-12 mb-4">
                                                    </div>

                                                </div> <!-- img-wrap.// -->
                                                <figcaption class="info-wrap">
                                                    <div class="fix-height">
                                                        <div id="productnamefix">
                                                            <a href="product-detail?productid=${requestScope.listP.get(i).id}" class="title">${requestScope.listP.get(i).name}</a>
                                                        </div>

                                                        <div class="price-wrap mt-2" style="padding-top: 5px">
                                                            <span class="price">$${requestScope.listP.get(i).price}</span>

                                                        </div> <!-- price-wrap.// -->
                                                    </div>
                                                </figcaption>
                                            </figure>
                                        </div> <!-- col.// -->
                                    </c:forEach>
                                </c:if>
                            </div> <!-- row end.// -->

                            <c:if test="${numberPage>1}">
                                <nav class="mt-4" aria-label="Page navigation sample">
                                    <ul class="pagination">

                                        <!-- fist page-->
                                        <c:if test="${pageCurrent ==1}">
                                            <li class="page-item"><p class="page-link"><<</p></li>
                                            </c:if>
                                            <c:if test="${pageCurrent !=1}">
                                            <li class="page-item"><a class="page-link" href="product?category=${requestScope.category}&beginp=${beginprice}&endp=${endprice}&page=1&s="productort=${requestScope.sortabc}&search=${requestScope.searchname}"">First</a></li>
                                            </c:if>

                                        <!--page-->
                                        <c:forEach var="page" begin="${beginPage}" end="${endPage}">
                                            <c:if test="${pageCurrent == page}">
                                                <li class="page-item active"><p class="page-link">${page}</p></li>
                                                </c:if>
                                                <c:if test="${pageCurrent != page}">
                                                <li class="page-item"><a class="page-link" href="product?category=${requestScope.category}&beginp=${beginprice}&endp=${endprice}&page=${page}&sort=${requestScope.sortabc}&search=${requestScope.searchname}">${page}</a></li>
                                                </c:if>
                                            </c:forEach>

                                        <!--last page-->        
                                        <c:if test="${pageCurrent ==numberPage}">
                                            <li class="page-item"><p class="page-link">>></p></li>
                                            </c:if>
                                            <c:if test="${pageCurrent !=numberPage}">
                                            <li class="page-item"><a class="page-link" href="product?category=${requestScope.category}&beginp=${beginprice}&endp=${endprice}&page=${numberPage}&sort=${requestScope.sortabc}&search=${requestScope.searchname}">Last</a></li>
                                            </c:if>
                                    </ul>
                                </nav>
                            </c:if>


                        </main> <!-- col.// -->

                    </div>

                </div> <!-- container .//  -->
            </section>
        </form>
        
    </body>
</html>


