<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link
            href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
            rel="stylesheet">
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Roboto+Condensed:wght@300;400;700&display=swap');

            * {
                margin: 0;
                padding: 0;
            }

            :root {
                --mainColor: #6169db;
                --txtColor: #686ffd;
                --txtBlack: #111111;
                --txtColorSecond: #ffffff;
                --btnColor: #474ed1;
                --onlineStatus: #67cfff;
                --offlineStatus: #ff6565;
                --conversationBody: #b1b6ff;
            }

            html {
                font-size: 10px;
                font-family: 'Ubuntu', sans-serif;
                background: var(--mainColor);
                color: var(--txtColorSecond);
            }

            a {
                text-decoration: none;
            }

            ul {
                list-style: none;
            }

            img {
                display: block;
            }

            .border {
                border-radius: .5rem;
            }

            .container {
                width: 100%;
                height: 100vh;
                display: flex;
                justify-content: center;
                align-items: center;
            }

            .form-title {
                font-size: 3.5rem;
                margin-bottom: 5rem;
                text-align: center;
            }

            .form-container {
                margin: auto;
                width: 40rem;
                max-width: 100%;
                display: inline-block;
            }

            .txt-input, .btn {
                padding: 1.5rem 1rem;
                display: block;
                margin-top: 1rem;
                width: 100%;
                box-sizing: border-box;
                border: none;
                outline: none;
                box-shadow: none;
                font-family: 'Ubuntu', sans-serif;
                box-shadow: 0px .2rem .4rem rgba(1, 1, 1, 0.05);
            }

            .btn {
                cursor: pointer;
                background: var(--btnColor);
                color: var(--txtColorSecond);
                font-size: 1.8rem;
            }

            .tab-control {
                text-align: left;
                display: flex;
            }

            .tab-control h3 {
                cursor: pointer;
                color: var(--txtColorSecond);
                font-size: 1.6rem;
                padding-right: 1.5rem;
                background: var(--btnColor);
                padding: 1.5rem 1rem;
                text-align: center;
                border-radius: .5rem .5rem 0rem 0rem;
                flex-grow: 1;
            }

            .tab-control h3.active {
                color: var(--txtColor);
                background: var(--txtColorSecond);
            }

            .login-form, .register-form {
                display: none;
                padding: 2rem 1.5rem;
                background: #ffffff;
                border-radius: 0rem 0rem .5rem .5rem;
            }

            .login-form.active, .register-form.active {
                display: block;
            }

            .image-profile {
                width: 15rem;
                height: 15rem;
                border-radius: 50%;
                margin-top: 1rem;
            }

            .image-profile img {
                width: 100%;
                height: 100%;
                object-fit: cover;
            }

            .conversation-container {
                box-shadow: 0rem .2rem .4rem rgba(1, 1, 1, 0.05);
                display: flex;
                flex-wrap: wrap;
                height: 70rem;
                overflow: hidden;
            }

            .conversation-container .left-side {
                width: 30rem;
                background: var(--btnColor);
                padding: 2rem 1.5rem;
                box-sizing: border-box;
                border-radius: 1rem 0rem 0rem 1rem;
                position: relative;
            }

            .conversation-container .right-side {
                width: 70rem;
                background: var(--conversationBody);
                box-sizing: border-box;
                border-radius: 0rem 1rem 1rem 0rem;
                overflow: hidden;
            }

            .add-group {
                position: absolute;
                left: 2rem;
                bottom: 2rem;
                font-size: 1.8rem;
                cursor: pointer;
                display: none;
                padding: 0.5rem 1rem;
                background: var(--mainColor);
                z-index: 9;
            }

            .add-group.active {
                display: block;
            }

            .modal-box {
                position: absolute;
                left: 50%;
                top: 50%;
                transform: translate(-50%, -50%);
                width: 30rem;
                background: var(--txtColorSecond);
                color: var(--txtBlack);
                padding: 1rem;
                box-sizing: border-box;
                z-index: 999;
                display: none;
            }

            .modal-box.active {
                display: block;
            }

            .modal-box-head {
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding-bottom: 1rem;
                font-size: 1.4rem;
                font-weight: 600;
            }

            .modal-box-body input {
                background: #dbdbdb;
            }

            .modal-box-body .list-user {
                max-height: 25rem;
            }

            .modal-box-body .list-user li:hover {
                background: none;
            }

            .modal-box-close {
                padding: 1rem;
                cursor: pointer;
            }

            .user-select-dot {
                width: 1.2rem;
                height: 1.2rem;
                border-radius: 50%;
                border: 0.1rem solid var(--txtBlack);
                position: relative;
            }

            .user-select-dot::before {
                content: "";
                position: absolute;
                width: .8rem;
                height: .8rem;
                border-radius: 50%;
                background: var(--mainColor);
                left: calc(50% - 0.4rem);
                top: calc(50% - 0.4rem);
                z-index: 9999;
                display: none;
            }

            .add-member-body li {
                display: flex;
                justify-content: space-between;
                align-items: center;
            }

            .add-member-body li:hover {
                background: none !important;
            }

            .add-member-body label {
                flex-grow: 1;
            }

            .add-member-body .list-user {
                max-height: 25rem !important;
            }

            .add-member-body input[type="checkbox"] {
                display: none;
            }

            .add-member-body input[type="checkbox"]:checked ~ .user-select-dot::before {
                display: block;
            }

            .tab-control {
                display: flex;
                justify-content: center;
                margin-top: 2rem;
            }

            .tab-control i {
                flex-grow: 1;
                text-align: center;
                font-size: 2rem;
                cursor: pointer;
                padding: 1.5rem 0rem;
                border-radius: .5rem;
                box-sizing: border-box;
            }

            .tab-control i.active, .tab-control i:hover {
                background: var(--mainColor);
            }

            .list-user {
                margin-top: 2rem;
                overflow-y: auto;
                max-height: 50rem;
                list-style: none;
                box-sizing: border-box;
            }

            .list-user li {
                position: relative;
            }

            .list-user-search .txt-input {
                background: var(--mainColor);
                color: var(--txtColorSecond);
                border-radius: .5rem;
            }

            .list-user-search .txt-input::placeholder {
                color: var(--txtColorSecond);
            }

            .list-user li {
                padding: 1rem;
                border-radius: .5rem;
                cursor: pointer;
                box-sizing: border-box;
            }

            .list-user li:hover, .list-user li.active {
                background: var(--mainColor);
            }

            .user-contain {
                display: flex;
                align-items: center;
                position: relative;
            }

            .group-delete {
                position: absolute;
                right: 1rem;
                top: 50%;
                transform: translateY(-50%);
                z-index: 10;
                padding: 1rem;
                background: var(--txtBlack);
            }

            .user-img {
                margin-right: 1rem;
                border-radius: 50%;
                padding: .2rem;
                background: var(--txtColorSecond);
                position: relative;
            }

            .user-img-dot {
                position: absolute;
                width: 1rem;
                height: 1rem;
                border-radius: 50%;
                z-index: 2;
                background: var(--offlineStatus);
                right: .2rem;
                bottom: .2rem;
                border: .3rem solid var(--txtColorSecond);
            }

            .user-img-dot.online {
                background: var(--onlineStatus);
            }

            .user-img img {
                border-radius: 50%;
                width: 5rem;
                height: 5rem;
            }

            .user-name {
                font-size: 1.5rem;
                display: block;
                margin-top: .5rem;
                font-weight: 700;
                word-break: break-word;
            }

            .user-last-message {
                font-size: 1.2rem;
                display: block;
                margin-top: .7rem;
            }

            .right-side .user-contact {
                box-shadow: 0rem .2rem .4rem rgba(1, 1, 1, 0.05);
                padding: 1.5rem;
                color: var(--txtBlack);
                display: flex;
                flex-wrap: wrap;
                align-items: center;
                background: var(--txtColorSecond);
            }

            .back {
                padding: 1rem;
                font-size: 1.6rem;
                cursor: pointer;
                display: none;
                padding-left: 0rem;
            }

            .user-contact .user-contain {
                align-items: center;
                flex-grow: 1;
            }

            .invite-user {
                font-size: 1.3rem;
                margin-right: 2rem;
            }

            .total-invite-user, .invite {
                padding: 0rem 1rem;
            }

            .total-invite-user {
                border-right: 0.1rem solid var(--txtBlack);
            }

            .setting, .invite, .add-member {
                cursor: pointer;
            }

            .setting, .add-member {
                font-size: 1.6rem;
                padding: .8rem 1rem;
                border-radius: .5rem;
            }

            .setting:hover, .add-member:hover {
                background: var(--mainColor);
                color: var(--txtColorSecond);
            }

            .list-messages-contain {
                padding: 0rem 1.5rem;
                height: 56rem;
                overflow-y: auto;
            }

            .message {
                display: flex;
                align-items: flex-end;
                /* overflow-y: auto; */
                margin-top: 2rem;
            }

            .message.right {
                justify-content: flex-end;
            }

            .message.right .message-img {
                order: 2;
            }

            .message-img {
                width: 3rem;
                height: 3rem;
                margin-right: .5rem;
                position: relative;
            }

            .message-img .sender-name {
                position: absolute;
                left: 4rem;
                bottom: -1.5rem;
                color: var(--txtColor);
                font-style: italic;
                font-weight: 700;
            }

            .message.right .sender-name {
                left: -2rem;
            }

            .message-img img {
                width: 100%;
                height: 100%;
                border-radius: 50%;
            }

            .message-text {
                padding: .8rem;
                background: var(--mainColor);
                border-radius: .5rem;
                font-size: 1.2rem;
                font-weight: 500;
                max-width: 20rem;
                margin-right: .5rem;
                word-break: break-word;
            }

            .message-text>* {
                max-width: 100%;
            }

            .message.right .message-text {
                background: var(--txtColorSecond);
                color: var(--txtBlack);
            }

            .list-file {
                width: 100%;
                position: absolute;
                background: var(--txtColorSecond);
                left: 0;
                bottom: 100%;
                display: flex;
                overflow-y: auto;
                box-sizing: border-box;
            }

            .list-file.active {
                padding: 1rem;
            }

            .list-file img {
                width: 7rem;
                height: 7rem;
                object-fit: cover;
                margin: 0 .5rem;
            }

            .list-file li {
                position: relative;
            }

            .file-input {
                padding: 1.5rem;
                color: var(--txtBlack);
                box-shadow: 0rem .2rem .4rem rgba(1, 1, 1, 0.1);
                margin-right: .5rem;
                white-space: nowrap;
            }

            .delete-attach {
                position: absolute;
                right: -.2rem;
                top: -.2rem;
                color: var(--txtColorSecond);
                cursor: pointer;
                width: 2rem;
                height: 2rem;
                font-size: 1.4rem;
                text-align: center;
                line-height: 2rem;
                background: var(--mainColor);
                opacity: .5;
                border-radius: 50%;
            }

            .form-send-message {
                background: var(--txtColorSecond);
                height: 5.6rem;
                align-items: center;
                display: flex;
                position: relative;
            }

            .form-send-message .txt-input {
                margin: 0rem;
                font-size: 1.3rem;
                flex-grow: 1;
            }

            .form-send-message .btn {
                background: transparent;
                color: var(--btnColor);
                width: auto;
                margin: 0rem;
            }

            .form-send-message input[type="file"], .register-form input[type="file"] {
                display: none;
            }

            @media only screen and (max-width: 1076px) {
                .conversation-container {
                    flex-direction: row;
                    padding: 0rem 1.5rem;
                    position: relative;
                    max-width: 100%;
                    box-sizing: border-box;
                }

                .conversation-container .right-side, .conversation-container .left-side {
                    width: 45rem;
                    display: none;
                    border-radius: 1rem;
                }

                .conversation-container .right-side.active, .conversation-container .left-side.active {
                    display: block;
                }

                .back {
                    display: block;
                }
            }

            @media only screen and (max-width: 400px) {
                .conversation-container .right-side, .conversation-container .left-side {
                    width: 30rem;
                    display: none;
                    border-radius: 1rem;
                }
            }
        </style>
        <link rel="icon" type="image/png"
              href="<c:url value="/static/images/icon.jpg" />">
        <title>Chat</title>
    </head>
    <body>
        <div class="container">
            <div class="conversation-container">
                <div class="modal-box border" id="add-group">
                    <div class="modal-box-head">
                        <div class="modal-box-title">
                            Add Group
                        </div>
                        <div class="modal-box-close toggle-btn" data-id="add-group" onclick="toggleModal(this, false)">
                            <i class="fa fa-times"></i>
                        </div>
                    </div>
                    <hr>
                    <form action="" onsubmit="return createGroup(event);">
                        <div class="modal-box-body">
                            <input type="text" class="txt-input txt-group-name" placeholder="Group Name...">
                        </div>		
                        <button type="submit" class="btn">Create Group</button>		
                    </form>
                </div>

                <div class="modal-box border" id="add-user">
                    <div class="modal-box-head">
                        <div class="modal-box-title">
                            Add Member
                        </div>
                        <div class="modal-box-close toggle-btn" data-id="add-user" onclick="toggleModal(this, false)">
                            <i class="fa fa-times"></i>
                        </div>
                    </div>
                    <hr>
                    <form action="" onsubmit="return addMember(event);">
                        <div class="modal-box-body add-member-body">
                            <input type="text" class="txt-input txt-group-name" placeholder="Name of member..." onkeyup="searchMemberByKeyword(this)">

                            <div class="list-user">
                                <ul>
                                </ul>
                            </div>
                        </div>		
                        <button type="submit" class="btn">Add Members</button>		
                    </form>
                </div>

                <div class="modal-box border" id="manage-user">
                    <div class="modal-box-head">
                        <div class="modal-box-title">
                            All Member Of Group
                        </div>
                        <div class="modal-box-close toggle-btn" data-id="manage-user" onclick="toggleModal(this, false)">
                            <i class="fa fa-times"></i>
                        </div>
                    </div>
                    <hr>
                    <div class="modal-box-body manage-member-body">
                        <div class="list-user">
                            <ul>
                            </ul>
                        </div>
                    </div>	
                </div>

                <div class="left-side active">
                    <div class="add-group border toggle-btn" data-id="add-group" onclick="toggleModal(this, true)"><i class="fa fa-plus-circle"></i></div>
                    <h2>
                        <a href="<%= request.getContextPath()%>/profile"
                           style="text-decoration: none; color: white;margin-right: 3rem;">${user.getFullName()}</a>
                        :
                        <a href="<%= request.getContextPath()%>/logout"
                           style="text-decoration: none; color: white; margin-left: 3rem;">Logout</a>
                    </h2>
                    <div class="tab-control">
                        <i class="fa fa-comment active" onclick="chatOne(this)"></i>
                        <i class="fa fa-comments" onclick="chatGroup(this)"></i>
                    </div>
                    <div class="list-user-search">
                        <input type="text" class="txt-input" data-type="user" placeholder="Search..." onkeyup="searchUser(this)">
                    </div>
                    <div class="list-user">
                        <ul>
                            <c:forEach items="${friends}" var="friend">
                                <li id=${friend.getFullname() } onclick="setReceiver(this);">
                                    <div class="user-contain">
                                        <div class="user-img">
                                            <img id="img-${friend.getFullname()}" src="${friend.getImage()== null ? "https://res.cloudinary.com/ddrjnfihc/image/upload/v1667138651/Home/images/UserProfile/default.jpg" :friend.getImage()}">
                                            <div id="status-${friend.getFullname()}" class="user-img-dot"></div>
                                        </div>
                                        <div class="user-info">
                                            <span class="user-name">${friend.getFullname()}</span>
                                        </div>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <div class="right-side" id="receiver"></div>
            </div>
        </div>
        <script>

            /* global fetch, URL */

            var username = null;
            var websocket = null;
            var receiver = null;
            var userAvatar = null;
            var receiverAvatar = null;

            var groupName = null;
            var groupId = null;

            var back = null;
            var rightSide = null;
            var leftSide = null;
            var conversation = null;

            var attachFile = null;
            var imageFile = null;
            var file = null;
            var listFile = [];
            var typeFile = "image";
            var deleteAttach = null;

            var typeChat = "user";

            var listUserAdd = [];
            var listUserDelete = [];
            var numberMember = 0;

            window.onload = function () {
                if ("WebSocket" in window) {
                    username = document.getElementById("username").textContent;
                    userAvatar = document.getElementById("userAvatar").textContent;
                    websocket = new WebSocket('ws://' + window.location.host + '/chat/' + username);

                    websocket.onopen = function () {
                    };

                    websocket.onmessage = function (data) {
                        setMessage(JSON.parse(data.data));
                    };

                    websocket.onerror = function () {
                        console.log('An error occured, closing application');
                        cleanUp();
                    };

                    websocket.onclose = function (data) {
                        console.log(data.reason);
                        cleanUp();
                    };
                } else {
                    console.log("Websockets not supported");
                }
            };

            window.onclick = function (e) {
                let modals = document.querySelectorAll(".modal-box");
                let toggleBtns = document.querySelectorAll(".toggle-btn");
                let count = 0;

                modals.forEach(function (modal) {
                    if (modal.contains(e.target))
                        count++;
                });

                toggleBtns.forEach(function (toggleBtn) {
                    if (toggleBtn.contains(e.target))
                        count++;
                });

                if (count !== 1)
                    toggleAllModal();
            };


            function cleanUp() {
                username = null;
                websocket = null;
                receiver = null;
            }

            function setReceiver(element) {
                groupId = null;
                receiver = element.id;
                receiverAvatar = document.getElementById('img-' + receiver).src;
                var status = '';
                if (document.getElementById('status-' + receiver).classList.contains('online')) {
                    status = 'online';
                }
                var rightSide = '<div class="user-contact">' + '<div class="back">'
                        + '<i class="fa fa-arrow-left"></i>'
                        + '</div>'
                        + '<div class="user-contain">'
                        + '<div class="user-img">'
                        + '<img src="' + receiverAvatar + '" '
                        + 'alt="Image of user">'
                        + '<div class="user-img-dot ' + status + '"></div>'
                        + '</div>'
                        + '<div class="user-info">'
                        + '<span class="user-name">' + receiver + '</span>'
                        + '</div>'
                        + '</div>'
                        + '<div class="setting">'
                        + '<i class="fa fa-cog"></i>'
                        + '</div>'
                        + '</div>'
                        + '<div class="list-messages-contain">'
                        + '<ul id="chat" class="list-messages">'
                        + '</ul>'
                        + '</div>'
                        + '<form class="form-send-message" onsubmit="return sendMessage(event)">'
                        + '<ul class="list-file"></ul> '
                        + '<input type="text" id="message" class="txt-input" placeholder="Type message...">'
                        + '<label class="btn btn-image" for="attach"><i class="fa fa-file"></i></label>'
                        + '<input type="file" multiple id="attach">'
                        + '<label class="btn btn-image" for="image"><i class="fa fa-file-image-o"></i></label>'
                        + '<input type="file" accept="image/*" multiple id="image">'
                        + '<button type="submit" class="btn btn-send">'
                        + '<i class="fa fa-paper-plane"></i>'
                        + '</button>'
                        + '</form>';

                document.getElementById("receiver").innerHTML = rightSide;

                loadMessages();

                displayFiles();

                makeFriend(rightSide);
            }

            function setGroup(element) {
                receiver = null;
                groupName = element.getAttribute("data-name");
                groupId = element.getAttribute("data-id");

                receiverAvatar = document.getElementById("img-group-" + groupId).src;

                listUserAdd = [];

                numberMember = parseInt(element.getAttribute("data-number"));


                fetch("http://" + window.location.host + "/conversations-rest-controller?usersConversationId=" + groupId)
                        .then(data => data.json())
                        .then(data => {
                            let findObject = data.find(element => element.username === username);
                            let isAdmin = findObject.admin;

                            var rightSide = '<div class="user-contact">' + '<div class="back">'
                                    + '<i class="fa fa-arrow-left"></i>'
                                    + '</div>'
                                    + '<div class="user-contain">'
                                    + '<div class="user-img">'
                                    + '<img id="img-group-' + groupId + '" src="' + receiverAvatar + '"'
                                    + 'alt="Image of user">'
                                    + '</div>'
                                    + '<div class="user-info">'
                                    + '<a href="http://' + window.location.host + '/conversation?conversationId=' + groupId + '" class="user-name">' + groupName + '</a>'
                                    + '</div>'
                                    + '</div>'
                                    + '<div class="invite-user">'
                                    + '<span class="total-invite-user">' + numberMember + ' paticipants</span>'
                                    + '<span data-id="add-user" onclick="toggleModal(this, true); searchMemberByKeyword(``);" class="invite toggle-btn">Invite</span>'
                                    + '</div>'
                                    + '<div class="setting toggle-btn" data-id="manage-user" onclick="toggleModal(this, true);  fetchUser();">'
                                    + '<i class="fa fa-cog"></i>'
                                    + '</div>'
                                    + '</div>'
                                    + '<div class="list-messages-contain">'
                                    + '<ul id="chat" class="list-messages">'
                                    + '</ul>'
                                    + '</div>'
                                    + '<form class="form-send-message" onsubmit="return sendMessage(event)">'
                                    + '<ul class="list-file"></ul> '
                                    + '<input type="text" id="message" class="txt-input" placeholder="Type message...">'
                                    + '<label class="btn btn-image" for="attach"><i class="fa fa-file"></i></label>'
                                    + '<input type="file" multiple id="attach">'
                                    + '<label class="btn btn-image" for="image"><i class="fa fa-file-image-o"></i></label>'
                                    + '<input type="file" accept="image/*" multiple id="image">'
                                    + '<button type="submit" class="btn btn-send">'
                                    + '<i class="fa fa-paper-plane"></i>'
                                    + '</button>'
                                    + '</form>';

                            document.getElementById("receiver").innerHTML = rightSide;

                            loadMessagesGroup();

                            displayFiles();

                            handleResponsive();
                        })
                        .catch(ex => console.log(ex));
            }

            function resetChat() {
                let chatBtn = document.querySelectorAll(".tab-control i");
                let searchTxt = document.querySelector(".list-user-search input");
                let addGroupBtn = document.querySelector(".add-group");

                searchTxt.value = "";

                chatBtn.forEach(function (ele) {
                    ele.classList.remove("active");
                });

                if (typeChat === "group") {
                    addGroupBtn.classList.add("active");
                } else {
                    addGroupBtn.classList.remove("active");
                }
            }


            function createGroup(e) {
                e.preventDefault();

                let groupName = document.querySelector(".txt-group-name").value;

                let object = new Object();
                let user = new Object();

                user.username = username;
                user.admin = true;

                object.name = groupName;
                object.users = [];
                object.users.push(user);
                toggleAllModal();

                fetch("http://" + window.location.host + "/conversations-rest-controller", {
                    method: "post",
                    cache: 'no-cache',
                    headers: {
                        'Content-Type': 'application/json;charset=utf-8'
                    },
                    body: JSON.stringify(object)
                })
                        .then(function (data) {
                            return data.json();
                        })
                        .then(function (data) {

                            if (typeChat !== "group")
                                return;

                            let numberMember = data.users.length;

                            let imgSrc = ' src="http://' + window.location.host + '/files/group-' + data.id + '/' + data.avatar + '"';
                            let appendUser = '<li id="group-' + data.id + '">'
                                    + '<div class="user-contain" data-id="' + data.id + '" data-number="' + numberMember + '" data-name="' + data.name + '" onclick="setGroup(this);">'
                                    + '<div class="user-img">'
                                    + '<img id="img-group-' + data.id + '"'
                                    + imgSrc
                                    + ' alt="Image of user">'
                                    + '</div>'
                                    + '<div class="user-info" style="flex-grow:1 ;">'
                                    + '<span class="user-name">' + data.name + '</span>'
                                    + '</div>'
                                    + '</div>'
                                    + '<div class="group-delete border" data-id="' + data.id + '" onclick="deleteGroup(this)">Delete</div>'
                                    + '</li>';
                            document.querySelector(".left-side .list-user").innerHTML += appendUser;
                            document.querySelector(".txt-group-name").value = "";
                        });
            }

            function addMember(e) {
                e.preventDefault();

                let object = new Object();
                object.name = groupName;
                object.id = groupId;
                object.users = [];


                listUserAdd.forEach(function (username) {
                    let user = new Object();

                    user.username = username;
                    user.admin = false;
                    user.avatar = null;

                    object.users.push(user);
                });


                fetch("http://" + window.location.host + "/conversations-rest-controller", {
                    method: "post",
                    cache: 'no-cache',
                    headers: {
                        'Content-Type': 'application/json;charset=utf-8'
                    },
                    body: JSON.stringify(object)
                })
                        .then(function (data) {
                            return data.json();
                        })
                        .then(function (data) {
                            numberMember += parseInt(listUserAdd.length);
                            listUserAdd = [];
                            let inviteNumber = document.querySelector(".total-invite-user");
                            if (inviteNumber)
                                inviteNumber.innerHTML = numberMember + " paticipants";

                            document.getElementById("group-" + groupId).querySelector(".user-contain").setAttribute("data-number", numberMember);

                            toggleAllModal();
                        });
            }

            function fetchUser() {

                fetch("http://" + window.location.host + "/conversations-rest-controller?usersConversationId=" + groupId)
                        .then(data => data.json())
                        .then(users => {
                            document.querySelector(".manage-member-body .list-user ul").innerHTML = "";

                            if (users.length === 1) {
                                document.querySelector(".manage-member-body .list-user ul").innerHTML = "No members in group";
                                document.querySelector(".manage-member-body .list-user ul").style = "text-align: center; font-size: 1.8rem;";
                            } else {
                                document.querySelector(".manage-member-body .list-user ul").style = "";
                            }

                            users.forEach(function (data) {
                                if (data.username === username)
                                    return;

                                let appendUser = '<li>'
                                        + '<div class="user-contain">'
                                        + '<div class="user-img">'
                                        + '<img '
                                        + ' src="http://' + window.location.host + '/files/' + data.username + '/' + data.avatar + '"'
                                        + 'alt="Image of user">'
                                        + '</div>'
                                        + '<div class="user-info" style="flex-grow: 1;">'
                                        + '<span class="user-name">' + data.username + '</span>'
                                        + '</div>';

                                if (!data.admin)
                                    appendUser += '<div class="user-delete" style="font-weight: 700;" data-username="' + data.username + '" onclick="deleteMember(this)">Delete</div>';

                                appendUser += '</div></li>';

                                document.querySelector(".manage-member-body .list-user ul").innerHTML += appendUser;
                            });

                        })
                        .catch(ex => console.log(ex));

            }

            function deleteGroup(ele) {
                let grpId = ele.getAttribute("data-id");

                if (grpId === groupId)
                    document.querySelector(".right-side").innerHTML = "";

                fetch("http://" + window.location.host + "/conversations-rest-controller?conversationId=" + grpId, {
                    method: 'delete'
                })
                        .then(function (data) {
                            return data.json();
                        })
                        .then(function (data) {

                            let groupNumber = document.getElementById("group-" + grpId);
                            if (groupNumber)
                                groupNumber.outerHTML = "";

                        })
                        .catch(ex => console.log(ex));
            }

            function deleteMember(ele) {
                let username = ele.getAttribute("data-username");

                fetch("http://" + window.location.host + "/conversations-rest-controller?conversationId=" + groupId + "&username=" + username, {
                    method: 'delete'
                })
                        .then(function (data) {
                            return data.json();
                        })
                        .then(function (data) {

                            numberMember -= 1;

                            let inviteNumber = document.querySelector(".total-invite-user");
                            if (inviteNumber)
                                inviteNumber.innerHTML = numberMember + " paticipants";

                            toggleAllModal();
                        })
                        .catch(ex => console.log(ex));

            }

            function toggleAllModal() {
                let modalBox = document.querySelectorAll(".modal-box");

                modalBox.forEach(function (modal) {
                    modal.classList.remove("active");
                });

            }

            function toggleModal(ele, mode) {
                let modalBox = document.querySelectorAll(".modal-box");
                let id = ele.getAttribute("data-id");

                modalBox.forEach(function (modal) {
                    modal.classList.remove("active");
                });


                if (mode)
                    document.getElementById(id).classList.add("active");
                else
                    document.getElementById(id).classList.remove("active");
            }

            function chatOne(ele) {
                typeChat = "user";
                resetChat();
                ele.classList.add("active");
                searchFriendByKeyword("");
                listFiles = [];
            }

            function chatGroup(ele) {
                typeChat = "group";
                resetChat();
                ele.classList.add("active");
                fetchGroup();
                listFiles = [];
            }

            function addUserChange(e) {
                if (e.checked) {
                    listUserAdd.push(e.value);
                } else {
                    let index = listUserAdd.indexOf(e.value);
                    listUserAdd.splice(index, 1);
                }

            }

            function makeFriend(rightSide) {
                fetch("http://" + window.location.host + "/friend-rest-controller?sender=" + username + "&receiver=" + receiver)
                        .then(function (data) {
                            return data.json();
                        })
                        .then(data => {
                            var status = '';
                            if (document.getElementById('status-' + receiver).classList.contains('online')) {
                                status = 'online';
                            }

                            if (data.status === false && data.owner === username && data.owner !== "any") {
                                rightSide = '<div class="user-contact">' + '<div class="back">'
                                        + '<i class="fa fa-arrow-left"></i>'
                                        + '</div>'
                                        + '<div class="user-contain">'
                                        + '<div class="user-img">'
                                        + '<img src="' + receiverAvatar + '" '
                                        + 'alt="Image of user">'
                                        + '<div class="user-img-dot ' + status + '"></div>'
                                        + '</div>'
                                        + '<div class="user-info">'
                                        + '<span class="user-name">' + receiver + '</span>'
                                        + '</div>'
                                        + '</div>'
                                        + '<span style="font-size:1.8rem">Sent Request</span>'
                                        + '</form>'
                                        + '</div>'
                                        + '<div class="list-messages-contain">'
                                        + '<ul id="chat" class="list-messages">'
                                        + '</ul>'
                                        + '</div>';

                                document.getElementById("receiver").innerHTML = rightSide;
                            } else if (data.status === false && data.owner !== username && data.owner !== "any") {
                                rightSide = '<div class="user-contact">' + '<div class="back">'
                                        + '<i class="fa fa-arrow-left"></i>'
                                        + '</div>'
                                        + '<div class="user-contain">'
                                        + '<div class="user-img">'
                                        + '<img src="' + receiverAvatar + '" '
                                        + 'alt="Image of user">'
                                        + '<div class="user-img-dot ' + status + '"></div>'
                                        + '</div>'
                                        + '<div class="user-info">'
                                        + '<span class="user-name">' + receiver + '</span>'
                                        + '</div>'
                                        + '</div>'
                                        + '<form action="http://' + window.location.host + '/chat" method="post" >'
                                        + '<input type="hidden" name="sender" value="' + username + '">'
                                        + '<input type="hidden" name="receiver" value="' + receiver + '">'
                                        + '<input type="hidden" name="status" value="true">'
                                        + '<input type="hidden" name="isAccept" value="true">'
                                        + '<input class="btn" type="submit" value="Accept Friend Request">'
                                        + '</form>'
                                        + '</div>'
                                        + '<div class="list-messages-contain">'
                                        + '<ul id="chat" class="list-messages">'
                                        + '</ul>'
                                        + '</div>';
                                document.getElementById("receiver").innerHTML = rightSide;

                            } else if (data.status === false && data.sender === "any" && data.receiver === "any") {
                                rightSide = '<div class="user-contact">' + '<div class="back">'
                                        + '<i class="fa fa-arrow-left"></i>'
                                        + '</div>'
                                        + '<div class="user-contain">'
                                        + '<div class="user-img">'
                                        + '<img src="' + receiverAvatar + '" '
                                        + 'alt="Image of user">'
                                        + '<div class="user-img-dot ' + status + '"></div>'
                                        + '</div>'
                                        + '<div class="user-info">'
                                        + '<span class="user-name">' + receiver + '</span>'
                                        + '</div>'
                                        + '</div>'
                                        + '<form action="http://' + window.location.host + '/chat" method="post" >'
                                        + '<input type="hidden" name="sender" value="' + username + '">'
                                        + '<input type="hidden" name="receiver" value="' + receiver + '">'
                                        + '<input type="hidden" name="status" value="false">'
                                        + '<input type="hidden" name="isAccept" value="false">'
                                        + '<input class="btn" type="submit" value="Add Friend">'
                                        + '</form>'
                                        + '</div>'
                                        + '<div class="list-messages-contain">'
                                        + '<ul id="chat" class="list-messages">'
                                        + '</ul>'
                                        + '</div>';
                                document.getElementById("receiver").innerHTML = rightSide;
                            }

                            handleResponsive();
                        })
                        .catch(ex => console.log(ex));
            }

            function fetchGroup() {
                fetch("http://" + window.location.host + "/conversations-rest-controller?username=" + username)
                        .then(function (data) {
                            return data.json();
                        })
                        .then(data => {

                            document.querySelector(".left-side .list-user").innerHTML = "";
                            data.forEach(function (data) {
                                let numberMember = data.users ? data.users.length : 0;

                                let findObject = data.users.find(element => element.username === username);
                                let isAdmin = findObject.admin;

                                let imgSrc = ' src="http://' + window.location.host + '/files/group-' + data.id + '/' + data.avatar + '"';
                                let appendUser = '<li id="group-' + data.id + '">'
                                        + '<div class="user-contain" data-id="' + data.id + '" data-number="' + numberMember + '" data-name="' + data.name + '" onclick="setGroup(this);">'
                                        + '<div class="user-img">'
                                        + '<img id="img-group-' + data.id + '"'
                                        + imgSrc
                                        + ' alt="Image of user">'
                                        + '</div>'
                                        + '<div class="user-info" style="flex-grow:1 ;">'
                                        + '<span class="user-name">' + data.name + '</span>'
                                        + '</div>'
                                        + '</div>';
                                if (isAdmin) {
                                    appendUser += '<div class="group-delete border" data-id="' + data.id + '" onclick="deleteGroup(this)">Delete</div>';
                                }
                                appendUser += '</li>';
                                document.querySelector(".left-side .list-user").innerHTML += appendUser;
                            });
                        }).catch(ex => {
                    console.log(ex);
                });
            }


            function handleResponsive() {
                back = document.querySelector(".back");
                rightSide = document.querySelector(".right-side");
                leftSide = document.querySelector(".left-side");

                if (back) {
                    back.addEventListener("click", function () {
                        rightSide.classList.remove("active");
                        leftSide.classList.add("active");
                        listFile = [];
                        renderFile();
                    });
                }

                rightSide.classList.add("active");
                leftSide.classList.remove("active");

            }

            function displayFiles() {
                attachFile = document.getElementById("attach");
                imageFile = document.getElementById("image");
                file = document.querySelector(".list-file");
                deleteAttach = document.querySelectorAll(".delete-attach");

                attachFile.addEventListener("change", function (e) {
                    let filesInput = e.target.files;

                    for (const file of filesInput) {
                        listFile.push(file);
                    }

                    typeFile = "file";
                    renderFile("attach");

                    this.value = null;
                });

                imageFile.addEventListener("change", function (e) {
                    let filesImage = e.target.files;

                    for (const file of filesImage) {
                        listFile.push(file);
                    }

                    typeFile = "image";

                    renderFile("image");

                    this.value = null;
                });



            }

            function deleteFile(idx) {
                if (!isNaN(idx))
                    listFile.splice(idx, 1);

                renderFile(typeFile);
            }

            function renderFile(typeFile) {
                let listFileHTML = "";
                let idx = 0;

                if (typeFile === "image") {
                    for (const file of listFile) {
                        listFileHTML += '<li><img src="' + URL.createObjectURL(file)
                                + '" alt="Image file"><span data-idx="'
                                + (idx) + '" onclick="deleteFile('
                                + idx + ')" class="delete-attach">X</span></li>';
                        idx++;
                    }
                } else {
                    for (const file of listFile) {
                        listFileHTML += '<li><div class="file-input">' + file.name
                                + '</div><span data-idx="'
                                + (idx) + '" onclick="deleteFile('
                                + idx + ')" class="delete-attach">X</span></li>';
                        idx++;
                    }
                }


                if (listFile.length === 0) {
                    file.innerHTML = "";
                    file.classList.remove("active");
                } else {
                    file.innerHTML = listFileHTML;
                    file.classList.add("active");
                }

                deleteAttach = document.querySelectorAll(".delete-attach");
            }

            function sendMessage(e) {
                e.preventDefault();

                var inputText = document.getElementById("message").value;
                if (inputText !== '') {
                    sendText();
                } else {
                    sendAttachments();
                }

                return false;
            }

            function sendText() {
                var messageContent = document.getElementById("message").value;
                var messageType = "text";
                document.getElementById("message").value = '';
                var message = buildMessageToJson(messageContent, messageType);
                setMessage(message);
                websocket.send(JSON.stringify(message));
            }

            function sendAttachments() {
                var messageType = "attachment";
                for (file of listFile) {
                    messageContent = file.name.trim();
                    messageType = file.type;
                    var message = buildMessageToJson(messageContent, messageType);
                    websocket.send(JSON.stringify(message));
                    websocket.send(file);


                    if (messageType.startsWith("audio")) {
                        message.message = '<audio controls>'
                                + '<source src="' + URL.createObjectURL(file) + '" type="' + messageType + '">'
                                + '</audio>';
                    } else if (messageType.startsWith("video")) {
                        message.message = '<video width="400" controls>'
                                + '<source src="' + URL.createObjectURL(file) + '" type="' + messageType + '">'
                                + '</video>';
                    } else if (messageType.startsWith("image")) {
                        message.message = '<img src="' + URL.createObjectURL(file) + '" alt="">';
                    } else {
                        message.message = '<a href= "' + URL.createObjectURL(file) + '">' + messageContent + '</a>';
                    }
                    setMessage(message);
                }
                file = document.querySelector(".list-file");
                file.classList.remove("active");
                file.innerHTML = "";
                listFile = [];
            }

            function buildMessageToJson(message, type) {
                return {
                    username: username,
                    message: message,
                    type: type,
                    receiver: receiver,
                    groupId: Number(groupId)
                };
            }

            function setMessage(msg) {
                console.log("online users: " + msg.onlineList);
                if (msg.message !== '[P]open' && msg.message !== '[P]close') {
                    var currentChat = document.getElementById('chat').innerHTML;
                    var newChatMsg = '';
                    if (msg.receiver !== null) {
                        newChatMsg = customLoadMessage(msg.username, msg.message);
                    } else {
                        newChatMsg = customLoadMessageGroup(msg.username, msg.groupId, msg.message, msg.avatar);
                    }
                    document.getElementById('chat').innerHTML = currentChat
                            + newChatMsg;
                    goLastestMsg();
                } else {
                    if (msg.message === '[P]open') {
                        msg.onlineList.forEach(username => {
                            try {
                                setOnline(username, true);
                            } catch (ex) {
                            }
                        });
                    } else {
                        setOnline(msg.username, false);
                    }

                }
            }

            function setOnline(username, isOnline) {
                let ele = document.getElementById('status-' + username);

                if (isOnline === true) {
                    ele.classList.add('online');
                } else {
                    ele.classList.remove('online');
                }
            }

            function loadMessagesGroup() {
                var currentChatbox = document.getElementById("chat");
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState === 4 && this.status === 200) {
                        var messages = JSON.parse(this.responseText);
                        var chatbox = "";
                        messages.forEach(msg => {
                            try {
                                chatbox += customLoadMessageGroup(msg.username, groupId, msg.message, msg.avatar);
                            } catch (ex) {

                            }
                        });
                        currentChatbox.innerHTML = chatbox;
                        goLastestMsg();
                    }
                };
                xhttp.open("GET", "http://" + window.location.host + "/conversations-rest-controller?messagesConversationId=" + groupId, true);
                xhttp.send();
            }

            function loadMessages() {
                var currentChatbox = document.getElementById("chat");
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState === 4 && this.status === 200) {
                        var messages = JSON.parse(this.responseText);
                        var chatbox = "";
                        messages.forEach(msg => {
                            try {
                                chatbox += customLoadMessage(msg.username, msg.message);
                            } catch (ex) {

                            }
                        });
                        currentChatbox.innerHTML = chatbox;
                        goLastestMsg();
                    }
                };
                xhttp.open("GET", "http://" + window.location.host + "/chat-rest-controller?sender=" + username
                        + "&receiver=" + receiver, true);
                xhttp.send();
            }

            function customLoadMessage(sender, message) {
                var imgSrc = receiverAvatar;
                var msgDisplay = '<li>'
                        + '<div class="message';
                if (receiver !== sender && username !== sender) {
                    return '';
                } else if (receiver === sender) {
                    msgDisplay += '">';
                } else {
                    imgSrc = userAvatar;
                    msgDisplay += ' right">';
                }
                return msgDisplay + '<div class="message-img">'
                        + '<img src="' + imgSrc + '" alt="">'
                        + ' </div>'
                        + '<div class="message-text">' + message + '</div>'
                        + '</div>'
                        + '</li>';
            }

            function customLoadMessageGroup(sender, groupIdFromServer, message, avatar) {
                let imgSrc = 'http://' + window.location.host + '/files/' + sender + '/' + avatar;
                var msgDisplay = '<li>'
                        + '<div class="message';
                if (groupIdFromServer !== groupId) {
                    return '';
                }
                if (username !== sender) {
                    msgDisplay += '">';
                } else {
                    imgSrc = userAvatar;
                    msgDisplay += ' right">';
                }
                return msgDisplay + '<div class="message-img">'
                        + '<img src="' + imgSrc + '" alt="">'
                        + '<div class="sender-name">' + sender + '</div>'
                        + ' </div>'
                        + '<div class="message-text">' + message + '</div>'
                        + '</div>'
                        + '</li>';
            }

            function searchFriendByKeyword(keyword) {
                fetch("http://" + window.location.host + "/users-rest-controller?username=" + username + "&keyword=" + keyword)
                        .then(function (data) {
                            return data.json();
                        })
                        .then(data => {

                            document.querySelector(".left-side .list-user").innerHTML = "";
                            data.forEach(function (data) {
                                if (data.online)
                                    status = "online";
                                else
                                    status = "";

                                let appendUser = '<li id="' + data.username + '" onclick="setReceiver(this);">'
                                        + '<div class="user-contain">'
                                        + '<div class="user-img">'
                                        + '<img id="img-' + data.username + '"'
                                        + ' src="http://' + window.location.host + '/files/' + data.username + '/' + data.avatar + '"'
                                        + 'alt="Image of user">'
                                        + '<div id="status-' + data.username + '" class="user-img-dot ' + status + '"></div>'
                                        + '</div>'
                                        + '<div class="user-info">'
                                        + '<span class="user-name">' + data.username + '</span>'
                                        + '</div>'
                                        + '</div>'
                                        + '</li>';
                                document.querySelector(".left-side .list-user").innerHTML += appendUser;
                            });
                        });
            }

            function searchMemberByKeyword(ele) {
                let keyword = ele.value;
                fetch("http://" + window.location.host + "/users-rest-controller?username=" + username + "&keyword=" + keyword + "&conversationId=" + groupId)
                        .then(function (data) {
                            return data.json();
                        })
                        .then(data => {

                            document.querySelector(".add-member-body .list-user ul").innerHTML = "";
                            data.forEach(function (data) {
                                if (data.online)
                                    status = "online";
                                else
                                    status = "";

                                let check = "";
                                if (listUserAdd.indexOf(data.username) >= 0)
                                    check = "checked";

                                let appendUser = '<li>'
                                        + '<input id="member-' + data.username + '" type="checkbox" ' + check + ' value="' + data.username + '" onchange="addUserChange(this)">'
                                        + '<label for="member-' + data.username + '">'
                                        + '<div class="user-contain">'
                                        + '<div class="user-img">'
                                        + '<img '
                                        + ' src="http://' + window.location.host + '/files/' + data.username + '/' + data.avatar + '"'
                                        + 'alt="Image of user">'
                                        + '</div>'
                                        + '<div class="user-info">'
                                        + '<span class="user-name">' + data.username + '</span>'
                                        + '</div>'
                                        + '</div>'
                                        + '</label>'
                                        + '<div class="user-select-dot"></div>'
                                        + '</li>';
                                document.querySelector(".add-member-body .list-user ul").innerHTML += appendUser;
                            });
                        });
            }

            function searchGroupByKeyword(value) {
                let keyword = value;
                fetch("http://" + window.location.host + "/conversations-rest-controller?username=" + username + "&conversationKeyword=" + keyword)
                        .then(function (data) {
                            return data.json();
                        })
                        .then(data => {

                            document.querySelector(".left-side .list-user").innerHTML = "";
                            data.forEach(function (data) {

                                let numberMember = data.users ? data.users.length : 0;
                                let findObject = data.users.find(element => element.username === username);
                                let isAdmin = false;

                                if (findObject)
                                    isAdmin = findObject.admin;

                                let imgSrc = ' src="http://' + window.location.host + '/files/group-' + data.id + '/' + data.avatar + '"';

                                let appendUser = '<li id="group-' + data.id + '">'
                                        + '<div class="user-contain" data-id="' + data.id + '" data-number="' + numberMember + '" data-name="' + data.name + '" onclick="setGroup(this);">'
                                        + '<div class="user-img">'
                                        + '<img id="img-group-' + data.id + '"'
                                        + imgSrc
                                        + ' alt="Image of user">'
                                        + '</div>'
                                        + '<div class="user-info" style="flex-grow:1 ;">'
                                        + '<span class="user-name">' + data.name + '</span>'
                                        + '</div>'
                                        + '</div>';
                                if (isAdmin)
                                    appendUser += '<div class="group-delete border" data-id="' + data.id + '" onclick="deleteGroup(this)">Delete</div>';

                                appendUser += '</li>';
                                document.querySelector(".left-side .list-user").innerHTML += appendUser;
                            });
                        });
            }

            function searchUser(ele) {
                if (typeChat === "user") {
                    searchFriendByKeyword(ele.value);
                } else {
                    if (ele.value === "") {
                        fetchGroup();
                    } else {
                        searchGroupByKeyword(ele.value);
                    }
                }
            }

            function goLastestMsg() {
                var msgLiTags = document.querySelectorAll(".message");
                var last = msgLiTags[msgLiTags.length - 1];
                try {
                    last.scrollIntoView();
                } catch (ex) {
                }
            }
        </script>
    </body>

</html>

