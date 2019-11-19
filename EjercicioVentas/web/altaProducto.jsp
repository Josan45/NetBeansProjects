<%@page import="Modelo.Producto"%>
<%@page import="Modelo.DbConnection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Comercial"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Alta</title>
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
        
        <% 
            ArrayList<Comercial>comercial=new ArrayList(); 
            comercial=DbConnection.consultaComerciales();
            
            ArrayList<Producto>productos=new ArrayList();
            productos=DbConnection.consultaProducto();
        %>
        
    </head>
    <body>
    <center>
    <button><a href="ventasListado.jsp">Listado de Ventas</a></button>
    <button><a href="alta.html">Alta Venta</a></button>
    <button><a href="modificar.jsp">Modificar Venta</a></button><br><br>
          
    <form action="compruebaAltas" method="POST">
    <select name="cod">
        <% for(int x=0;x<comercial.size();x++){
        out.println("<option value="+comercial.get(x).getCodigo()+">"+comercial.get(x).getNombre()+"</option>");
        } %>
    </select>
    <br><br>
    <select name="pro">
        <% for(int x=0;x<productos.size();x++){
        out.println("<option value="+productos.get(x).getReferencia()+">"+productos.get(x).getNombre()+"-"+productos.get(x).getDescripcion()+"</option>");
        } %>
    </select>
    <br><br>
    <p>Cantidad: <input type="number" name="cantidad"></p>
    <br>
    <p>Fecha: <input type="date" name="fecha"></p>
    <br>
    <input type="submit" value="Alta">
    </form>
    
    </center>
    </body>
</html>
