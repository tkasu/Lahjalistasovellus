
package Lahjalista.Servlets;

import Lahjalista.Models.Varaus;
import Lahjalista.Models.Vieras;
import java.io.IOException;
import javax.servlet.ServletException;
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
        
        if (nykyVieras == null) {
            session.setAttribute("ilmoitus", "Lahjan varaus epäonnistui, sähköpostia ei löytynyt kannasta.");
            response.sendRedirect("lahjalista");
        } else {
            Varaus uusiVaraus = new Varaus();
            uusiVaraus.setVaraajaId(nykyVieras.getId());
            
            String lahjaId = request.getParameter("lahja-id");
            uusiVaraus.setLahjaId(Integer.parseInt(lahjaId));
            
            Varaus loytyykoJo = Varaus.etsi(Integer.parseInt(lahjaId), nykyVieras.getId());
            
            if (loytyykoJo != null) {
                session.setAttribute("ilmoitus", "Lahjan varaus epäonnistui, olet jo varannut tämän lahjan!");
                response.sendRedirect("lahjalista");
            } else {
                try {
                    uusiVaraus.lisaaKantaan();
                    String ilmoitus = "Varaus lisätty onnistuneesti!";
                    session.setAttribute("ilmoitus", ilmoitus);    
                    response.sendRedirect("lahjalista");
                } catch (Exception e) {}
            }
            
            
        }
    }
}
