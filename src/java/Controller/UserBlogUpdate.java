/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.Impl.BlogDaoImpl;
import Dao.Impl.UserDaoImpl;
import Model.AddressReceiver;
import Model.Blog;
import Model.User;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 *
 * @author nguye
 */
@MultipartConfig
public class UserBlogUpdate extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");
                request.setCharacterEncoding("utf-8");
                int id = Integer.parseInt(request.getParameter("id"));
                BlogDaoImpl daoB = new BlogDaoImpl();
                Blog b = daoB.get(id);
                request.setAttribute("blog", b);
                request.getRequestDispatcher("/user/blog/blogupdate.jsp").forward(request, response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");
                request.setCharacterEncoding("utf-8");
                int id = Integer.parseInt(request.getParameter("id"));
                String title = request.getParameter("title");
                String description = request.getParameter("description");
                String content = request.getParameter("content");
                BlogDaoImpl daoB = new BlogDaoImpl();
                Blog b = new Blog(id, title, description, content);
                daoB.update(b);
                Blog bRemove = null;
                ArrayList<Blog> listB = daoB.getTop3Blog();
                for (Blog blog : listB) {
                        if (b.getId() == blog.getId()) {
                                bRemove = blog;
                        }
                }
                listB.remove(bRemove);
                if (listB.size() > 3) {
                        listB.remove(3);
                }
                request.setAttribute("listB", listB);
                request.setAttribute("blog", b);
                request.setAttribute("lstzsize", listB.size() - 1);
                request.getRequestDispatcher("blogdetails.jsp").forward(request, response);
        }

        private String extractFileName(Part part) {
                String contentDisp = part.getHeader("content-disposition");
                String[] items = contentDisp.split(";");
                for (String s : items) {
                        if (s.trim().startsWith("filename")) {
                                return s.substring(s.indexOf("=") + 2, s.length() - 1);
                        }
                }
                return "";
        }

        public File getFolderUpload() {
                File folderUpload = new File(
                                "C:\\Users\\nguye\\OneDrive\\Documents\\NetBeansProjects\\SWP391-SE1623-JS-G6\\web\\image\\blogImage");
                if (!folderUpload.exists()) {
                        folderUpload.mkdirs();
                }
                return folderUpload;
        }

}
