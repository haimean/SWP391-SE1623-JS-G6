<%-- 
    Document   : index
    Created on : Oct 12, 2022, 5:53:01 AM
    Author     : MrTuan
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.*" import="Dao.*" import="Dao.Impl.*" import="java.util.ArrayList" %>
<%@include file="../store/layout/index.jsp" %>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" rel="stylesheet" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<div class="grid-category">
    <%
        CategoryDaoImpl categoryDaoImpl= new CategoryDaoImpl();
    ArrayList<Category> categories = categoryDaoImpl.getAll();
      if(categories != null){
                           for(Category c : categories){
    %>
    <button class= "grid-item-button-category" onclick="FilterCategory(<=%c.getId()%>)"><%=c.getName()%></button>
    <%
              }}
    %>
</div>

<div class= "grid-container">
    <img class= "grid-item" src="<%=request.getContextPath()%>/images/Product/lala.jpg">
    <img class= "grid-item" src="<%=request.getContextPath()%>/images/Product/ghegamming.jpg">
    <img class= "grid-item" src="<%=request.getContextPath()%>/images/Product/mic.jpg">
    <img class= "grid-item" src="<%=request.getContextPath()%>/images/Product/loa.jpg">
    <img class= "grid-item" src="<%=request.getContextPath()%>/images/Product/taycam.jpg">
    <img class= "grid-item" src="<%=request.getContextPath()%>/images/Product/tainghe.jpg">
    <img class= "grid-item" src= "https://picsum.photos/400/900.jpg">
    <img class= "grid-item" src= "https://picsum.photos/900/800.jpg">
    <img class= "grid-item" src= "https://picsum.photos/600/910.jpg">
    <img class= "grid-item" src= "https://picsum.photos/500/900.jpg">
    <img class= "grid-item" src= "https://picsum.photos/900/810.jpg">
    <img class= "grid-item" src= "https://picsum.photos/900/900.jpg">
    <img class= "grid-item" src= "https://picsum.photos/400/910.jpg">
    <img class= "grid-item" src= "https://picsum.photos/900/510.jpg">
    <img class= "grid-item" src= "https://picsum.photos/800/910.jpg">
    <img class= "grid-item" src= "https://picsum.photos/900/710.jpg">
    <img class= "grid-item" src= "https://picsum.photos/610/910.jpg">
    <img class= "grid-item" src= "https://picsum.photos/500/910.jpg">
    <img class= "grid-item" src= "https://picsum.photos/950/600.jpg">
    <img class= "grid-item" src= "https://picsum.photos/400/900.jpg">
    <img class= "grid-item" src= "https://picsum.photos/900/800.jpg">
    <img class= "grid-item" src= "https://picsum.photos/600/910.jpg">
    <img class= "grid-item" src= "https://picsum.photos/500/900.jpg">
    <img class= "grid-item" src= "https://picsum.photos/900/810.jpg">
    <img class= "grid-item" src= "https://picsum.photos/900/900.jpg">
    <img class= "grid-item" src= "https://picsum.photos/400/910.jpg">
    <img class= "grid-item" src= "https://picsum.photos/900/510.jpg">
    <img class= "grid-item" src= "https://picsum.photos/800/910.jpg">
    <img class= "grid-item" src= "https://picsum.photos/900/710.jpg">
    <img class= "grid-item" src= "https://picsum.photos/610/910.jpg">
    <img class= "grid-item" src= "https://picsum.photos/500/910.jpg">
    <img class= "grid-item" src= "https://picsum.photos/950/600.jpg">
    <img class= "grid-item" src= "https://picsum.photos/400/900.jpg">
    <img class= "grid-item" src= "https://picsum.photos/900/800.jpg">
    <img class= "grid-item" src= "https://picsum.photos/600/910.jpg">
    <img class= "grid-item" src= "https://picsum.photos/500/900.jpg">
    <img class= "grid-item" src= "https://picsum.photos/900/810.jpg">
    <img class= "grid-item" src= "https://picsum.photos/900/900.jpg">
    <img class= "grid-item" src= "https://picsum.photos/400/910.jpg">
    <img class= "grid-item" src= "https://picsum.photos/900/510.jpg">
    <img class= "grid-item" src= "https://picsum.photos/800/910.jpg">
    <img class= "grid-item" src= "https://picsum.photos/900/710.jpg">
    <img class= "grid-item" src= "https://picsum.photos/610/910.jpg">
    <img class= "grid-item" src= "https://picsum.photos/500/910.jpg">
</div>
<script src="https://unpkg.com/masonry-layout@4/dist/masonry.pkgd.js"></script>
<script src="https://unpkg.com/imagesloaded@5/imagesloaded.pkgd.min.js"></script>
<script>
        var elem = document.querySelector('.grid-container');
        imagesLoaded(elem, () => {
            var msnry = new Masonry(elem, {
                itemSelector: '.grid-item',
                columnWidth: 220
            });
        });

        function DetailProduct(id) {
            window.location.href = "#";
        }

        function FilterCategory(idCategory) {
            window.onload
        }
</script>



<style>
    /*
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/CascadeStyleSheet.css to edit this template
    */
    /* 
        Created on : Oct 12, 2022, 5:41:22 AM
        Author     : MrTuan
    */
    .grid-container{
        display: grid;
        grid-template-columns: repeat(auto-fill,230px);
        gap: 20px;
        justify-content: center;
        margin: 20px auto 20px 80px;
    }
    .grid-item{
        width: 200px;
        height: auto;
        margin-bottom: 40px;
        border-radius: 15px;
        cursor: zoom-in;
        background-color: lightgray;
    }
    .grid-item:hover{
        filter: opacity(0.9);
    }
    .grid-category{
        text-align: center;
    }
    .grid-category button {
        margin-top: 5px;
        border: 1px solid rgb(13,110,253);
        padding: 0.4em 2em;
        border-radius: 3em;
        background-color: transparent;
        color: #6759ff;
        cursor: pointer;
        height: 37px;
    }
    .grid-category button:focus {
        background-color: rgb(13,110,253);
        color: white;
    }
</style>