/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ControllerAdmin;

import DAO.DAOCategory;
import DAO.DAOUser;
import Model.Category;
import Model.User;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author haimi
 */
public class AdminDashboard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Category> categories =  new DAOCategory().getCategories();       
        ArrayList<User> users =  new DAOUser().getAllUsers();
        request.setAttribute("categoriesCount", categories.size());    
        request.setAttribute("usersCount", users.size());
        System.out.println(users.size());
        request.getRequestDispatcher("/admin/Dashboard.jsp").forward(request, response);
    }
}
