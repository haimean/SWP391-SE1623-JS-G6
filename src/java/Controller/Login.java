/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import static Controller.Register.isValid;
import Model.User;
import Dao.Impl.UserDaoImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author MrTuan
 */
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            String email = "";
            String password = "";
            Cookie ck[] = request.getCookies();
            for (int i = 0; i < ck.length; i++) {
                if (ck[i].getName().equalsIgnoreCase("email")) {
                    email = ck[i].getValue();
                }
                if (ck[i].getName().equalsIgnoreCase("password")) {
                    password = ck[i].getValue();
                }
            }
            request.setAttribute("email", email);
            request.setAttribute("password", password);
            request.getRequestDispatcher("/login/login.jsp").forward(request, response);
            return;
        } else {
            int type = user.getRole();
            switch (type) {
                case 1:
                    response.sendRedirect(request.getContextPath() + "/admin");
                    break;
                case 2:
                    response.sendRedirect(request.getContextPath() + "/seller");
                    break;
                case 3:
                    response.sendRedirect(request.getContextPath());
                    break;
                default:
                    request.getRequestDispatcher("/login/login.jsp").forward(request, response);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            UserDaoImpl db = new UserDaoImpl();
            String email = request.getParameter("email").trim();
            String password = request.getParameter("password").trim();
            if (!isValid(password)) {
                //sai dinh dang pass
                request.setAttribute("email", email);
                request.setAttribute("password", password);
                request.setAttribute("errorPassword", "Password is not valid");
                request.getRequestDispatcher("login/login.jsp").forward(request, response);
                return;
            } else {
                User u = db.login(email, password);
                if (u == null) {
                    request.setAttribute("status", "incorect");
                    request.setAttribute("email", email);
                    request.setAttribute("password", password);
                    request.getRequestDispatcher("login/login.jsp").forward(request, response);
                    return;
                } else {
                    if (request.getParameter("remember") != null) {
                        Cookie userCookie = new Cookie("email", u.getEmail());
                        Cookie passCookie = new Cookie("password", u.getPassword());
                        userCookie.setMaxAge(60 * 60 * 24);
                        passCookie.setMaxAge(60 * 60 * 24);
                        response.addCookie(userCookie);
                        response.addCookie(passCookie);
                    }
                    request.getSession().setAttribute("user", u);
                    switch (u.getRole()) {
                        case 1:
                            response.sendRedirect(request.getContextPath() + "/admin");
                            break;
                        case 2:
                            response.sendRedirect(request.getContextPath() + "/seller");
                            break;
                        case 3:
                            response.sendRedirect(request.getContextPath());
                            break;
                        default:
                            request.setAttribute("status", "loginFail");
                            request.getRequestDispatcher("/login/login.jsp").forward(request, response);
                    }
                }
            }
        } else {
            int type = user.getRole();
            switch (type) {
                case 1:
                    response.sendRedirect(request.getContextPath() + "/admin");
                    break;
                case 2:
                    response.sendRedirect(request.getContextPath() + "/seller");
                    break;
                case 3:
                    response.sendRedirect(request.getContextPath());
                    break;
                default:
                    request.setAttribute("status", "loginFail");
                    request.getRequestDispatcher("/login/login.jsp").forward(request, response);
            }
        }

    }

    public static boolean isValid(String password) {
        String PASSWORD_PATTERN
                = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
