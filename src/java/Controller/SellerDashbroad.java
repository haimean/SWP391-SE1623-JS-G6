/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.Impl.OrderDaoimpl;
import Dao.Impl.SellerProductDaoimpl;
import Model.Order;
import Model.Product;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author haimi
 */
public class SellerDashbroad extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> listp = new SellerProductDaoimpl().getProduct();
        List<Order>  listo = new OrderDaoimpl().getOrder();
        
        request.setAttribute("productCount", listp.size());
        request.setAttribute("orderCount", listo.size());
        request.getRequestDispatcher("/seller/Dashboard.jsp").forward(request, response);
    }
}
