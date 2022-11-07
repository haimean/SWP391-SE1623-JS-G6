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
import java.io.PrintWriter;
import java.nio.file.Paths;
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
public class UserBlogCreate extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
        String title = request.getParameter("title");
        title.trim();
        String description = request.getParameter("description");
        String content = request.getParameter("content");
        Part filePart = request.getPart("image");
        if(filePart.getSize() == 0){
             Blog b = new Blog(title, description, null, content);
        daoB.insert(b);        
        int id = daoB.getIdByTitle(b.getTitle());        
        Blog b1 = new Blog(id, title, description, null, content);
        daoB.insertIntoImageBlog(b1);
response.sendRedirect(request.getContextPath()  +  "/user/blog");        }
        else{
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
        Blog b = new Blog(title, description, geturl, content);
        daoB.insert(b);        
        int id = daoB.getIdByTitle(b.getTitle());        
        Blog b1 = new Blog(id, title, description, geturl, content);
        daoB.insertIntoImageBlog(b1);
        response.sendRedirect(request.getContextPath()  +  "/user/blog");
        }
       
    }
}
