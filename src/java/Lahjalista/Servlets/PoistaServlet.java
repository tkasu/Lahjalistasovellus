
package Lahjalista.Servlets;

import Lahjalista.Models.Lahjaehdotus;
import Lahjalista.Models.Varaus;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class PoistaServlet extends LahjalistaServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("poista-id"));
        List<Varaus> varatut = Varaus.etsiLahjalla(id);
        
        Lahjaehdotus lahja = Lahjaehdotus.etsi(id);
        if (lahja == null) {
            session.setAttribute("ilmoitus", "Virhe! Lahjaa ei löytnyt tietokannasta.");
        } else if (varatut.size() != 0) {
            session.setAttribute("ilmoitus", "Virhe! Lahjalta löytyi varauksia, poista ensin varaukset!");
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

    