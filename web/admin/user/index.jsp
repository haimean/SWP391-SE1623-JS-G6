<%-- Document : index Created on : 18-09-2022, 23:04:55 Author : haimi --%>

	<<<<<<< HEAD <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@page contentType="text/html" pageEncoding="UTF-8" %>
			=======
			<%@page contentType="text/html" pageEncoding="UTF-8" %>
				<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
					<%@ taglib prefix="cd" uri="http://java.sun.com/jstl/core_rt" %>
						>>>>>>> 8ec4d3b (n)

						<!DOCTYPE html>

						<%@include file="../layout/index.jsp" %>
							<link href="<%=request.getContextPath()%>/admin/user/style.css" rel="stylesheet">


							<div class="modal fade" id="modal" tabindex="-1">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title">Ban comfirm</h5>
											<button type="button" class="btn-close" data-bs-dismiss="modal"
												aria-label="Close"></button>
										</div>
										<div class="modal-body">
											<p>Do you agree to ban this user?</p>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-bs-dismiss="modal">Close</button>
											<button type="button" class="btn btn-warning text-white ">Ban</button>
										</div>
									</div>
								</div>
							</div>
							<div class="content-wrap d-flex">
								<div class="container">
									<div class="table-responsive table-container mx-auto">
										<div
											class="shadow-sm p-3 mb-5 bg-white rounded px-5 py-5 d-flex flex-column align-items-center">
											<div class="d-flex mb-4"
												style=" justify-content: center; align-items: center;">
												<input type="search" id="search" class="form-control "
													placeholder="Search" />
												<button class="btn btn-primary"
													style="margin-left: 1rem;">Search</button>
											</div>
											</section>
										</div>
									</div>
								</div>