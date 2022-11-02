/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.Impl.MessageDaoImpl;
import Model.Message;
import Model.User;
import Dao.Impl.UserDaoImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haimi
 */
public class StoreMessage extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        User userReceiver;
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        String search = request.getParameter("search");
        List<Message> messages = new ArrayList<Message>();
        if (search != null) {
            messages = new MessageDaoImpl().getAll(user.getId(), search);
        } else {
            messages = new MessageDaoImpl().getAll(user.getId());
        }
        int userPnId = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0;
        if (userPnId == 0) {
            if (user.getId() == messages.get(0).getUserReceiverId()) {
                userPnId = messages.get(0).getUserSenderId();
            } else {
                userPnId = messages.get(0).getUserReceiverId();
            }
        }
        ArrayList<Message> messagesUser = new MessageDaoImpl().get(user.getId(), userPnId);
        if (user.getId() == messagesUser.get(0).getUserReceiverId()) {
            userReceiver = new UserDaoImpl().get(messagesUser.get(0).getUserSenderId());
        } else {
            userReceiver = new UserDaoImpl().get(messagesUser.get(0).getUserReceiverId());
        }
        request.setAttribute("messages", messages);
        request.setAttribute("messagesUser", messagesUser);
        request.setAttribute("userNameReceiver", userReceiver.getFullName());
        request.setAttribute("userIdReceiver", userReceiver.getId());
        request.getRequestDispatcher("/store/mess/index.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        User userReceiver;
        int userIdReceiver = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0;
        String message = request.getParameter("mess").trim();
        if (userIdReceiver != 0 && message != null) {
            new MessageDaoImpl().insert(new Message(user.getId(), userIdReceiver, message));
        }
        List<Message> messages = new MessageDaoImpl().getAll(user.getId());
        List<Message> messagesUser = new MessageDaoImpl().get(user.getId(), userIdReceiver);
        if (user.getId() == messagesUser.get(0).getUserReceiverId()) {
            userReceiver = new UserDaoImpl().get(messagesUser.get(0).getUserSenderId());
        } else {
            userReceiver = new UserDaoImpl().get(messagesUser.get(0).getUserReceiverId());
        }
        request.setAttribute("messages", messages);
        request.setAttribute("messagesUser", messagesUser);
        request.setAttribute("userNameReceiver", userReceiver.getFullName());
        request.setAttribute("userIdReceiver", userReceiver.getId());
        request.getRequestDispatcher("/store/mess/index.jsp").forward(request, response);
    }

}
