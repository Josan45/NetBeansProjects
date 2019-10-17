
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ComprobarDatos extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        ServletContext contexto=getServletContext();
        RequestDispatcher rd;
        try{
        String venta=request.getParameter("venta");
        double vent=Double.parseDouble(venta);
        
        String entregado=request.getParameter("entregado");
        double entre=Double.parseDouble(entregado);
        
        contexto.setAttribute("entregado", entregado);
        contexto.setAttribute("venta", venta);
        }catch(NumberFormatException e){
            rd=contexto.getRequestDispatcher("/ErrorDatos.html");
            rd.forward(request, response);
        }
        
        rd=contexto.getRequestDispatcher("/Calculadora");
        rd.forward(request, response);
    }
}