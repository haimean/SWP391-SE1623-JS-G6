<%@include file="../layout/index.jsp" %>
<div class="container-category">
    <div class="side-nav-categories">
        <form action="update" method="POST">
            <div class="div-title">
                <h1 class="title">${category.getName()}</h1>
            </div>
            <div class="div-id">
                <h3 class="title-id">ID</h3>
                <input class="text-id" type="text"  value="${category.id}" name="id" readonly>
            </div>
            <div class="div-name">
                <h3 class="title-name">Name</h3>
                <input class="text-name" type="text"  placeholder="Name..." value="${category.name}"name="name">
            </div>
            <input type="submit" class="btn btn-primary" style="font-family: serif;color: #fff;" value="Update">
        </form>
    </div>
</div>
