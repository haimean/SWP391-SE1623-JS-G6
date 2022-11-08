<%@include file="../layout/index.jsp" %>
<div class="container full"  style="
     border: 1px solid #0000004a;
     background: white;
     margin-top: 3rem;
     display: flex;
     justify-content: center;
     flex-direction: column;
     padding: 4rem;
     ">
    <div class="container form-ds">
        <!-- form search -->
        <form action="order" class="d-flex" role="search">
            <input name="txtFullName" class="form-control me-2" type="search" placeholder="Search" aria-label="Search" value="${search}">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
        <!-- table -->

        <div class="container-md"> 
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Name</th>
                        <th scope="col">Email</th>
                        <th scope="col">Number Phone</th>
                        <th scope="col">Price</th>
                        <th scope="col">Status</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.listO}" var="o">
                        <tr>
                            <th scope="row">${o.id}</th>
                            <td>${o.name}</td>  
                            <td>${o.email}</td>
                            <td>${o.phone}</td>
                            <td>${o.price}</td>
                            <td>${o.status}</td>
                            <td>
                                <a href="<%= request.getContextPath()%>/seller/order/detail?oid=${o.id}"><button type="button" class="btn btn-primary">Infor</button></a>
                            </td>
                        </tr>
                    </c:forEach>  
                </tbody>
            </table>
        </div>
        <!-- pagination -->
        <div class="paging">
            <ul class="pagination justify-content-center">
                <c:forEach begin="1" end="${endpage}" var="p">
                    <li class="page-item"><a class="page-link" href="order?page=${p}">${p}</a></li>
                    </c:forEach>
            </ul>
        </div>
    </div>     
</div>
<style>
    .form-select{
        width: 185px;
        height: 38px;
        border-radius: 4px;
        top: 131px;
        left: 301px;
    }
    .container{
        width: 1000px;
        height: 800px;
        margin-top: 131px;
        margin-left: 301px;

    }
    .full {
        position: relative;
    }
    .table{
        margin-top: 100px;
    }
    .form-ds {
        position: absolute;
        left: -30%;
        top: -15%;
    }
    .d-flex{
        margin-top: 30px;
        width: 574.2px;
        height: 45.21px;
        margin-left: 60px;
    }
    .pagination {
        margin-top: 300px;
        margin-left: 150px;

    }
    .input{
        margin-top: 50px;
    }
    .header{
        text-align: center;
        /* margin-left: 220px; */
    }
    .paging {
        position: absolute;
        top: 25%;
        left: 30%;
        transform: translateX(-50%);
    }
</style>
