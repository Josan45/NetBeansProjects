
package Controlador;

import com.sun.corba.se.spi.protocol.RequestDispatcherDefault;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext contexto=request.getServletContext();
        RequestDispatcher rd;
        
        String usuario=request.getParameter("usuario");
        String pass=request.getParameter("pass");
        
        String[] letras={"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
        
        String letra=usuario.substring(8,9);
        String numero=usuario.substring(0,8);
        boolean dni=true;
        
        if(usuario.length()==9){
                
            try{
                int num=Integer.parseInt(numero);
                int letraDNI=num%23;
                
                    if(letras[letraDNI].equals(letra)){
                        dni=true;
                    }else{
                        dni=false;
                    }
            }catch(NumberFormatException e){
                dni=false;
            }
            if(dni==true && pass.equals("trebujena")){
                rd=contexto.getRequestDispatcher("/Formulario.html");
                rd.forward(request, response);
            }else{
                rd=contexto.getRequestDispatcher("/LoginError.html");
                rd.forward(request, response);
            }
        }   
    }
}
