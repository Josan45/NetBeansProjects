
<%@page import="java.io.PrintWriter"%>
<%@page import="Modelo.DbConnection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Alumnos"%>
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
        
        String nombre=request.getParameter("nombre");
        String apellidos=request.getParameter("apellidos");
        String dawes=request.getParameter("dawes");
        String dawec=request.getParameter("dawec");
        String diw=request.getParameter("diw");
        String daw=request.getParameter("daw");
        String fct=request.getParameter("fct");
        String proyecto=request.getParameter("proyecto");
        
        Alumnos alum;
        ArrayList<Alumnos> list=new ArrayList<>();
        
        alum=new Alumnos(nombre, apellidos, dawes, dawec, diw, daw,fct,proyecto);
        
        list.add(alum);
        
        list=DbConnection.añadirAlumnos(nombre, apellidos, dawes, dawec, diw, daw,fct,proyecto);
        
        if(list!=null){
            out.println("Añadido");
            out.println("<br>");
            out.println("<a href='mostrar.jsp'>Mostrar Listado</a>");
        }else{
            out.println("No añadido");
            out.println("<br>");
            out.println("<a href='registro.jsp'>Volver a la pagina de inicio</a>");
        }
        
        
        %>
    </body>
</html>