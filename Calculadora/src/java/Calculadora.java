
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calculadora extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        
        ServletContext contexto= getServletContext();
        
        String venta = (String) getServletContext().getAttribute("venta");
        double imp = Double.parseDouble(venta);
        String entregado = (String) getServletContext().getAttribute("entregado");
        double cant = Double.parseDouble(entregado);
         
        double total=cant-imp;
        DecimalFormat formato1 = new DecimalFormat("#.00");
       
        int billete5 = 0;int billete10 = 0;int billete20 = 0;int billete50 = 0;
        int moneda1e = 0;int moneda50 = 0; int moneda20 = 0;int moneda10 = 0;int moneda5 = 0;int moneda2 = 0;int moneda1 = 0;
        
        out.println("<html>");
            out.println("<head>");
            out.println("<title>Calculadora</title>");
                out.println("<style>");
                out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Devolucion: "+formato1.format(total)+"</h3>");
            
            do {
            
                if (total >= 50) {
                    total = total - 50;
                    billete50++;
                }
                
                if (total >= 20) {
                    total = total - 20;
                    billete20++;
                }
                
                if (total >= 10) {
                    total = total - 10;
                    billete10++;
                }
                
                if (total >= 5) {
                    total = total - 5;
                    billete5++;
                }
            
                if (total >= 1) {
                    total = total - 1;
                    moneda1e++;
                }
            
                if (total >= 0.5) {
                    total = total - 0.5;
                    moneda50++;       
                }
            
                if (total >= 0.2) {
                    total = total - 0.2;
                    moneda20++;        
                }
              
                if (total >= 0.10) {
                    total = total - 0.10;
                    moneda10++;  
                }
                
                if (total >= 0.05) {
                    total = total - 0.05;
                    moneda5++;  
                }
                
                if (total >= 0.02) {
                    total= total - 0.02;
                    moneda2++;  
                }
                
                if (total >= 0.01) {
                    total = total - 0.01;
                    moneda1++;  
                }
        } while (total > 0.001);
         
                out.println("<h4> Billetes de 50euro: "+billete50+"</h4>");
                out.println("<h4> Billetes de 20euro: "+billete20+"</h4>");
                out.println("<h4> Billetes de 10euro: "+billete10+"</h4>");
                out.println("<h4> Billetes de 5euro: "+billete5+"</h4>");
                out.println("<h4> Monedas de 1euro: "+moneda1e+"</h4>");
                out.println("<h4> Monedas de 50cent: "+moneda50+"</h4>");
                out.println("<h4> Monedas de 20cent: "+moneda20+"</h4>");
                out.println("<h4> Monedas de 10cent: "+moneda10+"</h4>");
                out.println("<h4> Monedas de 5cent: "+moneda5+"</h4>");
                out.println("<h4> Monedas de 2cent: "+moneda2+"</h4>");
                out.println("<h4> Monedas de 1cent: "+moneda1+"</h4>");
            out.println("</body>");
        out.println("</html>");
                        
        
    }
}