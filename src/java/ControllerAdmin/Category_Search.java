/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ControllerAdmin;

<<<<<<< HEAD
import Dal.DAOCategory;
import java.io.IOException;
=======
import Dal.DAOUser;
import java.io.IOException;
import java.io.PrintWriter;
>>>>>>> ad91098 (update code project)
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
<<<<<<< HEAD
import java.util.ArrayList;
import Model.Category;

/**
 *
 * @author Mr Tuan
 */
public class Category_Search extends HttpServlet {
=======

/**
 *
 * @author PiPi
 */
<<<<<<<< HEAD:src/java/ControllerAdmin/DeleteUser.java
public class DeleteUser extends HttpServlet {
========
public class Category_Search extends HttpServlet {
>>>>>>>> f089ca3 (update code project):src/java/ControllerAdmin/Category_Search.java
>>>>>>> ad91098 (update code project)

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
<<<<<<< HEAD
//search
        DAOCategory db=new DAOCategory();
        String txtname=request.getParameter("txt");
        ArrayList<Category> listCategory=db.SearchName(txtname);
        request.setAttribute("category", listCategory);
        request.getRequestDispatcher("admin\\category\\index.jsp").forward(request, response);
        
=======
        response.setContentType("text/html;charset=UTF-8");

>>>>>>> ad91098 (update code project)
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
<<<<<<< HEAD
        processRequest(request, response);
=======
        DAOUser dao = new DAOUser();
        String id = request.getParameter("id");
        dao.deleteUser(id);
        response.sendRedirect(request.getContextPath() + "/user-list");
>>>>>>> ad91098 (update code project)
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
        processRequest(request, response);
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
