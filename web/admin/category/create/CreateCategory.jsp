<%-- Document : CreateCetegory Created on : Sep 30, 2022, 2:30:11 AM Author : Mr Tuan --%>

	<%@page contentType="text/html" pageEncoding="UTF-8" %>
		<%@include file="../../layout/index.jsp" %>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
				<link href="<%=request.getContextPath()%>/admin/category/create/css/style.css" rel="stylesheet">
				<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
				<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
				<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>

				<form action="create" method="POST">
					<div class="side-nav-categories">
						<c:forEach items="${requestScope.createCategory}" var="createC">
							<div class="div-title">
								<h1 class="title">Create Category</h1>
							</div>
							<div class="div-name">
								<h3 class="title-name">Name</h3>
								<input class="text-name" type="text" placeholder="Name..." name="txt"">
            </div>
            <!--<button type=" button" class="btn btn-info" href="update?id=${u.id}"
									style="font-family: serif;color: #fff;">Create</button>-->
								<button type="button" class="btn btn-primary"
									style="font-family: serif;color: #fff;">Create</button>
						</c:forEach>

					</div>
				</form>