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
        String indexpasge = "1";
        int page = Integer.parseInt(indexpasge);
        String mode = request.getParameter("mode");
        ArrayList<Category> categories = categoryDaoImpl.getAll(page);
        int pageExisted = request.getParameter("pageExisted") == null ? 0 : Integer.parseInt(request.getParameter("pageExisted"));
        List<Product> products = productDaoImpl.getNextTop45Products(pageExisted);
        if (mode == null) {
            request.setAttribute("categories", categories);
            request.setAttribute("products", products);
            request.getRequestDispatcher("/store/Home.jsp").forward(request, response);
        } else if (mode.equals("LOAD")) {
            for (Product product : products) {
                out.print(product.getProImg() + " ");
            }
        }
//        request.setAttribute("categories", categories);
//        request.setAttribute("products", products);
//        request.getRequestDispatcher("/store/Home.jsp").forward(request, response);
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
