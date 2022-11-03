/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.Impl.ProductDaoImpl;
import Model.Blog;
import Model.Cart;
import Model.ItemCart;
import Model.Product;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
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
        int id = Integer.parseInt(request.getParameter("id"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        ProductDaoImpl db = new ProductDaoImpl();
        Product product = db.get(id);
        List<Product> listProducts = db.getTop7Products(id, categoryId);
        List<Blog> listBlogs = db.getTop7Blogs(id);
        request.setAttribute("p", product);
        request.setAttribute("list", listProducts);
        request.setAttribute("listBlogs", listBlogs);
        request.getRequestDispatcher("/store/product-detail/productDetail.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        Cart cart;
        Object object = session.getAttribute("cart");

        if (object != null) {
            cart = (Cart) object;
        } else {
            cart = new Cart();
        }

        String mode = request.getParameter("mode");
        ProductDaoImpl db = new ProductDaoImpl();
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));

        if (mode.equals(Type.ADD.toString())) {
            String numStr = request.getParameter("num");
            int num;
            if (numStr != null && !numStr.isEmpty()) {
                num = Integer.parseInt(numStr);
            } else {
                num = 1;
            }
            int id = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0;
            if (num == 0) {
                num = 1;
            }
            ProductDaoImpl dao = new ProductDaoImpl();
            Product product = dao.get(id);
            double price = product.getPrice();
            ItemCart item = new ItemCart(product, num, price);
            boolean status = cart.addItem(item);
            ArrayList<ItemCart> list = cart.getItems();
            List<Blog> listBlogs = db.getTop7Blogs(id);
            List<Product> listProductsRelated = db.getTop7Products(id, categoryId);
            request.setAttribute("status", status);
            request.setAttribute("p", product);
            request.setAttribute("list", listProductsRelated);
            request.setAttribute("listBlogs", listBlogs);
            session.setAttribute("cart", cart);
            session.setAttribute("size", list.size());
            request.getRequestDispatcher("/store/product-detail/productDetail.jsp").forward(request, response);
        }
    }

}
