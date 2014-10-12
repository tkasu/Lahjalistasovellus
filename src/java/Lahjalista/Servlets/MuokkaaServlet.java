
package Lahjalista.Servlets;

import Lahjalista.Models.Lahjaehdotus;
import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class MuokkaaServlet extends LahjalistaServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("lahja-id"));

        Lahjaehdotus lahja = Lahjaehdotus.etsi(id);
        
        if (lahja == null) {
            session.setAttribute("virheIlmoitus", "Virhe! Lahjaa ei löytnyt tietokannasta.");
        } else {
            lahja.setNimi(request.getParameter("nimi"));
            lahja.setHinta(request.getParameter("hinta"));
            lahja.setMaxVaraukset(request.getParameter("maxVaraukset"));
            lahja.setOsoite(request.getParameter("osoite"));

            if (lahja.onkoKelvollinen()) {
                try {
                    lahja.paivitaKantaan();
                    String ilmoitus = "Lahjaehdotus '" + lahja.getNimi() + "' päivitetty onnistuneesti.";
                    session.setAttribute("ilmoitus", ilmoitus);

                } catch (Exception e) {
                    session.setAttribute("ilmoitus", e.getMessage());
                }

                

            } else {
                Collection<String> virheet = lahja.getVirheet();
                session.setAttribute("ilmoitus", "Lahjan muokkaus epäonnistui:");
                session.setAttribute("virheet", virheet);
            }

        }
        
        response.sendRedirect("admin");
        //out.println(lahja);
    }

}
