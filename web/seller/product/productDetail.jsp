<%-- Document : productDetail Created on : Sep 30, 2022, 4:44:05 PM Author : ngolu --%>

	<%@page contentType="text/html" pageEncoding="UTF-8" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
				integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
				crossorigin="anonymous">
			<link rel="stylesheet" href="CSS/style.css">
			<title>Document</title>
		</head>

		<body>

			<div class="container">
				<h3>Product</h3>

				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Name</label>
					<input type="email" class="form-control" id="exampleFormControlInput1" placeholder="">
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Category</label>
					<input type="email" class="form-control" id="exampleFormControlInput1" placeholder="">
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Quanlity</label>
					<input type="number" class="form-control" id="exampleFormControlInput1" placeholder="">
				</div>
				<div class="mb-3">
					<label for="exampleFormControlTextarea1" class="form-label">Example textarea</label>
					<textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
				</div>
				<div class="d-flex justify-content-center">
					<button type="button" class="btn btn-primary">Save</button>
				</div>

			</div>

		</body>

		</html>