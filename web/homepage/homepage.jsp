<%-- 
    Document   : homepage
    Created on : Oct 7, 2022, 2:24:35 AM
    Author     : Mr Tuan
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Bootstrap Example</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/homepage/css/style.css" rel="stylesheet">
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    </head>
    <body>

        <div class="container-homepage">
            <nav class="navbar navbar-expand-sm" >
                <div class="container-fluid" >
                    <a class="navbar-brand" href="<%= request.getContextPath()%>/homepage"><h2>Setups</h2></a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="mynavbar">
                        <ul class="navbar-nav me-auto">
                            <li class="nav-item">
                                <a class="nav-link" href="<%= request.getContextPath()%>/about">About</a>
                            </li>
                            <li class="nav-item">
                                <div class="dropdown" >
                                    <button class="dropbtn" onclick="ListCategory()">Category</button>
                                    <div class="dropdown-content">
                                        <a href="#">Char</a>
                                        <a href="#">Mouse</a>
                                        <c:forEach items="${requestScope.category}" var="ca">
                                            <a href="category?id=${c.getId()}">${ca.name}</a>
                                            <!--                                            <a href="#">Char</a>
                                                                                        <a href="#">Mouse</a>-->
                                        </c:forEach>
                                    </div>
                                </div>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="<%= request.getContextPath()%>/product">Shop</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="<%= request.getContextPath()%>/blog">Blog</a>
                            </li>
                        </ul>
                        <form class="d-flex">
                            <input class="form-control me-2" type="text" placeholder="Search">
                            <button class="button-search" type="button">Search</button>
                        </form>
                        <ul class="navbar-nav me-auto-1">
                            <li class="nav-item-cart">
                                <a  href="<%= request.getContextPath()%>/cart">
                                    <ion-icon class="nav-link" name="cart-outline" style="font-size: 35px;"></ion-icon>
                                </a>
                            </li>
                            <li class="nav-item-me">
                                <div class="dropdown-1" >
                                    <button class="dropbtn" onclick=""><ion-icon name="person-circle-outline" style="font-size: 35px;"></ion-icon></button>
                                    <div class="dropdown-content-1">
                                        <a href="<%= request.getContextPath()%>/profile">Profile<ion-icon name="person" style="margin-left: 15px;font-size: 25px;"></ion-icon></a>
                                        <a href="<%= request.getContextPath()%>/message">Message <ion-icon name="chatbubbles" style="margin-left: 15px;font-size: 25px;"></ion-icon></a>
                                        <a href="<%= request.getContextPath()%>/logout">Logout<ion-icon name="log-out-outline" style="margin-left: 15px;font-size: 25px;"></ion-icon></a>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>

                </div>
            </nav>
        </div>

        <div class="container-fluid mt-3">
            <h3>Navbar Forms</h3>
            <p>Russiaaa Uraaaaaaaaaaaaaaaaaaaaaaaa Uraaaaaaaaaaaaaaaaaaaaaaaa Uraaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa!</p>
        </div>

    </body>
    <script>
        function ListCategory() {
            window.location.href = "../category_list";
        }
    </script>
</html>



