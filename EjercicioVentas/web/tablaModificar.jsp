<%-- 
    Document   : tablaModificar
    Created on : 13-nov-2019, 17:15:06
    Author     : José Antonio
--%>


<%@page import="Modelo.DbConnection"%>
<%@page import="Modelo.Venta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabla modificar</title>
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
            
            th{
                background-color: yellow;
            }
            
            th, td{
                padding:10px;
                text-align: center;
            }
        </style>
    </head>
    <body>
    <center>
        <button><a href="ventasListado.jsp">Listado de Ventas</a></button>
        <button><a href="alta.html">Alta Venta</a></button>
        <button><a href="modificar.jsp">Modificar Venta</a></button><br><br>
        
        <% 
            String codigo=request.getParameter("cod");
            ArrayList<Venta>listado=new ArrayList();
            listado=DbConnection.consultaVentas(codigo);
        %>
        
        <form method="POST" action="compruebaModificar">
            <table border="3px">
            <tr>
                <th>Comercial</th>
                <th>Producto</th>
                <th>Cantidad</th>
                <th>Precio</th>
                <th>Total</th>
                <th>Descuento</th>
                <th>Total Descuento</th>
                <th>Fecha</th>
            </tr>
            
            <% 
                
                for(int x=0;x<listado.size();x++){
                    out.println("<tr>");
                    out.println("<td>"+listado.get(x).getNombreComercial()+"</td>");
                    out.println("<td>"+listado.get(x).getNombreProducto()+"</td>");
                    out.println("<td><input type='number' name='cantidad"+x+"' value="+listado.get(x).getCantidad()+"></td>");
                    out.println("<td>"+listado.get(x).getPrecio()+"</td>");
                    out.println("<td>"+listado.get(x).getTotal()+"</td>");
                    out.println("<td>"+listado.get(x).getDescuento()+"</td>");
                    out.println("<td>"+listado.get(x).getTotalDescuento()+"</td>");
                    out.println("<td>"+listado.get(x).getFechaCompra()+"</td>");                  
                    out.println("</tr>");
                    out.println("<input type='hidden' value='"+listado.size()+"' name='maximo'>");
                    out.println("<input type='hidden' value='"+listado.get(x).getCantidad()+"' name='cant'>");
                }
                
            %>
            
            </table>
            <br>
            <input type="submit" value="Modificar">
        </form>
        
    </center>
</body>
</html>