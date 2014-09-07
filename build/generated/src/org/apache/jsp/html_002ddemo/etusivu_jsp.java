package org.apache.jsp.html_002ddemo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class etusivu_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    \n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Lahjalista</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <ul class=\"nav nav-tabs\">\n");
      out.write("            <li class=\"active\"><a href=\"#\">Lahjalista</a></li>\n");
      out.write("            <li class=\"passive\"><a href=\"../html-demo/Kirjautuminen.jsp\">Admin Sign In</a></li>\n");
      out.write("        </ul>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <h1>Tervetuloa!</h1>\n");
      out.write("            <p>Tervetuloa X:n ja Y:n lahjanvaraussivustolle! \n");
      out.write("                Alla olevasta listasta voitte selata ja varata lahjaehdotuksia\n");
      out.write("                Kysymyksissä ja ongelmatilanteissa ota yhteyttä x@y.z.</p>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <br />\n");
      out.write("            <br />\n");
      out.write("            <br />\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <div class=\"panel panel-default\">\n");
      out.write("                 \n");
      out.write("                <div class=\"panel-heading\">Lahjaehdotukset</div>\n");
      out.write("                </div>             \n");
      out.write("             \n");
      out.write("                <table class=\"table\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>nimi</td>\n");
      out.write("                            <th>hinta</td>\n");
      out.write("                            <th>varauksia jäljellä</td>\n");
      out.write("                            <th>Varaus</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>lahja1</td>\n");
      out.write("                            <td>10e</td>\n");
      out.write("                            <td>2/10</td>\n");
      out.write("                            <td><button type=\"button\" class=\"btn-default\">Varaa</button></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>lahja2</td>\n");
      out.write("                            <td>20e</td>\n");
      out.write("                            <td>0/1</td>\n");
      out.write("                            <td><button type=\"button\" class=\"btn-default\">Varaa</button></td>\n");
      out.write("                        </tr>\n");
      out.write("                    </tbody>\n");
      out.write("                    \n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("            \n");
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
