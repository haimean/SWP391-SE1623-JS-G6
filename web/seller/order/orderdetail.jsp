<%@include file="../layout/index.jsp" %>

<div class="header">
    <h3>Order</h3>
</div>
<div class="container">  
    <!-- Input -->
    <div class="mb-3" id="txt">
        <label for="exampleFormControlInput1" class="form-label">ID</label>
        <input type="text" class="form-control" id="exampleFormControlInput1" readonly="" placeholder="" value="${detail.id}">
    </div>
    <div class="mb-3" id="numb">
        <label for="exampleFormControlInput1" class="form-label">Name</label>
        <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="" value="${detail.name}">
    </div>
    <div class="mb-3" id="txt">
        <label for="exampleFormControlInput1" class="form-label">Email</label>
        <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="" value="${detail.email}">
    </div>
    <div class="mb-3" id="numb">
        <label for="exampleFormControlInput1" class="form-label">Number Phone</label>
        <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="" value="${detail.phone}" >
    </div>
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Status</label>
        <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="" value="${detail.status}">
    </div>
    <!-- table -->
    <div class="table">
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Quanlity</th>
                    <th scope="col">UnitPrice</th>
                    <th scope="col">Price</th>
                </tr>
            </thead>
            <tbody>            
                <tr>
                    <th scope="row">${o.id}</th>
                    <td>${o.name}</td>
                    <td>${o.quantity}</td>
                    <td>${o.price}</td>
                    <td>${o.total}</td>
                </tr>                       
                <!--                        <tr>                      
                                            <th scope="row"></th>
                                            <td colspan="2">Total</td>
                                            <td>                               
                                            </td>
                                        </tr>-->
            </tbody>
        </table>

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
        margin-left: 6  0px;
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