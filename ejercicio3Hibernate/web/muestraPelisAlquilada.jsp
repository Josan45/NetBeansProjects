<%-- 
    Document   : muestraPelisAlquilada
    Created on : 04-feb-2020, 14:17:45
    Author     : Jose Antonio
--%>

<%@page import="java.util.List"%>
<%@page import="dvdRental.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pelicula alquilada</title>
    </head>
    <body>
        <%

            ServletContext contexto = request.getServletContext();

            int tienda = (int) contexto.getAttribute("tienda");
            int cliente = (int) contexto.getAttribute("cliente");
            String tram = request.getParameter("t");

            int tramo = Integer.parseInt(tram);

            FilmHelp ayu = new FilmHelp();

            List<Rental> listaCliente = ayu.consultaTienda2(tienda, cliente, tramo);

        %>
    <center>
        <table border="solid">
            <tr>
                <td>Titulo</td>
                <td>Fecha de alquiler</td>
                <td>Fecha de devolucion</td>
            </tr>               
            <%            for (int x = 0; x < listaCliente.size(); x++) {%>
            <tr>
                <td><%=listaCliente.get(x).getInventory().getFilm().getTitle()%></td>
                <td><%=listaCliente.get(x).getRentalDate()%></td>
                <td><%=listaCliente.get(x).getReturnDate()%></td>
            </tr>

            <% } %>
        </table>

        <% if (tramo >= 10) {%>
        <a href="muestraPelisAlquilada.jsp?t=<%=(tramo - 10)%>&cliente=<%=cliente%>&tienda=<%=tienda%>">Anterior</a>        
        <% }
           if (tramo <(listaCliente.size()*10)) {%>
        <a href="muestraPelisAlquilada.jsp?t=<%=(tramo + 10)%>&cliente=<%=cliente%>&tienda=<%=tienda%>">Siguiente</a> 
        <% }
        %>
    </center>
    </body>
</html>

