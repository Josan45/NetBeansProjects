<%-- 
    Document   : modificar
    Created on : 13-nov-2019, 17:13:38
    Author     : José Antonio
--%>

<%@page import="Modelo.DbConnection"%>
<%@page import="Modelo.Comercial"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            body{
                background-color:#ccffcc;
                margin-top: 5px;
            }

            a{
                color:black;                
            }
        </style>
    </head>
    <body>
        <%
            ArrayList<Comercial> comercial = new ArrayList();
            comercial = DbConnection.consultaComerciales();
        %>

    <center>
        <button><a href="ventasListado.jsp">Listado de Ventas</a></button>
        <button><a href="alta.html">Alta Venta</a></button>
        <button><a href="modificar.jsp">Modificar Venta</a></button><br><br>

        <h2>Elija al comercial que desea modificar:</h2>

        <form action="tablaModificar.jsp" method="POST">
            <select name="cod">
                <% for (int x = 0; x < comercial.size(); x++) {
                out.println("<option value=" + comercial.get(x).getCodigo() + ">" + comercial.get(x).getNombre() + "</option>");
            }%>
            </select>
            <br><br>
            <input type="submit" value="Modificar">
            <br><br>
        </form>
    </center>
</body>
</html>
