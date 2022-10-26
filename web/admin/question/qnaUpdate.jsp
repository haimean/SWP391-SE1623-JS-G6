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
        <input type="hidden" name="type" id="type" value="${sc.typeId}"/>
        <div class="row">
            <div class="col">
                <label class="mb-2">ID</label>
                <input type="text" class="form-control" placeholder="Id" value="${sc.id}" name="id" readonly>
            </div>
            <div class="col">
                <label class="mb-2">Question Type</label>
                <select class="form-select" onchange="changeTypeId(this)">
                    <c:forEach items="${list}" var="tsc">
                        <option value="${tsc.id}" ${tsc.name eq sc.name ? "selected" : ""}>${tsc.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group mt-5">
            <label class="mb-2">Question</label>
            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" placeholder="Question" name="question">${sc.question}</textarea>
        </div>
        <div class="form-group mt-5">
            <label class="mb-2">Answer</label>
            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" placeholder="Answer" name="answer">${sc.answer}</textarea>
        </div>
        <div class="mt-5 d-flex justify-content-center">
            <button type="submit" class="btn btn-primary">Update</button>
        </div>
    </form>
</div>

<script>
    function changeTypeId(el) {
        let value = el.value;
        let input = document.getElementById("type");
        input.value = value;
    }
</script>
