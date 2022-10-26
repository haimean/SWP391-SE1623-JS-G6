/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ControllerAdmin;

import DAO.DAOQuestion;
import Model.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author PiPi
 */
enum Mode {
    NORMAL,
    UPDATE
}

public class AdminQuestionUpdate extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminQuestionUpdate</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminQuestionUpdate at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        processRequest(request, response);
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
        ArrayList<TypeSupportCenter> list = null;
        DAOQuestion db = new DAOQuestion();
        String modeParam = request.getParameter("mode");
        if ((modeParam.equals(Mode.NORMAL.toString()))) {
            int id = Integer.parseInt(request.getParameter("id"));
            list = db.getAllQnaType();
            SupportCenter sc = db.getQnaById(id);
            request.setAttribute("list", list);
            request.setAttribute("sc", sc);
            request.getRequestDispatcher("/admin/question/qnaUpdate.jsp").forward(request, response);
        }
        if ((modeParam.equals(Mode.UPDATE.toString()))) {
            int id = Integer.parseInt(request.getParameter("id"));
            int typeId = Integer.parseInt(request.getParameter("type"));
            String question = request.getParameter("question");
            String answer = request.getParameter("answer");
            String status = db.update(id, typeId, question, answer);
            response.sendRedirect(request.getContextPath() + "/admin/qna?status=" + status);
        }
    }

}
