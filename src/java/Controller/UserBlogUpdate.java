/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.Impl.BlogDaoImpl;
import Dao.Impl.ImageBlogDaoImpl;
//import Dao.Impl.UserDaoImpl;
//import Model.AddressReceiver;
import Model.Blog;
import Model.ImageBlog;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
//import Model.User;
import java.io.File;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.DateFormat;

import java.text.SimpleDateFormat;
//import java.io.OutputStreamWriter;
//import java.io.PrintWriter;
//import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

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
        //lay ra thong tin user
//        UserDaoImpl daoUser = new UserDaoImpl();
//        HttpSession session = request.getSession();
//        User u = (User) session.getAttribute("user");
//      
//        AddressReceiver userInformation = daoUser.getUserById(u.getId());

        int id = Integer.parseInt(request.getParameter("id"));
        BlogDaoImpl daoB = new BlogDaoImpl();
        Blog b = daoB.getWithDate(id);
//        
        request.setAttribute("blog", b);
//        request.setAttribute("userInformation", userInformation);
//       
        request.getRequestDispatcher("/user/blog/blogupdate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        BlogDaoImpl daoB = new BlogDaoImpl();
        ImageBlogDaoImpl imgDaoB = new ImageBlogDaoImpl();
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
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//	Date date = new Date();
//        String curr_date = formatter.format(date);
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
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//	Date date = new Date();
//        String curr_date = formatter.format(date);
        Blog b = new Blog(id, title, description, null, content, date, date);
        daoB.update(b);
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

}
