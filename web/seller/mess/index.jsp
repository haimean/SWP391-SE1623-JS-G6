<%@include file="../layout/index.jsp"  %>
<body>
    <div class="container-fluid h-100">
        <div class="row justify-content-center h-100">
            <div class="col-md-4 col-xl-3 chat">
                <div class="card mb-sm-3 mb-md-0 contacts_card">
                    <div class="card-header">
                        <form
                            action="<%= request.getContextPath()%>/seller/message"
                            method="get"
                            class="d-flex"
                            >
                            <input type="hidden" name="id" value="${userIdReceiver}" />
                            <input
                                name="mess"
                                class="form-control me-2"
                                type="text"
                                placeholder="Name"
                                />
                            <button class="btn bg-info ml-3" type="submit">Search</button>
                        </form>
                    </div>
                    <div class="card-body contacts_body">
                        <ui class="contacts">
                            <!-- list -->
                            <%
  ArrayList<Message> messages = (ArrayList<Message>)  request.getAttribute("messages");   
  ArrayList<Message> messagesUser = (ArrayList<Message>)  request.getAttribute("messagesUser");  
  if (messages != null) {
      String userName;
      User userReceiver;
      for (Message m : messages) {
          if (user.getId() == m.getUserReceiverId()) {
              userReceiver = (User) new DAOUser().getUser(m.getUserSenderId());
          } else {
              userReceiver = (User) new DAOUser().getUser(m.getUserReceiverId());
          }
                            %>
                            <li>
                                <div class="d-flex bd-highlight">
                                    <div class="img_cont">
                                        <a href="<%= request.getContextPath()%>/seller/message?id=<%=userReceiver.getId()%>">
                                            <img 
                                                src="https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg"
                                                class="rounded-circle user_img"
                                                />
                                        </a>
                                    </div>
                                    <div class="user_info">
                                        <a href="<%= request.getContextPath()%>/seller/message?id=<%=userReceiver.getId()%>">
                                            <span>  <%=userReceiver.getFullName()%></span>
                                        </a>
                                        <p>Ban: <%=m.getContent()%></p>
                                    </div>
                                </div>
                            </li>
                            <%}}%>
                        </ui>
                    </div>
                </div>
            </div>
            <div class="col-md-8 col-xl-6 chat">
                <div class="card">
                    <div class="card-header msg_head">
                        <div class="d-flex bd-highlight">
                            <div class="img_cont">
                                <img
                                    src="https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg"
                                    class="rounded-circle user_img"
                                    />
                            </div>
                            <div class="user_info">
                                <span> ${userNameReceiver}</span>
                            </div>
                        </div>
                    </div>
                    <div class="card-body msg_card_body">
                        <% 
           for (Message m : messagesUser) {
           if (user.getId() != m.getUserReceiverId()) {
                        %>
                        <div class="d-flex justify-content-end mb-4">
                            <div class="msg_cotainer_send">
                                <%=m.getContent()%>
                            </div>
                            <div class="img_cont_msg">
                                <img src="https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg" class="rounded-circle user_img_msg" />
                            </div>
                        </div>
                        <%
                        } else {
                        %>
                        <div class="d-flex justify-content-start mb-4">
                            <div class="img_cont_msg">
                                <img
                                    src="https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg"
                                    class="rounded-circle user_img_msg"
                                    />
                            </div>
                            <div class="msg_cotainer">
                                <%=m.getContent()%>
                            </div>
                        </div>
                        <%}}%>
                    </div>
                    <div class="card-footer">
                        <form
                            action="<%= request.getContextPath()%>/message"
                            method="POST"
                            class="d-flex"
                            >
                            <input type="hidden" name="id" value="${userIdReceiver}" />
                            <input
                                name="mess"
                                class="form-control me-2"
                                type="text"
                                placeholder="Message"
                                />
                            <button class="btn bg-info ml-3" type="submit">Seen</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

<style>

    body,html{
        height: 100%;
        margin: 0;
    }
    .chat{
        margin-top: auto;
        margin-bottom: auto;
    }
    .card{
        height: 500px;
        border-radius: 15px !important;
        background-color: rgba(0,0,0,0.4) !important;
    }
    .contacts_body{
        padding:  0.75rem 0 !important;
        overflow-y: auto;
        white-space: nowrap;
    }
    .msg_card_body{
        overflow-y: auto;
    }
    .card-header{
        border-radius: 15px 15px 0 0 !important;
        border-bottom: 0 !important;
    }
    .container{
        align-content: center;
    }
    .search{
        border-radius: 15px 0 0 15px !important;
        background-color: rgba(0,0,0,0.3) !important;
        border:0 !important;
        color:white !important;
    }
    .search:focus{
        box-shadow:none !important;
        outline:0px !important;
    }
    .contacts{
        list-style: none;
        padding: 0;
    }
    .contacts li{
        width: 100% !important;
        padding: 5px 10px;
        margin-bottom: 15px !important;
    }
    .user_img{
        height: 70px;
        width: 70px;
        border:1.5px solid #f5f6fa;
    }
    .user_img_msg{
        height: 40px;
        width: 40px;
        border:1.5px solid #f5f6fa;

    }

    .img_cont_msg{
        height: 40px;
        width: 40px;
    }
    .user_info{
        margin-top: auto;
        margin-bottom: auto;
        margin-left: 15px;
    }
    .user_info span{
        font-size: 20px;
        color: white;
    }
    .user_info p{
        font-size: 10px;
        color: rgba(255,255,255,0.6);
    }
    .msg_cotainer{
        margin-top: auto;
        margin-bottom: auto;
        margin-left: 10px;
        border-radius: 25px;
        background-color: #82ccdd;
        padding: 10px;
        position: relative;
    }
    .msg_cotainer_send{
        margin-top: auto;
        margin-bottom: auto;
        margin-right: 10px;
        border-radius: 25px;
        background-color: #78e08f;
        padding: 10px;
        position: relative;
    }
    .msg_head{
        position: relative;
    }
    @media(max-width: 576px){
        .contacts_card{
            margin-bottom: 15px !important;
        }
    }
</style>