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
        
        out.println(protocolo);
        out.println(ip);
        out.println(mime);
        out.println(cadena);
    }

}
