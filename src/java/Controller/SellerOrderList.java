/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.Impl.OrderDaoimpl;
import Model.Order;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author ngolu
 */
public class SellerOrderList extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SellerOrderList</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SellerOrderList at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        OrderDaoimpl dao = new OrderDaoimpl();
        List<Order> listO = dao.getOrder();
        String search = request.getParameter("txtFullName");
        String indexpasge = request.getParameter("page");
        if (indexpasge == null) {
            indexpasge = "1";
            int page = Integer.parseInt(indexpasge);
            if (search != null) {
                List<Order> orders = dao.searchByFullName(search.trim());
                request.setAttribute("search", search);
                request.setAttribute("listO", orders);
                request.getRequestDispatcher("/seller/order/orderlist.jsp").forward(request, response);
            } else {
                List<Order> orders = dao.getOrder(page);
            }
            int count = dao.getTotalOrder();
            int endpage = count / 5;
            if (count % 5 != 0) {
                endpage++;
            }
            List<Order> orders = dao.getOrder(page);
            request.setAttribute("endpage", endpage);
            request.setAttribute("listO", orders);
            request.getRequestDispatcher("/seller/order/orderlist.jsp").forward(request, response);
        } else {
            int page = Integer.parseInt(indexpasge);
            if (search != null) {
                List<Order> orders = dao.searchByFullName(search.trim());
                request.setAttribute("search", search);
                request.setAttribute("listO", orders);
                request.getRequestDispatcher("/seller/order/orderlist.jsp").forward(request, response);
            } else {
                List<Order> orders = dao.getOrder(page);
            }
            int count = dao.getTotalOrder();
            int endpage = count / 5;
            if (count % 5 != 0) {
                endpage++;
            }
            List<Order> orders = dao.getOrder(page);
            request.setAttribute("page", page);
            request.setAttribute("endpage", endpage);
            request.setAttribute("listO", orders);
            request.getRequestDispatcher("/seller/order/orderlist.jsp").forward(request, response);
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
