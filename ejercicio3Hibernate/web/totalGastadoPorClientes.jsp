<%-- 
    Document   : totalGastadoPorClientes
    Created on : 04-feb-2020, 19:36:26
    Author     : Jose Antonio
--%>

<%@page import="java.util.List"%>
<%@page import="dvdRental.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
            ServletContext contexto = request.getServletContext();

            int tienda = (int) contexto.getAttribute("tienda2");
            String tram = request.getParameter("t2");

            int tramo = Integer.parseInt(tram);

            double total = 0;
            int dinero = 0;

            FilmHelp film = new FilmHelp();

            List<Customer>listaClientes=film.consultaCliente4(tienda,tramo);
            Customer clienteDelVideoclub=null;
            long totalGastado;
            String idCliente="";

        %>
        <table border="solid">
            <tr>
                <td>Cliente</td><td>Total alquiler</td>
            </tr>

            
                <% for (int x = 0; x < listaClientes.size(); x++) {
                    clienteDelVideoclub=listaClientes.get(x);
                    idCliente=clienteDelVideoclub.getCustomerId().toString();
                        totalGastado=film.consultaPago(idCliente, tienda); %>
                        <tr>
                            <td><%=clienteDelVideoclub.getFirstName() %> <%=clienteDelVideoclub.getLastName() %></td>
                            <td><%=totalGastado %></td>
                        </tr>
                        <%
                    } %>
        </table>

        <% if (tramo >= 10) {%>
        <a href="totalGastadoPorClientes.jsp?t2=<%=(tramo - 10)%>&tienda2=<%=tienda%>">Anterior</a>        
        <% }
            if (tramo < (listaClientes.size() * 10) - 10) {%>
        <a href="totalGastadoPorClientes.jsp?t2=<%=(tramo + 10)%>&tienda2=<%=tienda%>">Siguiente</a> 
        <% }
        %>


    </body>
</html>
