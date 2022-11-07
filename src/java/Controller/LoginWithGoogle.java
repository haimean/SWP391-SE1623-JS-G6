/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.Impl.UserDaoImpl;
import Dao.Impl.UserGoogleDaoImpl;
import GoogleService.Google;
import static GoogleService.Google.getToken;
import static GoogleService.Google.getUserInfo;
import Model.User;
import Model.UserGoogle;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author MrTuan
 */
public class LoginWithGoogle extends HttpServlet {

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
        UserGoogleDaoImpl userGoogleDaoImpl = new UserGoogleDaoImpl();
        String code = request.getParameter("code");
        if (code == null || code.isEmpty()) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            String accessToken = Google.getToken(code);
            UserGoogle userGoogle = Google.getUserInfo(accessToken);
            String email = userGoogle.getEmail();
            boolean verified_email = userGoogle.isVerified_email();
            UserGoogle usergoogle = userGoogleDaoImpl.getByEmail(email);
            if (usergoogle == null) {
                userGoogleDaoImpl.insertUser(email, verified_email);
                UserGoogle login = userGoogleDaoImpl.loginWithGoogle(email, verified_email);
                request.getSession().setAttribute("userGoogle", login);
                request.getRequestDispatcher("/store/Home.jsp").forward(request, response);
            } else {
                UserGoogle login = userGoogleDaoImpl.loginWithGoogle(email, verified_email);
                request.getSession().setAttribute("userGoogle", login);
                request.getRequestDispatcher("/store/Home.jsp").forward(request, response);
            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserGoogleDaoImpl userGoogleDaoImpl = new UserGoogleDaoImpl();
        String code = request.getParameter("code");
        if (code == null || code.isEmpty()) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            String accessToken = Google.getToken(code);
            UserGoogle userGoogle = Google.getUserInfo(accessToken);
            String email = userGoogle.getEmail();
            boolean verified_email = userGoogle.isVerified_email();
            UserGoogle usergoogle = userGoogleDaoImpl.getByEmail(userGoogle.getEmail());
            if (usergoogle == null) {
                boolean status = userGoogleDaoImpl.insertUser(email, verified_email);
                if (status == true) {
                    userGoogleDaoImpl.loginWithGoogle(email, verified_email);
                    response.sendRedirect(request.getContextPath());
                }
            } else {
                userGoogleDaoImpl.loginWithGoogle(email, verified_email);
                response.sendRedirect(request.getContextPath());
            }

        }
    }

}
