
package Controlador;

import Modelo.Listado;
import Modelo.ListaParte;
import static Modelo.Listado.lista;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlDatos extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext contexto=request.getServletContext();
        RequestDispatcher rd;
        
        String nombre=request.getParameter("nombre");
        String apellido1=request.getParameter("apellido1");
        String apellido2=request.getParameter("apellido2");
        String fecIng=request.getParameter("fecIng");
        String fecNac=request.getParameter("fecNac");
        String nss=request.getParameter("nss");
        String cif=request.getParameter("cif");
        String razsoc=request.getParameter("razsoc");
        String ccc=request.getParameter("ccc");
        String texto=request.getParameter("texto");
        
        
        if(nombre.equals("") || apellido1.equals("") || apellido2.equals("") || nss.equals("") || cif.equals("") ||
           razsoc.equals("") || ccc.equals("")|| fecIng.equals("")|| fecNac.equals("")){
            rd=contexto.getRequestDispatcher("/CamposVacios.html");
            rd.forward(request, response);
        }else{
            contexto.setAttribute("nombre", nombre);
            contexto.setAttribute("apellido1", apellido1);
            contexto.setAttribute("apellido2", apellido2);
            contexto.setAttribute("razsoc", razsoc);
            contexto.setAttribute("ccc", ccc);
            contexto.setAttribute("texto", texto);
            contexto.setAttribute("nss", nss);
        }
        
        boolean fechabien=true;
        Date datefecha=null;
        SimpleDateFormat formateador=new SimpleDateFormat("dd/MM/yyyy");
        formateador.setLenient(false);
        
        try {
            datefecha=formateador.parse(fecIng);
        } catch (ParseException ex) {
                rd=contexto.getRequestDispatcher("/FechaIncorrecta.html");
                rd.forward(request, response);
                fechabien=false;
        }
        if(fechabien){
          contexto.setAttribute("fecIng", fecIng);  
        }
        
        fechabien=true;
        datefecha=null;
        formateador=new SimpleDateFormat("dd/MM/yyyy");
        formateador.setLenient(false);
        
        try {
            datefecha=formateador.parse(fecNac);
        } catch (ParseException ex) {
                rd=contexto.getRequestDispatcher("/FechaIncorrecta.html");
                rd.forward(request, response);
                fechabien=false;
        }
        if(fechabien){
          contexto.setAttribute("fecNac", fecNac);  
        }
        
        /*
        boolean bien=true;
        try{
           int o=Integer.parseInt(cif.substring(0,1));
        }catch(NumberFormatException e){
            bien=true;
        }
        
        int p=Integer.parseInt(cif.substring(2,4));
        
        String[] codPro={ "01", "02", "03", "53", "54", "04", "05", "06", "07", "57", "08", "58", "59", "60", "61", "62", "63", "64", "09",
                            "10", "11", "72", "12", "13", "14", "56", "15", "70", "16", "17", "55", "18", "19", "20", "71", "21", "22", "23",
                            "24", "25", "26", "27", "28", "78", "79", "80", "81", "82", "83", "84", "85", "29", "92", "93", "30", "73", "31",
                            "32", "33", "74", "34", "35", "76", "36", "94", "37", "38", "75", "39", "40", "41", "91", "42", "43", "77", "44",
                            "45", "46", "96", "97", "98", "47", "48", "95", "49", "50", "99", "51" , "52"};
        int cont=0;
        boolean oa=true;
        for(int x=0;x<codPro.length;x++){
            if(codPro[x].equals(p)){
                cont++;
            }else{
                oa=false;
            }
        }
        if(cont<=1){
            oa=true;
        }
        
        if(oa){
            contexto.setAttribute("cif", cif); 
        }else{
                rd=contexto.getRequestDispatcher("/CIFIncorrecto.html");
                rd.forward(request, response);
        }
        */
        /*
        boolean verdad=true;
        if(nss.length()==13){
           int num=Integer.parseInt(nss.substring(0,10));
            System.out.println(num);
           int dc=Integer.parseInt(nss.substring(10,13));
            System.out.println(dc);
           int comp=num%97;
            System.out.println(comp);
           
           if(comp==dc){
               verdad=true;
           }else{
               verdad=false;
           }
        }else{
            rd=contexto.getRequestDispatcher("/NumSS.html");
            rd.forward(request, response);
        }
        */
        
        ListaParte parte=null;
        parte=new ListaParte(nombre,apellido1,apellido2,nss,cif,razsoc,texto);
        
        lista.add(parte);
        
        rd=contexto.getRequestDispatcher("/Formulario.html");
        rd.forward(request, response);
    }
}
