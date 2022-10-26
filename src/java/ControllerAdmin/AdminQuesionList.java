/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ControllerAdmin;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Model.*;
import DAO.*;
import java.util.ArrayList;

/**
 *
 * @author PiPi
 */
public class AdminQuesionList extends HttpServlet {

    public void paginate(ArrayList<SupportCenter> list, DAOQuestion db, HttpServletRequest request, HttpServletResponse response, String mode, String... searchValue)
            throws ServletException, IOException {
        final int recordsPerPage = 3;
        int index;
        String indexParam = request.getParameter("page");
        if (indexParam == null) {
            indexParam = "1";
        }

        if (Integer.parseInt(indexParam) == 0) {
            indexParam = "1";
        }

        try {
            index = Integer.parseInt(indexParam);
        } catch (Exception e) {
            index = 1;
        }
        int totalPage = db.getTotalQna();
        int endPage = totalPage / recordsPerPage;

        if (totalPage % recordsPerPage != 0) {
            endPage++;
        }

        if (index > endPage) {
            index = endPage;
        }

        if (mode.equals("SEARCH")) {
            totalPage = db.getTotalQnaSearch(searchValue[0]);
            endPage = totalPage / recordsPerPage;

            if (totalPage % recordsPerPage != 0) {
                endPage++;
            }

            if (index > endPage) {
                index = endPage;
            }
            list = db.searchQna(searchValue[0], index);
            request.setAttribute("tag", index);
            request.setAttribute("listQna", list);
            request.setAttribute("endP", endPage);
            request.setAttribute("search", searchValue[0]);
            request.getRequestDispatcher("/admin/question/qnaSearch.jsp").forward(request, response);

        } else {
            String status = request.getParameter("status");
            list = db.paginate(index);
            request.setAttribute("status", status);
            request.setAttribute("tag", index);
            request.setAttribute("listQna", list);
            request.setAttribute("endP", endPage);
            request.getRequestDispatcher("/admin/question/index.jsp").forward(request, response);
        }
    }

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
        DAOQuestion db = new DAOQuestion();
        String modeParam = request.getParameter("mode");
        ArrayList<SupportCenter> list = null;

        if (modeParam == null) {
            paginate(list, db, request, response, "NORMAL");
        } else if ((modeParam.equals("SEARCH"))) {
            String searchValue = request.getParameter("search");
            paginate(list, db, request, response, "SEARCH", searchValue);
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
        ArrayList<SupportCenter> list = null;
        DAOQuestion db = new DAOQuestion();
        String modeParam = request.getParameter("mode");

        if ((modeParam.equals("SEARCH"))) {
            String searchValue = request.getParameter("search");
            paginate(list, db, request, response, "SEARCH", searchValue);
        }
        if ((modeParam.equals("DELETE"))) {
            String id = request.getParameter("id");
            db.deleteQna(Integer.parseInt(id));
            paginate(list, db, request, response, "DELETE");
        }
    }
}
