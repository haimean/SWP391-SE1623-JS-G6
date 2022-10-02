<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Animated Login Form</title>
        <link href="<%=request.getContextPath()%>/login/css/style.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
    </head>
    <body>
        <div class="container">
            <header>Login Form</header>
            <form action="../login" method="POST">
                <div class="input-field">
                    <input type="text" name="email" required>
                    <label>Email or Username</label>
                </div>
                <div class="input-field">
                    <input class="pswrd" type="password" name="password" required>
                    <span class="show">SHOW</span>
                    <label>Password</label>
                </div>
                <div class="button">
                    <div class="inner"></div>
                    <input type="submit" value="LOGIN" >
                    <!--<button>LOGIN</button>-->
                </div>
            </form>
            <div class="auth">
                Or login with
            </div>
            <div class="links">
                <div class="facebook">
                    <i class="fab fa-facebook-square"><span>Facebook</span></i>
                </div>
                <div class="google">
                    <i class="fab fa-google-plus-square"><span>Google</span></i>
                </div>
            </div>
            <div class="signup">
                Not a member? <a href="#">Signup now</a>
            </div>
        </div>
        <script>
            var input = document.querySelector('.pswrd');
            var show = document.querySelector('.show');
            show.addEventListener('click', active);
            function active() {
                if (input.type === "password") {
                    input.type = "text";
                    show.style.color = "#1DA1F2";
                    show.textContent = "HIDE";
                } else {
                    input.type = "password";
                    show.textContent = "SHOW";
                    show.style.color = "#111";
                }
            }
        </script>
    </body>
</html>