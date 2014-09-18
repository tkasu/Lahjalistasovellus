package Lahjalista.Servlets;


import Lahjalista.Models.Tietokanta;
import Lahjalista.Models.Vieras;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


import java.io.IOException;
import java.io.PrintWriter;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import javax.naming.NamingException;
import java.sql.SQLException;


public class ListaServlet extends HttpServlet {
    
    private Connection yhteys;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        PrintWriter out = response.getWriter();
        
        try {
            Tietokanta kanta = new Tietokanta();
            yhteys = kanta.getYhteys();
        } catch (Exception e) {
            out.println("Yhteysvirhe: " + e.getMessage());
        }
       
        
        
        try {
            Vieras testi = new Vieras(1, "a", "b", "c");
            List<Vieras> vieraat = testi.getVieraat();
            
            for (Vieras vieras : vieraat) {
                out.println(vieras);
            }
            
            
          
            
        } catch (Exception e) {
          out.println("KyselyVirhe: " + e.getMessage()); 
        }
        try {
            yhteys.close();
        } catch (Exception e) {
            out.println("SQL:n sulkuvirhe: " + e.getMessage());
        }
      }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
