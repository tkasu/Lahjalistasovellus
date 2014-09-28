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



public class EtusivuServlet extends LahjalistaServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String hakuehto = request.getParameter("hakukentta");
        haeLahjat(hakuehto, request, response);
        haeVirheet(request);
        request.setAttribute("hakuehto", hakuehto);
        naytaJSP("etusivu.jsp", request, response);
    }
    
    
}


