<%-- 
    Document   : ProfileChangePassword
    Created on : Oct 27, 2022, 1:04:30 AM
    Author     : MrTuan
--%>

<%@include file="../../store/layout/index.jsp" %>
<div class="container-profile">
    <div class="side-nav-categories">
        <form id="form" action="changepassword" method="POST">
            <div class="div-information">
                <div class="div-info">
                    <h4 class="title-infomation">
                        <b>Change Password</b>
                    </h4>
                </div><br><br>
                <span> Email: <input name="email" value="${userinf.getMail()}" readonly></span><br><br>
                <span> Old Password: <input  type="password" id="oldpass" name="oldpass"/></span><br><br>
                <span> New Password: <input  onkeyup="ValidatePass()" type="password" id="newpass" name="newpass"/></span>&emsp;<span id="text-newpass"></span><br><br>
                <span> Confirm New Password: <input  onkeyup="ValidatePass()" type="password" id="newpass" name="confirmnewpass"/></span>&emsp;<span id="text-newpass"></span><br>
            </div>
            <input type="submit" class="btn btn-primary" style="font-family: serif;color: #fff;margin-bottom: 20px;" value="Save Change">
        </form>
    </div>
</div>

<script type="text/javascript">
    function ValidatePass() {
        var form = document.getElementById("form");
        var pass = document.getElementById("newpass").value;
        var text = document.getElementById("text-newpass");
        var pattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$/;

        if (pass.match(pattern)) {
            form.classList.add("valid");
            form.classList.remove("invalid");
            text.innerHTML = "Fullname valid!";
            text.style.color = "#00ff00";
        } else {
            form.classList.remove("valid");
            form.classList.add("valid");
            text.innerHTML = "Please enter password!";
            text.style.color = "#ff0000";
        }

        if (pass === "") {
            form.classList.remove("valid");
            form.classList.remove("invalid");
            text.innerHTML = "";
            text.style.color = "#00ff00";
        }
    }
</script>

<style>


    .side-nav-categories {
        border-radius: 30px;
        text-align: center;
        padding: 0px;
        position: relative;
        background-color: #fff;
        border-width: 1px;
        border-style: solid;
        border-color: #f5f5f5 #eee #d5d5d5 #eee;
        box-shadow: 0 5px 0 rgba(200,200,200,.2);
        width: 800px;
        margin: auto;
        top:15px;
        left: 20px;
    }
    .div-title{
        margin-top: 20px;
    }
    .title{
        font-family: serif;

    }

    .div-information{
        text-align: left;
        margin-top: 20px;
        margin-left: 30px;
        margin-bottom: 20px;
    }
    .title-infomation{
        font-family: serif;
        text-align: left;
        margin-left: 290px;
    }
    .div-option{
        text-align: right;
        margin-right: 20px;
    }
    .div-info{
        display: inline-flex;

    }
    .button-logout-update-profile {
        border: 0px solid rgb(13,110,253);
        padding: 0.2em 1em;
        border-radius: 3em;
        background-color: transparent;
        color: #6759ff;
        cursor: pointer;
        height: 35px;
    }
    .img-profile{
        width: 200px;
        height: auto;
        border-radius: 90px;
        cursor: zoom-in;
        background-color: lightgray;
    }
    ion-icon {
        font-size: 20px;
    }
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
</style>