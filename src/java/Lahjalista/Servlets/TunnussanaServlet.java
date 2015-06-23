/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Lahjalista.Servlets;

import Lahjalista.Models.Tunnussana;
import Lahjalista.Models.Yllapitaja;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class TunnussanaServlet extends LahjalistaServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            HttpSession session = request.getSession();
            haeVirheet(request);
            
            naytaJSP("tunnussivu.jsp", request, response);                
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String tunnussana = request.getParameter("tunnussana");
        boolean oikeaSana = false;
        
        try {
            oikeaSana = Tunnussana.oikeaTunnussana(tunnussana);
        } catch (Exception e) {
            session.setAttribute("ilmoitus", e.getMessage());
        }
                
        if (oikeaSana == true) {
            response.sendRedirect("lahjalista");
            session.setAttribute("tunnistautunut", true);
        } else {
            request.setAttribute("errorViesti","Tunnistautuminen epäonnistui");
          
            naytaJSP("tunnussivu.jsp", request, response);
        }
    }
}
