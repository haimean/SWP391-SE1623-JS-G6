<%-- 
    Document   : blogDetails
    Created on : Oct 18, 2022, 1:47:50 PM
    Author     : nguye
--%>
<%@include file="/store/layout/index.jsp" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <style>
            * {
                box-sizing: border-box;
            }

            body {
                font-family: Arial;
                padding: 20px;
                background: #f1f1f1;
            }
            p {
                margin-top: 20px;
            }
            /* Header/Blog Title */
            .header {
                padding: 30px;
                font-size: 40px;
                text-align: center;
                background: white;
            }

            /* Create two unequal columns that floats next to each other */
            /* Left column */
            .leftcolumn {
                float: left;
                width: 75%;
            }

            /* Right column */
            .rightcolumn {
                float: left;
                width: 25%;
                padding-left: 20px;
            }

            /* Fake image */
            .fakeimg {
                /*  background-color: #aaa;*/
                width: 100%;
                padding: 20px;
            }

            /* Add a card effect for articles */
            .card {
                border-radius: 20px;
                background-color: white;
                padding: 20px;
                margin-top: 20px;

            }
            .card2 {
                background-color: white;
                padding: 20px;
                margin-top: 20px;

            }

            /* Clear floats after the columns */
            .row:after {
                content: "";
                display: table;
                clear: both;
            }

            /* Footer */
            .footer {
                padding: 20px;
                text-align: center;
                background: #ddd;
                margin-top: 20px;
            }
            .img {
                height: 20px;
                width: 20px;
            }
            /* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other */
            @media screen and (max-width: 800px) {
                .leftcolumn, .rightcolumn {
                    width: 100%;
                    padding: 0;
                }
            }
            .dropdown{
                margin-left: 95%;
            }
        </style>
    </head>
    <body>

        <div class="header">
            <h2>Blog Name</h2>
        </div>

        <div class="row">
            <div class="leftcolumn">

                <div class="card2">
                    <div class="dropdown">

                        <img src="https://www.shareicon.net/data/512x512/2016/06/04/775696_interface_512x512.png" class="img" type="button"  data-bs-toggle="dropdown" aria-expanded="false">

                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="update?id=${requestScope.blog.id}">Update</a></li>                           
                        </ul>
                    </div>
                    <h2>${blog.title}</h2>
                    <h5>${blog.description}.</h5>
                    <c:if test="${blog.create_at != null}">
                        <h5>${blog.create_at}</h5>
                    </c:if><br>
                    <c:if test="${blog.create_at == null}">
                        <h5>khong nhan date</h5>
                    </c:if><br>
                    <div class="" >
                        <c:if test="${blog.image == null}">
                            <img src="https://agencyentourage.com/wp-content/uploads/2018/02/thinkstockphotos-626669886.jpg" class="img-fluid" style="max-height:700px; max-width: 75%;">
                        </c:if>
                        <c:if test="${blog.image != null}">
                            <img src="${blog.image}" class="img-fluid" style="max-height:700px; max-width: 75%;">
                        </c:if>
                    </div>
                    <h5>${blog.content}.</h5>
                </div>
            </div>
            <div class="rightcolumn">
                <div class="card">
                    <h2>About Me</h2>
                    <!--<div class="fakeimg" style="height:100px;">Image</div>-->
                    <p>Full Name: ${requestScope.userInformation.fullName}</p>
                    <p>Phone Number: ${userInformation.phone}</p>
                    <p>Emails: ${requestScope.userInformation.email}</p>
                    <p>Address: ${requestScope.userInformation.address}</p>     
                </div>
                <div class="card">
                    <h3>Popular Post</h3>
                    <c:if test="${lstzsize>-1}">
                        <!--<<form action="blogDetails">-->
                        <c:forEach  var="i" begin="0" end="${lstzsize}" >
                            <div class="fakeimg">
                                <a  href="blogDetails?id=${requestScope.listB.get(i).id}">
                                    <img src="${requestScope.listB.get(i).image == null?"https://agencyentourage.com/wp-content/uploads/2018/02/thinkstockphotos-626669886.jpg":requestScope.listB.get(i).image}" class="img-fluid avatar" style="max-height:700px; max-width: 75%;"><br>

                                    ${requestScope.listB.get(i).title}</a>&nbsp
                                <img src="https://www.freeiconspng.com/thumbs/eye-icon/eyeball-icon-png-eye-icon-1.png" class="img">&nbsp${requestScope.listB.get(i).viewNumber}<br>
                            </div>
                        </c:forEach>
                        <!--</form>-->
                    </c:if>

                </div>
                <div class="card">
                    <h3>Follow Me</h3>
                    <p>Some text..</p>
                </div>
            </div>
        </div>
    </body>
</html>
