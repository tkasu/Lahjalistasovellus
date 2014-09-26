/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Lahjalista.Servlets;

import Lahjalista.Models.Lahjaehdotus;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminServlet extends LahjalistaServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (onkoKirjautunut(request, response)) {
            haeLahjat(request, response);
            haeIlmoitus(request);
            naytaJSP("adminEtusivu.jsp", request, response);
        } else {
            response.sendRedirect("login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            int id = Integer.parseInt(request.getParameter("lahja-id"));
            Lahjaehdotus lahja = Lahjaehdotus.etsi(id);
            out.println(id);
        } catch (Exception e) {
            
        }
        
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
