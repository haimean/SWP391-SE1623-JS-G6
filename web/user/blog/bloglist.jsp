<%-- 
    Document   : blogList
    Created on : Oct 17, 2022, 7:26:12 PM
    Author     : nguye
--%>
<%@include file="/store/layout/index.jsp" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>How To Create Blog Section Design In Bootstrap</title>
        <link rel="stylesheet" href="blogList.css">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

        <style>
            #blog {
                width: 100%;
                float: left;
                padding: 50px 0px;
            }
            .blog-post h2 {
                font-size: 20px;
                margin: 10px 0px;
            }
            .blog-post h2 a {
                color: #333;
            }
            .blog-post p {
                color: #505050;
            }
            #blog .section-title {
                padding: 20px 0px 5px;
                background-color: #fafafa;
                border-radius: 10px;
                margin-bottom: 30px;
            }
            #blog .blog-post {
                padding: 15px;
                border-radius: 5px;
                /*box-shadow: 30px 30px 0px -20px #EEEEEE;*/
                background: #fff;
                border: 1px solid #e6e6e6;
                position: relative;
                overflow: hidden;
                z-index: 99999;
                margin-bottom: 30px;
            }
            #blog .blog-post .post-thumb {
                max-height: 210px;
                overflow: hidden;
            }
            .img {
                height: 20px;
                width: 20px;
            }
            .deslength {
                max-height: 210px;
                height: 100px;
                width: 300px;
            }
            .titlelength {

                height: 50px;
                width: 300px;
            }

            .mid {
                margin-left: 500px;
            }

        </style>
    </head>
    <body>

        <!-- Blog Section -->
        <section id="blog">
            <a href="./blog/blogcreate.jsp"> <button type="button" class="btn btn-secondary btn-sm" >New Blog...</button></a>

            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="section-title">
                            <h2 class="text-center">Read Guides And Tips</h2>
                            <p class="text-center col-md-8 offset-md-2"><i>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s</i></p>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <c:if test="${lstzsize>-1}">
                        <c:forEach  var="i" begin="0" end="${lstzsize}" >
                            <div class="col-md-4 col-lg-4 ">
                                <div class="blog-post">
                                    <div class="post-thumb">
                                        <a href="blog/detail?id=${requestScope.listB.get(i).id}">
                                            <c:if test="${listB.get(i).image != null}">
                                                <img src="${listB.get(i).image}" class="img-fluid" alt="Image"/>
                                            </c:if>
                                            <c:if test="${listB.get(i).image == null}">
                                                <img src="https://agencyentourage.com/wp-content/uploads/2018/02/thinkstockphotos-626669886.jpg" class="img-fluid" />
                                            </c:if>

                                        </a>
                                    </div>
                                    <h2 class="titlelength"><a href="blog/detail?id=${requestScope.listB.get(i).id}" >${requestScope.listB.get(i).title}</a></h2>
                                    <p class="deslength">${requestScope.listB.get(i).description}</p>
                                    <a href="blog/detail?id=${requestScope.listB.get(i).id}" class="btn btn-warning float-right">Read More</a>
                                    <img src="https://www.freeiconspng.com/thumbs/eye-icon/eyeball-icon-png-eye-icon-1.png" class="img">&nbsp${requestScope.listB.get(i).viewNumber}
                                </div>
                            </div> 
                        </c:forEach>
                    </c:if>



                </div>
                <c:if test="${numberPage>1}">
                    <nav class="mt-4 " aria-label="Page navigation sample">
                        <ul class="pagination mid">

                            <!-- fist page-->
                            <c:if test="${pageCurrent ==1}">
                                <li class="page-item"><p class="page-link"><<</p></li>
                                </c:if>
                                <c:if test="${pageCurrent !=1}">
                                <li class="page-item"><a class="page-link" href="/SWP391-SE1623-JS-G6/user/blog">First</a></li>
                                </c:if>

                            <!--page-->
                            <c:forEach var="page" begin="${beginPage}" end="${endPage}">
                                <c:if test="${pageCurrent == page}">
                                    <li class="page-item active"><p class="page-link">${page}</p></li>
                                    </c:if>
                                    <c:if test="${pageCurrent != page}">
                                    <li class="page-item"><a class="page-link" href="/SWP391-SE1623-JS-G6/user/blog?page=${page}">${page}</a></li>
                                    </c:if>
                                </c:forEach>

                            <!--last page-->        
                            <c:if test="${pageCurrent ==numberPage}">
                                <li class="page-item"><p class="page-link">>></p></li>
                                </c:if>
                                <c:if test="${pageCurrent !=numberPage}">
                                <li class="page-item"><a class="page-link" href="/SWP391-SE1623-JS-G6/user/blog?category=page=${numberPage}">Last</a></li>
                                </c:if>
                        </ul>
                    </nav>
                </c:if>
            </div>
        </section>
        <!-- End Blog Section -->

    </body>
</html>