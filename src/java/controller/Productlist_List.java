/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

<<<<<<< HEAD
<<<<<<<< HEAD:src/java/controller/Productlist_List.java
import dal.ProductDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import model.Product;
========
import DAO.DAOUser;
import Model.User;
import java.io.IOException;
=======
import DAO.ProductDBContext;
import java.io.IOException;
import java.io.PrintWriter;
>>>>>>> dev
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
<<<<<<< HEAD
import java.util.ArrayList;
>>>>>>>> dev:src/java/ControllerAdmin/UserList.java
=======
import java.util.List;
import Model.Product;
>>>>>>> dev

/**
 *
 * @author MrTuan
 */
public class Productlist_List extends HttpServlet {

<<<<<<< HEAD
<<<<<<<< HEAD:src/java/controller/Productlist_List.java
=======
>>>>>>> dev
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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            ProductDBContext db = new ProductDBContext();
            List<Product> listP = db.getProduct();
            request.setAttribute("listP", listP);
            request.getRequestDispatcher("productList.jsp").forward(request, response);
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
<<<<<<< HEAD
========
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOUser daoUser = new DAOUser();
        ArrayList<User> list = daoUser.getAllUsers();
        request.setAttribute("listU", list);
        request.getRequestDispatcher("/BlogShop/admin/user/index.jsp").forward(request, response);
>>>>>>>> dev:src/java/ControllerAdmin/UserList.java
    }
=======
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

>>>>>>> dev
}
