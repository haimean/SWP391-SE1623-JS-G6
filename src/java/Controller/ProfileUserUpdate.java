/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.Impl.UserInformationDaoImpl;
import Model.User;
import Model.UserInformation;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.nio.file.Paths;
import java.util.Map;

/**
 *
 * @author MrTuan
 */
@MultipartConfig
public class ProfileUserUpdate extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath());
        } else {
            UserInformationDaoImpl userInformationDaoImpl = new UserInformationDaoImpl();
            UserInformation userinf = userInformationDaoImpl.get(user.getId());
            request.setAttribute("userinf", userinf);
            request.getRequestDispatcher("/user/profile/ProfileUpdate.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath());
        } else {
            Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                    "cloud_name", "ddrjnfihc",
                    "api_key", "295827132792413",
                    "api_secret", "SyPzR-EcBnCG-BSQ5298s4MC9LE"));
            cloudinary.config.secure = true;
            UserInformationDaoImpl userInformationDaoImpl = new UserInformationDaoImpl();
            String fullname = request.getParameter("fullName");
            String gender = request.getParameter("gender");
            String biography = request.getParameter("biography");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            Part filePart = request.getPart("image");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            filePart.write(request.getRealPath("image") + fileName);
            Map path = ObjectUtils.asMap(
                    "public_id", "Home/Images/UserProfile/" + user.getId(),
                    "overwrite", true,
                    "resource_type", "image"
            );
            Map uploadResult = cloudinary.uploader().upload(request.getRealPath("image") + fileName, path);
            filePart.delete();
            String geturl = uploadResult.get("secure_url").toString();
            boolean status = userInformationDaoImpl.updateProfile(user.getId(), fullname,geturl, gender, biography, address, city);
            UserInformation userInf = userInformationDaoImpl.get(user.getId());
            request.setAttribute("status", status);
            request.setAttribute("userinf", userInf);
            request.setAttribute("urlimage", geturl);
            request.getRequestDispatcher("/user/profile/Profile.jsp").forward(request, response);
        }

    }

}
