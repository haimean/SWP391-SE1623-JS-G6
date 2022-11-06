/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.Impl.BlogDaoImpl;
import Dao.Impl.ImageBlogDaoImpl;
import Model.Blog;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

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
        String description = request.getParameter("description");
        String content = request.getParameter("content");
        Part filePart = request.getPart("image");
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
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//	Date date = new Date();
   
        Blog b = new Blog(title, description, geturl, content);
        daoB.insert(b);        
        int id = daoB.getIdByTitle(b.getTitle());        
        Blog b1 = new Blog(id, title, description, geturl, content);
        daoB.insertIntoImageBlog(b1);
        request.getRequestDispatcher("bloglist.jsp").forward(request, response);
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
