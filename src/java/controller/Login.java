/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.User;
import Dao.Impl.UserDaoImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User u = new UserDaoImpl().login(email, password);
            if (u == null) {
                String noti = "Incorrect user name or password,please try again";
                request.setAttribute("noti", noti);
                request.getRequestDispatcher("login/login.jsp").forward(request, response);
            } else {
                int type = u.getRole();
                request.getSession().setAttribute("user", u);
                request.getSession().setMaxInactiveInterval(600);
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
                        String noti = "aorn";
                        request.setAttribute("noti", noti);
                        request.getRequestDispatcher("/login/login.jsp").forward(request, response);
                }
            }
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
                    String noti = "Incoaoasdf";
                    request.setAttribute("noti", noti);
                    request.getRequestDispatcher("/login/login.jsp").forward(request, response);
            }
        }

    }
}
