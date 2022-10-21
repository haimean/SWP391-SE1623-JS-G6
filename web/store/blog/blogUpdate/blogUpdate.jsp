<%-- 
    Document   : blogDetails
    Created on : Oct 18, 2022, 1:47:50 PM
    Author     : nguye
--%>
<%@include file="/store/layout/index.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="icon" type="image/png" href="images/icons/favicon.ico" />
        <!--===============================================================================================-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
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
                margin: auto;
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
            @media screen and (max-height: 700px) {
                .leftcolumn, .rightcolumn {
                    width: 100%;
                    padding: 0;

                }
            }
            .text {
                 height: 100px;
             
              width: 1000px;
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
                    <h2><input type="text" name="title" value="${requestScope.blog.title}"></h2>
                    <!--<h5  ><input style="width: 1000px; height: 100px;" type="text" name="description" value="${requestScope.blog.description}"></h5>-->
                    <!--        <div>
                                <h5>${requestScope.blog.description}</h5>
                            </div>-->
                    <div class="wrap-input100 validate-input" data-validate="Name is required">
<!--                        <span class="label-input100">Blog Description</span>-->
                        <textarea class="text" type="text"  name="prodes" >${requestScope.blog.description}</textarea>
                        <!--<input class="text" type="text"  name="prodes" value="${requestScope.blog.description}"/>-->
                        <span class="focus-input100" data-symbol="&#xf206;"></span>
                    </div>
                    <h5>${requestScope.blog.create_at}</h5><br>
                    <div class="" ><img src="https://agencyentourage.com/wp-content/uploads/2018/02/thinkstockphotos-626669886.jpg" class="img-fluid" style="height:400px; width: 75%;"></div>
                    <p class="text">Some text.. dkfsjghkjlsdfhgkjldfshgkjlsdfhgkjfhgfldkgjslkfdjglk;sfdjglksfjglsk;fjglkfjgl;ksjglskfjgslfkjgsflk;jlf;kdsjglksfdjg;lskfjgl;ksfjgl;
                        dlkjlkdfjglkjfglkjfdgkljfdlkgjfdlkgjlfkdjglkfdjgkl
                        dlf;kgjfdlkgjdflkgjfldkjglkfdjgfd
                        dflkgjfdlkgjfdlgjdflkgjjlfkddflkgjfdlkjgldkfjglkfdjgljkfglkjdf
                        ldskfghjfdlkgjdflgjfldgjlfdgljlkfgjslkfjglkfdjglkjfd
                        lkdfjglkfdjglkfdjglkfdjglkfjdglkjfdglkjfdlkgjfdlkjgfd
                        dfglkjdflgkjfdlkgjfdlkgjfdlkjglfkdjglkfdjglkjfdgjlkfd
                        lkdfjglkdfjglkdfjglkfdjglkfdjglkjfdglkjdflkgjdflkjgdfl
                        dflkgjdflkgjdflkgjfdlkjglkfdjglkfdjglfdkjgfldkjglkjf
                        fdlkgjlkdfglksdfglksdfglksdflkgjklsfdjglkjsfdgsdfgsdfgsdfgsdfg
                        dfgsdfgsdfgsdfgsdfgsdf3g1dfs32g13df2s1g32dfs1g321sdfg321sdf32g1sfd
                        3f1sg32s1fdg321sdfg321sfd32g1sdf32g1sdf321g32sfd1g32sdf1g32sdf1g321sdf
                        fg321s1fg321sdfg321sdf3g21dsf32g1fd32g132sfg32sdf1g32f1g32sdf132sdf1g32s1
                        sdfasdfasdfaasdfasdfasdfadgafgahafhfadhafhfghfghsghdfghdfghfdghdfghdfghfgdhdfgh
                        dfghd4dfg21hd5g4fhd5fg61hg1hd9f86g4h9d8fgh49dgf8h4df6g5h1d6fgh4186dfgh41d6g8fh41d3
                        df53g2h16d8rt4h896d4gh321df68t4h8964fdg32h16drt84h68rt4hf1gh63drt8h4rdth64</p>
                </div>
            </div>

        </div>
    </body>
</html>
