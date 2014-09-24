

package Lahjalista.Servlets;


import Lahjalista.Models.Lahjaehdotus;
import Lahjalista.Models.Yllapitaja;
import java.io.IOException;
import java.io.PrintWriter;
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
        
        //PrintWriter out = response.getWriter();
        
        Lahjaehdotus uusiLahja = new Lahjaehdotus();
        uusiLahja.setNimi(request.getParameter("nimi"));
        uusiLahja.setHinta(request.getParameter("hinta"));
        uusiLahja.setOsoite(request.getParameter("ostoOsoite"));
        
        HttpSession session = request.getSession();
        Yllapitaja kirjautunut = (Yllapitaja)session.getAttribute("kirjautunut");
        uusiLahja.setLisaaja(kirjautunut.getUsername());
        
        uusiLahja.setMaxVaraukset(Integer.parseInt(request.getParameter("maxVaraukset")));
        
        try {
            uusiLahja.lisaaKantaan();
            response.sendRedirect("admin");
        } catch (Exception e) {
        }
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
