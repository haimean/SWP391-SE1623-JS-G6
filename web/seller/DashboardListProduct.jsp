<%@include file="../seller/layout/index.jsp" %>

<div class="container"  style="
     border: 1px solid #0000004a;
     background: white;
     margin-top: 3rem;
     display: flex;
     justify-content: center;
     flex-direction: column;
     padding: 4rem;
     ">   
    <div class="content" style="margin-top: 2rem">
        <form action="productlist" class="d-flex" role="search">
            <input name="txt" class="form-control me-2" type="text" placeholder="Enter Name" aria-label="Search" value="${search}" required="" maxlength="30">
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
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="paging">
            <ul class="pagination justify-content-center">            
                <c:forEach begin="1" end="${endpage}" var="p">
                    <li class="page-item ${page == p ? "active" : ""}"><a class="page-link" href="<%= request.getContextPath()%>/seller/dashboard/productlist?page=${p}">${p}</a></li>
                    </c:forEach>                  
            </ul>
        </div>  
    </div>
</div>
                   
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