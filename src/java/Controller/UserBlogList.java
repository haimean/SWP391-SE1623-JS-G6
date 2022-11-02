/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.Impl.BlogDaoImpl;
import Model.Blog;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author nguye
 */
public class UserBlogList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        BlogDaoImpl bdao = new BlogDaoImpl();

        int pagecount = 0;
        try {
            pagecount = bdao.getPageCount();
        } catch (Exception ex) {
            Logger.getLogger(UserBlogList.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("numberPage", pagecount);
        // get and set current page
        int page = 1;
        if (null != request.getParameter("page")) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        request.setAttribute("pageCurrent", page);
        // paging calculation
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

        // List<Blog> blog = bdao.getAllBlog();
        List<Blog> blog = bdao.getAllBlogByConstrain(page - 1);
        request.setAttribute("beginPage", beginPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("lstzsize", blog.size() - 1);
        request.setAttribute("listB", blog);
        request.getRequestDispatcher("/user/blog/bloglist.jsp").forward(request, response);

    }

}
