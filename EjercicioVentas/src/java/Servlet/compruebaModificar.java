/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Modelo.DbConnection;
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
public class compruebaModificar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] comerciales=request.getParameterValues("comercial");
        String[] cantidad=request.getParameterValues("cantidad");
        String[] cantidadOriginal=request.getParameterValues("cantidadOriginal");
        String[] fechaCompra=request.getParameterValues("fechaCompra");
        
        RequestDispatcher rd=null;
        ServletContext contexto=getServletContext();
        
        boolean incorrecto=false;
        
        for(int x=0;x<cantidad.length;x++){
            incorrecto=DbConnection.modificarVenta(cantidad[x],cantidadOriginal[x],comerciales[x],fechaCompra[x]);
        }
        
        if(incorrecto==true){
                rd=contexto.getRequestDispatcher("/ventasListado.jsp");
                rd.forward(request, response);
            }else{
                rd=contexto.getRequestDispatcher("/errorCantidad.html");
                rd.forward(request, response);
            }
       
    }

}
