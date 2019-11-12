
<%@page import="Servlet.Consulta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            body{background-color:#ccffcc; margin-left:10px;}            
        </style>
        <title>Resultado consulta</title>
    </head>
    <body>
        <h1>Información del libro:</h1>
        <% int i = Integer.parseInt(request.getParameter("libro")); %>
        <p>Código: <% out.println(Consulta.listita.get(i).getCodigo()); %></p>
        <p>Título: <% out.println(Consulta.listita.get(i).getTitulo()); %></p>
        <p>Autor: <% out.println(Consulta.listita.get(i).getAutor()); %></p>
        <p>Fecha: <% out.println(Consulta.listita.get(i).getFecha()); %></p>
        <p>Páginas: <% out.println(Consulta.listita.get(i).getPaginas()); %></p>
        <p>Precio: <% out.println(Consulta.listita.get(i).getPrecio());%></p>
        <a href="index.html">Volver a la pagina principal</a>
    </body>
</html>
