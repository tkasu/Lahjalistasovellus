

package Lahjalista.Servlets;

import Lahjalista.Models.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class KirjautumisServlet extends LahjalistaServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        naytaJSP("Kirjautuminen.jsp", request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String salasana = request.getParameter("password");
        String kayttajatunnus = request.getParameter("username");
        HttpSession session = request.getSession();
        Yllapitaja kayttaja = null;
        
        try {
            kayttaja = Yllapitaja.etsiYllapitajaTunnuksilla(kayttajatunnus, salasana);
        } catch (Exception e) {
            System.out.println(e.getMessage());
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

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
