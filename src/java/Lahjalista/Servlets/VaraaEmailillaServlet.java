/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lahjalista.Servlets;

import Lahjalista.Models.Varaus;
import Lahjalista.Models.Vieras;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class VaraaEmailillaServlet extends LahjalistaServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(); 
        String email = request.getParameter("email");
        
        Vieras nykyVieras = Vieras.etsiEmaililla(email);
        
        if (nykyVieras != null) {
            Varaus uusiVaraus = new Varaus();
            uusiVaraus.setVaraajaId(nykyVieras.getId());
            
            String lahjaId = request.getParameter("lahja-id");
            uusiVaraus.setLahjaId(Integer.parseInt(lahjaId));
            
            try {
                uusiVaraus.lisaaKantaan();
                String ilmoitus = "Varaus lisätty onnistuneesti!";
                session.setAttribute("ilmoitus", ilmoitus);    
                response.sendRedirect("lahjalista");
            } catch (Exception e) {
            
            }
        } else {
            session.setAttribute("ilmoitus", "Lahjan varaus epäonnistui, sähköpostia ei löytynyt kannasta.");
            response.sendRedirect("lahjalista");
        }
    }
}
