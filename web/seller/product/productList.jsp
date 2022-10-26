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

        <a class="btn btn-primary" href="create" role="button">Create</a>
    </div>
    <div class="content" style="margin-top: 2rem">
        <form action=""  method="post"  class="d-flex" role="search">
            <input name="txt" class="form-control me-2" type="text" placeholder="Enter Name" aria-label="Search">
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
                        <th ><img src="https://static.vecteezy.com/system/resources/previews/000/395/417/original/modern-company-logo-design-vector.jpg" width="120" alt="${o.name}"/></th>     
                        <th >  
                            <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal${o.id}">Delete</button>
                            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel${o.id}" aria-hidden="true">
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
                                            <a class="btn btn-danger" href="delete?id=${o.id}" role="button">Delete</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <a class="btn btn-info" href="update?id=${o.id}" role="button">Update</a></th>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>