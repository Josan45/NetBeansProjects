
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
        
            String usuario=request.getParameter("usuario");
            //String usuario=(String)getServletContext().setAttribute("usuario");
            String clave=request.getParameter("clave");

            if(usuario.equals("eso") && clave.equals("cdpjosecabreraeso")){

                contexto.setAttribute("usuario", usuario);
                rd=contexto.getRequestDispatcher("/Formulario.html");

                rd.forward(request, response);

            }else if(usuario.equals("sanidad") && clave.equals("cdpjosecabrerasanidad")){

                contexto.setAttribute("usuario", usuario);
                rd=contexto.getRequestDispatcher("/Formulario.html");

                rd.forward(request, response);

            }else if(usuario.equals("cocina") && clave.equals("cdpjosecabreracocina")){

                contexto.setAttribute("usuario", usuario);
                rd=contexto.getRequestDispatcher("/Formulario.html");

                rd.forward(request, response);

            }else if(usuario.equals("informatica") && clave.equals("cdpjosecabrerainformatica")){

                contexto.setAttribute("usuario", usuario);
                rd=contexto.getRequestDispatcher("/Formulario.html");

                rd.forward(request, response);

            }else{

                rd=contexto.getRequestDispatcher("/RespuestaError.html");
                rd.forward(request, response);

            }

                contexto.setAttribute("usuario", usuario);
                rd=contexto.getRequestDispatcher("ControladorActividad");
                rd.forward(request, response);
        
        }
}
