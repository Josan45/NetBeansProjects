/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author José Antonio
 */
public class ServletCerrarSession extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        HttpSession sesion=request.getSession();
        sesion.invalidate();
        
        out.println("<html>");
        out.println("<head><title>Sesiones</title></head>");
        out.println("<body>");
        out.println("Sesion Cerrada");
        out.println("a href='sesion'>Inicio</a>");
        out.println("</body>");
        out.println("</html>");
    }
}