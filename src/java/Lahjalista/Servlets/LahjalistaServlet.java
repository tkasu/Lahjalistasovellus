/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Lahjalista.Servlets;

import Lahjalista.Models.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    
    protected void haeLahjat(String hakuehto, HttpServletRequest request, HttpServletResponse response) {
        List<Lahjaehdotus> lahjat = null;
        HttpSession session = request.getSession();
        if (hakuehto == null) {
            hakuehto = "";
        }
        try {
            lahjat = Lahjaehdotus.getKaikkiLahjat(hakuehto);
        } catch (Exception e) {
            session.setAttribute("ilmoitus", e.getMessage());
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
    
    protected void haeVirheet(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Collection<String> virheet = (Collection)session.getAttribute("virheet");
        
        if (virheet != null) {
            session.removeAttribute("virheet");
            request.setAttribute("virheet", virheet);
        }
    }

}
