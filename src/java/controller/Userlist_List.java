/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.UserlistDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author MrTuan
 */
enum Mode {
    SEARCH,
    BAN,
    ROLE
}

public class Userlist_List extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String modeParam = request.getParameter("mode");
        UserlistDBContext db = new UserlistDBContext();
        ArrayList<User> list;
        if (modeParam == null) {
            list = db.getAllUsers();
            request.setAttribute("listU", list);
            request.getRequestDispatcher("/admin/user/index.jsp").forward(request, response);
        }
        if (modeParam.equals(Mode.BAN.toString())) {
            String idParam = request.getParameter("id");
            String statusParam = request.getParameter("status");
            int id = Integer.parseInt(idParam);
            boolean status = Boolean.parseBoolean(statusParam);
            db.updateUserStatusByID(id, !status);
            list = db.getAllUsers();
            request.setAttribute("listU", list);
            request.getRequestDispatcher("/admin/user/index.jsp").forward(request, response);
        }

    }

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
        processRequest(request, response);
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
        ArrayList<User> list;
        UserlistDBContext db = new UserlistDBContext();
        String modeParam = request.getParameter("mode");

        if (modeParam.equals(Mode.ROLE.toString())) { 
            String idParam = request.getParameter("id");
            String roleParam = request.getParameter("role");
            int id = Integer.parseInt(idParam);
            int role = Integer.parseInt(roleParam);
            db.updateUserRoleByID(id, role);
            list = db.getAllUsers();
            request.setAttribute("listU", list);
            request.getRequestDispatcher("/admin/user/index.jsp").forward(request, response);
        }
        if ((modeParam.equals(Mode.SEARCH.toString()))) {
            String searchValue = request.getParameter("search").trim();
            list = db.searchUser(searchValue);
            request.setAttribute("listU", list);
            request.setAttribute("value", searchValue);
            request.getRequestDispatcher("/admin/user/index.jsp").forward(request, response);
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
