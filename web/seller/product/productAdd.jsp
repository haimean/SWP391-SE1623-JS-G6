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
    <form action="<%= request.getContextPath()%>/seller/product/create" method="post">
        <div class="container">
            <h3>Add New Product </h3>
            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label" style="color:red">Name(*)</label>
                <input type="text" class="form-control" id="exampleFormControlInput1" name="name" placeholder="" required="required" maxlength="50">
            </div>
            <div>
                <label for="exampleFormControlInput1" class="form-label">Category</label>
                <input type="number" class="form-control" id="exampleFormControlInput1" name="categoryId" placeholder="" required min="0"> 
            </div>
            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">Origin</label>
                <input type="text" class="form-control" id="exampleFormControlInput1" name="origin" placeholder="" required>
            </div>
            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">Quantity</label>
                <input type="number" class="form-control" id="exampleFormControlInput1" name="quantity" placeholder="" min="0" required>
            </div>
            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">Price</label>
                <input type="number" class="form-control" id="exampleFormControlInput1" name="price" placeholder="" required min="0">
            </div>                     
            <div class="mb-3">
                <label for="exampleFormControlTextarea1" class="form-label">Description</label>
                <textarea class="form-control" id="exampleFormControlTextarea1" name="description" rows="3" maxlength="200"></textarea>
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
        padding-top: 130px;
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