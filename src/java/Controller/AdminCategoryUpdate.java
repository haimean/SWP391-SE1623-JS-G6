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
public class AdminCategoryUpdate extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        CategoryDaoImpl categoryDaoImpl = new CategoryDaoImpl();
        int id = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0;
        Category category = categoryDaoImpl.get(id);
        request.setAttribute("category", category);
        request.getRequestDispatcher("categoryDetail.jsp").forward(request, response);
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
        CategoryDaoImpl categoryDaoImpl = new CategoryDaoImpl();
        int id = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0;
        String name = request.getParameter("name");
        String indexpasge = request.getParameter("page");
        if (indexpasge == null) {
            indexpasge = "1";
            int page = Integer.parseInt(indexpasge);
            if (name == null || name.equals("")) {
                response.sendRedirect(request.getContextPath() + "/admin/category");
            } else {
                int count = categoryDaoImpl.getTotalCategory();
                int endpage = count / 5;
                if (count % 5 != 0) {
                    endpage++;
                }
                boolean status = categoryDaoImpl.update(new Category(id, name));
                ArrayList<Category> categories = categoryDaoImpl.getAll(page);
                request.setAttribute("status", status);
                request.setAttribute("categories", categories);
                request.setAttribute("endpage", endpage);
                request.getRequestDispatcher("categoryList.jsp").forward(request, response);
            }
        } else {
            int page = Integer.parseInt(indexpasge);
            if (name == null || name.equals("")) {
                response.sendRedirect(request.getContextPath() + "/admin/category");
            } else {
                int count = categoryDaoImpl.getTotalCategory();
                int endpage = count / 5;
                if (count % 5 != 0) {
                    endpage++;
                }
                boolean status = categoryDaoImpl.update(new Category(id, name));
                ArrayList<Category> categories = categoryDaoImpl.getAll(page);
                request.setAttribute("status", status);
                request.setAttribute("categories", categories);
                request.setAttribute("endpage", endpage);
                request.getRequestDispatcher("categoryList.jsp").forward(request, response);
            }
        }
    }
}
