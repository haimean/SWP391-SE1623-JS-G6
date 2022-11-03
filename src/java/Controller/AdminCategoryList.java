package Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import Dao.CategoryDao;
import Model.Category;
import Dao.Impl.CategoryDaoImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haimi
 */
public class AdminCategoryList extends HttpServlet {

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
        CategoryDao categoryDaoImpl = new CategoryDaoImpl();
        String search = request.getParameter("search");
        String indexpasge = request.getParameter("page");
        String status = request.getParameter("status");
        if (indexpasge == null) {
            indexpasge = "1";
            int page = Integer.parseInt(indexpasge);
            if (search != null) {
                ArrayList<Category> categories = categoryDaoImpl.search(search);
                request.setAttribute("search", search);
                request.setAttribute("categories", categories);
                request.getRequestDispatcher("category/categoryList.jsp").forward(request, response);
            } else {
                List<Category> categories = categoryDaoImpl.getAll(page);
            }
            int count = categoryDaoImpl.getTotalCategory();
            int endpage = count / 5;
            if (count % 5 != 0) {
                endpage++;
            }
            ArrayList<Category> categories = categoryDaoImpl.getAll(page);
            request.setAttribute("endpage", endpage);
            request.setAttribute("categories", categories);
            request.setAttribute("status", status);
            request.getRequestDispatcher("category/categoryList.jsp").forward(request, response);
        } else {
            int page = Integer.parseInt(indexpasge);
            if (search != null) {
                ArrayList<Category> categories = categoryDaoImpl.search(search);
                request.setAttribute("search", search);
                request.setAttribute("categories", categories);
                request.getRequestDispatcher("category/categoryList.jsp").forward(request, response);
            } else {
                ArrayList<Category> categories = categoryDaoImpl.getAll(page);
            }
            int count = categoryDaoImpl.getTotalCategory();
            int endpage = count / 5;
            if (count % 5 != 0) {
                endpage++;
            }
            ArrayList<Category> categories = categoryDaoImpl.getAll(page);
            request.setAttribute("endpage", endpage);
            request.setAttribute("categories", categories);
            request.setAttribute("status", status);
            request.getRequestDispatcher("category/categoryList.jsp").forward(request, response);

        }
    }
}
