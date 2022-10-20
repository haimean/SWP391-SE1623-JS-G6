/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.Impl.UserInformationDaoImpl;
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
public class ProfileUserUpdate extends HttpServlet {

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
        int id = Integer.parseInt(request.getParameter("id"));
        UserInformationDaoImpl userInformationDaoImpl = new UserInformationDaoImpl();
        UserInformation userinf = userInformationDaoImpl.get(id);
        request.setAttribute("userinf", userinf);
        request.getRequestDispatcher("/store/profile/ProfileUpdate.jsp").forward(request, response);

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
        UserInformationDaoImpl userInformationDaoImpl = new UserInformationDaoImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        String fullname = request.getParameter("fullname").trim();
        String gender = request.getParameter("gender");
        String bio = request.getParameter("bio").trim();
        String address = request.getParameter("address").trim();
        String city = request.getParameter("city").trim();
        boolean status = userInformationDaoImpl.updateProfile(id, fullname, gender, bio, address, city);
        UserInformation userInf = userInformationDaoImpl.get(id);
        request.setAttribute("status", status);
        request.setAttribute("userinf", userInf);
        request.getRequestDispatcher("/store/profile/Profile.jsp").forward(request, response);
    }

}