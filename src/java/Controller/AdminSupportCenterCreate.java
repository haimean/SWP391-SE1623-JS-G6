/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.Impl.SupportCenterDaolmpl;
import Dao.Impl.TypeSupportCenterDaolmpl;
import Model.SupportCenter;
import Model.TypeSupportCenter;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author PiPi
 */
public class AdminSupportCenterCreate extends HttpServlet {

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
        List<TypeSupportCenter> list;
        TypeSupportCenterDaolmpl db = new TypeSupportCenterDaolmpl();
        list = db.getAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/admin/question/qnaAdd.jsp").forward(request, response);
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
        SupportCenterDaolmpl db = new SupportCenterDaolmpl();
        int typeId = Integer.parseInt(request.getParameter("type"));
        String question = request.getParameter("question");
        String answer = request.getParameter("answer");
        boolean status = db.insert(new SupportCenter(Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()), question, answer, typeId));
        response.sendRedirect(request.getContextPath() + "/admin/qna?status=" + status);
    }

}
