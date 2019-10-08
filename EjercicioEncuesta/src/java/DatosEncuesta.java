import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DatosEncuesta extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom=request.getParameter("nom");
        String apel=request.getParameter("apel");
        String tel=request.getParameter("tel");
        String ciu=request.getParameter("ciu");
        String sex=request.getParameter("sex");
        String pais=request.getParameter("pais");
        String texto=request.getParameter("texto");
        
        response.setContentType("text/html");
        if(sex.equals("Hombre")){
            
            PrintWriter out=response.getWriter();
        
            out.println("<html>");
            out.println("<head><meta charset=\"UTF-8\"><title>Datos introducidos por Formulario</title></head>");
            out.println("<style> .nombre{color:red} body{background-color:cyan}</style>");
            out.println("<body>");
            out.println("<h1>DATOS ENCUESTA</h1>");
            out.println("<h2 class=nombre>Hola "+nom+"</h2>");
            out.println("<table border=\"5\">");
            out.println("<tr><td><b>Nombre:<b></td><td><i>"+nom+"</i></td></tr>");
            out.println("<tr><td><b>Apellidos:<b></td><td><i>"+apel+"</i></td></tr>");
            out.println("<tr><td><b>Telefono:<b></td><td><i>"+tel+"</i></td></tr>");
            out.println("<tr><td><b>Lugar de Nacimiento:<b></td><td><i>"+ciu+"</i></td></tr>");
            out.println("<tr><td><b>Sexo:<b></td><td><i>"+sex+"</i></td></tr>");
            out.println("<tr><td><b>Pais de Origen:<b></td><td><i>"+pais+"</i></td></tr>");
        
            if(texto.equals("")){
                out.println("<tr><td>Area de Texto:<b></td><td>No tengo ningun comentario que mostrar</td></tr");
            }else{  
                out.println("<tr><td>Area de Texto:<b></td><td>"+texto+"</td></tr>");
            }
            out.println("</table><br>");
            out.println("<h4>"+nom+" tus actividades de ocio son: </h4>");
            String[] casilla=request.getParameterValues("oc");
            out.println("<table border=\"5\">");
        
            for(int x=0;x<casilla.length;x++){
                out.println("<tr><td>"+casilla[x]+"</td></tr>");
            }
            out.println("</table>"); 
            out.println("<br><a href=tomcat.gif>Sorpresa</a>");       
            out.println("</html>");
   
            }else{
            PrintWriter out=response.getWriter();
        
            out.println("<html>");
            out.println("<head><meta charset=\"UTF-8\"><title>Datos introducidos por Formulario</title></head>");
            out.println("<style> .nombre{color:red} body{background-color:pink}</style>");
            out.println("<body>");
            out.println("<h1>DATOS ENCUESTA</h1>");
            out.println("<h2 class=nombre>Hola "+nom+"</h2>");
            out.println("<table border=\"5\">");
            out.println("<tr><td><b>Nombre:<b></td><td><i>"+nom+"</i></td></tr>");
            out.println("<tr><td><b>Apellidos:<b></td><td><i>"+apel+"</i></td></tr>");
            out.println("<tr><td><b>Telefono:<b></td><td><i>"+tel+"</i></td></tr>");
            out.println("<tr><td><b>Lugar de Nacimiento:<b></td><td><i>"+ciu+"</i></td></tr>");
            out.println("<tr><td><b>Sexo:<b></td><td><i>"+sex+"</i></td></tr>");
            out.println("<tr><td><b>Pais de Origen:<b></td><td><i>"+pais+"</i></td></tr>");
            if(texto.equals("")){
                out.println("<tr><td>Area de Texto:<b></td><td>No tengo ningun comentario que mostrar</td></tr");
            }else{  
                out.println("<tr><td>Area de Texto:<b></td><td>"+texto+"</td></tr>");
            }
            out.println("</table><br>");
            out.println("<h4>"+nom+" tus actividades de ocio son: </h4>");
            String[] casilla=request.getParameterValues("oc");
            out.println("<table border=\"5\">");

            for(int x=0;x<casilla.length;x++){
                out.println("<tr><td>"+casilla[x]+"</td></tr>");
            }
            out.println("</table>"); 
            out.println("<br><a href=taza.gif>Sorpresa</a>");       
            out.println("</html>");
        }
        
    }
}
