package ControllerAdmin;

import Dal.DAOCategory;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import Model.Category;

/**
 *
 * @author Mr Tuan
 */
public class CategoryList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOCategory db = new DAOCategory();
        ArrayList<Category> categories = new ArrayList<Category>();
        String search = request.getParameter("sreach");
        if (search == null) {
            categories = db.getAllCategory();
        } else {
            categories = db.SearchName(search);
        }
        request.setAttribute("categories", categories);
        request.setAttribute("search", search);
        request.getRequestDispatcher("category/index.jsp").forward(request, response);
    }
}
