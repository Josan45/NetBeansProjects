<%-- 
    Document   : ventasListado
    Created on : 05-nov-2018, 12:18:53
    Author     : alumno_2DAW
--%>

<%@page import="Modelo.Comercial"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ventas</title>
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
        <center>
        <div>
        <form method="POST" action="resultado.jsp">
            <button><a href="ventasListado.jsp">Listado de Ventas</a></button>
            <button><a href="alta.html">Alta Venta</a></button>
            <button><a href="modificar.jsp">Modificar Venta</a></button><br><br>
            <% 
            
            ArrayList<Comercial>listaComercial=new ArrayList<>();
            
            listaComercial=Modelo.DbConnection.consultaComerciales();

            %>            
            <select name='nom'>
                <%
                for(int x=0;x<listaComercial.size();x++){
                    out.println("<option value="+listaComercial.get(x).getCodigo()+">"+listaComercial.get(x).getNombre()+"</option>");
                }
                
                %>
            </select>
            <br><br>
            <input type="submit" value="Listado de ventas">
        </form>
        </div>      
    </center>
    </body>
</html>
