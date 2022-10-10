/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.DAOUser;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.User;

/**
 *
 * @author MrTuan
 */
public class LoginController extends HttpServlet {

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
            out.println("<title>Servlet LoginController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
<<<<<<< HEAD
            
=======
>>>>>>> dev
        }
    }

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
	// + sign on the left to edit the code.">
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
<<<<<<< HEAD
        response.sendRedirect("login.jsp");
        
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            LoginDBContext db = new LoginDBContext();
=======
        DAOUser db = new DAOUser();
>>>>>>> dev

        HttpSession session = request.getSession();

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = null;
        try {
<<<<<<< HEAD
            user = db.search(email, password);
        } catch (Exception ex) {
            Logger.getLogger(LoginDBContext.class.getName()).log(Level.SEVERE, null, ex);
=======
            user = db.login(email, password);
        } catch (Exception ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
>>>>>>> dev
        }
        //login
        if (user == null) {
            String noti = "Incorrect user name or password,please try again";
            request.setAttribute("noti", noti);
<<<<<<< HEAD
            response.sendRedirect("./login/login.jsp");
=======
            response.sendRedirect("Login.jsp");
>>>>>>> dev
        } else {
            int type = user.getRole();
            request.getSession().setMaxInactiveInterval(600);

            switch (type) {
                case 1:
                    session.setAttribute("email", email);
                    session.setAttribute("user", user);
                    response.sendRedirect("adminProfile");
                    request.getSession().setMaxInactiveInterval(600);

                    break;

                case 2:
                    session.setAttribute("email", email);
                    session.setAttribute("user", user);
                    response.sendRedirect("sellerProfile");
                    request.getSession().setMaxInactiveInterval(600);

                    break;
                case 3:
                    session.setAttribute("email", email);
                    session.setAttribute("user", user);
                    response.sendRedirect("customerProfile");
                    request.getSession().setMaxInactiveInterval(600);

                    break;
                default:
                    throw new AssertionError();
            }
            }
        }

	/**
	 * <<<<<<< HEAD
	 * =======
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
		processRequest(request, response);
	}

	/**
	 * >>>>>>> dev
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo

	() {
		return "Short description";
	}// </editor-fold>

}
