import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calculadora extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            ServletContext contexto=getServletContext();
            RequestDispatcher rd;
            
        try{
            String num=request.getParameter("num");
            int numero=Integer.parseInt(num);
            
            if(numero>=1 && numero<=20){
                
                contexto.setAttribute("numero_valido", numero);
                rd=contexto.getNamedDispatcher("Tablas");
                rd.forward(request, response); 
                
            }else{
                rd=contexto.getRequestDispatcher("/ErrorNumero.html");
                rd.forward(request, response);
            }
        }catch(NumberFormatException e){
            rd=contexto.getRequestDispatcher("/ErrorNumero.html");
            rd.forward(request, response);
        }
        
    }
}
