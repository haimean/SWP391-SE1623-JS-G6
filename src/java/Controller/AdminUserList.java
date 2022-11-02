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
public class AdminUserList extends HttpServlet {

    public void paginate(List<User> list, UserDaoImpl db, HttpServletRequest request, HttpServletResponse response,
            String mode, String... searchValue)
            throws ServletException, IOException {
        final int recordsPerPage = 4;
        int index;
        String indexParam = request.getParameter("page");
        if (indexParam == null) {
            indexParam = "1";
        }

        if (Integer.parseInt(indexParam) == 0) {
            indexParam = "1";
        }

        try {
            index = Integer.parseInt(indexParam);
        } catch (NumberFormatException e) {
            index = 1;
        }
        int totalPage = db.getTotalUsers();
        int endPage = totalPage / recordsPerPage;

        if (totalPage % recordsPerPage != 0) {
            endPage++;
        }

        if (index > endPage) {
            index = endPage;
        }

        if (mode.equals("SEARCH")) {
            totalPage = db.getTotalUsersSearch(searchValue[0]);
            endPage = totalPage / recordsPerPage;

            if (totalPage % recordsPerPage != 0) {
                endPage++;
            }

            if (index > endPage) {
                index = endPage;
            }
            list = db.search(searchValue[0], index);
            request.setAttribute("tag", index);
            request.setAttribute("listU", list);
            request.setAttribute("size", list.size());
            request.setAttribute("endP", endPage);
            request.setAttribute("search", searchValue[0]);
            request.getRequestDispatcher("/admin/user/userSearch.jsp").forward(request, response);

        } else {
            list = db.paginate(index);
        }
        request.setAttribute("tag", index);
        request.setAttribute("listU", list);
        request.setAttribute("endP", endPage);
        request.getRequestDispatcher("/admin/user/index.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String modeParam = request.getParameter("mode");
        UserDaoImpl db = new UserDaoImpl();
        List<User> list = null;

        if (modeParam == null) {
            paginate(list, db, request, response, "NORMAL");

        } else if (modeParam.equals("BAN")) {
            String idParam = request.getParameter("id");
            String statusParam = request.getParameter("status");
            int id = Integer.parseInt(idParam);
            boolean status = Boolean.parseBoolean(statusParam);
            db.updateUserStatusByID(id, !status);
            paginate(list, db, request, response, "BAN");
        } else if ((modeParam.equals("SEARCH"))) {
            String searchValue = request.getParameter("search");
            paginate(list, db, request, response, "SEARCH", searchValue);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> list = null;
        UserDaoImpl db = new UserDaoImpl();
        String modeParam = request.getParameter("mode");

        if (modeParam.equals("ROLE")) {
            String idParam = request.getParameter("id");
            String roleParam = request.getParameter("role");
            int id = Integer.parseInt(idParam);
            int role = Integer.parseInt(roleParam);
            db.updateUserRoleByID(id, role);
            paginate(list, db, request, response, "ROLE");
        }
        if ((modeParam.equals("SEARCH"))) {
            String searchValue = request.getParameter("search").trim();
            paginate(list, db, request, response, "SEARCH", searchValue);
        }
    }
}
