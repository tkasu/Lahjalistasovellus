
package Lahjalista.Servlets;

import Lahjalista.Models.Lahjaehdotus;
import Lahjalista.Models.Varaus;
import java.io.IOException;
import javax.servlet.ServletException;
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
            } else if (uusiLahja.getId() != lahjaId && Varaus.etsi(uusiLahja.getId(), varaajaId) != null) { // Onko varaaja jo ennestään varannut uuden lahjan?
                session.setAttribute("ilmoitus", "Virhe! Varaaja on jo varannut ko. lahjan!");
            } else {
                try {
                    varaus.setLahjaId(uusiLahja.getId());
                    varaus.paivitaKantaan(lahjaId, varaajaId);
                    session.setAttribute("ilmoitus", "Varaus päivitetty onnistuneesti.");
                } catch (Exception e) {}
                
            }
        }
        response.sendRedirect("varaukset");
    }
}
