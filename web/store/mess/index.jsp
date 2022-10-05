<%@include file="../layout/index.jsp"  %>
<link rel="stylesheet" href="https://rsms.me/inter/inter.css">
<div style="
     display: flex;
     padding: 30px 20px;
     height: 83vh;
     flex-direction: column;
     background-color: #fff4e9;
     float: left;
     ">
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
    <div class="mb-3" style="
         display: flex;
         flex-direction: row;
         align-items: center;
         ">
        <a style="margin-bottom: 0;    white-space: nowrap;
           overflow: hidden;
           text-overflow: ellipsis;" href="<%= request.getContextPath()%>/message?id=<%=userReceiver.getId()%>">
            <img  src="https://tse2.mm.bing.net/th?id=OIP.xHGWUXjqRhEXJd1ObAlkWAHaH1&pid=Api&P=0" width="40px" height="40px" class="rounded float-start " alt="...">
        </a>
        <div class="d-none d-lg-block" style="margin-left: 1rem;
             white-space: nowrap;
             overflow: hidden;
             text-overflow: ellipsis;
             ">
            <a style="margin-bottom: 0;    white-space: nowrap;
               overflow: hidden;
               text-overflow: ellipsis;" href="<%= request.getContextPath()%>/message?id=<%=userReceiver.getId()%>">
                <%=userReceiver.getFullName()%>
            </a>
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
    <div style="
         display: flex;
         align-items: center;
         background-color: #fdffd6;
         justify-content: flex-start;">       
        <img src="https://tse2.mm.bing.net/th?id=OIP.xHGWUXjqRhEXJd1ObAlkWAHaH1&pid=Api&P=0" width="60px" height="60px" class="rounded-circle float-start m-2" alt="...">
        <h4>  
            ${userNameReceiver}
        </h4>
    </div>
    <div class="m-2">
        <div>
            <% 
            for (Message m : messagesUser) {
            if (user.getId() != m.getUserReceiverId()) {
            %>
            <div style="display: flex; justify-content: flex-end; align-items: center;">
                <h5 style="margin: auto 0"><span class="badge bg-secondary">  <%=m.getContent()%></span></h5>
                <img src="https://tse2.mm.bing.net/th?id=OIP.xHGWUXjqRhEXJd1ObAlkWAHaH1&pid=Api&P=0" width="24px" height="24px" class="rounded-circle float-start m-2" alt="...">
            </div>
            <%
            } else {
            %>
            <div style="display: flex; justify-content: flex-start; align-items: center;">
                <img src="https://tse2.mm.bing.net/th?id=OIP.xHGWUXjqRhEXJd1ObAlkWAHaH1&pid=Api&P=0" width="24px" height="24px" class="rounded-circle float-start m-2" alt="...">
                <h5 style="margin: auto 0"><span class="badge bg-secondary">  <%=m.getContent()%></span></h5>
            </div>
            <%
            }}%>
        </div>
        <div class="mt-2" >  
            <form action="<%= request.getContextPath()%>/message"  method="POST"  class="d-flex" >
                <input type="hidden" name="id" value="${userIdReceiver}">
                <input name="mess" class="form-control me-2" type="text" placeholder="Message" >
                <button class="btn  bg-warning" type="submit">Seen</button>
            </form>
        </div>
    </div>

</div>