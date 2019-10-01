package PrimerServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormularioServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String nom=request.getParameter("nombre");
        String tef=request.getParameter("telefono");
        String lugNaci=request.getParameter("lugar de nacimiento");
        
        response.setContentType("text/html");
        
        PrintWriter out=response.getWriter();
        
        out.println("<html>");
        out.println("<head><title>Datos introducidos por Formulario</title></head>");
        out.println("<body>");
        out.println("<h1>DATOS INTRODUCIDOS</h1>");
        out.println("<table border=\"5\">");
        out.println("<tr><td><b>NOMBRE:<b></td><td><i>"+nom+"</i></td></tr>");
        out.println("<tr><td><b>TELEFONO:<b></td><td><i>"+tef+"</i></td></tr>");
        out.println("<tr><td><b>LUGAR NACIMIENTO:<b></td><td><i>"+lugNaci+"</i></td></tr>");
        out.println("</table><p>");
        out.println("</body>");
        out.println("</html>");
        
    }
}