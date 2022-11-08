<%@include file="../layout/index.jsp" %>
<div class="container"  style="
     border: 1px solid #0000004a;
     background: white;
     margin-top: 3rem;
     display: flex;
     justify-content: center;
     flex-direction: column;
     padding: 4rem;
     ">
    <div>
        <a class="btn btn-primary" href="<%= request.getContextPath()%>/seller/product/create" role="button">Create</a>
    </div>
    <div class="content" style="margin-top: 2rem">
        <form action="product" class="d-flex" role="search">
            <input name="txt" class="form-control me-2" type="text" placeholder="Enter Name" aria-label="Search" value="${search}">
            <button class="btn btn-success" type="submit">Search</button>
        </form>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Category</th>
                    <th scope="col">Quanlity</th>
                    <th scope="col">Image</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:set var="i" value="0"></c:set>
                <c:forEach items="${products}" var="o">
                    <c:set var="i" value="${i+1}"></c:set>
                        <tr>
                            <th >${i}</th>        
                        <th >${o.name}</th>
                        <th >${o.categoryID}</th>
                        <th >${o.quantity}</th>
                        <th ><img src="${o.proImg}" width="120" alt="${o.name}"/></th>     
                        <th >  
                            <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal${o.id}">Delete</button>
                            <div class="modal fade" id="exampleModal${o.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Delete confirm</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <p>Do you agree to delete product ?</p>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                            <a class="btn btn-danger" href="<%= request.getContextPath()%>/seller/product/delete?id=${o.id}" role="button">Delete</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <a class="btn btn-info" href="<%= request.getContextPath()%>/seller/product/update?id=${o.id}" role="button">Update</a></th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="paging">
            <ul class="pagination justify-content-center">            
                <c:forEach begin="1" end="${endpage}" var="p">
                    <li class="page-item"><a class="page-link" href="<%= request.getContextPath()%>/seller/product?page=${p}">${p}</a></li>
                    </c:forEach>                  
            </ul>
        </div>  
    </div>
</div>
                    <p> ${page}</p>
<style>
    .container{
        width: 1050px;
        height: 1050px;
        padding-top: 165px;
        background-color: rgba(255, 255, 255, 0.884);
    }
    .bttCreate{
        padding-bottom: 19px;
    }
    .me-2 {
        margin-right: .5rem!important;
        height: 40px;
        width: 480px;
    }
    [type=button]:not(:disabled), [type=reset]:not(:disabled), [type=submit]:not(:disabled), button:not(:disabled) {
        cursor: pointer;
        height: 40px;
    }
    .d-flex {
        display: flex!important;
        padding-bottom: 91px;
    }
    h3{
        text-align: center;
    }
    .Page navigation example{
        position: absolute;
        top: 25%;
        left: 30%;
        transform: translateX(-50%);
    }
</style>