/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.text.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author José Antonio
 */
public class ServletSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        int visitas=1;
        long fecha;
        HttpSession sesion=request.getSession();
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
        out.println("<head><title>Ejemplo sencillo que emplea sesiones</title></head>");
        out.println("<body>");
        out.println("Id de sesion:"+sesion.getId());
            if(sesion.isNew()){
                out.println("La sesion es nueva");
            }else{
                out.println("La sesion no es nueva");
            }
        out.println("Hora creacion sesion:"+formatoFecha.format(fechaC));
        out.println("Hora ultimo acceso:"+formatoFecha.format(fechaA));
        out.println("Numero de accesos:"+visitas);
        out.println("<form action='/Sesiones/cerrarSesion'>");
        out.println("<input type='submit' value='Cerrar sesion'><p>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");

    }
}