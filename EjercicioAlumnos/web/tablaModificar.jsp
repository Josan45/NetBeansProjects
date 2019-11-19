<%-- 
    Document   : tablaModificar
    Created on : 13-nov-2019, 17:15:06
    Author     : José Antonio
--%>


<%@page import="Modelo.DbConnection"%>
<%@page import="Modelo.Alumnos"%>
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
                ArrayList<Alumnos>listado=new ArrayList();
                String alum=request.getParameter("alumno");
                int alumno=Integer.parseInt(alum);
                
                    out.println("<tr>");
                    out.println("<td><input type='text' name='nombre"+alumno+"' value='"+listado.get(alumno).getNombre()+"'></td>");
                    out.println("<td><input type='text' name='apellidos"+alumno+"' value='"+listado.get(alumno).getApellidos()+"'></td>");
                    out.println("<td><input type='text' name='dawes"+alumno+"' value='"+listado.get(alumno).getDawes()+"'></td>");
                    out.println("<td><input type='text' name='dawec"+alumno+"' value='"+listado.get(alumno).getDawec()+"'></td>");
                    out.println("<td><input type='text' name='nombre"+alumno+"' value='"+listado.get(alumno).getDiw()+"'></td>");
                    out.println("<td><input type='text' name='nombre"+alumno+"' value='"+listado.get(alumno).getDaw()+"'></td>");
                    out.println("<td><input type='text' name='nombre"+alumno+"' value='"+listado.get(alumno).getFct()+"'></td>");
                    out.println("<td><input type='text' name='nombre"+alumno+"' value='"+listado.get(alumno).getProyecto()+"'></td>");                  
                    out.println("</tr>");
                
            %>
            
            </table>
            <br>
            <input type="submit" value="Modificar">
        </form>
        
    </center>
</body>
</html>