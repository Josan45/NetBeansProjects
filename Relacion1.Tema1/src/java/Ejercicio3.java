import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ejercicio3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        
        PrintWriter out=response.getWriter();
        
        String protocolo=request.getProtocol();
        String ip=request.getRemoteAddr();
        String mime=request.getContentType();
        String cadena=request.getQueryString();
        String rutaUriP=request.getRequestURI();
        StringBuffer url=request.getRequestURL();
        String rutaUriS=request.getServletPath();
        String encabezado=request.getHeader(mime);
        
        out.println("<h1>"+protocolo+"</h1>");
        out.println("<h1>"+ip+"</h1>");
        out.println("<h1>"+mime+"</h1>");
        out.println("<h1>"+cadena+"</h1>");
        out.println("<h1>"+rutaUriP+"</h1>");
        out.println("<h1>"+url+"</h1>");
        out.println("<h1>"+rutaUriS+"</h1>");
        out.println("<h1>"+encabezado+"</h1>");
    }

}
