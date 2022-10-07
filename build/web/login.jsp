<%-- 
    Document   : Login
    Created on : Sep 28, 2022, 8:55:56 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Login</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Abril+Fatface" rel="stylesheet">

        <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
        <link rel="stylesheet" href="css/animate.css">

        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">

        <link rel="stylesheet" href="css/aos.css">

        <link rel="stylesheet" href="css/ionicons.min.css">
        <link rel="icon" href="images/logo.png" type="">
        <link rel="stylesheet" href="css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="css/jquery.timepicker.css">


        <link rel="stylesheet" href="css/flaticon.css">
        <link rel="stylesheet" href="css/icomoon.css">
        <link rel="stylesheet" href="css/style.css">
        <!-- Font Icon -->
        <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="css/style1.css">
    </head> 
            <div class="main">

                <section class="signup" style="padding-top: 60px;padding-bottom: 60px">
                    <!-- <img src="images/signup-bg.jpg" alt=""> -->
                    <div class="container">
                        <div class="signup-content">
                            <form method="post" id="signup-form" class="signup-form" action="login">
                                <h2 class="form-title">Login</h2>


                                <div class="form-group">
                                    <input type="text" class="form-input" name="email" id="email" placeholder="Email"/>
                                </div>

                                <div class="form-group">
                                    <input type="password" class="form-input" name="password" id="password" placeholder="Password"/>

                                </div>
                         
                                <div class="form-group" >
                                      <input type="submit" name="submit" id="submit" class="form-submit" value="Login"/>
                                     <p>${noti}</p>
                                </div>
                               
       
                                
                         
                        </form>
                        <p class="loginhere">
                            Don't have account ? Click Here to <a href="registerCustomer" class="loginhere-link">Sign Up</a>
                        </p>

                    </div>
                </div>
            </section>

        </div>

       
</html>