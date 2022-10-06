/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.LoginDBContext;
import dal.UserlistDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author MrTuan
 */
public class LoginController extends HttpServlet {

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
        LoginDBContext db = new LoginDBContext();
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User();
        try {
            user = db.search(email, password);
        } catch (Exception ex) {
            Logger.getLogger(LoginDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        //login
        if (user == null) {
            String noti = "Incorrect user name or password,please try again";
//            request.setAttribute("noti", noti);
            request.getRequestDispatcher("login\\index.jsp").forward(request, response);
        } else {
            int type = user.getRole();
            request.getSession().setMaxInactiveInterval(600);
            switch (type) {
                case 1:
                    if (type == 1) {
                        session.setAttribute("email", email);
                        session.setAttribute("user", user);
                        response.sendRedirect("adminProfile");
                        request.getSession().setMaxInactiveInterval(600);
                        break;
                    }
                case 2:
                    if (type == 2) {
                        session.setAttribute("email", email);
                        session.setAttribute("user", user);
                        response.sendRedirect("sellerProfile");
                        request.getSession().setMaxInactiveInterval(600);
                        break;
                    }
                case 3:
                    if (type == 3) {
                        session.setAttribute("email", email);
                        session.setAttribute("user", user);
                        response.sendRedirect("customerProfile");
                        request.getSession().setMaxInactiveInterval(600);
                        break;
                    }
                default:
                    throw new AssertionError();
            }
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
        LoginDBContext db = new LoginDBContext();

        HttpSession session = request.getSession();

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = null;
        try {
            user = db.search(email, password);
        } catch (Exception ex) {
            Logger.getLogger(LoginDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        //login
        if (user == null) {
            String noti = "Incorrect user name or password,please try again";
            request.setAttribute("noti", noti);
            response.sendRedirect("Login.jsp");
        } else {
            int type = user.getRole();
            request.getSession().setMaxInactiveInterval(600);

            switch (type) {
                case 1:
                    session.setAttribute("email", email);
                    session.setAttribute("user", user);
                    response.sendRedirect("adminProfile");
                    request.getSession().setMaxInactiveInterval(600);

                    break;

                case 2:
                    session.setAttribute("email", email);
                    session.setAttribute("user", user);
                    response.sendRedirect("sellerProfile");
                    request.getSession().setMaxInactiveInterval(600);

                    break;
                case 3:
                    session.setAttribute("email", email);
                    session.setAttribute("user", user);
                    response.sendRedirect("customerProfile");
                    request.getSession().setMaxInactiveInterval(600);

                    break;
                default:
                    throw new AssertionError();
            }
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
