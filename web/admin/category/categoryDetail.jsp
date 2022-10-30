<%@include file="../layout/index.jsp" %>
<div class="container-category">
    <div class="side-nav-categories">
        <form id="form" action="update" method="POST">
            <div class="div-title">
                <h1 class="title">${category.getName()}</h1>
            </div>
            <div class="div-id">
                <h3 class="title-id">ID</h3>
                <input class="text-id" type="text"  value="${category.id}" name="id" readonly>
            </div>
            <div class="div-name">
                <h3 class="title-name">Name</h3>
                <input class="text-name" type="text" onkeyup="ValidateCategory()"  placeholder="Name..." value="${category.name}"name="name" id="category-input"><span id="text-category"></span>
            </div>
            <input type="submit" class="btn btn-primary" style="font-family: serif;color: #fff;" value="Update">
        </form>
    </div>
</div>
<script>
    function ValidateCategory() {
        var form = document.getElementById("form");
        var category = document.getElementById("category-input").value;
        var text = document.getElementById("text-category");
        var pattern = /^([^0-9!@#$=+/\|;.,?<'":~>}{%^&*()]*)$/;

        if (category.match(pattern)) {
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

        if (category === "") {
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
    .div-id{
        margin-top: 30px;
        margin-left: 100px;
    }
    .title-id{
        font-family: serif;
        text-align: left;
    }
    .text-id{
        border-radius: 5px;
        text-align: left;
        width: 200px;
        height: 32px;
        margin-right: 500px;
    }

    .div-name{
        margin-top: 20px;
        margin-left: 100px;
    }
    .title-name{
        font-family: serif;
        text-align: left;
    }
    .text-name{
        border-radius: 5px;
        text-align: left;
        width: 550px;
        height: 32px;
        margin-right: 200px;
    }

    .btn-primary{
        background-color: rgb(255, 165, 0);
        margin-top: 60px;
        margin-bottom: 60px;
        width: 100px;
        height: 45px;
    }
    #text-category{
        margin-right: 540px;
    }

</style>