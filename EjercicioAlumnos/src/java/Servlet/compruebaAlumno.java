/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
public class compruebaAlumno extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext contexto=getServletContext();
        RequestDispatcher rd;
            
        String nombre=request.getParameter("nombre");
        String apellidos=request.getParameter("apellidos");
        String dawes=request.getParameter("dawes");
        String dawec=request.getParameter("dawec");
        String diw=request.getParameter("diw");
        String daw=request.getParameter("daw");
        String fct=request.getParameter("fct");
        String proyecto=request.getParameter("proyecto");
        
        if(dawes.equals("aprobado") || dawes.equals("suspenso") || dawes.equals("no presentado")){
            rd=contexto.getRequestDispatcher("/nuevoAlumno.jsp");
            rd.forward(request, response);
        }else{
            rd=contexto.getRequestDispatcher("/errorDatos.html");
            rd.forward(request, response); 
        }
        
        if(dawec.equals("aprobado") || dawec.equals("suspenso") || dawec.equals("no presentado")){
            rd=contexto.getRequestDispatcher("/nuevoAlumno.jsp");
            rd.forward(request, response);
        }else{
            rd=contexto.getRequestDispatcher("/errorDatos.html");
            rd.forward(request, response); 
        }
        
        if(diw.equals("aprobado") || diw.equals("suspenso") || diw.equals("no presentado")){
            rd=contexto.getRequestDispatcher("/nuevoAlumno.jsp");
            rd.forward(request, response);
        }else{
            rd=contexto.getRequestDispatcher("/errorDatos.html");
            rd.forward(request, response); 
        }
        
        if(daw.equals("aprobado") || daw.equals("suspenso") || daw.equals("no presentado")){
            rd=contexto.getRequestDispatcher("/nuevoAlumno.jsp");
            rd.forward(request, response);
        }else{
            rd=contexto.getRequestDispatcher("/errorDatos.html");
            rd.forward(request, response); 
        }
        
        if(fct.equals("aprobado") || fct.equals("suspenso") || fct.equals("no presentado")){
            rd=contexto.getRequestDispatcher("/nuevoAlumno.jsp");
            rd.forward(request, response);
        }else{
            rd=contexto.getRequestDispatcher("/errorDatos.html");
            rd.forward(request, response); 
        }
        
        if(proyecto.equals("aprobado") || proyecto.equals("suspenso") || proyecto.equals("pendiente")){
            rd=contexto.getRequestDispatcher("/nuevoAlumno.jsp");
            rd.forward(request, response);
        }else{
            rd=contexto.getRequestDispatcher("/errorDatos.html");
            rd.forward(request, response); 
        }
    }
}
