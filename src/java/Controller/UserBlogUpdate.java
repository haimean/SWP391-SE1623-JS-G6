/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.Impl.BlogDaoImpl;
import Dao.Impl.UserDaoImpl;
import Model.AddressReceiver;
//import Dao.Impl.UserDaoImpl;
import Model.Blog;
import Model.User;
//import Model.User;
import java.io.File;
import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.io.PrintWriter;
import java.util.ArrayList;
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
        Blog b = daoB.get(id);
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
        //Get parameter
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String content = request.getParameter("content");
//        Part part = request.getPart("image");
//        String realPath = request.getServletContext().getRealPath("/image");
//        String filename = 
        
        //Update image
//        String fileName = null;
//        
//         for (Part part : request.getParts()) {
//      fileName = extractFileName(part);
//      // refines the fileName in case it is an absolute path
//      fileName = new File(fileName).getName();
//      part.write(this.getFolderUpload().getAbsolutePath() + File.separator + fileName);
//    }

        //Update title, content and description
        BlogDaoImpl daoB = new BlogDaoImpl();
        Blog b = new Blog(id, title, description, content);
        daoB.update(b);
        
        
//        
        Blog bRemove = null;
        ArrayList<Blog> listB = daoB.getTop3Blog();
        for (Blog blog : listB) {
            if(b.getId() == blog.getId()){
                bRemove = blog;
            }
        }
        listB.remove(bRemove);
        if(listB.size() > 3){
            listB.remove(3);
        }
        request.setAttribute("listB", listB);
        request.setAttribute("blog", b);
        request.setAttribute("lstzsize", listB.size() - 1);
        request.getRequestDispatcher("blogdetails.jsp").forward(request, response);
//response.sendRedirect(request.getContextPath()+ "/user/blog");
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
    File folderUpload = new File("C:\\Users\\nguye\\OneDrive\\Documents\\NetBeansProjects\\SWP391-SE1623-JS-G6\\web\\image\\blogImage");
    if (!folderUpload.exists()) {
      folderUpload.mkdirs();
    }
    return folderUpload;
    }

}
