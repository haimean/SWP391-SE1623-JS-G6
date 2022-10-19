/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.ItemCart;
import Model.Product;
import Model.Cart;
import Dao.ProductDao;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author PiPi
 */
enum Type {
    ADD,
    CHANGE_QUANTITY,
    SINGAL_DELETE,
    ALL_DELETE
}

public class StoreBuy extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("store/cart/index.jsp").forward(request, response);
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

        if (mode.equals(Type.ADD.toString())) {
            int num = Integer.parseInt(request.getParameter("num"));
            String id = request.getParameter("id");
            ProductDao dao = new ProductDao();
            Product product = dao.getProductById(id);
            double price = product.getPrice();
            ItemCart item = new ItemCart(product, num, price);
            try {
                cart.addItem(item);
            } catch (Exception e) {
                num = 1;
            }
        }
        if (mode.equals(Type.CHANGE_QUANTITY.toString())) {
            int num = Integer.parseInt(request.getParameter("num"));
            String id = request.getParameter("id");

            if ((num == -1) && (cart.getQuantityById(Integer.parseInt(id)) <= 1)) {
                cart.removeItem(Integer.parseInt(id));
            } else {
                ProductDao dao = new ProductDao();
                Product product = dao.getProductById(id);
                ItemCart t = new ItemCart(product, num, product.getPrice());
                cart.addItem(t);
            }
        }
        if (mode.equals(Type.SINGAL_DELETE.toString())) {
            int id = Integer.parseInt(request.getParameter("id"));
            cart.removeItem(id);
        }
        if (mode.equals(Type.ALL_DELETE.toString())) {
            cart.removeAllItems();
        }

        ArrayList<ItemCart> list = cart.getItems();
        session.setAttribute("cart", cart);
        session.setAttribute("total", cart.getTotalMoney());
        session.setAttribute("size", list.size());
        request.getRequestDispatcher("/store/cart/index.jsp").forward(request, response);
    }
}