/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lahjalista.Servlets;

import Lahjalista.Models.Lahjaehdotus;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class PoistaServlet extends LahjalistaServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("poista-id"));
        
        Lahjaehdotus lahja = Lahjaehdotus.etsi(id);
        if (lahja == null) {
            session.setAttribute("ilmoitus", "Virhe! Lahjaa ei löytnyt tietokannasta.");
            
        } else {

                try {
                    String tempNimi = lahja.getNimi();
                    lahja.poistaKannasta();
                    String ilmoitus = "Lahjaehdotus '" + tempNimi + "' poistettu onnistuneesti.";
                    session.setAttribute("ilmoitus", ilmoitus);
                    
                } catch (Exception e) {  
                    session.setAttribute("ilmoitus", e.getMessage());
                }
                
               
        }
        response.sendRedirect("admin");
    }
}

    