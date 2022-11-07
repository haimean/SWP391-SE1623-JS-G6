<!DOCTYPE html>
<html lang="en" dir="ltr">

    <head>
        <meta charset="utf-8">
        <title>Sign In</title>
        <link href="<%=request.getContextPath()%>/login/css/style.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
                integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
                integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
        crossorigin="anonymous"></script>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    </head>
    <body>

        <div class="container mt-5">
            <div class="row">
                <div class="col-lg-6 col-12 mx-auto">
                    <div class="p-5 bg-white rounded shadow-lg">
                        <h2 class="mb-2 text-center">Sign In</h2>
                        <form action="<%=request.getContextPath()%>/login" method="POST">
                            <h4 class="font-500">Email</h4>
                            <input name="email" class="form-control form-control-lg mb-3" type="email"  placeholder="Email" value="${email}" >
                            <h4 class="font-500">Password</h4>
                            <div class="input-group ">
                                <input class="form-control form-control-lg" id="password" name="password" type="password" placeholder="Password" value="${password}">
                                <span class="input-group-text">
                                    <i class="fa fa-eye-slash" id="togglePassword" 
                                       style="cursor: pointer"></i>
                                </span>
                            </div>
                            <span style="color: red" class="mb-3">${errorPassword}</span>
                            <div class="d-flex my-3  justify-content-between">
                                <div class="form-check">
                                    <input
                                        type="checkbox"
                                        class="form-check-input uf-form-check-input"
                                        id="remember"
                                        style="margin-top: 0.65rem;"
                                        />
                                    <h4 class="form-check-h4 " for="exampleCheck1"
                                        >Remember Me</h4
                                    >
                                </div>
                                <a href="#">Forgot password?</a>
                            </div>
                            <input class="btn btn-primary btn-lg w-100 shadow-lg"  type="submit" value="Login" />
                        </form>
                        <div class="login-google">
                            <div class="or-container">
                                <div class="line-separator"></div>
                                <div class="or-label">or</div>
                                <div class="line-separator"></div>
                            </div>
                            <div class="row">
                                <div class="col-md-12"> <a class="btn btn-lg btn-google btn-block btn-outline" href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:9999/SWP391-SE1623-JS-G6/logingoogle&response_type=code&client_id=1086381055681-0upu0i0nmp2v352u8b46hplsd8hpicc8.apps.googleusercontent.com&approval_prompt=force"><img src="https://img.icons8.com/color/20/000000/google-logo.png"> Sign In With Google</a> </div>
                            </div> <br>
                        </div>
                    </div>
                    <div class="text-center pt-4">
                        <p class="m-0 ">Do not have an account? <a href="<%=request.getContextPath()%>/register" class="text-black">Sign Up</a></p>
                    </div>      
                </div>        
            </div>

        </div>
        <div class="position-fixed w-100">
            <c:if test="${login == 'false'}">
                <button class="alert alert-danger d-flex align-items-center position-absolute ms-3 pe-auto" id="alert" role="alert" onclick="closeAlertModal()">
                    <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Danger:"><use xlink:href="#exclamation-triangle-fill"/></svg>
                    <div>
                        Your email or password is incorrect!
                    </div>
                </button>
            </c:if>
        </div>
    </body>
    <script>
        const togglePassword = document.querySelector("#togglePassword");
        const password = document.querySelector("#password");
        togglePassword.addEventListener("click", function () {
            const type = password.getAttribute("type") === "password" ? "text" : "password";
            password.setAttribute("type", type);
            this.classList.toggle('fa-eye');
            this.classList.toggle('fa-eye-slash');
        });
        setTimeout(closeAlertModal, 2000);
        function closeAlertModal() {
            let modal = document.getElementById("alert");
            modal.classList.add("fadeOutLeft");
        }
    </script>
    <style>
        .fadeOutLeft{
            animation: fadeOutLeft 0.3s ease-in;
            animation-fill-mode: forwards;
        }
        @keyframes fadeOutLeft {
            0% {
                opacity: 1;
                transform: translateX(0);
            }
            50%{
                opacity: 1;
                transform: skewX(-5deg);
            }
            75%{
                opacity: 1;
                transform: skewX(5deg);
            }
            100% {
                opacity: 0;
                transform: translateX(-100%);
            }
        }
        .login-google{
            text-align: center;
        }
        .btn-google {
            color: #545454;
            background-color: #ffffff;
            box-shadow: 0 1px 2px 1px #ddd
        }
        .line-separator {
            background-color: #ccc;
            flex-grow: 5;
            height: 1px;
            width: auto;

        }
        .or-label {
            flex-grow: 1;
            margin: 0 15px;
            text-align: center
        }
        .or-container {
            align-items: center;
            color: #ccc;
            display: flex;
            margin: 25px 0;
        }

    </style>
</html>