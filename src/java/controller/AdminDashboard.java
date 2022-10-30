/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.User;
import Model.Category;
import Dao.Impl.CategoryDaoImpl;
import Dao.Impl.UserDaoImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author haimi
 */
public class AdminDashboard extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Category> categories = new CategoryDaoImpl().getAll();
        List<User> users = new UserDaoImpl().getAll();
        request.setAttribute("categoriesCount", categories.size());
        request.setAttribute("usersCount", users.size());
        System.out.println(users.size());
        request.getRequestDispatcher("/admin/Dashboard.jsp").forward(request, response);
    }
}
