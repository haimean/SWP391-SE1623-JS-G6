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

        <footer class="ftco-footer ftco-bg-dark ftco-section">
            <div class="">
                <div class="row mb-5">
                    <div class="col-md">
                        <div class="ftco-footer-widget mb-3">
                            <h2 class="ftco-heading-2">CTU Travel</h2>
                            <p>
                                Customers can use CTU travel instead of having to find a lot of hotels, villas, ... suitable for their travel or needs. 
                            </p>

                        </div>
                    </div>
                    <div class="col-md">
                        <div class="ftco-footer-widget mb-3 ml-md-4">
                            <h2 class="ftco-heading-2">Information</h2>
                            <ul class="list-unstyled">
                                <li><a href="#" class="py-2 d-block">About Us</a></li>
                                <li><a href="#" class="py-2 d-block">Online enquiry</a></li>
                                <li><a href="#" class="py-2 d-block">Call Us</a></li>
                                <li><a href="#" class="py-2 d-block">General enquiries</a></li>
                                <li><a href="#" class="py-2 d-block">Booking Conditions</a></li>
                                <li><a href="#" class="py-2 d-block">Privacy and Policy</a></li>
                                <li><a href="#" class="py-2 d-block">Refund policy</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md">
                        <div class="ftco-footer-widget mb-3">
                            <h2 class="ftco-heading-2">Experience</h2>
                            <ul class="list-unstyled">
                                <li><a href="#" class="py-2 d-block">Beach</a></li>
                                <li><a href="#" class="py-2 d-block">Adventure</a></li>
                                <li><a href="#" class="py-2 d-block">Wildlife</a></li>
                                <li><a href="#" class="py-2 d-block">Honeymoon</a></li>
                                <li><a href="#" class="py-2 d-block">Nature</a></li>
                                <li><a href="#" class="py-2 d-block">Party</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md">
                        <div class="ftco-footer-widget mb-3">
                            <h2 class="ftco-heading-2">Co-operate with us</h2>
                            <div class="block-23 mb-3">
                                <ul>
                                    <li><span class="icon icon-map-marker"></span><span class="text">FPT University,Hoa Lac, Thach That, Ha Noi</span></li>
                                    <li><a href="#"><span class="icon icon-phone"></span><span class="text"> (+84)396 125 049</span></a></li>
                                    <li><a href="RegisterSupplierAccount"><span class="icon icon-envelope"></span><span class="text">Register Supplier</span></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 text-center">

                        <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                    </div>
                </div>
            </div>
        </footer>
        <!-- JS -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="js/main.js"></script>

        <script src="js/jquery.min.js"></script>
        <script src="js/jquery-migrate-3.0.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.easing.1.3.js"></script>
        <script src="js/jquery.waypoints.min.js"></script>
        <script src="js/jquery.stellar.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/aos.js"></script>
        <script src="js/jquery.animateNumber.min.js"></script>
        <script src="js/bootstrap-datepicker.js"></script>
        <script src="js/jquery.timepicker.min.js"></script>
        <script src="js/scrollax.min.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
        <script src="js/google-map.js"></script>
        <script src="js/main.js"></script>
    </body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>