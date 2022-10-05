/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ControllerSeller;

import DAO.DAOProduct;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author ngolu
 */
public class SellerProductCreate extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Productlist_insertProduct</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Productlist_insertProduct at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    /*
     * Handles the HTTP <code>GET</code> meth
     *
     * @param request servlet request
     * 
     * @param response servlet response
     * 
     * @throws ServletException if a servlet-specific error occurs
     * 
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("productAdd.jsp").forward(request, response);
    }

    **

    @param request servlet request*
    @param response servlet response*@throws ServletException if
    a servlet-specific error occurs*@throws IOException if
    an I/O error occurs*/

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        String origin = request.getParameter("origin");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));
        int viewNumber = Integer.parseInt(request.getParameter("viewnumber"));
        String create = request.getParameter("create");
        String update = request.getParameter("update");
        String description = request.getParameter("description");
        DAOProduct dao = new DAOProduct();
        dao.insertProduct(categoryId, name, description, origin, quantity, price, true, viewNumber, create, update);
        response.sendRedirect(request.getContextPath() + "/seller/product");
    }

}