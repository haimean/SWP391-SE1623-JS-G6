/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.Impl.UserDaoImpl;
import Dao.UserDao;
import Model.User;
import SendEmail.SendEmail;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author haimi
 */
public class Register extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
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
        request.getRequestDispatcher("register/register.jsp").forward(request, response);
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
        // feth form value
        UserDao userDaoImpl = new UserDaoImpl();
        String email = request.getParameter("email").trim();
        String password = request.getParameter("password").trim();
        String rePassword = request.getParameter("rePassword").trim();
        String fullName = request.getParameter("fullName").trim();
        if (!userDaoImpl.haveAccount(email) && isValid(password) && password.equals(rePassword)) {
            // create instance object of the SendEmail Class
            SendEmail sm = new SendEmail();
            // get the 6-digit code
            String code = sm.getRandom();
            // craete new user using all information
            User user = new User(fullName, email, password, code);
            // call the send email method
            boolean test = sm.sendEmail(user);
            // check if the email send successfully
            if (test) {
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(180);
                session.setAttribute("authcode", user);
                response.sendRedirect(request.getContextPath() + "/register/verify");
                return;
            } else {
                response.sendRedirect(request.getContextPath());
            }
        }

        if (userDaoImpl.haveAccount(email)) {
            // trung mail
            request.setAttribute("emailError", "Email already exists");
        }
        if (!isValid(password)) {
            // sai dinh dang pass
            request.setAttribute("passwordError", "Password is not valid");
        }
        if (!password.equals(rePassword)) {
            // k trung pass
            request.setAttribute("rePasswordError", "Confirm Password don't same the password");
        }
        request.setAttribute("email", email);
        request.setAttribute("password", password);
        request.setAttribute("rePassword", rePassword);
        request.setAttribute("fullName", fullName);
        request.getRequestDispatcher("/register/register.jsp").forward(request, response);
    }

    public static boolean isValid(String password) {
        String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

}
