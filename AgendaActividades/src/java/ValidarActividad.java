
import static Lista.lista;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidarActividad extends HttpServlet {
//public static ArrayList<actividades> actividades=new ArrayList();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            ServletContext contexto=getServletContext();
            RequestDispatcher rd;
            
            String nom=request.getParameter("nom");
            String lug=request.getParameter("lug");
            String profe=request.getParameter("profe");
        //String usuario=(String)getServletContext().setAttribute("usuario");
        
        char caracter='0';
        
        for(int x=0; x<nom.length(); x++){
        
            caracter=nom.charAt(x);
            
            if((caracter<'a' || caracter>'z') && (caracter<'A' || caracter>'Z')){
            
                rd=contexto.getRequestDispatcher("/ErrorLetra.html");
                rd.forward(request, response);
                break;
                
            }else{
            
                contexto.setAttribute("nom", nom);
                
            }
            
        }
        
        caracter='0';
        for(int x=0; x<lug.length(); x++){
        
            caracter=lug.charAt(x);
            
            if((caracter<'a' || caracter>'z') && (caracter<'A' || caracter>'Z')){
            
                rd=contexto.getRequestDispatcher("/ErrorLetra.html");
                rd.forward(request, response);
                break;
                
            }else{
            
                contexto.setAttribute("lug", lug);
                
            }
            
        }
        
        caracter='0';
        for(int x=0; x<profe.length(); x++){
        
            caracter=profe.charAt(x);
            
            if((caracter<'a' || caracter>'z') && (caracter<'A' || caracter>'Z')){
            
                rd=contexto.getRequestDispatcher("/ErrorCadena.html");
                rd.forward(request, response);
                break;
                
            }else{
            
                contexto.setAttribute("profe", profe);
                
            }
            
        }
        
        //*****************************************************************************
        
        //******************** Fecha y hora ********************************************
        
        String fec=request.getParameter("fec");
        String hor=request.getParameter("hor");
        
        if(!fec.substring(2,3).equals("/") || !fec.substring(5,6).equals("/") || fec.length()!=10){
        
            rd=contexto.getRequestDispatcher("/ErrorFecha.html");
            rd.forward(request, response);
            
        }else{
        
            contexto.setAttribute("fec", fec);
        }
        
        if(!hor.substring(2,3).equals(":") || hor.length()!=5){
        
            rd=contexto.getRequestDispatcher("/ErrorHora.html");
            rd.forward(request, response);
            
        }else{
        
            contexto.setAttribute("hor", hor);
        }
        
        //********************* Curso  ***************************************
        
        String curso=request.getParameter("curso");
        
        if(curso.equalsIgnoreCase("informatica")){
        
            contexto.setAttribute("curso", curso);
            
        }else if(curso.equalsIgnoreCase("cocina")){
        
            contexto.setAttribute("curso", curso);
            
        }else if(curso.equalsIgnoreCase("enfermeria")){
        
            contexto.setAttribute("curso", curso);
            
        }else if(curso.equalsIgnoreCase("eso")){
        
            contexto.setAttribute("curso", curso);
        }else{
        
            contexto.setAttribute("curso", curso);
        }
        
        //*************************** Destinado ****************************
        
        String destino=request.getParameter("destino");
        
        if(destino.equals("alumno")){
        
            contexto.setAttribute("destino", destino);
        
        }else{
        
            contexto.setAttribute("destino", destino);
        }
        
        //******************* Observaciones y tipo *********************
        
        String texto=request.getParameter("texto");
        
        contexto.setAttribute("texto", texto);
        
        //String[]tipo=(String[]) getServletContext().getAttribute("tipo");
        
        String[]tipo=request.getParameterValues("oc");
        String tipoActividad="";
        
        for(int x=0; x<tipo.length;x++){
            
            if(x==0){
            
                tipoActividad+=tipo[x];
                
            }else{
            
                tipoActividad+=", "+tipo[x];
            }
        
        }
        
        
        ListaActividades actividades=null;
        actividades=new ListaActividades(nom, lug, fec, hor, destino, curso, profe, texto, tipoActividad);
        
        lista.add(actividades);
        
        rd=contexto.getRequestDispatcher("/FormularioActividades.html");
        rd.forward(request, response);
    }
}
