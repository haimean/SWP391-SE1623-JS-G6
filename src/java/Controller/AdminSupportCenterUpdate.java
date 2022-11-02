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
import java.util.List;

/**
 *
 * @author PiPi
 */
public class AdminSupportCenterUpdate extends HttpServlet {

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
        List<TypeSupportCenter> list;
        TypeSupportCenterDaolmpl db = new TypeSupportCenterDaolmpl();
        SupportCenterDaolmpl db1 = new SupportCenterDaolmpl();
        String modeParam = request.getParameter("mode");
        if (modeParam.equals("NORMAL")) {
            int id = Integer.parseInt(request.getParameter("id"));
            list = db.getAll();
            SupportCenter sc = db1.get(id);
            request.setAttribute("list", list);
            request.setAttribute("sc", sc);
            request.getRequestDispatcher("/admin/question/qnaUpdate.jsp").forward(request, response);
        }
        if (modeParam.equals("UPDATE")) {
            int id = Integer.parseInt(request.getParameter("id"));
            int typeId = Integer.parseInt(request.getParameter("type"));
            String question = request.getParameter("question");
            String answer = request.getParameter("answer");
            boolean status = db1.update(new SupportCenter(id, question, answer, typeId));
            response.sendRedirect(request.getContextPath() + "/admin/qna?status=" + status);
        }
    }
}
