

package Lahjalista.Servlets;


import Lahjalista.Models.Lahjaehdotus;
import Lahjalista.Models.Yllapitaja;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LisaaServlet extends LahjalistaServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (onkoKirjautunut(request, response)) {
            naytaJSP("lisaaLahja.jsp", request, response);
        } else {
            response.sendRedirect("login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//        PrintWriter out = response.getWriter();
        
        Lahjaehdotus uusiLahja = new Lahjaehdotus();
        uusiLahja.setNimi(request.getParameter("nimi"));
        uusiLahja.setHinta(request.getParameter("hinta"));
        uusiLahja.setOsoite(request.getParameter("ostoOsoite"));
        
        HttpSession session = request.getSession();
        Yllapitaja kirjautunut = (Yllapitaja)session.getAttribute("kirjautunut");
        uusiLahja.setLisaaja(kirjautunut.getUsername());
        
        uusiLahja.setMaxVaraukset(request.getParameter("maxVaraukset"));
        
//        Collection<String> virheet = uusiLahja.getVirheet();
//        
//        for (String virhe : virheet) {
//            out.println(virhe);
//        }
//        
//        out.println("onkoKelvollinen = " + uusiLahja.onkoKelvollinen());
        
        if (uusiLahja.onkoKelvollinen()) {
            try {
                uusiLahja.lisaaKantaan();
                String ilmoitus = "Lahjaehdotus '" + uusiLahja.getNimi() + "' lisätty onnistuneesti.";
                session.setAttribute("ilmoitus", ilmoitus);
                
                response.sendRedirect("admin");
            } catch (Exception e) {
            }
        } else {
            Collection<String> virheet = uusiLahja.getVirheet();
            
            request.setAttribute("virheet", virheet);
            request.setAttribute("lahja", uusiLahja);
            
            naytaJSP("lisaaLahja.jsp", request, response);
        }
        
        
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
