/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Modelo.DbConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José Antonio
 */
public class Registro extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         ServletContext contexto=getServletContext();
            RequestDispatcher rd;
            
            String nombre=request.getParameter("nombre");
            String pass=request.getParameter("pass");
            
            //out.println(pass);
            
            
            if(nombre.equals("admin") && pass.equals("trebujena")){
                rd=contexto.getRequestDispatcher("/registroLibro.jsp");
                rd.forward(request, response);
            }else{
                rd=contexto.getRequestDispatcher("/error.html");
                rd.forward(request, response);
            }
    }
}
