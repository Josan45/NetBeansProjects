

<%@page import="Modelo.DbConnection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Venta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <title>Resultado</title>
    </head>
    <body>
        
        <center>
        <div>
        <form method="POST" action="ventasListado">
            <input type="submit" value="Ventas Listado">
            <button><a href="alta.html">Alta Venta</a></button>
            <button><a href="modificar.jsp">Modificar Venta</a></button>
        </form>
        </div>
        
            <br>
            
        <table border="3px">
            <tr><th>Comercial</th>
                <th>Producto</th>
                <th>Cantidad</th>
                <th>Precio</th>
                <th>Total</th>
                <th>Descuento</th>
                <th>Total Descuento</th>
                <th>Fecha</th>
            
            <% 
            
            String codigo=request.getParameter("cod");
            ArrayList<Venta>resultados=new ArrayList();
            resultados=DbConnection.consultaVentas(codigo);

                for(int x=0;x<resultados.size();x++){
                    out.println("<tr>");
                    out.println("<td>"+resultados.get(x).getNombreComercial()+"</td>");
                    out.println("<td>"+resultados.get(x).getNombreProducto()+"</td>");
                    out.println("<td>"+resultados.get(x).getCantidad()+"</td>");
                    out.println("<td>"+resultados.get(x).getPrecio()+"</td>");
                    out.println("<td>"+resultados.get(x).getTotal()+"</td>");
                    out.println("<td>"+resultados.get(x).getDescuento()+"</td>");
                    out.println("<td>"+resultados.get(x).getTotalDescuento()+"</td>");
                    out.println("<td>"+resultados.get(x).getFechaCompra()+"</td>");                  
                    out.println("</tr>");
                }
            %>
            
        </table>
            
        </center>
            
    </body>
</html>
