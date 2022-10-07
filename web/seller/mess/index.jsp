<%@include file="../layout/index.jsp"  %>


<link rel="stylesheet" href="https://rsms.me/inter/inter.css">
<div style="
     display: flex;
     padding: 30px 20px;
     height: 83vh;
     background-color: #FFE69C;
     flex-direction: column;
     float: left;
     ">
    <%
    ArrayList<Message> messages = (ArrayList<Message>)  request.getAttribute("messages");              
 if (messages != null) {
            String userName;
            int userId;
            for (Message m : messages) {
                if (user.getId() == m.getUserReceiverId()) {
                    userName = new DAOUser().getUserName(m.getUserSenderId());
                    userId = m.getUserSenderId();
                } else {
                    userName = new DAOUser().getUserName(m.getUserReceiverId());
                    userId = m.getUserReceiverId();
                }
    %>
    <div class="mb-3" style="
         display: flex;
         flex-direction: row;
         align-items: center;
         ">
        <img  src="https://tse2.mm.bing.net/th?id=OIP.xHGWUXjqRhEXJd1ObAlkWAHaH1&pid=Api&P=0" width="40px" height="40px" class="rounded float-start " alt="...">
        <div class="d-none d-lg-block" style="margin-left: 1rem;
             white-space: nowrap;
             overflow: hidden;
             text-overflow: ellipsis;
             ">
            <a style="margin-bottom: 0;    white-space: nowrap;
               overflow: hidden;
               text-overflow: ellipsis;" href="<%= request.getContextPath()%>/seller/message?id=<%=userId%>"><%=userName%></a>
            <p style="margin-bottom: 0;    white-space: nowrap;
               overflow: hidden;
               text-overflow: ellipsis;     max-width: 160px;"><small class="text-muted"><%=m.getContent()%></small></p>
        </div>
    </div>
    <%}}%>    
</div>   

<div style="
     display: flex;
     flex-direction: column;
     justify-content: space-between;
     height: 83vh;
     ">
    <div style="    display: flex;
         align-items: center;
         justify-content: flex-start;
         background-color: #FFF3CD;">       
        <img src="https://tse2.mm.bing.net/th?id=OIP.xHGWUXjqRhEXJd1ObAlkWAHaH1&pid=Api&P=0" width="60px" height="60px" class="rounded-circle float-start m-2" alt="...">
        <h4>Nguoi dung</h4>
    </div>
    <div class="m-2">
        <div>tin n    ${messagesUser}
            han</div>
        <div class="mt-2" >  
            <form action="<%= request.getContextPath()%>/seller/message"  method="post"  class="d-flex" >
                <input name="txt" class="form-control me-2" type="text" placeholder="Message" aria-label="Search">
                <button class="btn  bg-warning" type="submit">Seen</button>
            </form>
        </div>
    </div>

</div>