<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../layout/index.jsp"  %>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.css"/>

<style>
    #inputQuantity::-webkit-outer-spin-button,
    #inputQuantity::-webkit-inner-spin-button {
        -webkit-appearance: none;
        margin: 0;
    }
    .footer-title{
        background: linear-gradient(90deg, rgba(41,164,255,1) 0%, rgba(61,255,246,1) 79%);
        -webkit-background-clip: text;
        -webkit-text-fill-color: transparent;
    }
    .icon-view{
        height: 1.3rem;
    }
</style>

<section class="py-5">
    <div class="container px-4 px-lg-5 my-5">
        <div class="row gx-4 gx-lg-5 align-items-center">
            <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="https://dummyimage.com/600x700/dee2e6/6c757d.jpg" alt="IMAGE" /></div>
            <div class="col-md-6">
                <div class="d-flex">
                    <div class="small d-flex text-muted me-4">
                        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6 icon-view">
                            <path stroke-linecap="round" stroke-linejoin="round" d="M2.036 12.322a1.012 1.012 0 010-.639C3.423 7.51 7.36 4.5 12 4.5c4.638 0 8.573 3.007 9.963 7.178.07.207.07.431 0 .639C20.577 16.49 16.64 19.5 12 19.5c-4.638 0-8.573-3.007-9.963-7.178z" />
                            <path stroke-linecap="round" stroke-linejoin="round" d="M15 12a3 3 0 11-6 0 3 3 0 016 0z" />
                        </svg>
                        <p class="ms-2">${p.viewNumber}</p>
                    </div>
                    <div class="small d-flex text-muted">
                        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6 icon-view">
                            <path stroke-linecap="round" stroke-linejoin="round" d="M12 21a9.004 9.004 0 008.716-6.747M12 21a9.004 9.004 0 01-8.716-6.747M12 21c2.485 0 4.5-4.03 4.5-9S14.485 3 12 3m0 18c-2.485 0-4.5-4.03-4.5-9S9.515 3 12 3m0 0a8.997 8.997 0 017.843 4.582M12 3a8.997 8.997 0 00-7.843 4.582m15.686 0A11.953 11.953 0 0112 10.5c-2.998 0-5.74-1.1-7.843-2.918m15.686 0A8.959 8.959 0 0121 12c0 .778-.099 1.533-.284 2.253m0 0A17.919 17.919 0 0112 16.5c-3.162 0-6.133-.815-8.716-2.247m0 0A9.015 9.015 0 013 12c0-1.605.42-3.113 1.157-4.418" />
                        </svg>

                        <p class="ms-2">${p.original}</p>
                    </div>
                </div>
                <h1 class="display-5 fw-bolder">${p.name}</h1>
                <div class="fs-5 mb-5">
                    <span>${p.price}</span>
                </div>
                <p class="lead">${p.description}</p>
                <form class="d-flex" action="<%= request.getContextPath()%>/cart" method="post">
                    <input type="hidden" name="mode" value="ADD"/>
                    <input type="hidden" name="id" value="${p.id}"/>
                    <button class="btn btn-link px-2"
                            onclick="this.parentNode.querySelector('input[type=number]').stepDown()" type="button">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-dash" viewBox="0 0 16 16">
                            <path d="M4 8a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7A.5.5 0 0 1 4 8z"/>
                        </svg>
                    </button>
                    <input class="form-control text-center" id="inputQuantity" type="number" value="1" min="1" name="num"
                           onkeydown="return event.keyCode !== 69 && event.keyCode !== 187 && event.keyCode !== 189" onblur="quantityOnBlur()" style="max-width: 3rem;"/>
                    <button class="btn btn-link px-2 me-3"
                            onclick="this.parentNode.querySelector('input[type=number]').stepUp()" type="button">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus" viewBox="0 0 16 16">
                            <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
                        </svg>
                    </button>
                    <button class="btn btn-outline-primary flex-shrink-0" type="submit">
                        Add to cart
                    </button>
                </form>
            </div>
        </div>
    </div>
</section>

<section class="py-5 bg-light">
    <div class="container px-4 px-lg-5 mt-5">
        <h2 class="fw-bolder mb-4 footer-title">Related products</h2>
        <div class="swiper mySwiper">
            <div class="swiper-wrapper">
                <c:forEach items="${list}" var="rp">
                    <div class="swiper-slide">
                        <div class="card h-100">
                            <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="IMAGE" />
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <h5 class="fw-bolder">${rp.name}</h5>
                                    ${rp.price}
                                </div>
                            </div>
                            <form class="card-footer p-4 pt-0 border-top-0 bg-transparent" action="detail" method="post">
                                <input type="hidden" name="id" value="${rp.id}"/>
                                <div class="text-center">
                                    <button class="btn btn-outline-primary flex-shrink-0" type="submit">
                                        View Product
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="swiper-button-next"></div>
            <div class="swiper-button-prev"></div>
        </div>
    </div>
</section>
<script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>      
<script>
                                let swiper = new Swiper(".mySwiper", {
                                    slidesPerView: 4,
                                    spaceBetween: 50,
                                    pagination: {
                                        el: ".swiper-pagination",
                                        clickable: true
                                    },
                                    navigation: {
                                        nextEl: ".swiper-button-next",
                                        prevEl: ".swiper-button-prev",
                                    },
                                });
                                function quantityOnBlur() {
                                    let input = document.getElementById("inputQuantity");
                                    if (input.value === '0') {
                                        console.log(input.value);
                                        input.value = 1;
                                    }
                                    console.log(input.value);
                                }
</script>  

