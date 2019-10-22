
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Dispatch;


public class ControladosLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext contexto=getServletContext();
        RequestDispatcher rd;
        
        String usuario=request.getParameter("user");
        String pass=request.getParameter("pass");
        
        if((usuario.equals("eso") && pass.equals("cdpeso")) || usuario.equals("cocina") && pass.equals("cdpcocina")){
            rd=contexto.getRequestDispatcher("/Formulario.html");
            rd.forward(request, response); 
        }else{
            rd=contexto.getRequestDispatcher("/LoginIncorrecto.html");
            rd.forward(request, response); 
        }

    }
}
