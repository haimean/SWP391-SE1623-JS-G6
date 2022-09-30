<%@include file="../layout/index.jsp"  %>
<link href="<%=request.getContextPath()%>/admin/category/css/style.css" rel="stylesheet">

<div class="side-nav-categories" style="width: 1000px;height: 405px">
    <div class="title"><strong>Category</strong></div>
    <ul id="category-tabs">
        <li><a href="" class="main-category"> Web Applications<i class="fa fa-minus"></i></a>
            <ul class="sub-category-tabs">
                <li><a href="">HTML</a></li>
                <li><a href="">CSS</a></li>
                <li><a href="">SCSS</a></li>
            </ul>
        </li>
    </ul>
    <ul id="category-tabs">
        <li><a href="" class="main-category">Script<i class="fa fa-minus"></i></a>
            <ul class="sub-category-tabs">
                <li><a href="">Javascript</a></li>
                <li><a href="">CSSgo</a></li>
                <li><a href="">HTMLOL</a></li>
            </ul>
        </li>
    </ul>
    <ul id="category-tabs">
        <li><a href="" class="main-category">Server Script<i class="fa fa-minus"></i></a>
            <ul class="sub-category-tabs">
                <li><a href="">C#</a></li>
                <li><a href="">PYTHON</a></li>
                <li><a href="">JAVA</a></li>
            </ul>
        </li>
    </ul>
    <div id="footer-button-category">
        <button class="button create-category">Create New Category</button>
        <button class="button update-category">Update Category</button>
    </div>
</div>
