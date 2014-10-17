
package Lahjalista.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class EtusivuServlet extends LahjalistaServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String hakuehto = request.getParameter("hakukentta");
        haeLahjat(hakuehto, request, response);
        haeVirheet(request);
        request.setAttribute("hakuehto", hakuehto);
        naytaJSP("etusivu.jsp", request, response);
    }
    
    
}


