<%@page contentType="text/html" pageEncoding="UTF-8" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
				integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
				crossorigin="anonymous">
			<!-- JavaScript Bundle with Popper -->
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
				integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
				crossorigin="anonymous"></script>
			<link rel="stylesheet" href="CSS/style.css">
			<title>Admin Product</title>
		</head>

		<body>

			<div class="container">
				<div class="bttCreate">
					<button type="button" class="btn btn-primary">Create</button>
				</div>
				<div class="content">
					<form action="search" method="post" class="d-flex" role="search">
						<input name="txt" class="form-control me-2" type="text" placeholder="Enter Name"
							aria-label="Search">
						<button class="btn btn-outline-success" type="submit">Search</button>
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
							<c:forEach items="${listP}" var="o">
								<tr>

									<th scope="row">${o.id}</th>

									<td>
										${o.name}
									</td>
									<td>
										${o.categoryID}
									</td>
									<td>
										${o.quantity}
									</td>
									<td></td>

									<td>
										<!-- Button trigger modal -->
										<button type="button" class="btn btn-danger" data-bs-toggle="modal"
											data-bs-target="#exampleModal">
											Delete
										</button>

										<!-- Modal -->
										<div class="modal fade" id="exampleModal" tabindex="-1"
											aria-labelledby="exampleModalLabel" aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title" id="exampleModalLabel">Delete confirm
														</h5>
														<button type="button" class="btn-close" data-bs-dismiss="modal"
															aria-label="Close"></button>
													</div>
													<div class="modal-body">
														<p>Do you agree to delete product ?</p>
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-secondary"
															data-bs-dismiss="modal">Close</button>
														<button type="button" class="btn btn-primary">Save
															changes</button>
													</div>
												</div>
											</div>
										</div>

										<a href="updatep?pid=${o.id}"> <button type="button"
												class="btn btn-info">Update</button></a>
									</td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
		</body>

		</html>