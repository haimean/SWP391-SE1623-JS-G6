/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.Impl.ProductDaoImpl;
import Model.Product;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author PiPi
 */
public class StoreProductDetail extends HttpServlet {

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
        doPost(request, response);
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
        //        int id = Integer.parseInt(request.getParameter("id"));
//        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        ProductDaoImpl db = new ProductDaoImpl();
//        Product product = db.get(id);
        Product product = db.get(5);
//        ArrayList<Product> list = db.getTop7Products(id, categoryId);
        List<Product> list = db.getTop7Products(5, 5);
        request.setAttribute("p", product);
        request.setAttribute("list", list);
        request.setAttribute("sizeL", list.size());
        request.getRequestDispatcher("/store/product-detail/productDetail.jsp").forward(request, response);
    }

}
