/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ControllerStore;

import DAO.DAOBlog;
import Model.Blog;
import java.io.IOException;
import java.io.PrintWriter;
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
public class BlogList extends HttpServlet {

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
            out.println("<title>Servlet BlogList</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BlogList at " + request.getContextPath() + "</h1>");
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
        //get and pagecount
        DAOBlog bdao = new DAOBlog();
        
        int pagecount = 0;
        try {
            pagecount = bdao.getPageCount();
        } catch (Exception ex) {
            Logger.getLogger(BlogList.class.getName()).log(Level.SEVERE, null, ex);
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

//        List<Blog> blog = bdao.getAllBlog();
        List<Blog> blog = bdao.getAllBlogByConstrain(page - 1);
        request.setAttribute("beginPage", beginPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("lstzsize", blog.size() - 1);
        request.setAttribute("listB", blog);
        request.getRequestDispatcher("./store/blog/blogList/blogList.jsp").forward(request, response);

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
