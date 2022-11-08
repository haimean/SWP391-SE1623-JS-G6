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
        <form action="update" method="post">
            <div class="container">
                <h3>Product</h3>                 
                <div>
                    <label for="exampleFormControlInput1" class="form-label">Category</label>
                    <select class="form-select form-select-sm" aria-label=".form-select-sm example" name="categoryId">
                        <c:forEach items="${requestScope.listc}" var="o">
                            <option value="${o.id}"  ${detail.id == o.id ? "selected": "" }>${o.name}</option>     
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label" style="color:red">Name(*)</label>
                    <input type="text" class="form-control" id="pid" name="name" value="${detail.name}" placeholder="" maxlength="50">
                </div>
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Origin</label>
                    <input type="text" class="form-control" id="pid" name="origin" value="${detail.original}" placeholder="" maxlength="20">
                </div>
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Quantity</label>
                    <input type="number" class="form-control" id="pid" name="quantity" value="${detail.quantity}" placeholder="" min="0">
                </div>
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Price</label>
                    <input type="number" class="form-control" id="pid" name="price" value="${detail.price}" placeholder="" min="1">
                </div>
                <div class="mb-3">
                    <label for="exampleFormControlTextarea1" class="form-label">Description</label>
                    <textarea class="form-control" id="pid" name="description" rows="3" maxlength="1000">${detail.description}</textarea>
                </div>
                <div class="d-flex justify-content-center">
                    <input type="submit" class="btn btn-primary" value="Save">
                </div>   
            </div>
        </form>
</div>
                
<style>
    .container{
        width: 1050px;
        height: 1050px;
        padding-top: 80px;
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