
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
        <h1>Registrar Alumno:</h1>
        
        <form method="POST" action="compruebaAlumno">
            <table>
                Nombre: <input type="text" name="nombre" required><br>
                Apellidos: <input type="text" name="apellidos" required><br>
                DAWES: <input type="text" name="dawes" required><br>
                DAWEC: <input type="text" name="dawec" required><br>
                DIW: <input type="text" name="diw" required><br>
                DAW: <input type="text" name="daw" required><br>
                FCT: <input type="text" name="fct" required><br>
                Proyecto: <input type="text" name="proyecto" required><br>
            </table>
            <br>
        <input type="submit" value="Nuevo Alumno">
        <br><br>
        <input type="reset" value="Limpiar">
        <br><br>
        <a href="index.html">Volver a la página principal</a>
        
        </form>
        
    </body>
</html>