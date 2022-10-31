/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.Impl.UserDaoImpl;
import Dao.Impl.UserInformationDaoImpl;
import Model.User;
import Model.UserInformation;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author MrTuan
 */
public class ProfileUserChangePassword extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        if (user == null) {
            response.sendRedirect(request.getContextPath());
        } else {
            UserInformationDaoImpl userInformationDaoImpl = new UserInformationDaoImpl();
            UserInformation userinf = userInformationDaoImpl.get(user.getId());
            request.setAttribute("userinf", userinf);
            request.getRequestDispatcher("/user/profile/ProfileChangePassword.jsp").forward(request, response);
        }
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
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        String email = request.getParameter("email");
        String oldpass = request.getParameter("oldpass");
        String newpass = request.getParameter("newpass");
        String confirmnewpass = request.getParameter("confirmnewpass");
        if (userDaoImpl.login(email, oldpass) != null) {
            if (newpass.equals(confirmnewpass)) {
                boolean status = userDaoImpl.updatePassword(email, newpass);
                request.setAttribute("status", status);
                if (user == null) {
                    response.sendRedirect(request.getContextPath());
                } else {
                    UserInformationDaoImpl userInformationDaoImpl = new UserInformationDaoImpl();
                    UserInformation userinf = userInformationDaoImpl.get(user.getId());
                    request.setAttribute("userinf", userinf);
                    request.getRequestDispatcher("/user/profile/Profile.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("status", "New password different Confirm New Password!");
                if (user == null) {
                    response.sendRedirect(request.getContextPath());
                } else {
                    UserInformationDaoImpl userInformationDaoImpl = new UserInformationDaoImpl();
                    UserInformation userinf = userInformationDaoImpl.get(user.getId());
                    request.setAttribute("userinf", userinf);
                    request.getRequestDispatcher("/user/profile/ProfileChangePassword.jsp").forward(request, response);
                }
            }
        }
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
