/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.Impl.ProductDaoImpl;
import Model.Product;
import Model.User;
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
public class StoreFavoriteProduct extends HttpServlet {

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
        ProductDaoImpl db = new ProductDaoImpl();
        List<Product> listProducts;
        if (user != null) {
            listProducts = db.getFavoriteProducts(user.getId());
            request.setAttribute("list", listProducts);
            request.setAttribute("size", listProducts.size());
        }
        request.getRequestDispatcher("store/favorite-product/favoriteProduct.jsp").forward(request, response);
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
        ProductDaoImpl db = new ProductDaoImpl();
        List<Product> listProducts;

        String mode = request.getParameter("mode");
        if (user != null) {
            if (mode.equals("SINGAL_DELETE")) {
                int id = Integer.parseInt(request.getParameter("id"));
                db.removeFavoriteProducts(user.getId(), id);
                listProducts = db.getFavoriteProducts(user.getId());
                request.setAttribute("list", listProducts);
                request.setAttribute("size", listProducts.size());

            } else if (mode.equals("ALL_DELETE")) {
                db.removeAllFavoriteProducts(user.getId());
                listProducts = db.getFavoriteProducts(user.getId());
                request.setAttribute("list", listProducts);
                request.setAttribute("size", listProducts.size());
            }
        }
        request.getRequestDispatcher("store/favorite-product/favoriteProduct.jsp").forward(request, response);

    }
}
