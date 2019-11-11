<%-- 
    Document   : resultConsulta
    Created on : 24-oct-2018, 12:52:31
    Author     : alumno_2DAW
--%>

<%@page import="java.util.*"%>
<%@page import="Modelo.Libro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            body{background-color:#e2e3f8; margin-left:10px;}            
        </style>
        <title>Resultado consulta</title>
    </head>
    <body>
        <%
            String dato=request.getParameter("titulo");
            ArrayList<Libro>lista=Modelo.DbConnection.consultaTitulos(dato);
        %>
        <h1>Consulta de los titulos disponibles:</h1>
        <div align="center">
            <table border="1" align="center">
                <tr>
                    <td>Titulo</td>
                    <td>Isbn</td>
                    <td>Autor</td>
                    <td>Editorial</td>
                    <td>Descripcion</td>
                </tr>
         <%
               
              for(int x=0; x<lista.size(); x++){ {%>
              
              <td><%=lista.get(x).getTitulo()%></td>
              <td><%=lista.get(x).getIsbn()%></td>
              <td><%=lista.get(x).getAutor()%></td>
              <td><%=lista.get(x).getEditorial()%></td>
              <td><%=lista.get(x).getDescripcion()%></td>
                 
                <% } %>
            </tr>
            <% } %>
            </table>
        <a href="index.jsp">Volver a la pagina principal</a>
        </div>
    </body>
</html>
