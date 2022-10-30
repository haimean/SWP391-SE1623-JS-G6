/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Cart;
import Model.User;
import Dao.CartDao;
import Dao.Impl.CartDaoImpl;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author PiPi
 */
@WebServlet(name = "Checkout", urlPatterns = {"/checkout"})
public class StoreCheckout extends HttpServlet {

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
        User account;
        Object object2 = session.getAttribute("user");
        CartDao dao = new CartDaoImpl();

        if (object2 == null) {
            response.sendRedirect("login/login.jsp");
        } else {
            account = (User) object2;
            dao.addOrder(account, cart);
            session.removeAttribute("cart");
            session.setAttribute("size", 0);
            response.sendRedirect("store/Home.jsp");
        }
    }
}
