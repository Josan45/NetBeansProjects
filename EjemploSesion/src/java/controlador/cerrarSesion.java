/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author José Antonio
 */
public class cerrarSesion extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        HttpSession sesion=request.getSession();
        sesion.invalidate();
        
        out.println("<html>");
        out.println("<head><title>Sesiones</title></head>");
        out.println("<body>");
        out.println("Sesion Cerrada<p>");
        out.println("<a href='sesion'>Inicio</a>");
        out.println("</body>");
        out.println("</html>");
    }
}