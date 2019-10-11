
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            ServletContext contexto=getServletContext();
            RequestDispatcher rd;
            
            String usu=request.getParameter("usu");
            String pass=request.getParameter("pass");
            
            
                if((usu.equals("eso") && pass.equals("cdpjosecabreraeso")) || (usu.equals("sanidad") && pass.equals("cdpjosecabrerasanidad"))
                    || (usu.equals("cocina") && pass.equals("cdpjosecabreracocina")) || (usu.equals("informatica") && pass.equals("cdpjosecabrerainformatica"))){
                    rd=contexto.getRequestDispatcher("/FormularioActividades.html");
                    rd.forward(request, response);
                }else{
                    rd=contexto.getRequestDispatcher("/DatosErroneos.html");
                    rd.forward(request, response); 
                }
    }
}
