/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class ControlarDatos extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext contexto=getServletContext();
        RequestDispatcher rd;
        
        String nombre=request.getParameter("nombre");
        String lugar=request.getParameter("lugar");
        String profe=request.getParameter("profe");
        
        if(nombre.equals("")){
            rd=contexto.getRequestDispatcher("/DatosIncorrectos.html");
            rd.forward(request, response); 
        }else{
            contexto.setAttribute("nombre", nombre);
        }
        
        if(lugar.equals("")){
            rd=contexto.getRequestDispatcher("/DatosIncorrectos.html");
            rd.forward(request, response); 
        }else{
            contexto.setAttribute("lugar", lugar);
        }
        
        if(profe.equals("")){
            rd=contexto.getRequestDispatcher("/DatosIncorrectos.html");
            rd.forward(request, response); 
        }else{
            contexto.setAttribute("profe", profe);
        }
        
        char caracter='0';
        for(int x=0;x<nombre.length();x++){
            caracter=nombre.charAt(x);
            
            if((caracter<'A' || caracter>'Z') && (caracter<'a' || caracter>'z')){
                rd=contexto.getRequestDispatcher("/ErrorLetra.html");
                rd.forward(request, response); 
            }else{
                contexto.setAttribute("nombre", nombre);
            }
        }
        
        caracter='0';
        for(int x=0;x<lugar.length();x++){
            caracter=lugar.charAt(x);
            
            if((caracter<'A' || caracter>'Z') && (caracter<'a' || caracter>'z')){
                rd=contexto.getRequestDispatcher("/ErrorLetra.html");
                rd.forward(request, response); 
            }else{
                contexto.setAttribute("lugar", lugar);
            }
        }
        
        caracter='0';
        for(int x=0;x<profe.length();x++){
            caracter=profe.charAt(x);
            
            if((caracter<'A' || caracter>'Z') && (caracter<'a' || caracter>'z')){
                rd=contexto.getRequestDispatcher("/ErrorLetra.html");
                rd.forward(request, response); 
            }else{
                
            }
        }
        
        String fecha=request.getParameter("fecha");
        Date datefecha=null;
        java.sql.Date sqlfecha=null;
        SimpleDateFormat formateador=new SimpleDateFormat("dd/MM/yyyy");
        formateador.setLenient(false);
        boolean fechabien=true;
        try {
            datefecha=formateador.parse(fecha);
        } catch (ParseException ex) {
                rd=contexto.getRequestDispatcher("/ErrorFecha.html");
                rd.forward(request, response);
                fechabien=false;
        }
        if(fechabien){
           contexto.setAttribute("fecha", fecha); 
        }
        
        
        fechabien=true;
        String hora=request.getParameter("hora");
        Date datehora=null;
        SimpleDateFormat formateadorhora=new SimpleDateFormat("HH:mm");
        formateador.setLenient(false);
        try {
            datehora=formateadorhora.parse(hora);
        } catch (ParseException ex) {
                rd=contexto.getRequestDispatcher("/ErrorHora.html");
                rd.forward(request, response);
                fechabien=false;
        }
        if(fechabien){
          contexto.setAttribute("hora", hora);  
        }
    }
}