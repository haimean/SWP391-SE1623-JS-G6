/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ControllerSeller;

import Dal.DAOMessage;
import Model.Message;
import model.User;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author haimi
 */
public class SellerMess extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        int userPnId = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id"))
                : 0;
        ArrayList<Message> messages = new DAOMessage().getMessageList(user.getId());
        if (userPnId <= 0) {
            if (user.getId() == messages.get(0).getUserReceiverId()) {
                userPnId = messages.get(0).getUserSenderId();
            } else {
                userPnId = messages.get(0).getUserReceiverId();
            }
        }
        ArrayList<Message> messagesUser = new DAOMessage().getMessage(user.getId(), userPnId);
        request.setAttribute("messages", messages);
        request.setAttribute("messagesUser", messagesUser);

        request.getRequestDispatcher("/seller/mess/index.jsp").forward(request, response);
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
        request.getRequestDispatcher("/seller/mess/index.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
