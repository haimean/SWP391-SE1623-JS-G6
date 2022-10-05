package ControllerAdmin;

import Dal.DAOUser;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author PiPi
 */
public class UserList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        DAOUser daoUser = new DAOUser();
        ArrayList<User> list = daoUser.getAllUsers();
        request.setAttribute("listU", list);
        request.getRequestDispatcher("/BlogShop/admin/user/index.jsp").forward(request, response);
    }




}
