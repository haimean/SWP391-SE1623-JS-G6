package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/admin/layout/index.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT\" crossorigin=\"anonymous\">\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js\" integrity=\"sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js\" integrity=\"sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write("    .offcanvas-lg{\r\n");
      out.write("        --bs-offcanvas-width: none;\r\n");
      out.write("        --bs-offcanvas-border-width: 0px;\r\n");
      out.write("        --bs-offcanvas-padding-x: 0;\r\n");
      out.write("        --bs-offcanvas-padding-y: 0;\r\n");
      out.write("    }\r\n");
      out.write("    a{\r\n");
      out.write("        text-decoration: none;\r\n");
      out.write("        color: black\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("<nav class=\"navbar  fixed-top bg-secondary\">\r\n");
      out.write("    <div class=\"container-fluid\">\r\n");
      out.write("        <div class=\"d-flex align-items-center\">\r\n");
      out.write("            <button class=\"btn d-lg-none\" type=\"button\" data-bs-toggle=\"offcanvas\" data-bs-target=\"#offcanvasResponsive\" aria-controls=\"offcanvasResponsive\">\r\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("            </button>\r\n");
      out.write("            <a class=\"\" href=\"\"><h3>Admin</h3></a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <ul class=\"nav nav-pills\">\r\n");
      out.write("            <li class=\"nav-item dropdown\">\r\n");
      out.write("                <a class=\" dropdown-toggle\" data-bs-toggle=\"dropdown\" href=\"#\" role=\"button\" aria-expanded=\"false\">email@gmail.com</a>\r\n");
      out.write("                <ul class=\"dropdown-menu\">\r\n");
      out.write("                    <li><a class=\"dropdown-item\" href=\"");
      out.print( request.getContextPath());
      out.write("/admin/logout\">Logout</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>\r\n");
      out.write("<div class=\"offcanvas-lg offcanvas-start \" tabindex=\"-1\" id=\"offcanvasResponsive\" aria-labelledby=\"offcanvasResponsiveLabel\">\r\n");
      out.write("    <div class=\"offcanvas-body  bg-secondary\" style=\"\r\n");
      out.write("         float: left;\r\n");
      out.write("         height: 100pc;\r\n");
      out.write("         padding-top: 56px\"\r\n");
      out.write("         >\r\n");
      out.write("        <ul class=\"list-group  list-group-flush  bg-secondary\">\r\n");
      out.write("            <li class=\"list-group-item  bg-secondary\"><a href=\"");
      out.print( request.getContextPath());
      out.write("/admin\"> <h4>Dashboard</h3></a></li>\r\n");
      out.write("            <li class=\"list-group-item  bg-secondary\"><a href=\"");
      out.print( request.getContextPath());
      out.write("/admin/category\"> <h4>Category</h3></a></li>\r\n");
      out.write("            <li class=\"list-group-item  bg-secondary\"><a href=\"");
      out.print( request.getContextPath());
      out.write("/admin/user\"> <h4>User</h3></a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"content-wrap\">\r\n");
      out.write("    <div class=\"main\">\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("            <section id=\"main-content\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-lg-3\">\r\n");
      out.write("                        <div class=\"card\">\r\n");
      out.write("                            <div class=\"stat-widget-one\">\r\n");
      out.write("                                <div class=\"stat-icon dib\"><i class=\"ti-money color-success border-success\"></i>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"stat-content dib\">\r\n");
      out.write("                                    <div class=\"stat-text\">Total Profit</div>\r\n");
      out.write("                                    <div class=\"stat-digit\">1,012</div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-lg-3\">\r\n");
      out.write("                        <div class=\"card\">\r\n");
      out.write("                            <div class=\"stat-widget-one\">\r\n");
      out.write("                                <div class=\"stat-icon dib\"><i class=\"ti-user color-primary border-primary\"></i>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"stat-content dib\">\r\n");
      out.write("                                    <div class=\"stat-text\">New Customer</div>\r\n");
      out.write("                                    <div class=\"stat-digit\">961</div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-lg-3\">\r\n");
      out.write("                        <div class=\"card\">\r\n");
      out.write("                            <div class=\"stat-widget-one\">\r\n");
      out.write("                                <div class=\"stat-icon dib\"><i class=\"ti-layout-grid2 color-pink border-pink\"></i>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"stat-content dib\">\r\n");
      out.write("                                    <div class=\"stat-text\">Active Projects</div>\r\n");
      out.write("                                    <div class=\"stat-digit\">770</div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-lg-3\">\r\n");
      out.write("                        <div class=\"card\">\r\n");
      out.write("                            <div class=\"stat-widget-one\">\r\n");
      out.write("                                <div class=\"stat-icon dib\"><i class=\"ti-link color-danger border-danger\"></i></div>\r\n");
      out.write("                                <div class=\"stat-content dib\">\r\n");
      out.write("                                    <div class=\"stat-text\">Referral</div>\r\n");
      out.write("                                    <div class=\"stat-digit\">2,781</div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </section>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
