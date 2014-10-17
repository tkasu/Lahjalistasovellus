

package Lahjalista.Servlets;

import Lahjalista.Models.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class KirjautumisServlet extends LahjalistaServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (onkoKirjautunut(request, response)) {
            response.sendRedirect("admin");
        } else {
            naytaJSP("Kirjautuminen.jsp", request, response);
        }
                
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String salasana = request.getParameter("password");
        String kayttajatunnus = request.getParameter("username");
        
        Yllapitaja kayttaja = null;
        
        try {
            kayttaja = Yllapitaja.etsiYllapitajaTunnuksilla(kayttajatunnus, salasana);
        } catch (Exception e) {
            session.setAttribute("ilmoitus", e.getMessage());
        }
                
        if (kayttaja != null) {
            response.sendRedirect("admin");
            session.setAttribute("kirjautunut", kayttaja);
        } else {
            request.setAttribute("errorViesti","Kirjautuminen epäonnistui, tarkista käyttäjätunnus ja salasana.");
           
            request.setAttribute("kayttaja", kayttajatunnus);
            naytaJSP("Kirjautuminen.jsp", request, response);
        }
    }
}