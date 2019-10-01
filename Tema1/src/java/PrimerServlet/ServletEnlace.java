package PrimerServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletEnlace extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        response.setContentType("text/html");
        
        PrintWriter out=response.getWriter();
        
        out.println("<html>");
        out.println("<head><title>ServletEnlace</title></head>");
        out.println("<body bgcolor=\"green\">");
        out.println("<h2> Vienes de pulsar el enlace \"Pulsame\"</h2>");
        out.println("<img src=\"/>");
        out.println("</body>");
        out.println("</html>");
    }
}
