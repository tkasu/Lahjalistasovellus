
package Lahjalista.Servlets;

import Lahjalista.Models.Varaus;
import Lahjalista.Models.Vieras;
import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class VaraaServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(); 
        
        Vieras uusiVieras = new Vieras();
        String varaaja = request.getParameter("nimi");
        String puhNro = request.getParameter("numero");
        String email = request.getParameter("email");
        uusiVieras.setNimi(varaaja);
        uusiVieras.setPuhNro(puhNro);
        uusiVieras.setEmail(email);
        
        if (uusiVieras.onkoKelvollinen()) {
            uusiVieras.lisaaKantaan();
        } else {
            Collection<String> virheet = uusiVieras.getVirheet();           
            session.setAttribute("ilmoitus", "Lahjan varaus epäonnistui:");
            session.setAttribute("virheet", virheet);
            response.sendRedirect("lahjalista");
        }
        
        Varaus uusiVaraus = new Varaus();
        uusiVaraus.setVaraajaId(uusiVieras.getId());
        
        String lahjaId = request.getParameter("lahja-id");
        uusiVaraus.setLahjaId(Integer.parseInt(lahjaId));
        
        try {
            uusiVaraus.lisaaKantaan();
            String ilmoitus = "Varaus lisätty onnistuneesti!";
            session.setAttribute("ilmoitus", ilmoitus);    
            response.sendRedirect("lahjalista");
        } catch (Exception e) {
            
        }
    }

}
