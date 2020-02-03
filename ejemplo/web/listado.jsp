<%-- 
    Document   : listado
    Created on : 31-ene-2020, 9:20:00
    Author     : Jose Antonio
--%>

<%@page import="dvdRental.Category"%>
<%@page import="java.util.List"%>
<%@page import="dvdRental.Film"%>
<%@page import="dvdRental.Ayudante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado</title>
    </head>
    <body>

        <%

            String categoria = request.getParameter("categoria");
            int id = Integer.parseInt(categoria);

            Ayudante kk = new Ayudante();
            List<Film> lista = kk.getListado(id);
            
            List<Category>categori=kk.getNombre(id);

        %>

        <h1>Películas del género: <%=categori.get(0) %></h1>
        <br>
        <table>

            <% for (int x = 0; x < lista.size(); x++) {%>
            <tr><td><%=lista.get(x)%></td></tr>
            <%  }%>

        </table>

    </body>
</html>

