<%-- 
    Document   : blogDetails
    Created on : Oct 18, 2022, 1:47:50 PM
    Author     : nguye
--%>
<%@include file="../../store/layout/index.jsp" %>
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
        /*                float: left;*/
        width: 75%;
        margin: auto;
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
    .middle{
        margin-left: 200px;
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


</style>

<div class="header">
    <h2>Blog Name</h2>
</div>

<div class="row">
    <div class="leftcolumn">

        <div class="card2">
            <form action="update" method="POST" enctype="multipart/form-data">
                <input type="hidden" name="id" maxlength="150" value="${requestScope.blog.id}">
                <h2>Title: <input style=" width: 1000px;" value=" ${requestScope.blog.title}" name="title" required></h2> 
                <h5>Description: <textarea maxlength="150" style=" width: 1000px;" name="description">${requestScope.blog.description}</textarea></h5>
                <input type="hidden"  name="date" value="${requestScope.blog.create_at}">
                <h5><label>Date of create: ${requestScope.blog.create_at}</label></h5><br>
                <div class="middle">
                    <img src="${requestScope.blog.image == null?"https://agencyentourage.com/wp-content/uploads/2018/02/thinkstockphotos-626669886.jpg":requestScope.blog.image}" class="img-fluid avatar" style="max-height:700px; max-width: 75%;"><br>


                    <input class="file-upload avatar" type="file" id="img" name="image" accept="image/png,image/jpeg" multiple="multiple" style="margin-top: 20px;" value="${blog.image}">
                </div>
                <p>Content: <textarea maxlength="2000" style=" width: 1000px;" name="content"> ${requestScope.blog.content}</textarea></p>

                <input style="margin-bottom: 50px;"  class="btn btn-primary float-right" type="submit" value="Save">
            </form>
        </div>

    </div>
</div>
<script >$(document).ready(function () {


        var readURL = function (input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    $('.avatar').attr('src', e.target.result);
                }

                reader.readAsDataURL(input.files[0]);
            }
        }


        $(".file-upload").on('change', function () {
            readURL(this);
        });
    });</script>