package ControllerAdmin;

import Dal.DAOCategory;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Mr Tuan
 */
public class CategoryDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOCategory db = new DAOCategory();
        String id = request.getParameter("id");
        if (db.deleteByID(id) > 0) {
            response.sendRedirect("../category");
            return;
        }
        response.sendRedirect("../category");
    }
}
