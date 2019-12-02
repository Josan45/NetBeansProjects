/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author José Antonio
 */
public class ServletSesion extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        int visitas=1;
        long fecha;
        HttpSession sesion = request.getSession();
        sesion.setMaxInactiveInterval(60);
        
        if(sesion.getAttribute("visitas")==null){
            sesion.setAttribute("visitas", visitas);
        }else{
            visitas=Integer.parseInt(sesion.getAttribute("visitas").toString());
            visitas++;
            sesion.setAttribute("visitas", visitas);
        }
        
        fecha=sesion.getCreationTime();
        Date fechaC=new Date(fecha);
        
        SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
        fecha=sesion.getLastAccessedTime();
        
        Date fechaA=new Date(fecha);
        out.println("<html>");
        out.println("<head><title>Sesiones</title></head>");
        out.println("<body>");
        out.println("ID: <b>"+sesion.getId()+"</b><br>");
        if(sesion.isNew()){
           out.println("La sesion es nueva <br>"); 
        }else{
            out.println("La sesion no es nueva <br>");
        }
        out.println("Visitas: "+visitas+"<br>");
        out.println("Fecha Creacion: "+formatoFecha.format(fechaC)+"<br>");
        out.println("Ultimo Acceso: "+formatoFecha.format(fechaA)+"<br>");
        
        out.println("<form method='post' action='cerrarSesion'>");
        out.println("<input type='submit' value='Cerrar Sesion'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        
    }
}