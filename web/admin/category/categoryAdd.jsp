
<%-- 
    Document   : CreateCetegory
    Created on : Sep 30, 2022, 2:30:11 AM
    Author     : Mr Tuan
--%>

<%@include file="../layout/index.jsp" %>
<div class="container-category">
    <div class="side-nav-categories">
        <form action="create" method="POST">
            <div class="div-title">
                <h1 class="title">Create Category</h1>
            </div>
            <div class="div-name">
                <h3 class="title-name">Name</h3>
                <input class="text-name" type="text"  placeholder="Name..." name="txt">
            </div>
            <input type="submit" class="btn btn-primary" style="font-family: serif;color: #fff;" value="Create">
        </form>
    </div>
</div>