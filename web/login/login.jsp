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
    </head>
    <body>
        <div class="container mt-5">
            <div class="row">
                <div class="col-lg-6 col-12 mx-auto">
                    <div class="p-5 bg-white rounded shadow-lg">
                        <h2 class="mb-2 text-center">Sign In</h2>
                        <form action="<%=request.getContextPath()%>/login" method="POST">
                            <h4 class="font-500">Email</h4>
                            <input name="email" class="form-control form-control-lg mb-3" type="email"  placeholder="Email" >
                            <h4 class="font-500">Password</h4>
                            <div class="input-group ">
                                <input class="form-control form-control-lg" id="password" name="password" type="password" placeholder="Password" value="">
                                <span class="input-group-text">
                                    <i class="fa fa-eye-slash" id="togglePassword" 
                                       style="cursor: pointer"></i>
                                </span>
                            </div>
                            <div class="d-flex my-3  justify-content-between">
                                <div class="form-check">
                                    <input
                                        type="checkbox"
                                        class="form-check-input uf-form-check-input"
                                        id="exampleCheck1"
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
                    </div>
                    <div class="text-center pt-4">
                        <p class="m-0 ">Do not have an account? <a href="<%=request.getContextPath()%>/register" class="text-black">Sign Up</a></p>
                    </div>      
                </div>        
            </div>
        </div>
        <script>
            const togglePassword = document.querySelector("#togglePassword");
            const password = document.querySelector("#password");
            togglePassword.addEventListener("click", function () {
                const type = password.getAttribute("type") === "password" ? "text" : "password";
                password.setAttribute("type", type);
                this.classList.toggle('fa-eye');
                this.classList.toggle('fa-eye-slash');
            });
        </script>
    </body>
</html>