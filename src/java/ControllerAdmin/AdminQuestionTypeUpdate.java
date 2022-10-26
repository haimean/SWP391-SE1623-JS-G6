package ControllerAdmin;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import DAO.DAOQuestionType;
import Model.TypeSupportCenter;
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

public class AdminQuestionTypeUpdate extends HttpServlet {

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
            out.println("<title>Servlet AdminQuestionTypeUpdate</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminQuestionTypeUpdate at " + request.getContextPath() + "</h1>");
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
        DAOQuestionType db = new DAOQuestionType();
        String modeParam = request.getParameter("mode");
        if ((modeParam.equals(Mode.NORMAL.toString()))) {
            int id = Integer.parseInt(request.getParameter("id"));
            TypeSupportCenter tsc = db.getQnaTypeById(id);
            request.setAttribute("tsc", tsc);
            request.getRequestDispatcher("/admin/question-type/qnaTypeUpdate.jsp").forward(request, response);
        }
        if ((modeParam.equals(Mode.UPDATE.toString()))) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String status = db.update(id, name);
            response.sendRedirect(request.getContextPath() + "/admin/qna-type?status=" + status);
        }
    }
}
