<%-- 
    Document   : FormuColoresConAviso
    Created on : 09-oct-2019, 12:07:29
    Author     : José Antonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Formulario de nombres y colores</h2>
        <h3>Rellena los datos indicados y pulsa Enviar</h3>
        
        <font color="green"><h3>¡¡Debes rellenar todos los cuadros!!</h3></font>
        <form action="/Colores.jsp">
            <table>
                <tr><td>Introduce tu nombre:</td><td><input type="text" name="nombre" size="10"></td></tr>
                <tr><td>Color de fondo en ingles:</td><td><input type="text" name="color" size="10"></td></tr>
            </table>
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>
