
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Alumnos"%>
<%@page import="Modelo.DbConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            body{
                background-color:#ccffcc; 
                margin-left:10px;
            }
            
            button{
                margin-top: 10px;
                margin-left: 47%;
            }
        </style>
        <title>Resultado consulta</title>
    </head>
    <body>
        <%
            ArrayList<Alumnos>lista=new ArrayList<Alumnos>();
            lista=DbConnection.muestraAlumnos();
        %>
        
        <div align="center">
            <table border="1" align="center">
                <tr>
                    <td>Nombre</td>
                    <td>Apellido</td>
                    <td>DAWES</td>
                    <td>DAWEC</td>
                    <td>DIW</td>
                    <td>DAW</td>
                    <td>FCT</td>
                    <td>Proyecto</td>
                    <td>Editar</td>
                </tr>
                
         <%
               
              for(int x=0; x<lista.size(); x++){ 
                  
                out.print("<tr>");
                out.println("<td>"+lista.get(x).getNombre()+"</td>");
                out.print("<td>"+lista.get(x).getApellidos()+"</td>");
                out.print("<td>"+lista.get(x).getDawes()+"</td>");
                out.print("<td>"+lista.get(x).getDawec()+"</td>");
                out.print("<td>"+lista.get(x).getDaw()+"</td>");
                out.print("<td>"+lista.get(x).getDiw()+"</td>");
                out.print("<td>"+lista.get(x).getFct()+"</td>");
                out.print("<td>"+lista.get(x).getProyecto()+"</td>");
                out.print("<td><input type='submit' formaction='tablaModificar.jsp?alumno="+x+"' value='Editar'></td>");
                out.print("</tr>"); 
                
                }
              
         %>
            
            
            </table>
        </div>
            <button><a href="registro.jsp">Añadir Alumno</a></button>
    </body>
</html>
