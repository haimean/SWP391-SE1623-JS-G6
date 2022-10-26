package Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import Model.User;
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
enum Mode {
    SEARCH,
    BAN,
    ROLE
}

public class AdminUserList extends HttpServlet {

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
        String modeParam = request.getParameter("mode");
        UserDaoImpl db = new UserDaoImpl();
        List<User> list;
        if (modeParam == null) {
            list = db.getAll();
            request.setAttribute("listU", list);
            request.getRequestDispatcher("/admin/user/index.jsp").forward(request, response);
        }
        if (modeParam.equals(Mode.BAN.toString())) {
            String idParam = request.getParameter("id");
            String statusParam = request.getParameter("status");
            int id = Integer.parseInt(idParam);
            boolean status = Boolean.parseBoolean(statusParam);
            db.updateUserStatusByID(id, !status);
            list = db.getAll();
            request.setAttribute("listU", list);
            request.getRequestDispatcher("/admin/user/index.jsp").forward(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> list;
        UserDaoImpl db = new UserDaoImpl();
        String modeParam = request.getParameter("mode");

        if (modeParam.equals(Mode.ROLE.toString())) {
            String idParam = request.getParameter("id");
            String roleParam = request.getParameter("role");
            int id = Integer.parseInt(idParam);
            int role = Integer.parseInt(roleParam);
            db.updateUserRoleByID(id, role);
            list = db.getAll();
            request.setAttribute("listU", list);
            request.getRequestDispatcher("/admin/user/index.jsp").forward(request, response);
        }
        if ((modeParam.equals(Mode.SEARCH.toString()))) {
            String searchValue = request.getParameter("search");
            list = db.search(searchValue);
            request.setAttribute("listU", list);
            request.getRequestDispatcher("/admin/user/index.jsp").forward(request, response);
        }
    }
}
