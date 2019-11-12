<%-- 
    Document   : registroLibro
    Created on : 24-oct-2018, 17:45:40
    Author     : jesus
--%>

<%@page import="Modelo.DbConnection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
        <style>
            body{background-color:#ccffcc; margin-left:10px;}            
        </style>
    </head>
    <body>
        <h1>Registrar nuevo libro:</h1>
        
        <form method="POST" action="addLibro.jsp">
        <p>Código: <input type="number" name="codigo" required></p>
        <p>Título: <input type="text" name="titulo" required></p>
        <p>Autor: <input type="text" name="autor" required></p>
        <p>Fecha: <input type="date" name="fecha" required></p>
        <p>Páginas: <input type="number" name="paginas" required></p>
        <p>Precio: <input type="number" name="precio" required></p>
        
        <input type="submit" value="Nuevo libro">
        <br><br>
        <input type="reset" value="Limpiar">
        <br><br>
        <a href="index.html">Volver a la página principal</a>
        
        </form>
        
    </body>
</html>