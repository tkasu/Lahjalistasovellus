/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lahjalista.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tkasu
 */
public class VarauksetServlet extends LahjalistaServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (onkoKirjautunut(request, response)) {
            String hakuehto = request.getParameter("hakukentta");
            haeVaraukset(hakuehto, request, response);
            request.setAttribute("hakuehto", hakuehto);
            naytaJSP("varaukset.jsp", request, response);
        } else {
            response.sendRedirect("login");
        }
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    
}
