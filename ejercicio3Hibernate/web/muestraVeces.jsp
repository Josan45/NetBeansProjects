<%-- 
    Document   : muestraVeces
    Created on : 04-feb-2020, 19:43:18
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

            int tienda = Integer.parseInt(request.getParameter("tienda3"));
            int t = Integer.parseInt(request.getParameter("t3"));

            FilmHelp film = new FilmHelp();

            List<Inventory> consultaPelis = film.consultaInventario(tienda,t);
            List<Inventory>consultaVeces=null;
            
            String titulo="";


        %>

        <table border="solid">
            <tr>
                <td><strong>Pelicula:</strong></td>
                <td><strong>Veces vista:</strong></td>
            </tr>
            <% for (int x = 0; x < consultaPelis.size(); x++) { 
                    titulo=""+consultaPelis.get(x);
                    short id=film.consultaPelisId(titulo);
                    consultaVeces=film.consultaVeces(tienda, titulo);    

                    if(consultaVeces.size()!=0){
            %>
                    <tr>
                        <td><%=titulo %></td>
                        <td><%=consultaVeces.get(0) %></td>
                    </tr>
           <% 
                }
            } 
            %>

        </table>
            
            <% if (t >= 10) {%>
        <a href="muestraVeces.jsp?t3=<%=(t - 10)%>&tienda3=<%=tienda%>">Anterior</a>        
        <% }
            if (t < (consultaPelis.size() * 10) - 10) {%>
        <a href="muestraVeces.jsp?t3=<%=(t + 10)%>&tienda3=<%=tienda%>">Siguiente</a> 
        <% }
        %>
    </body>
</html>
