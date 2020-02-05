<%-- 
    Document   : totalActores
    Created on : 04-feb-2020, 19:51:43
    Author     : Jose Antonio
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="dvdRental.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            ServletContext contexto=request.getServletContext();
            
            int id=(int)contexto.getAttribute("pelis");
            
            FilmHelp film=new FilmHelp();
            
            List<Film>lista=film.consultaPelisActores(id);

           %> 
           
           <h2><%=lista.get(0).getTitle() %></h2>
           <hr>
           <table>
               <% for(Iterator it=lista.get(0).getFilmActors().iterator(); it.hasNext();){ 
                        FilmActor actor=(FilmActor)it.next();
               %>
               
               <tr><td><%=actor.getActor().getFirstName() %> <%=actor.getActor().getLastName() %></td></tr>
               
               <% } %>
               
           </table>
    </body>
</html>
