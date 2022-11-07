<%-- 
    Document   : ProfileUpdate
    Created on : Oct 20, 2022, 11:43:06 PM
    Author     : MrTuan
--%>


<%@include file="../../store/layout/index.jsp" %>
<link
    href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500&display=swap"
    rel="stylesheet"
    />
<div class="side-nav-categories">
    <form id="form" action="update" method="POST" enctype="multipart/form-data">
        <div class="div-option">
            <button type="submit" class="button-logout-update-profile" name="id" value="${userinf.getId()}"><u>Save</u></button>
        </div>
        <div class="div-image-profile">
            <img id="photo" class= "img-profile" src="${userinf.getImage()== null ? "https://res.cloudinary.com/ddrjnfihc/image/upload/v1667138651/Home/images/UserProfile/default.jpg" : userinf.getImage()}">
            <input type="file" id="file" name="image" accept="image/png,image/jpeg" multiple="multiple">
            <label for="file" id="uploadBtn">Choose Photo</label>
        </div>
        <div class="div-title">
            <h1 class="title">${userinf.getFullname()}</h1>
        </div>
        <div class="div-bio">
            <span>${userinf.getBiography()}</span>
        </div>
        <div class="div-information">
            <div class="div-info">
                <h4 class="title-infomation">
                    <b>Update Information Profile</b>
                </h4>
            </div><br>
            <span><ion-icon name="person-circle-outline"></ion-icon> Full Name:  <input value="${userinf.getFullname()}" onkeyup="ValidateFullname()" type="search" id="fullname" placeholder="ex:Nguyen Ngoc Tuan" name="fullName"/></span>&emsp;<span id="text-fullname"></span><br>
            <span><ion-icon name="transgender"></ion-icon> Gender:<br>
                <input type="radio" id="sex" name="gender" value="1" ${userinf.getGender()==1?"checked":""}>Male<br>
                <input type="radio" id="sex" name="gender" value="0" ${userinf.getGender()==0?"checked":""}>Female
            </span><br>
            <span><ion-icon name="hand-right-outline"></ion-icon>Bio: <input value="${userinf.getBiography()}"  type="text" id="bio" placeholder="ex:about me,..." name="biography"/></span>&emsp;<span id="text-bio"></span><br>
            <span><ion-icon name="call-outline"></ion-icon> Phone: ${userinf.getPhone()}</span><br>
            <span><ion-icon name="mail-outline"></ion-icon> Email: ${userinf.getMail()}</span><br>
            <span><ion-icon name="navigate-circle-outline"></ion-icon> Address: <input value="${userinf.getAddress()}" onkeyup="ValidateAddress()" type="search" id="address" placeholder="ex:Cu Dinh-Viet Hung,..." name="address"/></span><span id="text-address"></span><br>
            <span><ion-icon name="business-outline"></ion-icon> City: <input value="${userinf.getCity()}" onkeyup="ValidateCity()" type="text" id="city" placeholder="ex:Hung Yen" name="city"/></span>&emsp;<span id="text-city"></span>
        </div>
    </form>
</div>

<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>

<script type="text/javascript">
    function ValidateFullname() {
        var form = document.getElementById("form");
        var fullname = document.getElementById("fullname").value;
        var text = document.getElementById("text-fullname");
        var pattern = /^([^0-9!@#$=+/\|;.,?<'":~>}{%^&*()]*)$/;

        if (fullname.match(pattern)) {
            form.classList.add("valid");
            form.classList.remove("invalid");
            text.innerHTML = "Fullname valid!";
            text.style.color = "#00ff00";
        } else {
            form.classList.remove("valid");
            form.classList.add("valid");
            text.innerHTML = "Please enter fullname!";
            text.style.color = "#ff0000";
        }

        if (fullname === "") {
            form.classList.remove("valid");
            form.classList.remove("invalid");
            text.innerHTML = "";
            text.style.color = "#00ff00";
        }
    }

    function ValidateAddress() {
        var form = document.getElementById("form");
        var fullname = document.getElementById("address").value;
        var text = document.getElementById("text-address");
        var pattern = /^([^!@#$=+/\|;.,?<'":~>}{%^&*()]*]*)$/;

        if (fullname.match(pattern)) {
            form.classList.add("valid");
            form.classList.remove("invalid");
            text.innerHTML = "Input Valid!";
            text.style.color = "#00ff00";
        } else {
            form.classList.remove("valid");
            form.classList.add("valid");
            text.innerHTML = "Input Invalid!Please enter again!";
            text.style.color = "#ff0000";
        }

        if (fullname === "") {
            form.classList.remove("valid");
            form.classList.remove("invalid");
            text.innerHTML = "";
            text.style.color = "#00ff00";
        }

    }
    function ValidateCity() {
        var form = document.getElementById("form");
        var fullname = document.getElementById("city").value;
        var text = document.getElementById("text-city");
        var pattern = /^([^0-9!@#$=+/\|;.,?<'":~>}{%^&*()]*)$/;

        if (fullname.match(pattern)) {
            form.classList.add("valid");
            form.classList.remove("invalid");
            text.innerHTML = "Input Valid!";
            text.style.color = "#00ff00";
        } else {
            form.classList.remove("valid");
            form.classList.add("valid");
            text.innerHTML = "Input Invalid!Please enter again!";
            text.style.color = "#ff0000";
        }

        if (fullname === "") {
            form.classList.remove("valid");
            form.classList.remove("invalid");
            text.innerHTML = "";
            text.style.color = "#00ff00";
        }

    }

    const imgDiv = document.querySelector('.div-image-profile');
    const img = document.querySelector('#photo');
    const file = document.querySelector('#file');
    const uploadBtn = document.querySelector('#uploadBtn');


    imgDiv.addEventListener('mouseenter', function () {
        uploadBtn.style.display = "block";
    });


    imgDiv.addEventListener('mouseleave', function () {
        uploadBtn.style.display = "none";
    });

    file.addEventListener('change', function () {
        const choosedFile = this.files[0];

        if (choosedFile) {

            const reader = new FileReader();

            reader.addEventListener('load', function () {
                img.setAttribute('src', reader.result);
            });

            reader.readAsDataURL(choosedFile);
        }
    });
</script>


<style>

    .side-nav-categories {
        width: auto;
        height: auto;
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
    .div-image-profile{
        height: 200px;
        width: 200px;
        position: relative;
        margin: auto;
        border-radius: 50%;
        overflow: hidden;
        border: 1px solid grey;
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
        width: 60px;
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
    #photo{
        height: 100%;
        width: 100%;
    }

    #file{
        display: none;
    }

    #uploadBtn{
        height: 40px;
        width: 100%;
        position: absolute;
        bottom: 0;
        left: 50%;
        transform: translateX(-50%);
        text-align: center;
        background: rgba(0, 0, 0, 0.7);
        color: wheat;
        line-height: 30px;
        font-family: sans-serif;
        font-size: 15px;
        cursor: pointer;
        display: none;
        border-radius: 50%;
        overflow: hidden;
        border: 1px solid grey;
        margin: auto;
    }
</style>