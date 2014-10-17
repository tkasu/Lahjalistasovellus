
package Lahjalista.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VarauksetServlet extends LahjalistaServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (onkoKirjautunut(request, response)) {
            String hakuehto = request.getParameter("hakukentta");
            haeVaraukset(hakuehto, request, response);
            request.setAttribute("hakuehto", hakuehto);
            naytaJSP("varaukset.jsp", request, response);
        } else {
            response.sendRedirect("login");
        }
        
    }
    
}
