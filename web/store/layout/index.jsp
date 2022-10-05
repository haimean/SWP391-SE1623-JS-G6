<%-- 
    Document   : homepage
    Created on : Oct 7, 2022, 2:24:35 AM
    Author     : Mr Tuan
--%>
<%@page import="Model.*"
        import="DAO.*"
        import="java.util.ArrayList"
        %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Bootstrap Example</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
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
                                    <button class="dropbtn" onclick="ShopCart()"><ion-icon name="person-circle-outline" style="font-size: 35px;"></ion-icon></button>
                                    <div class="dropdown-content-1">
                                        <%
                                        User user = (User) request.getSession().getAttribute("user");
                                        if(user == null){
                                        %>
                                        <a class="dropdown-item" href="<%= request.getContextPath()%>/login">Login</a>    
                                        <%
                                        }else{
                                        %>
                                        <a href="<%= request.getContextPath()%>/profile">Profile<ion-icon name="person-outline" style="margin-left: 15px;font-size: 25px;"></ion-icon></a>
                                        <a href="<%= request.getContextPath()%>/seller/message">Message <ion-icon name="chatbubbles-outline" style="margin-left: 15px;font-size: 25px;"></ion-icon></a>
                                        <a href="<%= request.getContextPath()%>/logout">Logout<ion-icon name="log-out-outline" style="margin-left: 15px;font-size: 25px;"></ion-icon></a>
                                                <%}%> 
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
    </body>
    <script>
        function ListCategory() {
            window.location.href = "#";
        }
        function ShopCart() {
            window.location.href = "#";
        }
    </script>
</html>

<style>
    /*
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/CascadeStyleSheet.css to edit this template
    */
    /* 
        Created on : Oct 7, 2022, 2:24:53 AM
        Author     : Mr Tuan
    */
    .container-homepage{
        background-color: rgb(119, 73, 248);
        border-radius: 3px;
        height: 75px;
    }
    .navbar-brand{
        color: white;
    }
    .nav-item{
        margin-left: 50px;
    }
    .dropbtn {
        color: white;
        background-color: rgb(119, 73, 248);
        padding: 8px;
        font-size: 16px;
        border: none;
        cursor: pointer;
    }
    .dropbtn:hover {
        color: var(--bs-nav-link-color);
        transition: color .15s ease-in-out,background-color .15s ease-in-out,border-color .15s ease-in-out;
        background-color: rgb(119, 73, 248);
        padding: 8px;
        font-size: 16px;
        border: none;
        cursor: pointer;
    }

    .dropdown {
        position: relative;
        display: inline-block;
    }

    .dropdown-content {
        border-radius: 5px;
        display: none;
        position: absolute;
        background-color: #f9f9f9;
        min-width: 160px;
        box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        z-index: 1;
    }

    .dropdown-content a {
        border-radius: 5px;
        color: black;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
    }

    .dropdown-content a:hover {
        background-color: #f1f1f1
    }

    .dropdown:hover .dropdown-content {
        display: block;
    }
    .nav-link{
        color: white;
    }
    .d-flex{
        margin-bottom: 0;
        width: 400px;
        margin-right: 200px;
    }
    .nav-item-cart{
        margin-left: 200px;
        margin-right: 20px;
    }
    .navbar-nav me-auto-1{
        text-align: right;
    }
    .dropdown-content-1 {
        border-radius: 5px;
        display: none;
        position: absolute;
        background-color: #f9f9f9;
        min-width: 160px;
        box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        z-index: 1;
        text-align: left;
        width: 200px;
        right: 10px;
    }

    .dropdown-content-1 a {
        border-radius: 5px;
        color: black;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
    }

    .dropdown-content-1 a:hover {
        background-color: #f1f1f1;

    }

    .dropdown-1:hover .dropdown-content-1 {
        display: block;
    }

    .button-search{
        background-color: rgb(119, 73, 248);
        transition-duration: 0.4s;
        border-radius: 5px;
        color: white;
        border: 2px solid white;
        width: 100px;
    }

    .button-search:hover {
        color: var(--bs-nav-link-color);
        border-color: var(--bs-nav-link-color);
        transition: color .15s ease-in-out,background-color .15s ease-in-out,border-color .15s ease-in-out;
        background-color: rgb(119, 73, 248);
    }

</style>