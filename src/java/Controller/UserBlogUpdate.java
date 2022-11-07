/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.Impl.BlogDaoImpl;
import Model.Blog;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
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
        Blog b = daoB.getWithDate(id);      
        request.setAttribute("blog", b);     
        request.getRequestDispatcher("/user/blog/blogupdate.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        BlogDaoImpl daoB = new BlogDaoImpl();
        //Get and Set Image
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "ddrjnfihc",
                "api_key", "295827132792413",
                "api_secret", "SyPzR-EcBnCG-BSQ5298s4MC9LE"));
        cloudinary.config.secure = true;
        //Get parameter
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String content = request.getParameter("content");
        String date = request.getParameter("date");
        Part filePart = request.getPart("image");
        if(filePart.getSize() != 0){
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        filePart.write(request.getRealPath("image") + fileName);
        Map path = ObjectUtils.asMap(
                "public_id", "Home/Images/Blog/" + fileName,
                "overwrite", true,
                "resource_type", "image"
        );
        Map uploadResult = cloudinary.uploader().upload(request.getRealPath("image") + fileName, path);
        filePart.delete();
        String geturl = uploadResult.get("secure_url").toString();

        //Update title, content, image and description
        Blog b = new Blog(id, title, description, geturl, content, date, date);
        daoB.update(b);
        daoB.delete(b.getId());
        daoB.insertIntoImageBlog(b);
        //
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
        

        //Update title, content, image and description
        Blog b = new Blog(id, title, description, null, content, date, date);
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
        Blog b1 = daoB.getWithDate2(b.getId());
        request.setAttribute("listB", listB);
        request.setAttribute("blog", b1);
        request.setAttribute("lstzsize", listB.size() - 1);
        request.getRequestDispatcher("blogdetails.jsp").forward(request, response);

    }

}
