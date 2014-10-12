
package Lahjalista.Servlets;

import Lahjalista.Models.Varaus;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class PoistaVarausServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int lahjaId = Integer.parseInt(request.getParameter("poista-lahja-id"));
        int varaajaId = Integer.parseInt(request.getParameter("poista-varaaja-id"));
        
        Varaus varaus = Varaus.etsi(lahjaId, varaajaId);
        if (varaus == null) {
            session.setAttribute("ilmoitus", "Virhe! Lahjaa ei löytnyt tietokannasta.");        
        } else {
            try {
                varaus.poistaKannasta();
                String ilmoitus = "Varaus poistettu onnistuneesti.";
                session.setAttribute("ilmoitus", ilmoitus);
                    
            } catch (Exception e) {  
                session.setAttribute("ilmoitus", e.getMessage());
            }
        }
        response.sendRedirect("varaukset");
    }

}
