/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Lahjalista.Servlets;

import Lahjalista.Models.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;


public class LahjalistaServlet extends HttpServlet {
    
    protected void naytaJSP(String osoite, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(osoite);
        dispatcher.forward(request, response);
    }
    
    protected boolean onkoKirjautunut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Yllapitaja kirjautunut = (Yllapitaja)session.getAttribute("kirjautunut");
        if (kirjautunut != null) {
            return true;
        }
        
        return false;
    }
    
    protected void haeLahjat(HttpServletRequest request, HttpServletResponse response) {
        List<Lahjaehdotus> lahjat = null;
        try {
            lahjat = Lahjaehdotus.getKaikkiLahjat();
        } catch (Exception e) {
            e.getMessage();
        }
        request.setAttribute("lahjat", lahjat);
    }
    
    protected void haeIlmoitus(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String ilmoitus = (String)session.getAttribute("ilmoitus");
        
        if (ilmoitus != null) {
            session.removeAttribute("ilmoitus");
            request.setAttribute("ilmoitus", ilmoitus);
        }
    }

}
