<%-- 
    Document   : Profile
    Created on : Oct 20, 2022, 11:41:34 PM
    Author     : MrTuan
--%>


<%@include file="../../store/layout/index.jsp" %>
<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
    <symbol id="check-circle-fill" fill="currentColor" viewBox="0 0 16 16">
        <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
    </symbol>
    <symbol id="info-fill" fill="currentColor" viewBox="0 0 16 16">
        <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
    </symbol>
    <symbol id="exclamation-triangle-fill" fill="currentColor" viewBox="0 0 16 16">
        <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
    </symbol>
</svg>
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
                <a href="<%= request.getContextPath()%>/profile/update">Edit</a>
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
<div class="position-fixed w-100">
    <c:if test="${status == true}">
        <button class="alert alert-success d-flex align-items-center position-absolute ms-3 pe-auto" id="alert" role="alert" onclick="closeAlertModal()">
            <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Success:"><use xlink:href="#check-circle-fill"/></svg>
            <div>
                Update Succeeded!
            </div>
        </button>
    </c:if>
    <c:if test="${status == false}">
        <button class="alert alert-danger d-flex align-items-center position-absolute ms-3 pe-auto" id="alert" role="alert" onclick="closeAlertModal()">
            <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Danger:"><use xlink:href="#exclamation-triangle-fill"/></svg>
            <div>
                Update Failed!
            </div>
        </button>
    </c:if>

</div>
<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script>
    function EditProfile() {
        window.location.href = "<%= request.getContextPath()%>/profile/update"";
    }
    function closeAlertModal() {
        let modal = document.getElementById("alert");
        modal.classList.add("fadeOutLeft");
        console.log(modal);
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