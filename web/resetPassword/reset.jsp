<!DOCTYPE html>
<html lang="en" dir="ltr">

    <head>
        <meta charset="utf-8"> 
        <title>Sign Up</title>
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
                        <h2 class="mb-2 text-center">Reset Password</h2>
                        <form action="<%=request.getContextPath()%>/reset_password" method="POST">
                            <h4 class="font-500">Email</h4>
                            <input name="email" class="form-control form-control-lg mb-1" type="email" placeholder="Email" value="${email}" >
                            <span style="color: red" class="mb-3">${emailError} </span>
                            <h4 class="font-500">New Password</h4>
                            <div class="input-group  mb-1 ">
                                <input class="form-control form-control-lg" id="password" name="password" placeholder="Password" value="${password}">
                                <span class="input-group-text">
                                    <i class="fa fa-eye" id="togglePassword" 
                                       style="cursor: pointer"></i>
                                </span>
                            </div>
                            <span style="color: red" class="mb-3">${passwordError} </span>
                            <h4 class="font-500 ">Confirm New Password</h4>
                            <div class="input-group  mb-1">
                                <input class="form-control form-control-lg" id="rePassword" name="rePassword" placeholder="Confirm Password" value="${rePassword}">
                                <span class="input-group-text">
                                    <i class="fa fa-eye" id="toggleRePassword" 
                                       style="cursor: pointer"></i>
                                </span>
                            </div>
                            <span style="color: red" class="mb-3">${rePasswordError} </span>
                            <input class="btn btn-primary btn-lg w-100 shadow-lg mt-2"  type="submit" value="Reset" />
                        </form>
                    </div>
                    <div class="text-center pt-4">
                        <p class="m-0 ">Already a member? <a href="<%=request.getContextPath()%>/login" class="text-black">Login</a></p>
                    </div>      
                </div>        
            </div>
        </div>
    </body>

</html>