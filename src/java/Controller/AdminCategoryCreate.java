/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.Impl.CategoryDaoImpl;
import Model.Category;
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
public class AdminCategoryCreate extends HttpServlet {

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
        request.getRequestDispatcher("/admin/category/categoryAdd.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
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
        CategoryDaoImpl categoryDaoImpl = new CategoryDaoImpl();
        String categoryName = request.getParameter("name").trim();
        String indexpasge = request.getParameter("page");
        if (indexpasge == null) {
            indexpasge = "1";
            int page = Integer.parseInt(indexpasge);
            if (categoryName == null || categoryName.equals("")) {
                response.sendRedirect(request.getContextPath() + "/admin/category");
            } else {
                boolean status = categoryDaoImpl.insert(new Category(categoryName));
                int count = categoryDaoImpl.getTotalCategory();
                int endpage = count / 5;
                if (count % 5 != 0) {
                    endpage++;
                }
                ArrayList<Category> categories = categoryDaoImpl.getAll(page);
                request.setAttribute("categories", categories);
                request.setAttribute("endpage", endpage);
                response.sendRedirect(request.getContextPath() + "/admin/category?status=" + status);
            }
        } else {
            int page = Integer.parseInt(indexpasge);
            if (categoryName == null || categoryName.equals("")) {
                response.sendRedirect(request.getContextPath() + "/admin/category");
            } else {
                boolean status = categoryDaoImpl.insert(new Category(categoryName));
                int count = categoryDaoImpl.getTotalCategory();
                int endpage = count / 5;
                if (count % 5 != 0) {
                    endpage++;
                }
                ArrayList<Category> categories = categoryDaoImpl.getAll(page);
                request.setAttribute("categories", categories);
                request.setAttribute("endpage", endpage);
                response.sendRedirect(request.getContextPath() + "/admin/category?status=" + status);
            }
        }

    }
}
