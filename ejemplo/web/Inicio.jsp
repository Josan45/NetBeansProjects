<%-- 
    Document   : Inicio
    Created on : 30-ene-2020, 12:24:26
    Author     : alumno_2DAW
--%>

<%@page import="java.util.List"%>
<%@page import="dvdRental.Category"%>
<%@page import="dvdRental.Category"%>
<%@page import="dvdRental.Ayudante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <link rel="stylesheet" href="css/standardize.css">
        <link rel="stylesheet" href="css/index-grid.css">
        <link rel="stylesheet" href="css/index.css">
    </head>
    <body>
        <div class="container clearfix">
            <p class="titulo">Ejemplo 1 Hibernate. Listado de Peliculas segun la categoria</p>
            <form action="listado.jsp" method="POST">
                <p class="text">Categoria</p>
                <select class="_select" name="idCategoria">
                    <% 
                        Ayudante fh=new Ayudante();
                        List<Category>categorias=fh.getCategoria();
                        Category nuevo=null;
                        for(int x=0;x<categorias.size();x++){
                            nuevo=categorias.get(x);
                            out.println("<option value='"+nuevo.getCategoryId()+"'>"+nuevo.getName()+"</option>");
                        }
                    %>
                </select>
                
                <button class="mostrar">Mostrar Peliculas</button>
            </form>
        </div>
    </body>
</html>
