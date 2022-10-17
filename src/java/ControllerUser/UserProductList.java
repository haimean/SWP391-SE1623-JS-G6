/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ControllerUser;

import DAO.DAOCategory;
import DAO.DAOProduct;
import Model.Category;
import Model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nguye
 */
public class UserProductList extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserProductList</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserProductList at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        int sortby = 1;
        if (null != request.getParameter("sort")) {
            sortby = Integer.parseInt(request.getParameter("sort"));
        }
        switch (sortby) {
            case 1: {
                request.setAttribute("sortname", "selected");
                break;
            }
            case 2: {
                request.setAttribute("sortasc", "selected");
                break;
            }
            case 3: {
                request.setAttribute("sortdesc", "selected");
                break;
            }
            default: {
                request.setAttribute("sortnew", "selected");
                break;
            }
        }
        request.setAttribute("sortabc", sortby);

        //get search by name
        String name = "";
        if (request.getParameter("search") != null) {
            name = request.getParameter("search").trim();

        }
        request.setAttribute("searchname", name);

        //get selected cartegory
        int catCheck = 0;
        if (null != request.getParameter("category")) {
            catCheck = Integer.parseInt(request.getParameter("category"));
        }
        request.setAttribute("category", catCheck);
        
        //get price range
        int beginprice = 0;
        int endprice = 0;
        if (request.getParameter("beginp") != null && !"".equals(request.getParameter("beginp"))) {
            beginprice = Integer.parseInt(request.getParameter("beginp"));
            request.setAttribute("beginprice", beginprice);
        }
        if (request.getParameter("endp") != null && !"".equals(request.getParameter("endp"))) {
            endprice = Integer.parseInt(request.getParameter("endp"));
            request.setAttribute("endprice", endprice);
        }

        //DAO import
        DAOProduct pdao = new DAOProduct();
        DAOCategory cdao = new DAOCategory();
        
        //load cartegory
        List<Category> categories = new ArrayList<>();
        Category all = new Category();
        all.setId(0);
        all.setName("All");
        categories.add(all);
        try {
            for (Category cat : cdao.getCategories()) {
                categories.add(cat);
            }
        } catch (Exception ex) {
            Logger.getLogger(UserProductList.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("categories", categories);

        //get and pagecount
        int pagecount = 0;
        try {
            pagecount = pdao.getPageCount(catCheck, beginprice, endprice, name);
        } catch (Exception ex) {
            Logger.getLogger(UserProductList.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("numberPage", pagecount);
        //get and set current page
        int page = 1;
        if (null != request.getParameter("page")) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        request.setAttribute("pageCurrent", page);
        //paging calculation
        int beginPage = page - 1;
        int endPage = page + 1;
        if (page < 3) {
            beginPage = 1;
            endPage = 3;
            if (endPage > pagecount) {
                endPage = pagecount;
            }
        } else {
            if (page > pagecount - 2) {
                endPage = pagecount;
                beginPage = pagecount - 2;
            }
        }
        List<Product> products = pdao.getAllProductByConstrain(page - 1, sortby, catCheck, beginprice, endprice, name);
        request.setAttribute("beginPage", beginPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("lstzsize", products.size() - 1);
        request.setAttribute("listP", products);
        request.getRequestDispatcher("./user/product/productlistuser.jsp").forward(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
