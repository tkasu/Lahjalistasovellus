
package Lahjalista.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminServlet extends LahjalistaServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (onkoKirjautunut(request, response)) {
            String hakuehto = request.getParameter("hakukentta");
            haeLahjat(hakuehto, request, response);
            haeIlmoitus(request);
            haeVirheet(request);
            request.setAttribute("hakuehto", hakuehto);
            
            naytaJSP("adminEtusivu.jsp", request, response);
        } else {
            response.sendRedirect("login");
        }
    }
}
