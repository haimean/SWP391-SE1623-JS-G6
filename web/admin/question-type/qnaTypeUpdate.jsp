<%-- Document : index Created on : 18-09-2022, 23:04:55 Author : haimi --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>

<%@include file="../layout/index.jsp"  %>

<style>
    *{
        padding: 0;
        margin: 0;
        box-sizing: border-box;
    }

    form{
        margin-left: 15%;
    }
</style>

<div class="container">
    <form action="update" method="post" class="shadow-sm p-3 mb-5 bg-white rounded p-5 mt-5">
        <input type="hidden" value="UPDATE" name="mode"/>
        <div class="form-group">
            <label class="mb-2">ID</label>
            <input type="text" class="form-control" placeholder="Id" value="${tsc.id}" name="id" readonly>
        </div>
        <div class="form-group mt-5">
            <label class="mb-2">Type Name</label>
            <input type="text" class="form-control" placeholder="Type Name" value="${tsc.name}" name="name">
        </div>
        <div class="mt-5 d-flex justify-content-center">
            <button type="submit" class="btn btn-primary">Add</button>
        </div>
    </form>
</div>
