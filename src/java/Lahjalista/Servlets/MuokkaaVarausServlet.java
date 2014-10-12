/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lahjalista.Servlets;

import Lahjalista.Models.Lahjaehdotus;
import Lahjalista.Models.Varaus;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class MuokkaaVarausServlet extends LahjalistaServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int lahjaId = Integer.parseInt(request.getParameter("lahja-id"));
        int varaajaId = Integer.parseInt(request.getParameter("varaaja-id"));
        
        String lahjaNimi = request.getParameter("lNimi");
        
        Varaus varaus = Varaus.etsi(lahjaId, varaajaId);
        if (varaus == null) {
            session.setAttribute("ilmoitus", "Virhe! Varausta ei löytnyt tietokannasta.");        
        } else {
            Lahjaehdotus uusiLahja = Lahjaehdotus.etsi(lahjaNimi);
            if (uusiLahja == null) {
                session.setAttribute("ilmoitus", "Virhe! Lahjaa ei löytnyt tietokannasta.");
            } else {
                try {
                    varaus.setLahjaId(uusiLahja.getId());
                    varaus.paivitaKantaan(lahjaId, varaajaId);
                    session.setAttribute("ilmoitus", "Varaus päivitetty onnistuneesti.");
                } catch (Exception e) {
                    
                }
                
            }
        }
        response.sendRedirect("varaukset");
    }
}
