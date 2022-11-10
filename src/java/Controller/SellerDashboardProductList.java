/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.Impl.SellerProductDaoimpl;
import Model.Product;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author ngolu
 */
public class SellerDashboardProductList extends HttpServlet {

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
        SellerProductDaoimpl dao = new SellerProductDaoimpl();
        List<Product> products;
        String search = request.getParameter("txt");
        String indexpasge = request.getParameter("page");
        if (indexpasge == null) {
            indexpasge = "1";
            int page = Integer.parseInt(indexpasge);
            if (search != null) {
                products = dao.searchByName(search.trim());
                request.setAttribute("search", search);
                request.setAttribute("products", products);
                request.getRequestDispatcher("/seller/DashboardListProduct.jsp").forward(request, response);
            }
            int count = dao.getTotalProduct();
            int endpage = count / 5;
            if (count % 5 != 0) {
                endpage++;
            }
            products = dao.getProduct(page);
            request.setAttribute("endpage", endpage);
            request.setAttribute("products", products);
            request.getRequestDispatcher("/seller/DashboardListProduct.jsp").forward(request, response);
        } else {
            int page = Integer.parseInt(indexpasge);
            if (search != null) {
                products = dao.searchByName(search.trim());
                request.setAttribute("search", search);
                request.setAttribute("products", products);
                request.getRequestDispatcher("/seller/DashboardListProduct.jsp").forward(request, response);
            }
            int count = dao.getTotalProduct();
            int endpage = count / 5;
            if (count % 5 != 0) {
                endpage++;
            }
            products = dao.getProduct(page);
            request.setAttribute("page", page);
            request.setAttribute("search", search);
            request.setAttribute("endpage", endpage);
            request.setAttribute("products", products);
            request.getRequestDispatcher("/seller/DashboardListProduct.jsp").forward(request, response);
        }
    }

}
