<%-- 
    Document   : profile_update
    Created on : Oct 17, 2022, 4:30:03 AM
    Author     : MrTuan
--%>

<%@include file="../store/layout/index.jsp" %>
<link
    href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500&display=swap"
    rel="stylesheet"
    />
<div class="container-profile">
    <div class="side-nav-categories">
        <form action="update" method="get">
        <div class="div-option">
            <button class="button-logout-update-profile"><u>Save</u></button>
        </div>
        <div class="div-image-profile">
            <img class= "img-profile" src="https://picsum.photos/950/600.jpg">
        </div>
        <div class="div-title">
            <h1 class="title">${userinf.getFullname()}</h1>
        </div>
        <div class="div-bio">
            <span>${userinf.getBio()}</span>
        </div>
        <div class="div-information">
            <div class="div-info">
                <h4 class="title-infomation">
                    <b>Update Information Profile</b>
                </h4>
            </div><br>
            <span><ion-icon name="person-circle-outline"></ion-icon> Full Name:  <input type="search" id="search-input" placeholder="ex:Nguyen Ngoc Tuan"/></span><br>
            <span><ion-icon name="transgender"></ion-icon> Gender:<br>
                <input type="radio" id="sex" name="radio-item" value="male">Male<br>
                <input type="radio" id="sex" name="radio-item" value="female">Female<br>
                <input type="radio" id="sex" name="radio-item" value="other">Other...
            </span><br>
            <span><ion-icon name="call-outline"></ion-icon> Phone: <input type="search" id="search-input" placeholder="ex:+8432xxxxxx,032xxxxxx,.."/></span><br>
            <span><ion-icon name="mail-outline"></ion-icon> Email: <input type="search" id="search-input" placeholder="ex:tnxxxxxxxx@gmail.com"/></span><br>
            <span><ion-icon name="navigate-circle-outline"></ion-icon> Address: <input type="search" id="search-input" placeholder="ex:Cu Dinh-Viet Hung,..."/></span><br>
            <span><ion-icon name="business-outline"></ion-icon> City: <input type="search" id="search-input" placeholder="ex:Hung Yen"/></span>
        </div>
        </form>
    </div>
</div>
<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>

<!--<script>
    function UpdateProfile(id){
        window.location.href = "<%= request.getContextPath()%>/profile/update?id="+id;
    }
</script>-->
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
        margin-right: 400px;
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
    * {
        padding: 0;
        margin: 0;
        box-sizing: border-box;
        border: none;
        outline: none;
        font-family: "Poppins", sans-serif;
    }
    input {
        background-color: transparent;
        width: 40%;
        border-bottom: 1px solid #110f29;
    }
    input:focus {
        border-bottom-color: #6759ff;
    }
    #sex{
        width: 15px;
        margin-left: 90px;
        margin-bottom: 10px;
    }
</style>