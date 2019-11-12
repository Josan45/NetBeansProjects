
<%@page import="java.io.PrintWriter"%>
<%@page import="Modelo.DbConnection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Libro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Añadir libro</title>
        <style>
            body{background-color:#ccffcc; margin-left:10px;}            
        </style>
    </head>
    <body>
        <% 
        
        ServletContext contexto=getServletContext();
        RequestDispatcher rd;
        
        String cod=request.getParameter("codigo");
        int codigo=Integer.parseInt(cod);
        String titulo=request.getParameter("titulo");
        String autor=request.getParameter("autor");
        String fecha=request.getParameter("fecha");
        String pag=request.getParameter("paginas");
        int paginas=Integer.parseInt(pag);
        String pre=request.getParameter("precio");
        double precio=Double.parseDouble(pre);
        
        Libro lib;
        ArrayList<Libro> li=new ArrayList<>();
        
        lib=new Libro(codigo, titulo, autor, fecha, paginas, precio);
        
        li.add(lib);
        
        //out.println(li.size());
        
        li=DbConnection.añadirLibros(codigo, titulo, autor, fecha, paginas, precio);
        
        if(li!=null){
            out.println("Añadido");
            out.println("<br>");
            out.println("<a href='index.html'>Volver a la pagina de inicio</a>");
        }else{
            out.println("No añadido");
            out.println("<br>");
            out.println("<a href='index.html'>Volver a la pagina de inicio</a>");
        }
        
        
        %>
    </body>
</html>