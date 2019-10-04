import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Tablas extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String op=request.getParameter("op");
        String num=request.getParameter("num");
        int numero=Integer.parseInt(num);
        long factorial=1;
        
        response.setContentType("text/html");
        
        PrintWriter out=response.getWriter();
        
            if(op.equals("mult")){
                out.println("<html>");
                out.println("<head><title>Tabla de multiplicar de"+numero+"</title></head>");
                out.println("<body>");
                out.println("<h1 text align=center>Tabla de multiplicar de "+numero+"</h1>");
                out.println("<table align=center>");
                    for(int x=1;x<21;x++){
                        out.println("<tr>");
                        out.println("<td>"+numero+"*"+x+"="+numero*x+"</td>");
                        out.println("<tr>");
                    }
                out.println("</table>");
                out.println("</body>");
                out.println("</html>");
            }
        
            if(op.equals("div")){
                out.println("<html>");
                out.println("<head><title>Tabla de dividir de "+numero+"</title></head>");
                out.println("<body>");
                out.println("<h1 align=center>Tabla de dividir de "+numero+"</h1>");
                out.println("<table align=center>");
                    for(int x=1;x<21;x++){
                        out.println("<tr>");
                        out.println("<td>"+numero+"/"+x+"="+numero/x+"</td>");
                        out.println("<tr>");
                    }
                out.println("</table>");
                out.println("</body>");
                out.println("</html>");
            }
        
            if(op.equals("fac")){
                out.println("<html>");
                out.println("<head><title>Tabla de Factorial de "+numero+"</title></head>");
                out.println("<body>");
                out.println("<h1 align=center>Table de Factorial de "+numero+"</h1>");
                out.println("<table align=center>");
                    for(int x=1;x<numero;x++){
                        for (int i = numero; i > 0; i--) {
                            factorial = factorial * i;
                        }
                        out.println("<tr>");
                        out.println("<td>"+numero+"!="+x+"="+factorial+"</td>");
                        out.println("<tr>");
                    }
                out.println("</table>");
                out.println("</body>");
                out.println("</html>");
            }
    }
}