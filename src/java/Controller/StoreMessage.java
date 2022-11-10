/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.Impl.MessageDaoImpl;
import Model.Message;
import Model.User;
import Dao.Impl.UserDaoImpl;
import Dao.Impl.UserInformationDaoImpl;
import Dao.MessageDao;
import Dao.UserInformationDao;
import Model.UserInformation;
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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        UserInformation userReceiver = new UserInformation();
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        MessageDao messageDao = new MessageDaoImpl();
        UserInformationDao userInformationDao = new UserInformationDaoImpl();
        List<Message> messagesUser = new ArrayList<>();
        List<Message> messages = new ArrayList<>();
        String avatar = userInformationDao.get(user.getId()) != null
                ? userInformationDao.get(user.getId()).getImage() : "";
        String search = request.getParameter("search");
        if (search != null && search.matches(".*\\w.*")) {
            messages = messageDao.getAll(user.getId(), search);
        } else {
            messages = messageDao.getAll(user.getId());
        }
        int userPnId = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0;
        if (userPnId != 0) {
            messagesUser = new MessageDaoImpl().get(user.getId(), userPnId);
            userReceiver = userInformationDao.get(userPnId);
        }
        request.setAttribute("messagesUser", messagesUser);
        request.setAttribute("uReceiver", userReceiver);
        request.setAttribute("messages", messages);
        request.setAttribute("avatar", avatar);
        request.getRequestDispatcher("/store/mess/index.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        MessageDao messageDao = new MessageDaoImpl();
        UserInformationDao userInformationDao = new UserInformationDaoImpl();
        String avatar = userInformationDao.get(user.getId()) != null
                ? userInformationDao.get(user.getId()).getImage() : "";
        UserInformation userReceiver;
        int userIdReceiver = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0;
        String message = request.getParameter("mess").trim();
        if (userIdReceiver != 0 && message != null && message.matches(".*\\w.*")) {
            messageDao.insert(new Message(user.getId(), userIdReceiver, message));
        }
        List<Message> messages = new MessageDaoImpl().getAll(user.getId());
        List<Message> messagesUser = new MessageDaoImpl().get(user.getId(), userIdReceiver);
        userReceiver = userInformationDao.get(userIdReceiver);
        request.setAttribute("messages", messages);
        request.setAttribute("messagesUser", messagesUser);
        request.setAttribute("avatar", avatar);
        request.setAttribute("uReceiver", userReceiver);
        request.getRequestDispatcher("/store/mess/index.jsp").forward(request, response);
    }

}
