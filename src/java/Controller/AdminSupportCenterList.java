/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.Impl.SupportCenterDaolmpl;
import Model.SupportCenter;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author PiPi
 */
@WebServlet(name = "AdminSupportCenterList", urlPatterns = {"/admin/qna"})
public class AdminSupportCenterList extends HttpServlet {

    public void paginate(ArrayList<SupportCenter> list, SupportCenterDaolmpl db, HttpServletRequest request, HttpServletResponse response, String mode, String... searchValue)
            throws ServletException, IOException {
        final int RECORD_PER_PAGE = 4;
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
        } catch (NumberFormatException e) {
            index = 1;
        }
        int totalPage = db.getTotalQna();
        int endPage = totalPage / RECORD_PER_PAGE;

        if (totalPage % RECORD_PER_PAGE != 0) {
            endPage++;
        }

        if (index > endPage) {
            index = endPage;
        }

        if (mode.equals("SEARCH")) {
            totalPage = db.getTotalQnaSearch(searchValue[0]);
            endPage = totalPage / RECORD_PER_PAGE;

            if (totalPage % RECORD_PER_PAGE != 0) {
                endPage++;
            }

            if (index > endPage) {
                index = endPage;
            }
            list = db.searchQna(searchValue[0], index);
            request.setAttribute("tag", index);
            request.setAttribute("listQna", list);
            request.setAttribute("size", list.size());
            request.setAttribute("endP", endPage);
            request.setAttribute("search", searchValue[0]);
            request.getRequestDispatcher("/admin/question/qnaSearch.jsp").forward(request, response);

        } else if (mode.equals("DELETE")) {
            String id = request.getParameter("id");
            boolean status = db.delete(Integer.parseInt(id));
            list = db.paginate(index);
            request.setAttribute("tag", index);
            request.setAttribute("listQna", list);
            request.setAttribute("endP", endPage);
            request.setAttribute("status", status);
            request.getRequestDispatcher("/admin/question/index.jsp").forward(request, response);
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
        SupportCenterDaolmpl db = new SupportCenterDaolmpl();
        String modeParam = request.getParameter("mode");
        ArrayList<SupportCenter> list = null;

        if (modeParam == null) {
            paginate(list, db, request, response, "NORMAL");
        } else if ((modeParam.equals("SEARCH"))) {
            String searchValue = request.getParameter("search").trim();
            paginate(list, db, request, response, "SEARCH", searchValue);
        }
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
        SupportCenterDaolmpl db = new SupportCenterDaolmpl();
        String modeParam = request.getParameter("mode");

        if ((modeParam.equals("SEARCH"))) {
            String searchValue = request.getParameter("search").trim();
            paginate(list, db, request, response, "SEARCH", searchValue);
        }
        if ((modeParam.equals("DELETE"))) {
            paginate(list, db, request, response, "DELETE");
        }
    }

}
