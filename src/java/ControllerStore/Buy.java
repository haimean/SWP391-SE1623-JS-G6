/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ControllerStore;

import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import DAO.*;
import Model.*;

/**
 *
 * @author PiPi
 */
enum Mode {
    ADD,
    CHANGE_QUANTITY,
    SINGAL_DELETE,
    ALL_DELETE
}

public class Buy extends HttpServlet {

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
        request.getRequestDispatcher("store/cart/index.jsp").forward(request, response);
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

        if (mode.equals(Mode.ADD.toString())) {
            int num = Integer.parseInt(request.getParameter("num"));
            String id = request.getParameter("id");
            DAOProduct dao = new DAOProduct();
            Product product = dao.getProductById(id);
            double price = product.getPrice();
            Item item = new Item(product, num, price);
            try {
                cart.addItem(item);
            } catch (Exception e) {
                num = 1;
            }
        }
        if (mode.equals(Mode.CHANGE_QUANTITY.toString())) {
            int num = Integer.parseInt(request.getParameter("num"));
            String id = request.getParameter("id");

            if ((num == -1) && (cart.getQuantityById(Integer.parseInt(id)) <= 1)) {
                cart.removeItem(Integer.parseInt(id));
            } else {
                DAOProduct dao = new DAOProduct();
                Product product = dao.getProductById(id);
                Item t = new Item(product, num, product.getPrice());
                cart.addItem(t);
            }
        }
        if (mode.equals(Mode.SINGAL_DELETE.toString())) {
            int id = Integer.parseInt(request.getParameter("id"));
            cart.removeItem(id);
        }
        if (mode.equals(Mode.ALL_DELETE.toString())) {
            cart.removeAllItems();
        }

        ArrayList<Item> list = cart.getItems();
        session.setAttribute("cart", cart);
        session.setAttribute("total", cart.getTotalMoney());
        session.setAttribute("size", list.size());
        request.getRequestDispatcher("/store/cart/index.jsp").forward(request, response);
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
