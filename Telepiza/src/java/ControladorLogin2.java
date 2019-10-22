
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorLogin2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext contexto=getServletContext();
        RequestDispatcher rd;
            
        String user=request.getParameter("user");
        String pass=request.getParameter("pass");
        
        if(user.equals("cliente") && pass.equals("cliente") ){
            rd=contexto.getRequestDispatcher("/FormularioCliente.html");
            rd.forward(request, response);
        }else{
            rd=contexto.getRequestDispatcher("/DatosErroneos.html");
            rd.forward(request, response); 
        }
    }
}
