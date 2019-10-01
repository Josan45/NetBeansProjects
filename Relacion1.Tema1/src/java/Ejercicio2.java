import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ejercicio2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String oper1=request.getParameter("oper1");
        String oper2=request.getParameter("oper2");
        String operacion=request.getParameter("operacion");
        
        response.setContentType("text/html");
        
        PrintWriter out=response.getWriter();
        
        
        int num1=Integer.parseInt(oper1);
        int num2=Integer.parseInt(oper2);
        
        if(operacion.equalsIgnoreCase("suma")){
            int suma=num1+num2;
            out.println("<h1>La suma es: "+suma+"</h1>");
        }else if(operacion.equalsIgnoreCase("resta")){
            int resta=num1-num2;
            out.println("<h1>La resta es: "+resta+"</h1>");
        }else if(operacion.equalsIgnoreCase("multiplicar")){
            int multiplicar=num1*num2;
            out.println("<h1>La multiplicación es: "+multiplicar+"</h1>");
        }else if(operacion.equalsIgnoreCase("dividir")){
            int dividir=num1/num2;
            out.println("<h1>La división es: "+dividir+"</h1>");
        }
    }

}
