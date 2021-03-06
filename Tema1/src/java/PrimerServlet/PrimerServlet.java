package PrimerServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PrimerServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PrimerServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre=request.getParameter("nombre");
        
        response.setContentType("text/html");
        
        PrintWriter out=response.getWriter();
        
        out.println("<html>");
        out.println("<head><title>Primer servlet</title></head>");
        out.println("<body>");
        out.println("<h1>Hola, "+nombre+"</h1>");
        out.println("<h1>"+getServletName()+" funcionando</h1>");
        DateFormat dfEspañol=DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG,Locale.getDefault());
        
        out.println("<h3>Fehca: "+dfEspañol.format(new Date())+"</h3>");
        out.println("Este es un servlet muy sencillo");
        out.println("</body>");
        out.println("</html>");
        
        
        //processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
