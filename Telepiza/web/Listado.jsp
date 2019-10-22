
<%@page import="java.io.PrintWriter"%>
<%@page import="Modelo.Listado"%>
<%@page import="java.util.Collections"%>
<%@page import="Modelo.ListaPedidos"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabla Actividades</title>
        
        <style>
           
            body{
                background-color: red;
            }
            table{
                
               padding: 0.5%;
                margin-top: 3%;
                margin-left: 29%;
            }
            
            #cabecera{
                background-color:white;
                text-align: center;
                
            }
            
            #filas{
                
                background-color: white;
                text-align: center;
            }
            
            img{
                margin-left:30%;
            }
            
           
            
        </style>
    </head>
    <body>
        <div><a href="index.html"><img src="tp.jpg"></a></div>
        <table>
            
            <tr id="cabecera">
                <td>Nombre</td>
                <td>Apellidos</td>
                <td>Masa</td>
                <td>Ingredientes</td>
                <td>Observaciones</td>
            </tr>
            
           <%
               
              for(int x=0; x<Listado.lista.size(); x++){
              
                  String nombre=Listado.lista.get(x).getNombre();
                  String apellidos=Listado.lista.get(x).getApellidos();
                  String masa=Listado.lista.get(x).getMasa();
                  String ing=Listado.lista.get(x).getIng();
                  String texto=Listado.lista.get(x).getTexto();
                 
                  
               %>
               
                <tr id="filas">
                <td><%=nombre%></td>
                <td><%=apellidos%></td>
                <td><%=masa%></td>
                <td><%=texto%></td>
                <td><%=ing%></td>
            </tr>
              
              
              
            
            <% }    %>
           
           
           
        </table>
        
    </body>
</html>
