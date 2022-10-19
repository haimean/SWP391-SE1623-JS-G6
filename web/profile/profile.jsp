<%-- 
    Document   : profile
    Created on : Oct 17, 2022, 4:26:42 AM
    Author     : MrTuan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../store/layout/index.jsp" %>
<div class="container-profile">
    <div class="side-nav-categories">
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
                    <b>Information Profile</b>
                </h4>
                <button class="button-logout-update-profile" onclick="EditProfile(${userinf.getId()})"><u>Edit</u></button>
            </div><br>
            <span><ion-icon name="person-circle-outline"></ion-icon> Full Name: <b>${userinf.getFullname()}</b></span><br>
            <span><ion-icon name="transgender"></ion-icon> Gender: <b>
                    <c:if test="${userinf.isGender()==1}">
                        Male
                    </c:if>
                    <c:if test="${userinf.isGender()==0}">
                        Female
                    </c:if>
                </b></span><br>
            <span><ion-icon name="call-outline"></ion-icon> Phone: <b>${userinf.getPhone()}</b></span><br>
            <span><ion-icon name="mail-outline"></ion-icon> Email: <b>${userinf.getMail()}</b></span><br>
            <span><ion-icon name="navigate-circle-outline"></ion-icon> Address: <b>${userinf.getAddress()}</b></span><br>
            <span><ion-icon name="business-outline"></ion-icon> City: <b>${userinf.getCity()}</b></span>
        </div>
    </div>
</div>
<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script>
    function EditProfile(id) {
        window.location.href = "<%= request.getContextPath()%>/profile/update?id=" + id;
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