
import Modelo.ListaPedidos;
import Modelo.Listado;
import com.sun.corba.se.spi.protocol.RequestDispatcherDefault;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static Modelo.Listado.lista;
/**
 *
 * @author José Antonio
 */
public class DatosPedido extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext contexto=getServletContext();
        RequestDispatcher rd;
        
        String nombre=request.getParameter("nombre");
        String apellidos=request.getParameter("apellidos");
        
        char caracter='0';
        
        for(int x=0;x<nombre.length();x++){
            caracter=nombre.charAt(x);
            
            if((caracter<'a' || caracter>'z') && (caracter<'A' || caracter>'Z')){
                rd=contexto.getRequestDispatcher("PedidoErroneo.html");
                rd.forward(request, response);
            }else{
                contexto.setAttribute("nombre", nombre);
            }
        }
        
        caracter='0';
        
        for(int x=0;x<apellidos.length();x++){
            caracter=apellidos.charAt(x);
            
            if((caracter<'a' || caracter>'z') && (caracter<'A' || caracter>'Z')){
                rd=contexto.getRequestDispatcher("PedidoErroneo.html");
                rd.forward(request, response);
            }else{
                contexto.setAttribute("apellidos", apellidos);
            }
        }
        
        String masa=request.getParameter("masa");
        
        if(masa.equalsIgnoreCase("normal")){
        
            contexto.setAttribute("masa", masa);
            
        }else if(masa.equalsIgnoreCase("gorda")){
        
            contexto.setAttribute("masa", masa);
            
        }else if(masa.equalsIgnoreCase("fina")){
        
            contexto.setAttribute("masa", masa);
            
        }else{
            contexto.setAttribute("masa", masa);
        }
        
        String texto=request.getParameter("texto");
        
        contexto.setAttribute("texto", texto);
        
        String[]ing=request.getParameterValues("ing");
        String tipoPedido="";
        
        for(int x=0; x<ing.length;x++){
            
            if(x==0){
            
                tipoPedido+=ing[x];
                
            }else{
            
                tipoPedido+=", "+ing[x];
            }
        
        }
        
        ListaPedidos pedidos=null;
        pedidos=new ListaPedidos(nombre, apellidos, tipoPedido, texto, masa);
        
        lista.add(pedidos);
        
        rd=contexto.getRequestDispatcher("/FormularioCliente.html");
        rd.forward(request, response);
    }
}