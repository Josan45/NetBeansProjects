import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ejercicio1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
          String nombre=request.getParameter("nombre");
        
        response.setContentType("text/html");
        
        PrintWriter out=response.getWriter();
        
        out.println("<html>");
        out.println("<head><title>Ejercicio 1</title></head>");
        out.println("<body>");
        out.println("<h1>"+getServletName()+"</h1>");
        DateFormat dfEspañol=DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG,Locale.getDefault());
        
        out.println("<h3>Fehca: "+dfEspañol.format(new Date())+"</h3>");
        out.println("</body>");
        out.println("</html>");
    }
}
