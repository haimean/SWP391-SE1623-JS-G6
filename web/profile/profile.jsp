<%-- 
    Document   : profile
    Created on : Oct 17, 2022, 4:26:42 AM
    Author     : MrTuan
--%>

<%@include file="../store/layout/index.jsp" %>
<div class="container-profile">
    <div class="side-nav-categories">
        <!--<form action="profile/update" method="POST">-->
            <div class="div-option">
                <!--<button class="button-update-profile" onclick="EditProfile(${profile.getId()})">Edit</button>-->
                <button class="button-logout-update-profile" onclick="Logout(${profile.getId()})"><u>Log Out <ion-icon name="log-out-outline"></ion-icon></u></button>
            </div>
            <div class="div-image-profile">
                <img class= "img-profile" src="https://picsum.photos/950/600.jpg">
            </div>
            <div class="div-title">
                <!--<h1 class="title">${profile.getFullname()}</h1>-->
                <h1 class="title">Nguyen Ngoc Tuan</h1>
            </div>
            <div class="div-bio">
                <!--<span>${profile.getBio()}</span>-->
                <span>Khong co ap luc khong tao ra thanh cong!</span>
            </div>
            <div class="div-information">
                <div class="div-info">
                    <h4 class="title-infomation">
                        <b>Thong tin ca nhan</b>
                    </h4>
                    <!--<button class="button-logout-update-profile" onclick="EditProfile(${profile.getId()})"><u>Edit</u></button>-->
                    <button class="button-logout-update-profile" onclick="EditProfile()"><u>Edit</u></button>
                </div><br>
                <span><ion-icon name="person-circle-outline"></ion-icon> Full Name: <b>Nguyen Ngoc Tuan</b></span><br>
                <span><ion-icon name="transgender"></ion-icon> Gender: <b>Nam</b></span><br>
                <span><ion-icon name="call-outline"></ion-icon> Phone: <b>032xxxxxx</b></span><br>
                <span><ion-icon name="mail-outline"></ion-icon> Email: <b>tnxxxxxxx@gmail.com</b></span><br>
                <span><ion-icon name="navigate-circle-outline"></ion-icon> Address: <b>Cu Dinh-Viet Hung-Van Lam-Hung Yen</b></span><br>
                <span><ion-icon name="business-outline"></ion-icon> City: <b>Hung Yen</b></span>
            </div>
        <!--</form>-->
    </div>
</div>
<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script>
    function EditProfile() {
//        window.location.href = "/profile/update?id=" + id;
        window.location.href = "<%= request.getContextPath()%>/profile/update";
    }
    function Logout(id) {
        window.location.href = "logout?id=" + id;
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
        margin-right: 480px;
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
</style>