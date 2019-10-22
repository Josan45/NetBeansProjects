<%-- 
    Document   : Lista
    Created on : 22-oct-2019, 11:08:18
    Author     : José Antonio
--%>

<%@page import="Modelo.Lista.lista"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Lista"%>
<%@page import="Modelo.ListaActividades"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <table>
            <tr>
                <td>Nombre de Actividad</td>
                <td>Lugar de Actividad</td>
                <td>Fecha</td>
                <td>Hora</td>
                <td>Destino</td>
                <td>Tipo de Actividad</td>
                <td>Curso</td>
                <td>Profesor</td>
                <td>Observaciones</td>
                <td>Hora</td>
            </tr>
            
            <%
                for(int x=0;x<lista.size();x++){
                    String nombre=Lista.lista.get(x).getNombre();
                    String lugar=Lista.lista.get(x).getLugar();
                }
            %>
        </table>
    </body>
</html>
