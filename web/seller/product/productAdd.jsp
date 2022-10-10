<%-- 
    Document   : productAdd
    Created on : Oct 10, 2022, 4:48:59 PM
    Author     : ngolu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="style.css">
        <title>Document</title>
    </head>
    <body>
        <form action="addProduct" method="post">
            <div class="container">
                <h3>Add New Product </h3>

                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Name</label>
                    <input type="text" class="form-control" id="exampleFormControlInput1" name="name" placeholder="">
                </div>
                <div>
                    <label for="exampleFormControlInput1" class="form-label">Category</label>
                    <input type="text" class="form-control" id="exampleFormControlInput1" name="categoryId" placeholder="" value="1">
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
                    <input type="submit" class="btn btn-primary" value="Save">
                    <!--                    <button type="button" class="btn btn-primary">Save</button>-->
                </div>   
            </div>
        </form>
    </body>
</html>
