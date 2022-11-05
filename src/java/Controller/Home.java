/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.Impl.CategoryDaoImpl;
import Dao.Impl.ProductDaoImpl;
import Model.Category;
import Model.Product;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haimi
 */
public class Home extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        CategoryDaoImpl categoryDaoImpl = new CategoryDaoImpl();
        ProductDaoImpl productDaoImpl = new ProductDaoImpl();
        String mode = request.getParameter("mode");
        ArrayList<Category> categories;
        int pageExisted = request.getParameter("pageExisted") == null ? 0 : Integer.parseInt(request.getParameter("pageExisted"));
        List<Product> products;
        if (mode == null) {
            products = productDaoImpl.getNextTop45Products(pageExisted);
            categories = categoryDaoImpl.getAll();
            request.setAttribute("categories", categories);
            request.setAttribute("products", products);
            request.getRequestDispatcher("/store/Home.jsp").forward(request, response);
        } else if (mode.equals("LOAD")) {
            products = productDaoImpl.getNextTop45Products(pageExisted);
            for (Product product : products) {
                out.print("<img class=\"grid-item\" src=\"" + product.getProImg() + "\"onclick=\"productDetail(" + product.getId() + "," + product.getCategoryID() + ")\">+");
            }
        } else if (mode.equals("FILTER")) {
            int categoryId = Integer.parseInt(request.getParameter("categoryId"));
            products = productDaoImpl.getNextTop45ProductsByCategoryId(pageExisted, categoryId);
            categories = categoryDaoImpl.getAll();
            request.setAttribute("categoryId", categoryId);
            request.setAttribute("products", products);
            request.setAttribute("categories", categories);
            request.getRequestDispatcher("/store/HomeFilter.jsp").forward(request, response);
        } else if (mode.equals("FILTER_LOAD")) {
            int categoryId = Integer.parseInt(request.getParameter("categoryId"));
            products = productDaoImpl.getNextTop45ProductsByCategoryId(pageExisted, categoryId);
            for (Product product : products) {
                out.print("<img class=\"grid-item\" src=\"" + product.getProImg() + "\"onclick=\"productDetail(" + product.getId() + "," + product.getCategoryID() + ")\">+");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
