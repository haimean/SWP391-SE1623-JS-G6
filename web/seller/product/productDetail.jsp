<%-- 
    Document   : productDetail
    Created on : Sep 30, 2022, 4:44:05 PM
    Author     : ngolu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="CSS/style.css">
    <title>Document</title>
</head>
<body>
    
  <div class="container">
        <h3>Product</h3>
    
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Id</label>
        <input type="text" class="form-control" id="exampleFormControlInput1" name="name" readonly="" placeholder="">
    </div>
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Name</label>
        <input type="text" class="form-control" id="exampleFormControlInput1" name="name" placeholder="">
    </div>
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">CategoryID</label>
        <input type="text" class="form-control" id="exampleFormControlInput1" name="CategoryId" placeholder="">
    </div>
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Origin</label>
        <input type="text" class="form-control" id="exampleFormControlInput1" name="origin" placeholder="">
    </div>
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Quantity</label>
        <input type="number" class="form-control" id="exampleFormControlInput1" name="quantity" placeholder="">
    </div>
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Price</label>
        <input type="text" class="form-control" id="exampleFormControlInput1" name="price" placeholder="">
    </div>
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">View Number</label>
        <input type="number" class="form-control" id="exampleFormControlInput1" name="viewnumber" placeholder="">
    </div>
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Time Create</label>
        <input type="date" class="form-control" id="exampleFormControlInput1" name="create" placeholder="">
    </div>
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Time Update</label>
        <input type="date" class="form-control" id="exampleFormControlInput1" name="update" placeholder="">
    </div>
    <div class="mb-3">
        <label for="exampleFormControlTextarea1" class="form-label">Description</label>
        <textarea class="form-control" id="exampleFormControlTextarea1" name="description" rows="3"></textarea>
    </div>
    <div class="d-flex justify-content-center">
        <button type="button" class="btn btn-primary">Save</button>
    </div>   
    </div>
    </div>

</body>
</html>
