/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class Controlador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            ServletContext contexto=getServletContext();
            RequestDispatcher rd;
            
            String nom=request.getParameter("nom");
            String apel=request.getParameter("apel");
            String ciu=request.getParameter("ciu");
            String sex=request.getParameter("sex");
            String pais=request.getParameter("pais");
            
            
            try{
                String tel=request.getParameter("tel");
                int num = Integer.parseInt(tel);
            
                if(nom.equals("") || apel.equals("") || ciu.equals("") || tel.length()!=9){
                    rd=contexto.getRequestDispatcher("/CamposVacios.html");
                    rd.forward(request, response);
                }else{
                    rd=contexto.getNamedDispatcher("DatosEncuesta");
                    rd.forward(request, response); 
                }
            }catch(NumberFormatException e){
                rd=contexto.getRequestDispatcher("/CamposVacios.html");
                rd.forward(request, response);
        }
            
    }
}
