package org.apache.jsp.html_002ddemo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Kirjautuminen_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    \n");
      out.write("    <link href=\"../css/bootstrap.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"../css/bootstrap-theme.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"../css/main.css\" rel=\"stylesheet\">\n");
      out.write("   \n");
      out.write("    \n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Admin kirjautuminen</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <ul class=\"nav nav-tabs\">\n");
      out.write("            <li class=\"passive\"><a href=\"../html-demo/etusivu.jsp\">Lahjalista</a></li>\n");
      out.write("            <li class=\"active\"><a href=\"#\">Admin Sign In</a></li>\n");
      out.write("        </ul>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <h1>Admin-kirjautuminen</h1>\n");
      out.write("            <form class=\"form-horizontal\" role=\"form\" action=\"lomake.html\" method=\"POST\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"inputUsername\" class=\"col-md-2 control-label\">Käyttäjätunnus</label>\n");
      out.write("                    <div class=\"col-md-10\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"Username\" placeholder=\"Username\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"inputPassword1\" class=\"col-md-2 control-label\">Salasana</label>\n");
      out.write("                    <div class=\"col-md-10\">\n");
      out.write("                        <input type=\"password\" class=\"form-control\" id=\"inputPassword1\" name=\"password\" placeholder=\"Password\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <div class=\"col-md-offset-2 col-md-10\">\n");
      out.write("                        <div class=\"checkbox\">\n");
      out.write("                            <label>\n");
      out.write("                                <input type=\"checkbox\"> Muista kirjautuminen\n");
      out.write("                            </label>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <div class=\"col-md-offset-2 col-md-10\">\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-default\">Kirjaudu sisään</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
