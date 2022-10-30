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
    <style>
        .form-select{
            width: 185px;
            height: 38px;
            border-radius: 4px;
            top: 131px;
            left: 301px;
        }
        .container{
            width: 815px;
            height: 646px;
            margin-top: 131px;
            margin-left: 301px;
        }
        .table{
            margin-top: 100px;
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
    </style>
    <div class="container">
        <!-- form search -->
        <form action="searchorder" class="d-flex" role="search">
            <input name="txtFullName" class="form-control me-2" type="search" placeholder="Search" aria-label="Search" value="">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
        <!-- table -->
        <div class=".container-md"> 
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
                                <a href="getorder?oid=${o.id}"><button type="button" class="btn btn-primary">Infor</button></a>
                            </td>
                        </tr>
                    </c:forEach>  
                </tbody>
            </table>
        </div>
        <!-- pagination -->
        <div class="pagination">
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">
                    <li class="page-item disabled">
                        <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
                    </li>           
                    <li class="page-item"><a class="page-link" href="#">1</a></li>            
                    <li class="page-item">
                        <a class="page-link" href="#">Next</a>
                    </li>

                </ul>
            </nav>
        </div>
    </div>   
</div>
