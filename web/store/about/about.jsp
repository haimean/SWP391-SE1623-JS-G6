<%@include file="../layout/index.jsp"  %>
<style>
    h1{
        background: linear-gradient(90deg, rgba(41,164,255,1) 0%, rgba(61,255,246,1) 79%);
        -webkit-background-clip: text;
        -webkit-text-fill-color: transparent;
        font-size: 6rem;
        position: relative;
    }
    .type{
        font-size: 1.6rem;
    }
</style>
<div class="container">
    <h1 class="text-center mt-5">QnAs</h1>
    <div class="accordion p-5">
        <c:set var="no" value="0"></c:set>
        <c:forEach items="${listQuestionType}" var="qt">
            <div class="mt-3 mb-2 type">${qt.name}</div>
            <c:forEach items="${listQuestion}" var="q">
                <c:if test="${qt.id == q.typeId}">
                    <c:set var="no" value="${no+1}"></c:set>
                        <div class="accordion-item">
                            <h2 class="accordion-header" id="panelsStayOpen-headingTwo">
                                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-${q.id}" aria-expanded="false" aria-controls="panelsStayOpen-collapseTwo">
                        <strong class="mx-2">#${no} Question:</strong><span style="text-transform: capitalize">${q.question}</span>
                            </button>
                        </h2>
                        <div id="panelsStayOpen-${q.id}" class="accordion-collapse collapse" aria-labelledby="panelsStayOpen-headingTwo">
                            <div class="accordion-body">
                                <strong>Answer:</strong>
                                <p style="text-transform: capitalize">${q.answer}</p>
                            </div>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </c:forEach>
    </div>
</div>
