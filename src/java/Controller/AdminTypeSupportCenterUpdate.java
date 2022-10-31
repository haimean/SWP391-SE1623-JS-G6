/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.Impl.TypeSupportCenterDaolmpl;
import Model.TypeSupportCenter;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author PiPi
 */
public class AdminTypeSupportCenterUpdate extends HttpServlet {

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
        TypeSupportCenterDaolmpl db = new TypeSupportCenterDaolmpl();
        String modeParam = request.getParameter("mode");
        if (modeParam.equals("NORMAL")) {
            int id = Integer.parseInt(request.getParameter("id"));
            TypeSupportCenter tsc = db.get(id);
            request.setAttribute("tsc", tsc);
            request.getRequestDispatcher("/admin/question-type/qnaTypeUpdate.jsp").forward(request, response);
        }
        if (modeParam.equals("UPDATE")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            boolean status = db.update(new TypeSupportCenter(id, name, Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now())));
            response.sendRedirect(request.getContextPath() + "/admin/qna-type?status=" + status);
        }
    }

}
