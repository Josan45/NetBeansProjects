
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidarActividad extends HttpServlet {
public static ArrayList<actividades> actividades=new ArrayList();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            ServletContext contexto=getServletContext();
            RequestDispatcher rd;
        
                String nom=request.getParameter("nom");
                
                if(Pattern.matches("[a-zA-Z]", nom)){
                    rd=contexto.getRequestDispatcher("AñadirActividad");
                    rd.forward(request, response);
                }else{
                    rd=contexto.getRequestDispatcher("/ActividadErronea.html");
                    rd.forward(request, response);
                }
    }
}
