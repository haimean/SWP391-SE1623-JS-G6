<%-- 
    Document   : index
    Created on : Oct 12, 2022, 5:53:01 AM
    Author     : MrTuan
--%>
<%@include file="../store/layout/index.jsp" %>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" rel="stylesheet" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link
    rel="stylesheet"
    href="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.css"
    />
<div class="swiper mySwiper container mt-4">
    <div class="swiper-wrapper">
        <c:forEach items="${categories}" var="c">
            <button class="btn btn-outline-primary swiper-slide rounded-pill" onclick="filterCategory(${c.getId()})">${c.getName()}</button>
        </c:forEach>
    </div>
</div>

<div class= "grid-container">
    <c:forEach items="${products}" var="p">
        <img class="grid-item" src="${p.proImg}" onclick="productDetail(${p.id},${p.categoryID})">
        </c:forEach>

</div>
<div class="text-center mb-5 position-fixed d-none btn-scroll">
    <button type="button" class="btn btn-light btn-lg rounded-4" id="scrollTop" onclick="scrollToTop()">
        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-up" viewBox="0 0 16 16">
            <path fill-rule="evenodd" d="M8 15a.5.5 0 0 0 .5-.5V2.707l3.146 3.147a.5.5 0 0 0 .708-.708l-4-4a.5.5 0 0 0-.708 0l-4 4a.5.5 0 1 0 .708.708L7.5 2.707V14.5a.5.5 0 0 0 .5.5z"/>
        </svg>
    </button>
</div>
<div class="text-center mb-5 btn-load">
    <button type="button" class="btn btn-outline-primary rounded-3" id="loadMore" onclick="loadMore()">
        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-double-down" viewBox="0 0 16 16">
            <path fill-rule="evenodd" d="M1.646 6.646a.5.5 0 0 1 .708 0L8 12.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z"/>
            <path fill-rule="evenodd" d="M1.646 2.646a.5.5 0 0 1 .708 0L8 8.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z"/>
        </svg>
        See More
    </button>
</div>
<div class="border-top text-center pt-3 mb-5 text-muted d-none last">
    <h3 class="infinite-scroll-error">No more products</h3>
</div>

<script src="https://unpkg.com/masonry-layout@4/dist/masonry.pkgd.js"></script>
<script src="https://unpkg.com/imagesloaded@5/imagesloaded.pkgd.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>
<script>
        console.log("Run");
        let elem = document.querySelector('.grid-container');
        let msnry;
        imagesLoaded(elem, () => {
            msnry = new Masonry(elem, {
                itemSelector: '.grid-item',
                columnWidth: 220
            });
        });

        let swiper = new Swiper(".mySwiper", {
            slidesPerView: 11,
            spaceBetween: 10,
            freeMode: true
        });

        function filterCategory(categoryId) {
            window.location.href = "?categoryId=" + categoryId + "&mode=FILTER";
        }

        let btnScrollTop = document.querySelector(".btn-scroll");

        window.onscroll = function () {
            showScrollBackToTop();
        };
        function showScrollBackToTop() {
            if (btnScrollTop) {
                if (document.body.scrollTop > 100 || document.documentElement.scrollTop > 100) {
                    btnScrollTop.classList.remove("d-none")
                } else {
                    btnScrollTop.classList.add("d-none")
                }
            }
        }
        function scrollToTop() {
            document.body.scrollTop = 0;
            document.documentElement.scrollTop = 0;
        }
        function loadMore() {
            let imgs = document.getElementsByTagName("img").length;
            $.ajax({
                url: '<%= request.getContextPath()%>',
                type: 'get',
                data: {
                    pageExisted: imgs,
                    mode: "LOAD"
                },
                success: function (data) {
                    let arrImgStr = data.split("+");
                    let arrElImg = [];
                    arrImgStr.forEach(elStr => {
                        if (!(elStr == "")) {
                            let el = getItemElement(elStr);
                            console.log(el);
                            arrElImg.push(el);
                        }
                    });

                    arrElImg.forEach(imgEl => {
                        elem.appendChild(imgEl);
                        console.log(imgEl);
                    });
                    console.log(arrImgStr);
                    msnry.appended(arrElImg);
                    if (data.length == 0) {
                        let btnLoad = document.querySelector(".btn-load");
                        let lastModal = document.querySelector(".last");
                        btnLoad.classList.add("d-none");
                        lastModal.classList.remove("d-none");
                    }
                },
                error: function () {
                }
            });
        }
        function getItemElement(elStr) {
            const template = document.createElement('template');
            template.innerHTML = elStr;
            const fragment = template.content;
            return fragment.childNodes[0];
        }
        function productDetail(productId, categoryId) {
            window.location.href = "product/detail?id=" + productId + "&categoryId=" + categoryId;
        }
</script>
<style>
    .grid-container{
        display: grid;
        grid-template-columns: repeat(auto-fill,230px);
        gap: 20px;
        justify-content: center;
        margin: 20px auto 54px 111px;
    }
    .grid-item{
        width: 200px;
        height: auto;
        margin-bottom: 40px;
        border-radius: 15px;
        cursor: zoom-in;
        background-color: lightgray;
    }
    .grid-item:hover{
        filter: opacity(0.9);
    }
    .btn-scroll{
        bottom: 0;
        right: 2.7rem;
    }
    #scrollTop{
        height: 3rem;
        width: 3rem;
    }
    .swiper-slide{
        width: fit-content!important;
    }
</style>